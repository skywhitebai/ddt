package com.sky.ddt.common.constant;

import com.sky.ddt.common.excel.ExcelField;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baixueping
 * @description 内部单号运输信息静态类
 * @date 2020/7/1 16:56
 */
public class InternalOrderNumberTransportConstant {
    public static final String ID_EMPTY = "id不能为空";
    public static final String SUB_ORDER_NUMBER_EMPTY = "内部子单号不能为空";
    public static final String TRANSPORT_TYPE_ID_EMPTY = "物流渠道不能为空";
    public static final String TRANSFER_ORDER_NO_EMPTY = "转单号不能为空";
    public static final String FBA_SHIPMENT_ID_EMPTY = "fbaShipmentId不能为空";
    public static final String SUB_ORDER_NUMBER_TOO_LONG = "内部子单号长度不能超过50";
    public static final String FBA_SHIPMENT_ID_TOO_LONG = "fbaShipmentId长度不能超过50";
    public static final String TRANSFER_ORDER_NO_TOO_LONG = "转单号长度不能超过50";
    public static final String SUB_ORDER_NUMBER_PARENT_NOT_EXIST = "内部子单号对应的内部单号不存在";
    public static final String SUB_ORDER_NUMBER_NOT_EXIST = "内部子单号不存在";
    public static final String SUB_ORDER_NUMBER_REPEAT = "内部子单号不能重复";
    public static final String FBA_SHIPMENT_ID_REPEAT = "fbaShipmentId不能重复";
    public static final String SUB_ORDER_NUMBER_EXIST = "内部子单号已存在";
    public static final String FBA_SHIPMENT_ID_EXIST = "fbaShipmentId已存在";
    public static final String ID_NOT_EXIST = "id不存在";
    public static final String TRANSPORT_TYPE_ID_NOT_EXIST = "物流渠道号不存在";
    public static final String FBA_START = "FBA";
    public static final String FBA_SHIPMENT_ID_ERRO = "fbaShipmentId必须以FBA开头";
    public static final String ORDER_NUMBER_EMPTY = "单号不能为空";
    public static final String ORDER_NUMBER_REPEAT = "单号不能重复";
    public static final String ORDER_NUMBER_NOT_EXIST = "单号不存在";
    public static final String HEAD_TRIP_COST_RATE_ERRO = "头程费率必须在0.001-0.200之间的三位小数";
    public static final String HEAD_TRIP_COST_RATE_EMPTY = "头程费率不允许为空";
    public static final String SEND_STATUS_SENT ="此订单已发货不允许重复发货" ;
    public static final String U_PREFIX = "U000";
    public static final String LOCK_HEAD_TRIPCOST_RATE_NOT_ALLOW_CHANGE ="头程费已锁定不允许修改" ;
    public static List<ExcelField> exprotInternalOrderNumberTransportFieldList = new ArrayList<>();

    static {
        exprotInternalOrderNumberTransportFieldList.add(new ExcelField("orderNumber", "单号", ExcelField.FieldTypeEnum.STRING));
        exprotInternalOrderNumberTransportFieldList.add(new ExcelField("subOrderNumber", "子单号", ExcelField.FieldTypeEnum.STRING));
        exprotInternalOrderNumberTransportFieldList.add(new ExcelField("fbaShipmentId", "fbaShipmentId", ExcelField.FieldTypeEnum.STRING));
        exprotInternalOrderNumberTransportFieldList.add(new ExcelField("transferOrderNo", "转单号", ExcelField.FieldTypeEnum.STRING));
        exprotInternalOrderNumberTransportFieldList.add(new ExcelField("headTripCostRate", "头程费率", ExcelField.FieldTypeEnum.NUMBER));
        exprotInternalOrderNumberTransportFieldList.add(new ExcelField("transportTypeName", "物流渠道", ExcelField.FieldTypeEnum.STRING));
    }

    @Getter
    public enum LockHeadTripCostRateEnum {
        LOCK(1, "锁定"),
        UN_LOCK(0, "未锁定");
        Integer lockHeadTripCostRate;
        String lockHeadTripCostRateName;

        LockHeadTripCostRateEnum(Integer lockHeadTripCostRate, String lockHeadTripCostRateName) {
            this.lockHeadTripCostRate = lockHeadTripCostRate;
            this.lockHeadTripCostRateName = lockHeadTripCostRateName;
        }

        public static boolean contains(Integer lockHeadTripCostRate) {
            for (LockHeadTripCostRateEnum lockHeadTripCostRateEnum : LockHeadTripCostRateEnum.values()) {
                if (lockHeadTripCostRateEnum.getLockHeadTripCostRate().equals(lockHeadTripCostRate)) {
                    return true;
                }
            }
            return false;
        }
    }

    @Getter
    public enum SendStatusEnum {
        SENT(1, "已发货"),
        UN_send(0, "未发货");
        Integer sendStatus;
        String sendStatusName;

        SendStatusEnum(Integer sendStatus, String sendStatusName) {
            this.sendStatus = sendStatus;
            this.sendStatusName = sendStatusName;
        }
    }
}
