package com.sky.ddt.dto.easyui.response;

import lombok.Data;

import java.util.List;

/**
 * @author baixueping
 * @description  树
 * @date 2019/6/21 16:57
 */
@Data
public class MenuRightTreeResponse {
    String id;
    Integer menuId;
    Integer rightId;
    Integer type;
    String text;
    String state;
    String iconCls;
    List<MenuRightTreeResponse> children;
}
