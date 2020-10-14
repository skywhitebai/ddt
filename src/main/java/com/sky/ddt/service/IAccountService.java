package com.sky.ddt.service;

import com.sky.ddt.dto.account.request.ChangePasswordRequest;
import com.sky.ddt.dto.account.request.LoginRequest;
import com.sky.ddt.dto.account.request.ResetPasswordRequest;
import com.sky.ddt.dto.response.BaseResponse;

public interface IAccountService {
    BaseResponse login(LoginRequest params);

    BaseResponse changePassword(ChangePasswordRequest params, Integer currentUserId);

    /**
     * 客户端登录
     *
     * @param params
     * @param request
     * @return
     */
    BaseResponse clientLogin(LoginRequest params);

    /**
     * @param
     * @return
     * @description 重置密码
     * @author baixueping
     * @date 2019/7/12 16:15
     */
    BaseResponse resetPassword(ResetPasswordRequest params, Integer currentUserId);

}
