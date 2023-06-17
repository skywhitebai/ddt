package com.sky.ddt.dto.shopSku.request;

import lombok.Data;

/**
 * @author baixueping
 * @description 获取店铺sku信息
 * @date 2019/8/12 15:32
 */
@Data
public class GetPrintShopSkuRequest {
    String shopSku;
    String fnsku;
    String barcode;
}
