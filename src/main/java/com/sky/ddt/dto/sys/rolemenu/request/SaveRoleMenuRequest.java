package com.sky.ddt.dto.sys.rolemenu.request;

import lombok.Data;

import java.util.List;

/**
 * @author baixueping
 * @description 保存角色菜单
 * @date 2019/6/24 14:52
 */
@Data
public class SaveRoleMenuRequest {
    Integer roleId;
    List<Integer> menuIds;
}
