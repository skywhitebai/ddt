package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.ShopUserMapper;
import com.sky.ddt.dto.shopUser.response.ShopUserResponse;
import com.sky.ddt.dto.shopUser.Request.GetShopUserListRequest;

import java.util.List;

/**
 * @author baixueping
 * @description 店铺用户
 * @date 2019/7/25 11:17
 */
public interface CustomShopUserMapper extends ShopUserMapper{
    List<ShopUserResponse> getShopUserList(GetShopUserListRequest params);
}
