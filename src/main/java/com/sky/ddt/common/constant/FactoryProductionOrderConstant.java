package com.sky.ddt.common.constant;

import lombok.Getter;

/**
 * @author baixueping
 * @description 工厂生产单静态类
 * @date 2020/10/10 14:59
 */
public class FactoryProductionOrderConstant {
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
    }
}
