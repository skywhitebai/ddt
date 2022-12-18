package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.RoleMapper;
import com.sky.ddt.entity.Role;

import java.util.List;

/**
 * @author baixueping
 * @description 角色管理
 * @date 2019/6/13 15:52
 */
public interface CustomRoleMapper extends RoleMapper {
    List<Role> comboboxlist();

    List<String> userRoleList(Integer userId);
}
