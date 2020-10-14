package com.sky.ddt.service;

public interface IUserShopService {
    /**
     * 判断用户是否有店铺权限
     * @param dealUserId
     * @param shopId
     * @return
     */
    boolean userHasShop(Integer dealUserId, Integer shopId);
}
