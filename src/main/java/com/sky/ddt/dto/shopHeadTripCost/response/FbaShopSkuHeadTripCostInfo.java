package com.sky.ddt.dto.shopHeadTripCost.response;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author baixueping
 * @description fba装箱单店铺sku头程费信息
 * @date 2020/8/18 10:21
 */
@Data
public class FbaShopSkuHeadTripCostInfo {
    Integer shopSkuId;
    Integer quantity;
    BigDecimal headTripCostRate;
}
