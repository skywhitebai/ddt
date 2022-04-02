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
    public static final String[] EXPORT_SKU_HEAD = {"产品名称", "产品编码", "sku", "颜色", "色号", "尺码", "重量", "成本价", "头程费用", "库存数量", "创建时间", "备注"};
    public static final String WEIGHT_ERRO = "重量必须为大于0的数字";
    public static final String HEAD_TRIP_COST_ERRO = "头程费用必须为大于0的数字";
    public static final String INVENTORY_QUANTITY_ERRO = "库存数量必须为大于等于0的数字";
    public static final String WEIGHT_EMPTY = "重量不能为空";
    public static final String SKU_NOT_EXIST = "sku不存在";
    public static final String INVENTORY_QUANTITY_EMPTY = "库存数量不能为空";
    public static final String DEVELOPMENT_LEVEL_EMPTY = "开发等级不能为空";
    public static final String DEVELOPMENT_LEVEL_ERRO = "开发等级必续为0-10的数字";
    //fba头程费
    public static final BigDecimal HEAD_TRIP_COST_RATE = BigDecimal.valueOf(0.055);
    public static final BigDecimal HEAD_TRIP_COST_MIN_RATE = BigDecimal.valueOf(0.04);
    public static final String SIZE_ERRO = "尺码错误，尺码必须为F、XS到6XL";
    public static final String SUGGESTED_RETAIL_PRICE_EMPTY = "建议零售价不能为空";
    public static final String SUGGESTED_RETAIL_PRICE_ERRO = "建议零售价必须为大于0的数字";

    @Getter
    public enum SkuSizeEnum {
        F("F"),
        XS("XS"),
        S("S"),
        M("M"),
        L("L"),
        XL("XL"),
        XXL("2XL"),
        XXXL("3XL"),
        XXXXL("4XL"),
        XXXXXL("5XL"),
        XXXXXXL("6XL"),
        US2("US 2"),
        US4("US 4"),
        US6("US 6"),
        US8("US 8"),
        US10("US 10"),
        US12("US 12"),
        US14("US 14"),
        US16("US 16"),
        US18("US 18"),
        US20("US 20"),
        US22("US 22"),
        US24("US 24"),
        US26("US 26"),
        US28("US 28"),
        US30("US 30"),
        US32("US 32"),
        US34("US 34"),
        US36("US 36"),
        ;
        private String size;

        SkuSizeEnum(String size) {
            this.size = size;
        }

        public static Boolean containSize(String size) {
            for (SkuSizeEnum skuSizeEnum :
                    SkuSizeEnum.values()) {
                if (skuSizeEnum.getSize().equals(size)) {
                    return true;
                }
            }
            return false;
        }
    }
}
