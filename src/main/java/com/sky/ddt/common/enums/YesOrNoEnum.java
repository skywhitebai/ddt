package com.sky.ddt.common.enums;

import lombok.Getter;

@Getter
public enum YesOrNoEnum {
    YES(1),
    NO(0);
    Integer value;

    YesOrNoEnum(Integer value) {
        this.value = value;
    }
}
