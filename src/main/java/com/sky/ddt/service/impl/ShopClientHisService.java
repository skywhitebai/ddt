package com.sky.ddt.service.impl;

import com.sky.ddt.dao.custom.CustomShopClientHisMapper;
import com.sky.ddt.service.IShopClientHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 店铺客户端历史信息
 *
 * @author sky
 * @date 2019/03/27
 */
@Service
public class ShopClientHisService implements IShopClientHisService {
    @Autowired
    CustomShopClientHisMapper customShopClientHisMapper;
    /**
     * 判断ip是否存在其他店铺
     *
     * @param shopId
     * @param ip
     * @param macAddress
     * @return
     */
    @Override
    public Boolean clientExistsOtherShop(Integer shopId, String ip, String macAddress) {
        if(StringUtils.isEmpty(ip)&&StringUtils.isEmpty(macAddress)){
            return false;
        }
        return customShopClientHisMapper.clientExistsOtherShop(shopId,ip,macAddress);
    }
}
