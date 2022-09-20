package com.sky.ddt.util;

import com.sky.ddt.dto.response.BaseResponse;

/**
 * @author sky
 * @Description
 * @date 2022/9/15 21:20
 */
public class BaseResponseUtils {
    public static boolean isFail(BaseResponse baseResponse) {
        return !isSuccess(baseResponse);
    }

    public static boolean isSuccess(BaseResponse baseResponse) {
        return BaseResponse.SUCCESS_CODE.equals(baseResponse.getCode());
    }

    public static boolean isFailOrEmpty(BaseResponse baseResponse) {
        return !isSuccess(baseResponse) || baseResponse.getData() == null;
    }
}
