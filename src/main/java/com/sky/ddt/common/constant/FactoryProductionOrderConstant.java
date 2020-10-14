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
        UNCONFIRMED(0,"待确认"),
        CONFIRMED(0,"已确认");
        Integer status;
        String statusName;

        StatusEnum(Integer status, String statusName) {
            this.status = status;
            this.statusName = statusName;
        }
    }
}
