package com.sky.ddt.dto.sys.role.request;
import com.sky.ddt.common.constant.RoleConstant;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author baixueping
 * @description 保存角色
 * @date 2019/6/21 10:16
 */
@Data
public class RoleSaveRequest {
    Integer id;
    @NotEmpty(message = RoleConstant.ROLE_NAME_EMPTY)
    String roleName;
    @Length(max = 200,message = RoleConstant.REMARK_TOO_LONG)
    String remark;
}
