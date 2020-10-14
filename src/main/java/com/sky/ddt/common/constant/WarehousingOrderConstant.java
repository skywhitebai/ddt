package com.sky.ddt.common.constant;

import lombok.Getter;

/**
 * @author baixueping
 * @description 入库单
 * @date 2020/4/10 16:12
 */
public class WarehousingOrderConstant {

    public static final String SHOP_ID_EMPTY = "店铺不能为空";
    public static final String TYPE_EMPTY = "入库类型不能为空";
    public static final String WAREHOUSING_TIME_EMPTY = "入库时间不能为空";
    public static final String BATCH_NUMBER_EMPTY = "入库单批号不能为空";
    public static final String BATCH_NUMBER_TOO_LONG = "批次号长度不能超过50";
    public static final String REMARK_TOO_LONG = "备注长度不能超过200";
    public static final String PRODUCE_ORDER_BATCH_NUMBER_EMPTY = "生产单批次号不能为空";
    public static final String PRODUCE_ORDER_BATCH_NUMBER_NOT_EXIST = "生产单批次号不存在";
    public static final String PRODUCE_ORDER_CANCEL = "生产单已作废，不允许创建入库单";
    public static final String BATCH_NUMBER_EXIST = "入库单批号已存在";
    public static final String PRODUCE_ORDER_SHOP_ID_NOT_SAME = "生产单和入库单店铺不一致";
    public static final String SHOP_ID_NOT_EXIST = "店铺id不存在";
    public static final String ID_EMPTY = "入库单id不能为空";
    public static final String ID_NOT_EXIST = "入库单id不存在";
    public static final String NOT_ALLOW_CANCEL = "只有待入库的订单允许作废";
    public static final String NOT_ALLOW_CHANGE = "只有待入库的订单允许修改";
    public static final String EXIST_SHOP_SKU_NOT_ALLOW_CHANGE_SHOP_ID = "存在店铺sku不允许修改店铺";
    public static final String ONLY_PENDING_STORAGE_ALLOW_WAREHOUSING = "只有待入库的订单允许入库";
    public static final String NOT_EXIST_SHOP_SKU_NOT_ALLOW_WAREHOUSING ="入库单没有店铺sku，不允许入库" ;
    public static final String SHOP_SKU_QUANTITY_ZERO_NOT_ALLOW_WAREHOUSING ="店铺sku的数量为0，不允许入库" ;
    public static final String PRODUCE_ORDER_NOT_EXIST ="生产单不存在，不允许入库" ;
    public static final String PRODUCE_ORDER_STATUS_NOT_ALLOW_WAREHOUSING ="只有待入库、部分入库的生产单允许入库" ;
    public static final String SHOP_SKU_ID_NOT_EXIST ="店铺sku[%s]不存在" ;

    @Getter
    public enum StatusEnum {
        PENDING_STORAGE(1, "待入库"),
        WAREHOUSING(2, "已入库"),
        CANCEL(0, "取消"),;
        Integer status;
        String statusName;

        StatusEnum(Integer status, String statusName) {
            this.status = status;
            this.statusName = statusName;
        }

        public static boolean contains(Integer status) {
            for (StatusEnum statusEnum : StatusEnum.values()) {
                if (statusEnum.status.equals(status)) {
                    return true;
                }
            }
            return false;
        }

        public static String getStatusName(Integer status) {
            for (StatusEnum statusEnum : StatusEnum.values()) {
                if (statusEnum.status.equals(status)) {
                    return statusEnum.statusName;
                }
            }
            return null;
        }
    }

    @Getter
    public enum TypeEnum {
        PRODUCTION_ORDER_WAREHOUSING(1, "生产单入库"),
        MANUAL_WAREHOUSING(2, "手工入库"),;
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
}
