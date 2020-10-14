package com.sky.ddt.service.sys;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.userrole.request.GetUserRolesRequest;
import com.sky.ddt.dto.userrole.request.UserRoleSaveRequest;
import com.sky.ddt.dto.userrole.response.UserRoleResponse;

import java.util.List;

/**
 * @author baixueping
 * @description 用户角色服务
 * @date 2019/6/12 15:42
 */
public interface IUserRoleService {
    /**
     * @param
     * @param params
     * @return
     * @description 获取用户拥有的角色
     * @author baixueping
     * @date 2019/6/12 15:52
     */
    PageInfo<UserRoleResponse> getUserRoles(GetUserRolesRequest params);

    /**
     * @param
     * @return
     * @description 删除用户角色
     * @author baixueping
     * @date 2019/6/13 15:13
     */
    BaseResponse delete(List<Integer> ids);

    /**
     * @param
     * @return
     * @description 添加用户角色
     * @author baixueping
     * @date 2019/6/13 15:37
     */
    BaseResponse save(UserRoleSaveRequest params, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 通过角色id删除所有用户此角色
     * @author baixueping
     * @date 2019/6/21 11:13
     */
    void deleteByRoleId(Integer id);
}
