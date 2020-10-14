package com.sky.ddt.dto.sys.menu.request;

import com.sky.ddt.common.constant.MenuConstant;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 保存菜单
 * @date 2019/6/19 14:48
 */
@Data
public class SaveMenuRequest {
    Integer id;
    @NotEmpty(message = MenuConstant.MENU_NAME_EMPTY)
    String menuName;
    @NotNull(message = MenuConstant.PARENT_MENU_ID_EMPTY)
    Integer parentMenuId;
    String url;
    @NotNull(message = MenuConstant.STATUS_EMPTY)
    Integer status;
    @NotNull(message = MenuConstant.SORT_EMPTY)
    Integer sort;
}
