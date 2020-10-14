package com.sky.ddt.dto.orderImport.response;

import lombok.Data;

/**
 * @author baixueping
 * @description 订单店铺sku信息
 * @date 2019/9/19 16:04
 */
@Data
public class OrderShopSkuResponse {
    String amazonOrderId;
    String sku;
}
