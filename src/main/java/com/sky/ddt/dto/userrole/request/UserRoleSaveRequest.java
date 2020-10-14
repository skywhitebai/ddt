package com.sky.ddt.dto.userrole.request;

import com.sky.ddt.common.constant.UserRoleConstant;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 保存用户信息
 * @date 2019/6/13 15:35
 */
@Data
public class UserRoleSaveRequest {
    @NotNull(message = UserRoleConstant.USER_ID_EMPTY )
    Integer userId;
    @NotNull(message = UserRoleConstant.ROLE_ID_EMPTY )
    Integer roleId;
}
