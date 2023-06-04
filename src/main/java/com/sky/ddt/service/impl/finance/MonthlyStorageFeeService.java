package com.sky.ddt.service.impl.finance;

import com.sky.ddt.common.constant.FinanceConstant;
import com.sky.ddt.common.constant.MonthlyStorageFeeConstant;
import com.sky.ddt.dao.custom.CustomFinanceMapper;
import com.sky.ddt.dao.custom.CustomMonthlyStorageFeeMapper;
import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.finance.request.MonthlyStorageFeeImportRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.service.finance.IFinanceService;
import com.sky.ddt.service.finance.IMonthlyStorageFeeService;
import com.sky.ddt.util.CheckUtil;
import com.sky.ddt.util.DateUtil;
import com.sky.ddt.util.ExcelUtil;
import com.sky.ddt.util.MathUtil;
import com.sky.ddt.utilddt.ShopSkuUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author baixueping
 * @description 仓储费
 * @date 2019/11/29 15:50
 */
@Service
public class MonthlyStorageFeeService implements IMonthlyStorageFeeService {
    @Autowired
    CustomMonthlyStorageFeeMapper customMonthlyStorageFeeMapper;
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
     * @description 导入仓储费
     * @author baixueping
     * @date 2019/11/29 15:59
     */
    @Override
    public BaseResponse importMonthlyStorageFee(ImportFinanceRequest params, Integer dealUserId) {
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
        List<MonthlyStorageFeeImportRequest> monthlyStorageFeeImportRequestList = new ArrayList<>();
        Integer shopId = null;
        Integer shopIdAsinRowNum = null;
        String shopIdAsin = null;
        List<String> asinList = ShopSkuUtil.getList(list, "asin");
        List<ShopSku> shopSkuList = shopSkuService.getShopSkuListByAsin(asinList);
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = list.get(i);
            //忽略空行
            if (map.containsKey("isEmpty")) {
                continue;
            }
            StringBuilder sbErroItem = new StringBuilder();
            MonthlyStorageFeeImportRequest monthlyStorageFeeImportRequest = new MonthlyStorageFeeImportRequest();
            if (StringUtils.isEmpty(map.get("asin"))) {
                sbErroItem.append(",").append(MonthlyStorageFeeConstant.ASIN_EMPTY);
            } else {
                ShopSku shopSku = ShopSkuUtil.getShopSkuByAsin(map.get("asin"), shopSkuList);
                if (shopSku == null) {
                    sbErroItem.append(",").append(MonthlyStorageFeeConstant.ASIN_NOT_EXIST);
                } else {
                    if (shopId == null) {
                        shopId = shopSku.getShopId();
                        shopIdAsinRowNum = i + 2;
                        shopIdAsin = map.get("asin");
                    } else if (!shopId.equals(shopSku.getShopId())) {
                        sbErroItem.append(",").append("asin:" + map.get("asin") + "与第" + shopIdAsinRowNum + "行asin:" + shopIdAsin + "的店铺不一致");
                    }
                    monthlyStorageFeeImportRequest.setSku(shopSku.getShopSku());
                    monthlyStorageFeeImportRequest.setShopSkuId(shopSku.getShopSkuId());
                }
                monthlyStorageFeeImportRequest.setAsin(map.get("asin"));
            }
            if (StringUtils.isEmpty(map.get("fnsku"))) {
                sbErroItem.append(",").append(MonthlyStorageFeeConstant.FNSKU_EMPTY);
            } else {
                monthlyStorageFeeImportRequest.setFnsku(map.get("fnsku"));
            }
            if (StringUtils.isEmpty(map.get("product_name"))) {
                sbErroItem.append(",").append(MonthlyStorageFeeConstant.PRODUCT_NAME_EMPTY);
            } else {
                monthlyStorageFeeImportRequest.setProductName(map.get("product_name"));
            }
            if (StringUtils.isEmpty(map.get("fulfillment_center"))) {
                sbErroItem.append(",").append(MonthlyStorageFeeConstant.FULFILLMENT_CENTER_EMPTY);
            } else {
                monthlyStorageFeeImportRequest.setFulfillmentCenter(map.get("fulfillment_center"));
            }
            if (StringUtils.isEmpty(map.get("country_code"))) {
                sbErroItem.append(",").append(MonthlyStorageFeeConstant.COUNTRY_CODE_EMPTY);
            } else {
                monthlyStorageFeeImportRequest.setCountryCode(map.get("country_code"));
            }
            if (StringUtils.isEmpty(map.get("longest_side"))) {
                sbErroItem.append(",").append(MonthlyStorageFeeConstant.LONGEST_SIDE_EMPTY);
            } else {
                BigDecimal longestSide = MathUtil.strToBigDecimal(map.get("longest_side"));
                if (longestSide == null) {
                    sbErroItem.append(",").append(MonthlyStorageFeeConstant.LONGEST_SIDE_ERRO);
                } else {
                    monthlyStorageFeeImportRequest.setLongestSide(longestSide);
                }
            }
            if (StringUtils.isEmpty(map.get("median_side"))) {
                sbErroItem.append(",").append(MonthlyStorageFeeConstant.MEDIAN_SIDE_EMPTY);
            } else {
                BigDecimal medianSide = MathUtil.strToBigDecimal(map.get("median_side"));
                if (medianSide == null) {
                    sbErroItem.append(",").append(MonthlyStorageFeeConstant.MEDIAN_SIDE_ERRO);
                } else {
                    monthlyStorageFeeImportRequest.setMedianSide(medianSide);
                }
            }
            if (StringUtils.isEmpty(map.get("shortest_side"))) {
                sbErroItem.append(",").append(MonthlyStorageFeeConstant.SHORTEST_SIDE_EMPTY);
            } else {
                BigDecimal shortestSide = MathUtil.strToBigDecimal(map.get("shortest_side"));
                if (shortestSide == null) {
                    sbErroItem.append(",").append(MonthlyStorageFeeConstant.SHORTEST_SIDE_ERRO);
                } else {
                    monthlyStorageFeeImportRequest.setShortestSide(shortestSide);
                }
            }
            if (StringUtils.isEmpty(map.get("measurement_units"))) {
                sbErroItem.append(",").append(MonthlyStorageFeeConstant.MEASUREMENT_UNITS_EMPTY);
            } else {
                monthlyStorageFeeImportRequest.setMeasurementUnits(map.get("measurement_units"));
            }
            if (StringUtils.isEmpty(map.get("weight"))) {
                sbErroItem.append(",").append(MonthlyStorageFeeConstant.WEIGHT_EMPTY);
            } else {
                BigDecimal weight = MathUtil.strToBigDecimal(map.get("weight"));
                if (weight == null) {
                    sbErroItem.append(",").append(MonthlyStorageFeeConstant.WEIGHT_ERRO);
                } else {
                    monthlyStorageFeeImportRequest.setWeight(weight);
                }
            }
            if (StringUtils.isEmpty(map.get("weight_units"))) {
                sbErroItem.append(",").append(MonthlyStorageFeeConstant.WEIGHT_UNITS_EMPTY);
            } else {
                monthlyStorageFeeImportRequest.setWeightUnits(map.get("weight_units"));
            }
            if (StringUtils.isEmpty(map.get("item_volume"))) {
                sbErroItem.append(",").append(MonthlyStorageFeeConstant.ITEM_VOLUME_ERRO);
            } else {
                BigDecimal itemVolume = MathUtil.strToBigDecimal(map.get("item_volume"));
                if (itemVolume == null) {
                    sbErroItem.append(",").append(MonthlyStorageFeeConstant.ITEM_VOLUME_ERRO);
                } else {
                    monthlyStorageFeeImportRequest.setItemVolume(itemVolume);
                }
            }
            if (StringUtils.isEmpty(map.get("volume_units"))) {
                sbErroItem.append(",").append(MonthlyStorageFeeConstant.VOLUME_UNITS_EMPTY);
            } else {
                monthlyStorageFeeImportRequest.setVolumeUnits(map.get("volume_units"));
            }
            if (StringUtils.isEmpty(map.get("product_size_tier"))) {
                sbErroItem.append(",").append(MonthlyStorageFeeConstant.PRODUCT_SIZE_TIER_EMPTY);
            } else {
                monthlyStorageFeeImportRequest.setProductSizeTier(map.get("product_size_tier"));
            }
            BaseResponse<BigDecimal> checkAverageQuantityOnHand = CheckUtil.checkBigDecimal(map, "average_quantity_on_hand", true);
            if (checkAverageQuantityOnHand.isSuccess()) {
                monthlyStorageFeeImportRequest.setAverageQuantityOnHand(checkAverageQuantityOnHand.getData());
            } else {
                sbErroItem.append(",").append(checkAverageQuantityOnHand.getMessage());
            }
            BaseResponse<BigDecimal> checkAverageQuantityPendingRemoval = CheckUtil.checkBigDecimal(map, "average_quantity_pending_removal", true);
            if (checkAverageQuantityPendingRemoval.isSuccess()) {
                monthlyStorageFeeImportRequest.setAverageQuantityPendingRemoval(checkAverageQuantityPendingRemoval.getData());
            } else {
                sbErroItem.append(",").append(checkAverageQuantityPendingRemoval.getMessage());
            }
            CheckUtil.checkAndSetBigDecimal(monthlyStorageFeeImportRequest, sbErroItem, map, "average_quantity_pending_removal", null, true);

            if (StringUtils.isEmpty(map.get("month_of_charge"))) {
                sbErroItem.append(",").append("month_of_charge不能为空");
            } else {
                Date date = DateUtil.strToDate(map.get("month_of_charge"));
                if (date == null) {
                    sbErroItem.append(",").append("month_of_charge必须为年月");
                } else {
                    monthlyStorageFeeImportRequest.setMonthOfCharge(DateUtil.getFormatYearMonth(date));
                }
            }
            CheckUtil.checkAndSetBigDecimal(monthlyStorageFeeImportRequest, sbErroItem, map, "base_rate", "storage_rate", false);
            CheckUtil.checkAndSetStr(monthlyStorageFeeImportRequest, sbErroItem, map, "currency", null, true);
            CheckUtil.checkAndSetBigDecimal(monthlyStorageFeeImportRequest, sbErroItem, map, "estimated_monthly_storage_fee", null, true);
            CheckUtil.checkAndSetStr(monthlyStorageFeeImportRequest, sbErroItem, map, "dangerous_goods_storage_type", null, true);
            CheckUtil.checkAndSetBoolenOrYN(monthlyStorageFeeImportRequest, sbErroItem, map, "eligible_for_inventory_discount", true);
            CheckUtil.checkAndSetBoolenOrYN(monthlyStorageFeeImportRequest, sbErroItem, map, "qualifies_for_inventory_discount", true);
            monthlyStorageFeeImportRequestList.add(monthlyStorageFeeImportRequest);
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
        if (Boolean.TRUE.equals(finance.getMonthlyStorageFee())) {
            MonthlyStorageFeeExample monthlyStorageFeeExample = new MonthlyStorageFeeExample();
            monthlyStorageFeeExample.createCriteria().andFinanceIdEqualTo(finance.getId());
            customMonthlyStorageFeeMapper.deleteByExample(monthlyStorageFeeExample);
        }
        for (MonthlyStorageFeeImportRequest monthlyStorageFeeImportRequest : monthlyStorageFeeImportRequestList) {
            MonthlyStorageFee monthlyStorageFee = new MonthlyStorageFee();
            BeanUtils.copyProperties(monthlyStorageFeeImportRequest, monthlyStorageFee);
            monthlyStorageFee.setCreateBy(dealUserId);
            monthlyStorageFee.setCreateTime(new Date());
            monthlyStorageFee.setFinanceId(finance.getId());
            customMonthlyStorageFeeMapper.insert(monthlyStorageFee);
        }
        Finance financeUpdate = new Finance();
        financeUpdate.setId(finance.getId());
        financeUpdate.setUpdateBy(dealUserId);
        financeUpdate.setUpdateTime(new Date());
        financeUpdate.setMonthlyStorageFee(true);
        customFinanceMapper.updateByPrimaryKeySelective(financeUpdate);
        return BaseResponse.success();
    }

}
