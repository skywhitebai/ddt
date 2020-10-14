package com.sky.ddt.dto.userrole.response;

import lombok.Data;

/**
 * @author baixueping
 * @description 用户角色实体
 * @date 2019/6/12 16:01
 */
@Data
public class UserRoleResponse {
    Integer id;
    Integer userId;
    Integer roleId;
    String roleName;
}
