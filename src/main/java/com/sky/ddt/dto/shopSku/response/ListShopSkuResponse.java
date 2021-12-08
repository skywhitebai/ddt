package com.sky.ddt.dto.shopSku.response;

import com.sky.ddt.entity.ShopSku;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author baixueping
 * @description 店铺sku
 * @date 2019/7/29 15:25
 */
@Data
public class ListShopSkuResponse extends ShopSku{
    String shopName;
    String productCode;
    String sku;
    String productName;
    String salesmanUserName;
    private String chineseProductName;
    private String englishProductName;
    String imgUrl;
    String colour;
    String colourNumber;
    private BigDecimal suggestedRetailPrice;

}
