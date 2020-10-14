package com.sky.ddt.common.constant;

import lombok.Getter;

/**
 * @author baixueping
 * @description 调拨单静态类
 * @date 2020/8/31 17:32
 */
public class TransferOrderConstant {

    public static final String SHOP_ID_FROM_EMPTY ="调出店铺不能为空" ;
    public static final String SHOP_ID_TO_EMPTY ="调入店铺不能为空" ;
    public static final String REMARK_TOO_LONG ="备注长度不能超过200" ;
    public static final String ID_NOT_EXIST ="id不存在" ;
    public static final String NOT_ALLOW_CHANGE ="只有待调拨的订单允许修改";
    public static final String EXIST_SHOP_SKU_NOT_ALLOW_CHANGE_SHOP_ID ="存在店铺sku不允许修改店铺";
    public static final String SHOP_ID_FROM_SHOP_ID_TO_NOT_ALLOW_SAME ="出库店铺和入库店铺不能相同" ;
    public static final String SHOP_ID_FROM_NOT_EXISTS ="出库店铺id不存在" ;
    public static final String SHOP_ID_TO_NOT_EXISTS ="入库店铺id不存在" ;
    public static final String ID_EMPTY ="调拨单id不能为空";
    public static final String NOT_ALLOW_CANCEL ="只有待调拨的订单允许取消";
    public static final String ONLY_PENDING_TRANSFER_ALLOW_TRANSFER = "只有待调拨的订单允许调拨";
    public static final String NOT_EXIST_SHOP_SKU_NOT_ALLOW_TRANSFER ="没有店铺sku信息不允许调拨" ;

    @Getter
    public enum StatusEnum {
        PENDING_TRANSFER(1, "待调拨"),
        TRANSFER(2, "已调拨"),
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
