package com.sky.ddt.dto.shopHeadTripCost.response;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author baixueping
 * @description 店铺sku库存
 * @date 2020/8/17 19:02
 */
@Data
public class ShopSkuInventoryDetails {
    Integer shopSkuId;
    Integer quantity;
}
