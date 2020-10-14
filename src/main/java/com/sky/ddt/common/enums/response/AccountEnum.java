package com.sky.ddt.common.enums.response;

import com.sky.ddt.common.constant.ResponseConstant;

public enum AccountEnum implements IResponseBaseEnum {
    LOGIN_USER_NAME_EMPTY("1001","用户名不能为空"),
    LOGIN_PASSWORD_EMPTY("1002","密码不能为空"),
    LOGIN_USER_NAME_NOT_EXIST("1003","用户名不存在"),
    LOGIN_PASSWORD_ERRO("1004","密码错误"),
    LOGIN_DISABLE(ResponseConstant.LOGIN_DISABLE_CODE,ResponseConstant.LOGIN_DISABLE_MESSAGE),
    USER_DISABLE("1005","用户已停用" ),
    NO_MENU("403","没有菜单权限" ),
    NO_RIGHT("403","没有权限" );

    private String code;
    private String message;

    AccountEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
