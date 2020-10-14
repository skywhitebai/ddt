package com.sky.ddt.common.exception;

/**
 * @author baixueping
 * @description 基础异常类
 * @date 2020/5/7 16:35
 */
public class BaseException extends RuntimeException {
    private String code = "10000";

    public BaseException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public BaseException(String msg) {
        super(msg);
    }

    public BaseException(Throwable throwable) {
        super(throwable);
    }

    public BaseException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}