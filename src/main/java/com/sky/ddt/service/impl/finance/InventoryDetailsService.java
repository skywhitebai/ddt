package com.sky.ddt.service.impl.finance;

import com.sky.ddt.common.constant.FinanceConstant;
import com.sky.ddt.common.constant.RemoveOrdersConstant;
import com.sky.ddt.dao.custom.CustomFinanceMapper;
import com.sky.ddt.dao.custom.CustomInventoryDetailsMapper;
import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.finance.request.InventoryDetailsImportRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopHeadTripCost.response.ShopSkuInventoryDetails;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.service.finance.IFinanceService;
import com.sky.ddt.service.finance.IInventoryDetailsService;
import com.sky.ddt.util.CheckUtil;
import com.sky.ddt.util.ExcelUtil;
import com.sky.ddt.utilddt.ShopSkuUtil;
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
 * @description 库存明细
 * @date 2019/12/12 15:19
 */
@Service
public class InventoryDetailsService implements IInventoryDetailsService {
    @Autowired
    CustomInventoryDetailsMapper customInventoryDetailsMapper;
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
     * @description 导入库存明细
     * @author baixueping
     * @date 2019/12/12 15:23
     */
    @Override
    public BaseResponse importInventoryDetails(ImportFinanceRequest params, Integer dealUserId) {
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
        List<InventoryDetailsImportRequest> importRequestList = new ArrayList<>();
        Integer shopId = null;
        Integer shopIdSkuRowNum = null;
        String shopIdSku = null;
        List<String> skuList = ShopSkuUtil.getList(list, "sku");
        List<ShopSku> shopSkuList = shopSkuService.getShopSkuListByShopSku(skuList);
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = list.get(i);
            //忽略空行
            if (map.containsKey("isEmpty")) {
                continue;
            }
            StringBuilder sbErroItem = new StringBuilder();
            InventoryDetailsImportRequest importRequest = new InventoryDetailsImportRequest();
            if (StringUtils.isEmpty(map.get("sku"))) {
                sbErroItem.append(",").append(RemoveOrdersConstant.SKU_EMPTY);
            } else {
                ShopSku shopSku = ShopSkuUtil.getShopSkuByShopSku(map.get("sku"), shopSkuList);
                if (shopSku == null) {
                    sbErroItem.append(",").append(String.format(RemoveOrdersConstant.SKU_NOT_EXIST, map.get("sku")));
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
            CheckUtil.checkAndSetStr(importRequest, sbErroItem, map, "asin", null, true);
            CheckUtil.checkAndSetStr(importRequest, sbErroItem, map, "product-name", null, true);
            CheckUtil.checkAndSetBigDecimal(importRequest, sbErroItem, map, "your-price", null, true);
            CheckUtil.checkAndSetStr(importRequest, sbErroItem, map, "mfn-listing-exists", null, true);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "mfn-fulfillable-quantity", null, false);
            CheckUtil.checkAndSetStr(importRequest, sbErroItem, map, "afn-listing-exists", null, true);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "afn-warehouse-quantity", null, true);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "afn-fulfillable-quantity", null, true);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "afn-unsellable-quantity", null, true);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "afn-reserved-quantity", null, true);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "afn-total-quantity", null, true);
            CheckUtil.checkAndSetBigDecimal(importRequest, sbErroItem, map, "per-unit-volume", null, true);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "afn-inbound-working-quantity", null, true);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "afn-inbound-shipped-quantity", null, true);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "afn-inbound-receiving-quantity", null, true);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "afn-researching-quantity", null, true);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "afn-reserved-future-supply", null, true);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "afn-future-supply-buyable", null, true);
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
        Finance finance = financeResponse.getData();
        if (FinanceConstant.FinanceStatusEnum.LOCKED.getStatus().equals(finance.getStatus())) {
            return BaseResponse.failMessage(FinanceConstant.FINANCE_LOCKED_NOT_ALLOW_IMPORT);
        }
        if (Boolean.TRUE.equals(finance.getInventoryDetails())) {
            InventoryDetailsExample example = new InventoryDetailsExample();
            example.createCriteria().andFinanceIdEqualTo(finance.getId());
            customInventoryDetailsMapper.deleteByExample(example);
        }
        for (InventoryDetailsImportRequest importRequest : importRequestList) {
            InventoryDetails entity = new InventoryDetails();
            BeanUtils.copyProperties(importRequest, entity);
            entity.setCreateBy(dealUserId);
            entity.setCreateTime(new Date());
            entity.setFinanceId(finance.getId());
            customInventoryDetailsMapper.insert(entity);
        }
        Finance financeUpdate = new Finance();
        financeUpdate.setId(finance.getId());
        financeUpdate.setUpdateBy(dealUserId);
        financeUpdate.setUpdateTime(new Date());
        financeUpdate.setInventoryDetails(true);
        customFinanceMapper.updateByPrimaryKeySelective(financeUpdate);
        return BaseResponse.success();
    }

    /**
     * @param financeId@return
     * @description 查询店铺sku存库
     * @author baixueping
     * @date 2020/8/17 19:10
     */
    @Override
    public List<ShopSkuInventoryDetails> listShopSkuInventoryDetails(Integer financeId) {
        return customInventoryDetailsMapper.listShopSkuInventoryDetails(financeId);
    }
}
