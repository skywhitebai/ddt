package com.sky.ddt.dto.shopUser.response;

import lombok.Data;

/**
 * @author baixueping
 * @description 店铺用户
 * @date 2019/7/25 11:02
 */
@Data
public class ShopUserResponse {
    Integer shopUserId;
    Integer userId;
    Integer shopId;
    String userName;
}
