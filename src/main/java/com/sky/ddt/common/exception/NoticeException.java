package com.sky.ddt.common.exception;

/**
 * @author baixueping
 * @description 通知异常类
 * @date 2020/5/7 16:36
 */
public class NoticeException extends BaseException {
    public NoticeException(String code, String msg) {
        super(code, msg);
    }

    public NoticeException(String msg) {
        super(msg);
    }
}
