package com.sky.ddt.common.constant;

import lombok.Getter;

/**
 * @author baixueping
 * @description 备货信息
 * @date 2019/8/21 14:54
 */
public class StockConsatnt {
    public static final String SHOP_ID_EMPTY = "店铺id不能为空";
    public static final String SHOP_SKU_ID_EMPTY = "shopSkuId不能为空";
    public static final String STOCK_QUANTITY_ERRO = "补货数量必须大于等于0";
    public static final String SHOP_SKU_ID_NOT_EXIST = "shopSkuId不存在";
    public static final String TYPE_EERO = "请选择正确的补货类型";
    public static final String PRODUCTION_QUANTITY_ERRO = "生产数量必须大于等于0";

    public enum StockQuantityTypeEnum {
        KY("ky"),
        KP("kp"),
        HY("hy"),
        HY2("hy2"),
        DL("dl"),
        DLX("dlx"),
        AMHY("amhy"),
        AMTY("amty"),;
        String type;

        public String getType() {
            return type;
        }

        StockQuantityTypeEnum(String type) {
            this.type = type;
        }
        public static StockQuantityTypeEnum getStockQuantityTypeEnum(String type){
            StockQuantityTypeEnum[] stockQuantityTypeEnums=StockQuantityTypeEnum.values();
            for (StockQuantityTypeEnum stockQuantityTypeEnum:stockQuantityTypeEnums){
                if(stockQuantityTypeEnum.getType().equals(type)){
                    return stockQuantityTypeEnum;
                }
            }
            return null;
        }
    }
    @Getter
    public enum TypeEnum {
        REPLENISHMENT(1,"补货"),
        FACTORY_PRODUCTION(2,"工厂生产单");
        Integer type;
        String typeName;

        TypeEnum(Integer type, String typeName) {
            this.type = type;
            this.typeName = typeName;
        }
    }
}
