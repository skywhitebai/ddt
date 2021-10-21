package com.sky.ddt.common.constant;

import lombok.Getter;

/**
 * @author baixueping
 * @description 产品工价历史
 * @date 2019/12/30 16:45
 */
public class ProductLabourCostHisConstant {
    @Getter
    public enum TypeEnum {
        SAVE(1, "页面修改"),
        IMPORT_LABOUR_COST(2, "导入工价");

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

        public static String getTypeName(Integer type) {
            TypeEnum typeEnum=getTypeEnum(type);
            if(typeEnum==null){
                return null;
            }
            return typeEnum.typeName;
        }
    }
}
