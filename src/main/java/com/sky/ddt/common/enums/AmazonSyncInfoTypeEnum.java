package com.sky.ddt.common.enums;

import lombok.Getter;

/**
 * @author baixueping
 * @description 亚马逊同步信息类型
 * @date 2021/5/11 14:45
 */
@Getter
public enum AmazonSyncInfoTypeEnum {
    ORDER("order"),
    FBA_INVENTORY("fbaInventory");

    String type;

    AmazonSyncInfoTypeEnum(String type) {
        this.type = type;
    }
}
