package com.sky.ddt.dto.produceOrder.request;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author sky
 * @Description 店铺sku信息
 * @date 2021/11/17 0:22
 */
@Data
public class SkuCostPriceInfo {
    Integer skuId;
    String sku;
    BigDecimal labourCost;
    BigDecimal costPrice;
    //库存+fba库存
    Integer quantity;
}
