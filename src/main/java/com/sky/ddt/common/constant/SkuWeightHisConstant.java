package com.sky.ddt.common.constant;

import lombok.Getter;

/**
 * @author baixueping
 * @description sku历史成本价
 * @date 2019/12/30 16:45
 */
public class SkuWeightHisConstant {
    @Getter
    public enum WeightHisTypeEnum {
        SAVE(1, "页面修改"),
        IMPORT_SKU(2, "导入sku"),
        IMPORT_COST_PRICE(3, "导入重量");

        private Integer type;
        private String typeName;

        WeightHisTypeEnum(Integer type, String typeName) {
            this.type = type;
            this.typeName = typeName;
        }

        public static WeightHisTypeEnum getTypeEnum(Integer type) {
            for (WeightHisTypeEnum typeEnum : WeightHisTypeEnum.values()) {
                if (typeEnum.getType().equals(type)) {
                    return typeEnum;
                }
            }
            return null;
        }
    }
}
