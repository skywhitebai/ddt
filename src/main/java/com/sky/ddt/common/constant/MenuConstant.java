package com.sky.ddt.common.constant;

import lombok.Getter;

/**
 * @author baixueping
 * @description 菜单
 * @date 2019/6/18 17:55
 */
public class MenuConstant {

    public static final String MENU_NAME_EMPTY = "菜单名称不能为空";
    public static final String PARENT_MENU_ID_EMPTY = "父菜单不能为空";
    public static final String STATUS_EMPTY = "状态不能为空";
    public static final String PARENT_MENU_ID_NOT_EXIST = "父菜单id不存在";
    public static final String SORT_EMPTY = "排序不能为空";
    public static final String MENU_ID_NOT_EXIST ="菜单id不存在";
    public static final String PARENT_MENU_ID_ERRO ="父菜单选择错误，存在循环，请重新选择" ;

    @Getter
    public enum Status {

        AVAILABLE(1, "显示"),
        DISABLED(0, "不显示"),;

        private Status(Integer code, String label) {
            this.code = code;
            this.label = label;
        }

        private Integer code;
        private String label;
    }
}
