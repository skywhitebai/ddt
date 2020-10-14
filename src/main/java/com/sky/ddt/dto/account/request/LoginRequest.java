package com.sky.ddt.dto.account.request;

import lombok.Data;

@Data
public class LoginRequest {
    String  userName;
    String  password;
    String  macAddress;
}
