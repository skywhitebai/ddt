package com.sky.ddt.common.constant;

import lombok.Getter;

/**
 * @author baixueping
 * @description 生产单常量
 * @date 2020/3/30 9:26
 */
public class ProduceOrderConstant {
    public static final String SHOP_ID_EMPTY = "店铺不能为空";
    public static final String PRODUCTION_TIME_EMPTY = "生产日期不能为空";
    public static final String BATCH_NUMBER_EMPTY = "生产批号不能为空";
    public static final String BATCH_NUMBER_TOO_LONG = "批次号长度不能超过50";
    public static final String REMARK_TOO_LONG = "备注长度不能超过200";
    public static final String ID_NOT_EXIST = "生产单id不存在";
    public static final String BATCH_NUMBER_EXIST = "生产批号已存在";
    public static final String ID_EMPTY = "生产单id不能为空";
    public static final String NOT_ALLOW_CANCEL = "只有待生产的订单允许作废";
    public static final String NOT_ALLOW_CHANGE_SHOP_ID = "生产单已有店铺sku，不允许修改店铺";
    public static final String SHOP_ID_NOT_EXIST = "店铺id不存在";
    public static final String ONLY_PARTIAL_STORAGE_ALLOW_FINISHED_PRODUCTION = "只有部分入库的生产单允许生产完毕";
    public static final String EXIST_PENDING_STORAGE_WAREHOUSING_ORDER_NOT_ALLOW_FINISHED_PRODUCTION = "生产单存在待入库的入库单不允许生产完毕";
    public static final String SHOP_SKU_EMPTY = "店铺sku不能为空";
    public static final String SHOP_SKU_NOT_EXIST = "店铺sku不存在";
    public static final String COST_REMARK_TOO_LONG = "成本备注长度不能超过500";

    @Getter
    public enum StatusEnum {
        PENDING_STORAGE(1, "待入库"),
        PARTIAL_STORAGE(2, "部分入库"),
        FINISHED_PRODUCTION(3, "生产完毕"),
        CANCEL(0, "作废"),;
        Integer status;
        String statusName;

        StatusEnum(Integer status, String statusName) {
            this.status = status;
            this.statusName = statusName;
        }

        public static boolean contains(Integer status) {
            for (StatusEnum statusEnum : StatusEnum.values()) {
                if (statusEnum.getStatus().equals(status)) {
                    return true;
                }
            }
            return false;
        }

        public static String getStatusName(Integer status) {
            for (StatusEnum statusEnum : StatusEnum.values()) {
                if (statusEnum.getStatus().equals(status)) {
                    return statusEnum.statusName;
                }
            }
            return null;
        }
    }
    @Getter
    public enum TypeEnum {
        MANUAL(1, "手工生产单"),
        FACTORY_PRODUCTION_ORDER(2, "工厂生产单"),;
        Integer type;
        String typeName;

        TypeEnum(Integer type, String typeName) {
            this.type = type;
            this.typeName = typeName;
        }

        public static boolean contains(Integer type) {
            for (TypeEnum typeEnum : TypeEnum.values()) {
                if (typeEnum.type.equals(type)) {
                    return true;
                }
            }
            return false;
        }

        public static String getTypeName(Integer type) {
            for (TypeEnum typeEnum : TypeEnum.values()) {
                if (typeEnum.type.equals(type)) {
                    return typeEnum.typeName;
                }
            }
            return null;
        }
    }
    @Getter
    public enum CostStatusEnum {
        NOT_CALCULATED(0, "未计算"),
        CALCULATED(1, "已计算"),;
        Integer status;
        String statusName;

        CostStatusEnum(Integer status, String statusName) {
            this.status = status;
            this.statusName = statusName;
        }

        public static boolean contains(Integer status) {
            for (CostStatusEnum statusEnum : CostStatusEnum.values()) {
                if (statusEnum.getStatus().equals(status)) {
                    return true;
                }
            }
            return false;
        }

        public static String getStatusName(Integer status) {
            for (CostStatusEnum statusEnum : CostStatusEnum.values()) {
                if (statusEnum.getStatus().equals(status)) {
                    return statusEnum.statusName;
                }
            }
            return null;
        }
    }
}
