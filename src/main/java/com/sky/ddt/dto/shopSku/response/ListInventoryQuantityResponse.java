package com.sky.ddt.dto.shopSku.response;

import lombok.Data;

/**
 * @author baixueping
 * @description 其他店铺sku返回值
 * @date 2021/3/30 14:27
 */
@Data
public class ListInventoryQuantityResponse {
    Integer shopSkuId;
    Integer shopId;
    String shopName;
    String shopSku;
    Integer inventoryQuantity;
}
