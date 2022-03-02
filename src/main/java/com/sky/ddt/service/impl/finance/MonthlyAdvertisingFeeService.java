package com.sky.ddt.service.impl.finance;

import com.sky.ddt.common.constant.FinanceConstant;
import com.sky.ddt.common.constant.MonthlyAdvertisingFeeConstant;
import com.sky.ddt.dao.custom.CustomFinanceMapper;
import com.sky.ddt.dao.custom.CustomMonthlyAdvertisingFeeMapper;
import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.finance.request.MonthlyAdvertisingFeeImportRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.Finance;
import com.sky.ddt.entity.MonthlyAdvertisingFee;
import com.sky.ddt.entity.MonthlyAdvertisingFeeExample;
import com.sky.ddt.entity.ShopSku;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.service.finance.IFinanceService;
import com.sky.ddt.service.finance.IMonthlyAdvertisingFeeService;
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
 * @description 广告费
 * @date 2019/12/4 15:54
 */
@Service
public class MonthlyAdvertisingFeeService implements IMonthlyAdvertisingFeeService {
    @Autowired
    CustomMonthlyAdvertisingFeeMapper customMonthlyAdvertisingFeeMapper;
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
     * @description 导入月广告费
     * @author baixueping
     * @date 2019/12/4 16:02
     */
    @Override
    public BaseResponse importMonthlyAdvertisingFee(ImportFinanceRequest params, Integer dealUserId) {
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
        List<MonthlyAdvertisingFeeImportRequest> importRequestList=new ArrayList<>();
        Integer shopId = null;
        Integer shopIdSkuRowNum = null;
        String shopIdSku = null;
        List<String> skuList = ShopSkuUtil.getList(list, "Advertised SKU");
        List<ShopSku> shopSkuList = shopSkuService.getShopSkuListByShopSku(skuList);
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = list.get(i);
            //忽略空行
            if (map.containsKey("isEmpty")) {
                continue;
            }
            StringBuilder sbErroItem = new StringBuilder();
            MonthlyAdvertisingFeeImportRequest importRequest=new MonthlyAdvertisingFeeImportRequest();
            CheckUtil.checkAndSetDate(importRequest, sbErroItem, map, "Start Date", "startDate", true);
            CheckUtil.checkAndSetDate(importRequest, sbErroItem, map, "End Date", "endDate", true);
            CheckUtil.checkAndSetStr(importRequest, sbErroItem, map, "Portfolio name", "adMixName", true);
            CheckUtil.checkAndSetStr(importRequest, sbErroItem, map, "Currency", "currency", true);
            CheckUtil.checkAndSetStr(importRequest, sbErroItem, map, "Campaign Name", "adName", true);
            CheckUtil.checkAndSetStr(importRequest, sbErroItem, map, "Ad Group Name", "adGroupName", true);
            if (StringUtils.isEmpty(map.get("Advertised SKU"))) {
                sbErroItem.append(",").append(MonthlyAdvertisingFeeConstant.SKU_EMPTY);
            } else {
                ShopSku shopSku = ShopSkuUtil.getShopSkuByShopSku(map.get("Advertised SKU"), shopSkuList);
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
                importRequest.setSku(map.get("Advertised SKU"));
            }
            CheckUtil.checkAndSetStr(importRequest, sbErroItem, map, "Advertised ASIN", "asin", true);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "Impressions", "displayQuantity", true);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "Clicks", "clickQuantity", true);
            CheckUtil.checkAndSetBigDecimal(importRequest, sbErroItem, map, "Click-Thru Rate (CTR)", "clickThroughRate", false);
            CheckUtil.checkAndSetBigDecimal(importRequest, sbErroItem, map, "Cost Per Click (CPC)", "costPerClick", false);
            CheckUtil.checkAndSetBigDecimal(importRequest, sbErroItem, map, "Spend", "cost", false);
            CheckUtil.checkAndSetBigDecimal(importRequest, sbErroItem, map, "7 Day Total Sales", "totalSalesIn7Days", false);
            CheckUtil.checkAndSetBigDecimal(importRequest, sbErroItem, map, "Total Advertising Cost of Sales (ACoS)", "advertisingCostSalesRatio", false);
            CheckUtil.checkAndSetBigDecimal(importRequest, sbErroItem, map, "Total Return on Advertising Spend (RoAS)", "inputOutputRatio", false);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "7 Day Total Orders (#)", "totalOrdersIn7Days", true);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "7 Day Total Units (#)", "totalSalesQuantityIn7Days", true);
            CheckUtil.checkAndSetBigDecimal(importRequest, sbErroItem, map, "7 Day Conversion Rate", "conversionIn7Days", false);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "7 Day Advertised SKU Units (#)", "adSkuSalesQuantityIn7Days", true);
            CheckUtil.checkAndSetInteger(importRequest, sbErroItem, map, "7 Day Other SKU Units (#)", "otherSkuSalesQuantityIn7Days", true);
            CheckUtil.checkAndSetBigDecimal(importRequest, sbErroItem, map, "7 Day Advertised SKU Sales", "adSkuSalesIn7Days", true);
            CheckUtil.checkAndSetBigDecimal(importRequest, sbErroItem, map, "7 Day Other SKU Sales", "otherSkuSalesIn7Days", true);
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
        if (Boolean.TRUE.equals(finance.getMonthlyAdvertisingFee())) {
            MonthlyAdvertisingFeeExample example = new MonthlyAdvertisingFeeExample();
            example.createCriteria().andFinanceIdEqualTo(finance.getId());
            customMonthlyAdvertisingFeeMapper.deleteByExample(example);
        }
        for (MonthlyAdvertisingFeeImportRequest importRequest : importRequestList) {
            MonthlyAdvertisingFee monthlyAdvertisingFee = new MonthlyAdvertisingFee();
            BeanUtils.copyProperties(importRequest, monthlyAdvertisingFee);
            monthlyAdvertisingFee.setCreateBy(dealUserId);
            monthlyAdvertisingFee.setCreateTime(new Date());
            monthlyAdvertisingFee.setFinanceId(finance.getId());
            customMonthlyAdvertisingFeeMapper.insert(monthlyAdvertisingFee);
        }
        Finance financeUpdate = new Finance();
        financeUpdate.setId(finance.getId());
        financeUpdate.setUpdateBy(dealUserId);
        financeUpdate.setUpdateTime(new Date());
        financeUpdate.setMonthlyAdvertisingFee(true);
        customFinanceMapper.updateByPrimaryKeySelective(financeUpdate);
        return BaseResponse.success();
    }
}
