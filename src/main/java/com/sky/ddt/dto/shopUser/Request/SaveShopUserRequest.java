package com.sky.ddt.dto.shopUser.Request;

import com.sky.ddt.common.constant.ShopConstant;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 保存店铺用户
 * @date 2019/7/25 11:38
 */
@Data
public class SaveShopUserRequest {
    @NotNull(message = ShopConstant.SHOP_ID_EMPTY)
    Integer shopId;
    @NotNull(message = ShopConstant.USER_ID_EMPTY)
    Integer userId;
}
