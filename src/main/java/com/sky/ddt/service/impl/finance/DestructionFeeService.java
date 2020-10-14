package com.sky.ddt.service.impl.finance;

import com.sky.ddt.common.constant.FinanceConstant;
import com.sky.ddt.common.constant.RemoveOrdersConstant;
import com.sky.ddt.dao.custom.CustomDestructionFeeMapper;
import com.sky.ddt.dao.custom.CustomFinanceMapper;
import com.sky.ddt.dto.finance.request.DestructionFeeImportRequest;
import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.service.finance.IDestructionFeeService;
import com.sky.ddt.service.finance.IFinanceService;
import com.sky.ddt.util.CheckUtil;
import com.sky.ddt.util.ExcelUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author baixueping
 * @description 销毁费
 * @date 2019/12/5 15:32
 */
@Service
public class DestructionFeeService implements IDestructionFeeService {
    @Autowired
    CustomDestructionFeeMapper customDestructionFeeMapper;
    @Autowired
    IShopSkuService shopSkuService;
    @Autowired
    IFinanceService financeService;
    @Autowired
    CustomFinanceMapper customFinanceMapper;

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 导入销毁费
     * @author baixueping
     * @date 2019/12/5 15:38
     */
    @Override
    public BaseResponse importDestructionFee(ImportFinanceRequest params, Integer dealUserId) {
        BaseResponse<List<Map<String, String>>> listResponse = ExcelUtil.getListByExcel2(params.getFile());
        if (!listResponse.isSuccess()) {
            return listResponse;
        }
        List<Map<String, String>> list = listResponse.getData();
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历数据
        StringBuilder sbErro = new StringBuilder();
        List<DestructionFeeImportRequest> importRequestList=new ArrayList<>();
        Integer shopId = null;
        Integer shopIdSkuRowNum = null;
        String shopIdSku = null;
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = list.get(i);
            //忽略空行
            if (map.containsKey("isEmpty")) {
                continue;
            }
            StringBuilder sbErroItem = new StringBuilder();
            DestructionFeeImportRequest importRequest=new DestructionFeeImportRequest();
            CheckUtil.checkAndSetUtcDateTime(importRequest, sbErroItem, map, "request-date", null, true);
            CheckUtil.checkAndSetStr(importRequest, sbErroItem, map, "order-id", null, true);
            CheckUtil.checkAndSetStr(importRequest, sbErroItem, map, "order-type", null, true);
            CheckUtil.checkAndSetStr(importRequest, sbErroItem, map, "order-status", null, true);
            CheckUtil.checkAndSetUtcDateTime(importRequest, sbErroItem, map, "last-updated-date", null, true);
            if (StringUtils.isEmpty(map.get("sku"))) {
                sbErroItem.append(",").append(RemoveOrdersConstant.SKU_EMPTY);
            } else {
                ShopSku shopSku = shopSkuService.getShopSkuByShopSku(map.get("sku"));
                if (shopSku == null) {
                    sbErroItem.append(",").append(RemoveOrdersConstant.SKU_NOT_EXIST);
                } else {
                    if (shopId == null) {
                        shopId = shopSku.getShopId();
                        shopIdSkuRowNum = i + 2;
                        shopIdSku = map.get("sku");
                    } else if (!shopId.equals(shopSku.getShopId())) {
                        sbErroItem.append(",").append("sku:" + map.get("sku") + "与第" + shopIdSkuRowNum + "行sku:" + shopIdSku + "的店铺不一致");
                    }
                    importRequest.setShopSkuId(shopSku.getShopSkuId());
                }
                importRequest.setSku(map.get("sku"));
            }
            CheckUtil.checkAndSetStr(importRequest, sbErroItem, map, "fnsku", null, true);
            CheckUtil.checkAndSetStr(importRequest, sbErroItem, map, "disposition", null, true);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "requested-quantity", null, true);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "cancelled-quantity", null, true);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "shipped-quantity", null, false);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "in-process-quantity", null, true);
            CheckUtil.checkAndSetBigDecimal(importRequest, sbErroItem, map, "removal-fee", null, false);
            CheckUtil.checkAndSetStr(importRequest, sbErroItem, map, "currency", null, false);
            importRequestList.add(importRequest);
            if (sbErroItem.length() > 0) {
                sbErro.append(",第" + map.get("rowNum") + "行").append(sbErroItem);
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
        if (shopId == null) {
            return BaseResponse.failMessage("没有有效的店铺，请完善数据后再导入");
        }
        BaseResponse<Finance> financeResponse = financeService.getOrCreateFinance(shopId, params.getMonthDate(), dealUserId);
        if (!financeResponse.isSuccess()) {
            return financeResponse;
        }
        Finance finance=financeResponse.getData();
        if (FinanceConstant.FinanceStatusEnum.LOCKED.getStatus().equals(finance.getStatus())) {
            return BaseResponse.failMessage(FinanceConstant.FINANCE_LOCKED_NOT_ALLOW_IMPORT);
        }
        if (Boolean.TRUE.equals(finance.getDestructionFee())) {
            DestructionFeeExample example = new DestructionFeeExample();
            example.createCriteria().andFinanceIdEqualTo(finance.getId());
            customDestructionFeeMapper.deleteByExample(example);
        }
        for (DestructionFeeImportRequest importRequest : importRequestList) {
            DestructionFee destructionFee = new DestructionFee();
            BeanUtils.copyProperties(importRequest, destructionFee);
            destructionFee.setCreateBy(dealUserId);
            destructionFee.setCreateTime(new Date());
            destructionFee.setFinanceId(finance.getId());
            customDestructionFeeMapper.insert(destructionFee);
        }
        Finance financeUpdate = new Finance();
        financeUpdate.setId(finance.getId());
        financeUpdate.setUpdateBy(dealUserId);
        financeUpdate.setUpdateTime(new Date());
        financeUpdate.setDestructionFee(true);
        customFinanceMapper.updateByPrimaryKeySelective(financeUpdate);
        return BaseResponse.success();
    }
}
