package com.sky.ddt.controller;

import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.ShopSenderAddress;
import com.sky.ddt.service.IShopSenderAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baixueping
 * @description 店铺发货地址
 * @date 2019/7/26 15:27
 */
@RequestMapping("/shopSenderAddress")
@RestController
public class ShopSenderAddressController extends SuperController {

    @Autowired
    IShopSenderAddressService shopSenderAddressService;

    /**
     * @param
     * @return
     * @description 获取店铺发货地址
     * @author baixueping
     * @date 2019/7/26 15:36
     */
    @RequestMapping("/getShopSenderAddress")
    public BaseResponse getShopSenderAddress(Integer shopId) {
        return shopSenderAddressService.getShopSenderAddress(shopId);
    }

    /**
     * @param
     * @return
     * @description 保存店铺发货地址
     * @author baixueping
     * @date 2019/7/26 15:54
     */
    @MenuAnnotation("shop/index")
    @RequestMapping("/saveShopSenderAddress")
    public BaseResponse saveShopSenderAddress(ShopSenderAddress params) {
        return shopSenderAddressService.saveShopSenderAddress(params,getCurrentUserId());
    }
}
