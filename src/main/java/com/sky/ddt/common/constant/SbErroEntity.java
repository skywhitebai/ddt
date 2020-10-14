package com.sky.ddt.common.constant;

import com.sky.ddt.dto.response.BaseResponse;

/**
 * @author baixueping
 * @description 错误类
 * @date 2020/3/30 17:06
 */
public class SbErroEntity {
    StringBuilder sbErro = new StringBuilder();
    String splitStr = ",";

    public SbErroEntity() {
    }

    public SbErroEntity(String splitStr) {
        this.splitStr = splitStr;
    }

    public SbErroEntity append(String erroMessage) {
        sbErro.append(splitStr).append(erroMessage);
        return this;
    }

    public Boolean isSuccess() {
        if (sbErro.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean isFail() {
        if (sbErro.length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public BaseResponse getResponse() {
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
        return BaseResponse.success();
    }

    public String getMessage() {
        if (sbErro.length() > 0) {
            return sbErro.substring(1);
        }
        return null;
    }
}
