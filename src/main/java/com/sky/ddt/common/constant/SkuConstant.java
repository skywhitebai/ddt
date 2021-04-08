package com.sky.ddt.common.constant;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * @author baixueping
 * @description sku常量
 * @date 2019/5/10 15:22
 */
public class SkuConstant {
    public static final String PRODUCT_CODE_EMPTY = "产品sku不能为空";
    public static final String SKU_EMPTY = "sku不能为空";
    public static final String COLOR_EMPTY = "颜色不能为空";
    public static final String SIZE_EMPTY = "尺码不能为空";
    public static final String COST_PRICE_EMPTY = "成本价不能为空";
    public static final String PRODUCT_CODE_NOT_EXIST = "产品编码不存在";
    public static final String COST_PRICE_ERRO = "成本价必须为大于0的数字";
    public static final String SKU_ID_NOT_EXIST = "skuId不存在";
    public static final String[] EXPORT_SKU_HEAD = {"产品名称","产品编码", "sku", "颜色", "色号","尺码", "重量", "成本价", "头程费用", "库存数量","创建时间","备注"};
    public static final String WEIGHT_ERRO = "重量必须为大于0的数字";
    public static final String HEAD_TRIP_COST_ERRO = "头程费用必须为大于0的数字";
    public static final String INVENTORY_QUANTITY_ERRO = "库存数量必须为大于等于0的数字";
    public static final String WEIGHT_EMPTY = "重量不能为空";
    public static final String SKU_NOT_EXIST = "sku不存在";
    public static final String INVENTORY_QUANTITY_EMPTY ="库存数量不能为空";
    public static final String DEVELOPMENT_LEVEL_EMPTY ="开发等级不能为空";
    public static final String DEVELOPMENT_LEVEL_ERRO ="开发等级必续为0-10的数字";
    //fba头程费
    public static final BigDecimal HEAD_TRIP_COST_RATE= BigDecimal.valueOf(0.055);
    public static final BigDecimal HEAD_TRIP_COST_MIN_RATE= BigDecimal.valueOf(0.04);
    public static final String SIZE_ERRO ="尺码错误，尺码必须为XS到6XL" ;

    @Getter
    public enum SkuSizeEnum {
        XS("XS"),
        S("S"),
        M("M"),
        L("L"),
        XL("XL"),
        XXL("2XL"),
        XXXL("3XL"),
        XXXXL("4XL"),
        XXXXXL("5XL"),
        XXXXXXL("6XL");
        private String size;

        SkuSizeEnum(String size) {
            this.size = size;
        }
        public static Boolean containSize(String size){
            for (SkuSizeEnum skuSizeEnum:
                    SkuSizeEnum.values()) {
                if(skuSizeEnum.getSize().equals(size)){
                    return true;
                }
            }
            return false;
        }
    }
}
