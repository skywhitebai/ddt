package com.sky.ddt.service.sys;

import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.RoleRight;

import java.util.List;

/**
 * @author baixueping
 * @description 角色权限服务
 * @date 2020/9/22 18:49
 */
public interface IRoleRightService {
    void deleteByRightId(Integer id);

    BaseResponse<List<RoleRight>> roleRightList(Integer roleId);

    BaseResponse saveRoleRight(Integer roleId, List<Integer> rightIdList, Integer currentUserId);
}
