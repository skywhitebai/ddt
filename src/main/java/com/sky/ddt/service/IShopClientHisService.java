package com.sky.ddt.service;
/**
 * 店铺客户端历史信息
 *
 * @author sky
 * @date 2019/03/27
 */
public interface IShopClientHisService {

    /**
     * 判断ip是否存在其他店铺
     * @param shopId
     * @param ip
     * @param macAddress
     * @return
     */
    Boolean clientExistsOtherShop(Integer shopId, String ip, String macAddress);
}
