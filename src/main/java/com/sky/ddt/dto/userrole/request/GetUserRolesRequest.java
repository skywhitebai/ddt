package com.sky.ddt.dto.userrole.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description 获取用户角色
 * @date 2019/6/13 15:00
 */
@Data
public class GetUserRolesRequest extends DataGridRequest {
    Integer userId;
}
