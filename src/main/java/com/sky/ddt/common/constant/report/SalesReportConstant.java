package com.sky.ddt.common.constant.report;

import lombok.Getter;

/**
 * @author baixueping
 * @description 销售报表静态类
 * @date 2020/4/16 9:48
 */
public class SalesReportConstant {

    @Getter
    public enum SkuTypeEnum {
        SHOP_SKU("shopSku", "店铺sku"),
        SHOP_PARENT_SKU("shopParentSku", "店铺父sku"),;
        String skuType;
        String skuTypeName;

        SkuTypeEnum(String skuType, String skuTypeName) {
            this.skuType = skuType;
            this.skuTypeName = skuTypeName;
        }
    }
}
