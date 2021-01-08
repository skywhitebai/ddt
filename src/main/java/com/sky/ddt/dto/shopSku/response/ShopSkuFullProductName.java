package com.sky.ddt.dto.shopSku.response;

import lombok.Data;

/**
 * @author baixueping
 * @description shopSku报关名
 * @date 2019/9/17 17:47
 */
@Data
public class ShopSkuFullProductName {
    private Integer shopSkuId;
    private String shopSku;
    private String chineseProductName;
    private String englishProductName;
    private Double weight;
}
