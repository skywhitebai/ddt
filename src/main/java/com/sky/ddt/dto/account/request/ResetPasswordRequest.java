package com.sky.ddt.dto.account.request;

import com.sky.ddt.common.constant.AccountConstant;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 重置密码
 * @date 2019/7/12 16:12
 */
@Data
public class ResetPasswordRequest {
    @NotNull(message = AccountConstant.USERID_EMPTY)
    Integer userId;
    @NotEmpty(message = AccountConstant.PASSWORD_EMPTY)
    String newPassword;
}
