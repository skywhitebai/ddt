package com.sky.ddt.dto.sys.right.request;

import com.sky.ddt.common.constant.RightConstant;
import com.sky.ddt.entity.Right;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 保存权限
 * @date 2020/9/22 17:57
 */
@Data
public class SaveRightRequest {
    Integer id;
    @NotNull(message = RightConstant.MENU_ID_EMPTY)
    Integer menuId;
    @NotEmpty(message = RightConstant.RIGHT_NAME_EMPTY)
    @Length(max = 50, message = RightConstant.RIGHT_NAME_TOO_LONG)
    String rightName;
    @NotEmpty(message = RightConstant.RIGHT_STR_EMPTY)
    @Length(max = 50, message = RightConstant.RIGHT_STR_TOO_LONG)
    String rightStr;
}
