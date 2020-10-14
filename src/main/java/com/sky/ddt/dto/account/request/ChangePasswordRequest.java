package com.sky.ddt.dto.account.request;
import lombok.Data;

@Data
public class ChangePasswordRequest {
    String oldPassword;
    String password;
    String confirmPassword;
}
