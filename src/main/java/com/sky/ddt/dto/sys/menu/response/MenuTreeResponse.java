package com.sky.ddt.dto.sys.menu.response;

import lombok.Data;

import java.util.List;

/**
 * @author baixueping
 * @description 菜单树
 * @date 2019/6/18 17:39
 */
@Data
public class MenuTreeResponse {
    private Integer id;

    private String menuName;
    private String text;
    private String url;
    private Integer sort;

    private Integer parentMenuId;

    private Integer status;

    private List<MenuTreeResponse> children;

    public void setMenuName(String menuName) {
        this.menuName = menuName;
        this.text = menuName;
    }
}
