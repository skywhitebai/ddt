package com.sky.ddt.dto.user.request;

import lombok.Data;

@Data
public class UserSaveRequest {
    String userName;
    String mobile;
    String realName;
    private Integer gender;

    private String email;

    private Integer status;
    private String remark;
    private Integer userId;
}
