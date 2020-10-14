package com.sky.ddt.dto.easyui.response;

import lombok.Data;

import java.util.List;

/**
 * @author baixueping
 * @description 菜单
 * @date 2019/6/24 17:13
 */
@Data
public class MenuTree {
    Integer id;
    String text;
    MenuTreeAttributes attributes;
    List<MenuTree> children;
}
