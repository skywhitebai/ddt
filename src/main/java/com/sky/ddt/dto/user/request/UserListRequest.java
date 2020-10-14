package com.sky.ddt.dto.user.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

@Data
public class UserListRequest extends DataGridRequest {
    String userName;
    String mobile;
    String realName;
    private Integer gender;

    private String email;

    private Integer status;
}

