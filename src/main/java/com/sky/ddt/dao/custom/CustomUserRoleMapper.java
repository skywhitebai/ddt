package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.UserRoleMapper;
import com.sky.ddt.dto.userrole.request.GetUserRolesRequest;
import com.sky.ddt.dto.userrole.response.UserRoleResponse;

import java.util.List;

/**
 * @author baixueping
 * @description 用户角色dao类
 * @date 2019/6/12 15:54
 */
public interface CustomUserRoleMapper extends UserRoleMapper {
    /**
     * @param
     * @param userId
     * @return
     * @description 获取用户的所有角色
     * @author baixueping
     * @date 2019/6/12 15:58
    */
    List<UserRoleResponse> getUserRoles(GetUserRolesRequest userId);
}
