package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopUser.response.ShopUserResponse;
import com.sky.ddt.dto.shopUser.Request.GetShopUserListRequest;
import com.sky.ddt.dto.shopUser.Request.SaveShopUserRequest;
import com.sky.ddt.entity.Shop;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author baixueping
 * @description 店铺用户
 * @date 2019/7/25 10:48
 */
public interface IShopUserService {
    /**
     * @param
     * @return
     * @description 获取店铺用户
     * @author baixueping
     * @date 2019/7/25 11:15
     */
    PageInfo<ShopUserResponse> getShopUserList(GetShopUserListRequest params);

    /**
     * @param
     * @return
     * @description 删除店铺用户
     * @author baixueping
     * @date 2019/7/25 14:16
     */
    BaseResponse deleteShopUser(List<Integer> shopUserIds);

    /**
     * @param
     * @return
     * @description 保存店铺用户
     * @author baixueping
     * @date 2019/7/25 14:16
     */
    BaseResponse saveShopUser(SaveShopUserRequest params, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 获取用户店铺
     * @author baixueping
     * @date 2019/7/29 10:08
     */
    List<Shop> listUserShop(Integer userId);

    /**
     * @param
     * @return
     * @description 判断用户是否存在指定店铺权限
     * @author baixueping
     * @date 2019/8/22 16:23
     */
    boolean exisShopUser(Integer shopId, Integer userId);
}
