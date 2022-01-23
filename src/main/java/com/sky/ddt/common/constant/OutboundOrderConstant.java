package com.sky.ddt.common.constant;

import com.sky.ddt.common.excel.ExcelField;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baixueping
 * @description 出库单静态类
 * @date 2020/5/12 10:09
 */
public class OutboundOrderConstant {
    public static final String SHOP_ID_EMPTY = "店铺不能为空";
    public static final String FBA_NO_TOO_LONG = "FBA编号长度不能超过50";
    public static final String REMARK_TOO_LONG = "备注长度不能超过200";
    public static final String ID_NOT_EXIST = "出库单id不存在";
    public static final String NOT_ALLOW_CHANGE = "只有待出库的订单允许修改";
    public static final String EXIST_SHOP_SKU_NOT_ALLOW_CHANGE_SHOP_ID = "存在店铺sku不允许修改店铺";
    public static final String SHOP_ID_NOT_EXIST = "店铺id不存在";
    public static final String ID_EMPTY ="出库单id不能为空";
    public static final String NOT_ALLOW_CANCEL ="只有待出库的订单允许取消";
    public static final String ONLY_PENDING_OUTBOUND_ALLOW_OUTBOUND = "只有待出库的订单允许出库";
    public static final String NOT_EXIST_SHOP_SKU_NOT_ALLOW_OUTBOUND ="出库单没有店铺sku，不允许出库" ;
    public static final String SHOP_SKU_SHOP_ID_NOT_SAME ="店铺sku的店铺不一致" ;
    public static final String FBA_PACKING_LIST_ID_EXIST ="fba装箱单的出库单已生成，不允许重复生成" ;
    public static final String SHOP_TYPE_ERRO ="店铺类型错误" ;
    public static final String OUTBOUND_SHOP_ID_NOT_EXIST ="出库仓库id错误" ;
    public static final String OUTBOUND_SHOP_TYPE_ERRO ="出库仓库类型错误" ;
    public static final String OUTBOUND_SHOP_ID_EMPTY ="出库仓库不能为空" ;

    @Getter
    public enum StatusEnum {
        PENDING_OUTBOUND(1, "待出库"),
        OUTBOUND(2, "已出库"),
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

    @Getter
    public enum TypeEnum{
        MANUAL_OUTBOUND(1,"手工出库"),
        FBA_PACKING_LIST_OUTBOUND(2,"FBA装箱单出库"),;
        Integer type;
        String typeName;

        TypeEnum(Integer type, String typeName) {
            this.type = type;
            this.typeName = typeName;
        }
    }
}
