package com.sky.ddt.dto.shopHeadTripCost.response;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author baixueping
 * @description 店铺sku头程费信息
 * @date 2020/8/18 11:15
 */
@Data
public class ShopSkuHeadTripCostInfo {
    Integer shopSkuId;
    BigDecimal headTripCost;
    BigDecimal weight;
}
