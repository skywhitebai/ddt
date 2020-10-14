package com.sky.ddt.common.constant;

import lombok.Getter;

/**
 * @author baixueping
 * @description sku历史成本价
 * @date 2019/12/30 16:45
 */
public class SkuCostPriceHisConstant {
    @Getter
    public enum TypeEnum {
        SAVE(1, "页面修改"),
        IMPORT_SKU(2, "导入sku"),
        IMPORT_COST_PRICE(3, "导入成本价");

        private Integer type;
        private String typeName;

        TypeEnum(Integer type, String typeName) {
            this.type = type;
            this.typeName = typeName;
        }
        public static TypeEnum getTypeEnum(Integer type) {
            for (TypeEnum typeEnum : TypeEnum.values()) {
                if (typeEnum.getType().equals(type)) {
                    return typeEnum;
                }
            }
            return null;
        }
    }
}
