package com.sky.ddt.dto.shopSku.response;

import lombok.Data;

/**
 * @author baixueping
 * @description 打印店铺sku返回值
 * @date 2019/8/12 15:49
 */
@Data
public class GetPrintShopSkuResponse {
    private String title;
    private String fnsku;
    private Integer status;
    private String sku;
    private String shopParentSku;
    String imgUrl;
    String colourNumber;
}
