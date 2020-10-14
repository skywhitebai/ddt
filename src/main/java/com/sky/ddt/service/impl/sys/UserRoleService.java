package com.sky.ddt.service.impl.sys;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.UserRoleConstant;
import com.sky.ddt.dao.custom.CustomUserRoleMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.userrole.request.GetUserRolesRequest;
import com.sky.ddt.dto.userrole.request.UserRoleSaveRequest;
import com.sky.ddt.dto.userrole.response.UserRoleResponse;
import com.sky.ddt.entity.UserRole;
import com.sky.ddt.entity.UserRoleExample;
import com.sky.ddt.service.sys.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author baixueping
 * @description 用户角色服务
 * @date 2019/6/12 15:44
 */
@Service
public class UserRoleService implements IUserRoleService {
    @Autowired
    CustomUserRoleMapper customUserRoleMapper;

    /**
     * @param params @return
     * @description 获取用户拥有的角色
     * @author baixueping
     * @date 2019/6/12 15:52
     */
    @Override
    public PageInfo<UserRoleResponse> getUserRoles(GetUserRolesRequest params) {
        if (params.getUserId() == null) {
            return new PageInfo<>();
        }
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<UserRoleResponse> list = customUserRoleMapper.getUserRoles(params);
        PageInfo<UserRoleResponse> page = new PageInfo<UserRoleResponse>(list);
        return page;
    }

    /**
     * @param ids@return
     * @description 删除用户角色
     * @author baixueping
     * @date 2019/6/13 15:13
     */
    @Override
    public BaseResponse delete(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return BaseResponse.success();
        }
        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.createCriteria().andIdIn(ids);
        customUserRoleMapper.deleteByExample(userRoleExample);
        return BaseResponse.success();
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 添加用户角色
     * @author baixueping
     * @date 2019/6/13 15:37
     */
    @Override
    public BaseResponse save(UserRoleSaveRequest params, Integer dealUserId) {
        if (existUserRole(params.getUserId(), params.getRoleId())) {
            return BaseResponse.failMessage(UserRoleConstant.USER_ROLE_EXIST);
        }
        UserRole userRole = new UserRole();
        userRole.setCreateBy(dealUserId);
        userRole.setRoleId(params.getRoleId());
        userRole.setUserId(params.getUserId());
        customUserRoleMapper.insert(userRole);
        return BaseResponse.success();
    }

    /**
     * @param roleId@return
     * @description 通过角色id删除所有用户此角色
     * @author baixueping
     * @date 2019/6/21 11:13
     */
    @Override
    public void deleteByRoleId(Integer roleId) {
        UserRoleExample example = new UserRoleExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        customUserRoleMapper.deleteByExample(example);
    }

    /**
     * @param
     * @return
     * @description 判断用户是否存在指定角色
     * @author baixueping
     * @date 2019/6/13 15:43
     */
    Boolean existUserRole(Integer userId, Integer roleId) {
        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.createCriteria().andUserIdEqualTo(userId).andRoleIdEqualTo(roleId);
        long count = customUserRoleMapper.countByExample(userRoleExample);
        if (count > 0) {
            return true;
        }
        return false;
    }
}
