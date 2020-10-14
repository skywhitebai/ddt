package com.sky.ddt.common.enums.response;

import com.sky.ddt.common.constant.ResponseConstant;


public enum ResponseEnum implements IResponseBaseEnum {

    SUCCESS(ResponseConstant.SUCCESS_CODE,ResponseConstant.SUCCESS_MESSAGE),
    FAIL(ResponseConstant.FAIL_CODE,ResponseConstant.FAIL_MESSAGE),
    NO_RIGHT(ResponseConstant.NO_RIGHT_CODE,ResponseConstant.NO_RIGHT_MESSAGE),
    LOGIN_DISABLE(ResponseConstant.LOGIN_DISABLE_CODE,ResponseConstant.LOGIN_DISABLE_MESSAGE);
    private String code;
    private String message;
    ResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
