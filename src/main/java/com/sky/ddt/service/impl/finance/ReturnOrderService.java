package com.sky.ddt.service.impl.finance;

import com.sky.ddt.common.constant.FinanceConstant;
import com.sky.ddt.common.constant.ReturnOrderConstant;
import com.sky.ddt.dao.custom.CustomFinanceMapper;
import com.sky.ddt.dao.custom.CustomReturnOrderMapper;
import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.finance.request.ReturnOrderImportRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.Finance;
import com.sky.ddt.entity.ReturnOrder;
import com.sky.ddt.entity.ReturnOrderExample;
import com.sky.ddt.entity.ShopSku;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.service.finance.IFinanceService;
import com.sky.ddt.service.finance.IReturnOrderService;
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
 * @description 退换货订单
 * @date 2019/12/4 11:26
 */
@Service
public class ReturnOrderService implements IReturnOrderService {
    @Autowired
    CustomReturnOrderMapper customReturnOrderMapper;
    @Autowired
    IShopSkuService shopSkuService;
    @Autowired
    IFinanceService financeService;
    @Autowired
    CustomFinanceMapper customFinanceMapper;

    /**
     * @param
     * @return
     * @description 导入退换货订单
     * @author baixueping
     * @date 2019/12/4 14:18
     */
    @Override
    public BaseResponse importReturnOrder(ImportFinanceRequest params, Integer dealUserId) {
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
        List<ReturnOrderImportRequest> returnOrderImportRequestList = new ArrayList<>();
        Integer shopId = null;
        Integer shopIdSkuRowNum = null;
        String shopIdSku = null;
        List<String> skuList = ShopSkuUtil.getList(list, "sku");
        List<ShopSku> shopSkuList = shopSkuService.getShopSkuListByShpSku(skuList);
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = list.get(i);
            //忽略空行
            if (map.containsKey("isEmpty")) {
                continue;
            }
            StringBuilder sbErroItem = new StringBuilder();
            ReturnOrderImportRequest returnOrderImportRequest = new ReturnOrderImportRequest();
            CheckUtil.checkAndSetUtcDateTime(returnOrderImportRequest, sbErroItem, map, "return-date", null, true);
            CheckUtil.checkAndSetStr(returnOrderImportRequest, sbErroItem, map, "order-id", null, true);
            if (StringUtils.isEmpty(map.get("sku"))) {
                sbErroItem.append(",").append(ReturnOrderConstant.SKU_EMPTY);
            } else {
                ShopSku shopSku = ShopSkuUtil.getShopSkuByShopSku(map.get("sku"), shopSkuList);
                if (shopSku == null) {
                    sbErroItem.append(",").append(ReturnOrderConstant.SKU_NOT_EXIST);
                } else {
                    if (shopId == null) {
                        shopId = shopSku.getShopId();
                        shopIdSkuRowNum = i + 2;
                        shopIdSku = map.get("sku");
                    } else if (!shopId.equals(shopSku.getShopId())) {
                        sbErroItem.append(",").append("sku:" + map.get("sku") + "与第" + shopIdSkuRowNum + "行sku:" + shopIdSku + "的店铺不一致");
                    }
                }
                returnOrderImportRequest.setSku(map.get("sku"));
            }
            CheckUtil.checkAndSetStr(returnOrderImportRequest, sbErroItem, map, "asin", null, true);
            CheckUtil.checkAndSetStr(returnOrderImportRequest, sbErroItem, map, "fnsku", null, true);
            CheckUtil.checkAndSetStr(returnOrderImportRequest, sbErroItem, map, "product-name", null, true);
            CheckUtil.checkAndSetInteger(returnOrderImportRequest, sbErroItem, map, "quantity", null, true);
            CheckUtil.checkAndSetStr(returnOrderImportRequest, sbErroItem, map, "fulfillment-center-id", null, true);
            CheckUtil.checkAndSetStr(returnOrderImportRequest, sbErroItem, map, "detailed-disposition", null, true);
            CheckUtil.checkAndSetStr(returnOrderImportRequest, sbErroItem, map, "reason", null, true);
            CheckUtil.checkAndSetStr(returnOrderImportRequest, sbErroItem, map, "status", null, true);
            CheckUtil.checkAndSetStr(returnOrderImportRequest, sbErroItem, map, "license-plate-number", null, true);
            CheckUtil.checkAndSetStr(returnOrderImportRequest, sbErroItem, map, "customer-comments", null, false);
            returnOrderImportRequestList.add(returnOrderImportRequest);
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
       /* if (Boolean.TRUE.equals(finance.getReturnOrder())) {
            ReturnOrderExample example = new ReturnOrderExample();
            example.createCriteria().andFinanceIdEqualTo(finance.getId());
            customReturnOrderMapper.deleteByExample(example);
        }
        for (ReturnOrderImportRequest returnOrderImportRequest : returnOrderImportRequestList) {
            ReturnOrder removeOrders = new ReturnOrder();
            BeanUtils.copyProperties(returnOrderImportRequest, removeOrders);
            removeOrders.setCreateBy(dealUserId);
            removeOrders.setCreateTime(new Date());
            removeOrders.setFinanceId(finance.getId());
            customReturnOrderMapper.insert(removeOrders);
        }
        Finance financeUpdate = new Finance();
        financeUpdate.setId(finance.getId());
        financeUpdate.setUpdateBy(dealUserId);
        financeUpdate.setUpdateTime(new Date());
        financeUpdate.setReturnOrder(true);
        customFinanceMapper.updateByPrimaryKeySelective(financeUpdate);*/
        return BaseResponse.success();
    }
}
