package com.sky.ddt.dto.shopSku.request;

import lombok.Data;

/**
 * @author baixueping
 * @description 获取sql入参
 * @date 2020/11/20 14:21
 */
@Data
public class GetShopSkuByShopParentSkuAndSizeRequest {
    String shopParentSku;
    String size;
    String colour;
    String colourNumber;
    Integer shopId;
}
