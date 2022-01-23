package com.sky.ddt.dto.shopSku.response;

import lombok.Data;

/**
 * @author sky
 * @Description 查询出库店铺sku出餐
 * @date 2022/1/23 13:59
 */
@Data
public class ListOutboundShopSkuResponse {
    Integer shopSkuId;
    String shopSku;
    String outboundShopSku;
    Integer outboundShopSkuId;
    Integer inventoryQuantity;

}
