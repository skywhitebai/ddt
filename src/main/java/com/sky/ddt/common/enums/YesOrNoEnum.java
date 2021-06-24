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
    public static Boolean containValue(Integer value){
        for (YesOrNoEnum itemEmun:
             YesOrNoEnum.values()) {
            if(itemEmun.value.equals(value)){
                return true;
            }
        }
        return false;
    }
}
