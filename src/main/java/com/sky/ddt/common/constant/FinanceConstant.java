package com.sky.ddt.common.constant;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * @author baixueping
 * @description 财务管理
 * @date 2019/11/22 10:39
 */
public class FinanceConstant {
    public static final String TYPE_EMPTY = "导入类型不能为空";
    public static final String MONTH_EMPTY = "月份不能为空";
    public static final String TYPE_NOT_EXIST = "导入类型不存在";
    public static final String FINANCE_LOCKED_NOT_ALLOW_IMPORT = "该店铺此月份财务报表已锁定，不允许导入，如需导入请联系管理员";
    public static final String CREATE_FINANCE_FAIL = "创建财务数据失败";
    public static final String MONTH_ERRO = "月份格式错误，必须为YYYY-MM";
    public static final String ID_EMPTY = "财务信息id不能为空";
    public static final String ID_NOT_EXIST = "财务信息id不存在";
    public static final String NOT_ALLOW_LOCK = "财务报表不允许锁定";
    public static final String NOT_ALLOW_CREATE_FINANCIAL_STATEMENT = "财务报表已锁定，不允许重复生成";
    public static final String GET_FINANCIAL_STATEMENT_RESPONSE_FAIL = "获取财务统计信息失败";
    //亚马逊店铺费
    public static final BigDecimal SELLERPAYMENTS_REPORT_FEE_SUBSCRIPTION = new BigDecimal(-39.99);
    public static final String[] EXPORT_FBA_CUSTOMER_RETURN_PER_UNIT_FEE_NOT_EXIST_SKU_HEAD = {"order_id", "total", "date_time"};
    public static final String FINANCE_ID_EMPTY = "财务id不能为空";
    public static final String REMARK_TOO_LONG = "备注长度不能超过500";
    public static final String NOT_ALLOW_UNLOCK = "财务报表未锁定，不允许解锁";

    @Getter
    public enum FinanceTypeEnum {
        MONTHLY_SALES("monthlySales"),
        LIGHTING_DEAL("lightingDeal"),
        MONTHLY_ADVERTISING_FEE("monthlyAdvertisingFee"),
        MONTHLY_STORAGE_FEE("monthlyStorageFee"),
        LONG_STORAGE_FEE("longStorageFee"),
        COUPON("coupon"),
        EARLY_REVIEWER_PROGRAM_FEE("earlyReviewerProgramFee"),
        DESTRUCTION_FEE("destructionFee"),
        DESTRUCTION_DETAILS("destructionDetails"),
        INVENTORY_DETAILS("inventoryDetails"),
        HEAD_DEDUCTION("headDeduction"),
        MANUAL_ADJUSTMENT("manualAdjustment"),
        BRAND_ADVERTISING("brandAdvertising"),
        DISPLAY_ADVERTISING("displayAdvertising"),

        REMOVE_ORDERS("removeOrders"),
        RETURN_ORDER("returnOrder"),;

        FinanceTypeEnum(String type) {
            this.type = type;
        }

        public static Boolean contains(String type) {
            return getFinanceTypeEnum(type) != null;
        }

        public static FinanceTypeEnum getFinanceTypeEnum(String type) {
            for (FinanceTypeEnum financeTypeEnum : FinanceTypeEnum.values()) {
                if (financeTypeEnum.getType().equals(type)) {
                    return financeTypeEnum;
                }
            }
            return null;
        }

        String type;
    }

    @Getter
    public enum FinanceStatusEnum {
        NOT_GENERATED("未生成", 0),
        GENERATED("已生成", 1),
        LOCKED("锁定", 2),;

        FinanceStatusEnum(String statusName, Integer status) {
            this.statusName = statusName;
            this.status = status;
        }

        String statusName;
        Integer status;
    }

    @Getter
    public enum FinanceExprotType {
        DEVELOPER("developer"),
        SALESMAN("salesman"),
        SALESGROUP("salesGroup"),;

        FinanceExprotType(String type) {
            this.type = type;
        }

        String type;
    }
}
