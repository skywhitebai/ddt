package com.sky.ddt.service.sys;

import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.RoleMenu;

import java.util.List;

/**
 * @author baixueping
 * @description 角色菜单
 * @date 2019/6/21 11:09
 */
public interface IRoleMenuService {
    /**
     * @param
     * @return
     * @description 通过角色id删除角色菜单
     * @author baixueping
     * @date 2019/6/21 11:15
     */
    void deleteByRoleId(Integer id);

    /**
     * @param
     * @param roleId
     * @return
     * @description 获取角色菜单
     * @author baixueping
     * @date 2019/6/24 14:09
     */
    BaseResponse<List<RoleMenu>> roleMenuList(Integer roleId);

    /**
     * @param
     * @return
     * @description 保存角色菜单
     * @author baixueping
     * @date 2019/6/24 14:53
     */
    BaseResponse save(Integer roleId, List<Integer> menuIds, Integer currentUserId);

    /**
     * @param
     * @param menuRightIds
     * @return
     * @description 保存角色菜单和权限
     * @author baixueping
     * @date 2020/9/27 14:07
     */
    BaseResponse saveRoleMenuRight(Integer roleId, List<String> menuRightIds, Integer currentUserId);
}
