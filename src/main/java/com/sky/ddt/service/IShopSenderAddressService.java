package com.sky.ddt.service;

import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.ShopSenderAddress;

/**
 * @author baixueping
 * @description 店铺发货地址
 * @date 2019/7/26 15:28
 */
public interface IShopSenderAddressService {
    /**
     * @param
     * @return
     * @description 获取店铺发货地址
     * @author baixueping
     * @date 2019/7/26 15:37
     */
    BaseResponse getShopSenderAddress(Integer shopId);

    /**
     * @param
     * @param currentUserId
     * @return
     * @description 保存店铺发货地址
     * @author baixueping
     * @date 2019/7/26 15:54
     */
    BaseResponse saveShopSenderAddress(ShopSenderAddress params, Integer currentUserId);
}
