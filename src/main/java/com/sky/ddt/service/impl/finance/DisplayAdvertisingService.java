package com.sky.ddt.service.impl.finance;

import com.sky.ddt.common.constant.FinanceConstant;
import com.sky.ddt.common.constant.MonthlyAdvertisingFeeConstant;
import com.sky.ddt.dao.custom.CustomDisplayAdvertisingMapper;
import com.sky.ddt.dao.custom.CustomFinanceMapper;
import com.sky.ddt.dto.finance.request.*;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.service.finance.IDisplayAdvertisingService;
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
 * @author sky
 * @Description 展示广告
 * @date 2022/1/13 23:27
 */
@Service
public class DisplayAdvertisingService implements IDisplayAdvertisingService {
    @Autowired
    CustomDisplayAdvertisingMapper customDisplayAdvertisingMapper;
    @Autowired
    IShopSkuService shopSkuService;
    @Autowired
    IFinanceService financeService;
    @Autowired
    CustomFinanceMapper customFinanceMapper;

    @Override
    public BaseResponse importDisplayAdvertising(ImportFinanceRequest params, Integer dealUserId) {
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
        List<DisplayAdvertisingImportRequest> importRequestList = new ArrayList<>();
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
            DisplayAdvertisingImportRequest importRequest = new DisplayAdvertisingImportRequest();
            CheckUtil.checkAndSetDate(importRequest, sbErroItem, map, "Start Date", "startDate", false);
            CheckUtil.checkAndSetDate(importRequest, sbErroItem, map, "End Date", "endDate", false);
            CheckUtil.checkAndSetStr(importRequest, sbErroItem, map, "Currency", "currency", false);
            CheckUtil.checkAndSetStr(importRequest, sbErroItem, map, "Portfolio name", "portfolioName", false);
            CheckUtil.checkAndSetStr(importRequest, sbErroItem, map, "Campaign Name", "campaignName", false);
            CheckUtil.checkAndSetStr(importRequest, sbErroItem, map, "Ad Group Name", "adGroupName", false);
            CheckUtil.checkAndSetStr(importRequest, sbErroItem, map, "Bid Optimization", "bidOptimization", false);
            if (StringUtils.isEmpty(map.get("Advertised SKU"))) {
                sbErroItem.append(",").append(MonthlyAdvertisingFeeConstant.SKU_EMPTY);
            } else {
                ShopSku shopSku = shopSkuService.getShopSkuByShopSku(map.get("Advertised SKU"));
                if (shopSku == null) {
                    sbErroItem.append(",").append(MonthlyAdvertisingFeeConstant.SKU_NOT_EXIST);
                } else {
                    if (shopId == null) {
                        shopId = shopSku.getShopId();
                        shopIdSkuRowNum = i + 2;
                        shopIdSku = map.get("Advertised SKU");
                    } else if (!shopId.equals(shopSku.getShopId())) {
                        sbErroItem.append(",").append("Advertised SKU:" + map.get("Advertised SKU") + "与第" + shopIdSkuRowNum + "行sku:" + shopIdSku + "的店铺不一致");
                    }
                    importRequest.setShopSkuId(shopSku.getShopSkuId());
                }
                importRequest.setAdvertisedSku(map.get("Advertised SKU"));
            }
            CheckUtil.checkAndSetStr(importRequest, sbErroItem, map, "Advertised ASIN", "advertisedAsin", false);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "Impressions", "impressions", false);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "Viewable Impressions", "viewableImpressions", false);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "Clicks", "clicks", false);
            CheckUtil.checkAndSetBigDecimal(importRequest, sbErroItem, map, "Click-Thru Rate (CTR)", "clickThruRate", false);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "14 Day Detail Page Views (DPV)", "pageViewsDay14", false);
            CheckUtil.checkAndSetBigDecimal(importRequest, sbErroItem, map, "Spend", "spend", false);
            CheckUtil.checkAndSetBigDecimal(importRequest, sbErroItem, map, "Cost Per Click (CPC)", "costPerClick", false);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "Cost per 1,000 viewable impressions (VCPM)", "costPer1000ViewableImpressions", false);
            CheckUtil.checkAndSetBigDecimal(importRequest, sbErroItem, map, "", "totalAdvertisingCostOfSales", false);
            CheckUtil.checkAndSetBigDecimal(importRequest, sbErroItem, map, "", "totalReturnOnAdvertisingSpend", false);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "", "totalOrdersDay14", false);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "", "ttotalUnitsDay14", false);
            CheckUtil.checkAndSetBigDecimal(importRequest, sbErroItem, map, "", "totalSalesDay14", false);
            CheckUtil.checkAndSetBigDecimal(importRequest, sbErroItem, map, "", "conversionRateDay14", false);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "", "newToBrandOrdersDay14", false);
            CheckUtil.checkAndSetBigDecimal(importRequest, sbErroItem, map, "", "newToBrandSalesDay14", false);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "", "newToBrandUnitsDay14", false);
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
        if (Boolean.TRUE.equals(finance.getDisplayAdvertising())) {
            DisplayAdvertisingExample example = new DisplayAdvertisingExample();
            example.createCriteria().andFinanceIdEqualTo(finance.getId());
            customDisplayAdvertisingMapper.deleteByExample(example);
        }
        for (DisplayAdvertisingImportRequest importRequest : importRequestList) {
            DisplayAdvertising model = new DisplayAdvertising();
            BeanUtils.copyProperties(importRequest, model);
            model.setCreateBy(dealUserId);
            model.setCreateTime(new Date());
            model.setFinanceId(finance.getId());
            customDisplayAdvertisingMapper.insertSelective(model);
        }
        Finance financeUpdate = new Finance();
        financeUpdate.setId(finance.getId());
        financeUpdate.setUpdateBy(dealUserId);
        financeUpdate.setUpdateTime(new Date());
        financeUpdate.setDisplayAdvertising(true);
        customFinanceMapper.updateByPrimaryKeySelective(financeUpdate);
        return BaseResponse.success();
    }
}
