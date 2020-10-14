package com.sky.ddt.common.constant;

import lombok.Getter;

/**
 * @author baixueping
 * @description 盘点单静态类
 * @date 2020/5/11 10:06
 */
public class CheckOrderConstant {
    public static final String SHOP_ID_EMPTY = "店铺不能为空";
    public static final String REMARK_TOO_LONG = "备注长度不能超过200";
    public static final String ID_NOT_EXIST = "盘点单id不存在";
    public static final String NOT_ALLOW_CHANGE = "只有待确认的盘点单允许修改";
    public static final String EXIST_SHOP_SKU_NOT_ALLOW_CHANGE_SHOP_ID = "存在店铺sku不允许修改店铺";
    public static final String SHOP_ID_NOT_EXIST = "店铺id不存在";
    public static final String ID_EMPTY ="盘点单id不能为空";
    public static final String NOT_ALLOW_CANCEL = "只有待确认的订单允许取消";
    public static final String ONLY_PENDING_CONFIRM_ALLOW_CONFIRM ="只有待确认的订单允许确认";
    public static final String NOT_EXIST_SHOP_SKU_NOT_ALLOW_CONFIRM ="盘点单没有店铺sku，不允许确认" ;

    @Getter
    public enum StatusEnum {
        PENDING_CONFIRM(1, "待确认"),
        CONFIRM(2, "已确认"),
        CANCEL(0, "取消"),;
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
}
