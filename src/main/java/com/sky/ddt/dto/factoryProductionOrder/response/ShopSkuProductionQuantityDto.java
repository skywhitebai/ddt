package com.sky.ddt.dto.factoryProductionOrder.response;

import lombok.Data;

/**
 * @author baixueping
 * @description 查詢店鋪sku生產數量
 * @date 2020/10/15 18:53
 */
@Data
public class ShopSkuProductionQuantityDto {
    String shopParentSku;
    String shopSku;
    Integer shopSkuId;
    String colour;
    String size;
    Integer productionQuantity;
}
