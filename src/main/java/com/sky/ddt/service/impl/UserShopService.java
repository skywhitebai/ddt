package com.sky.ddt.service.impl;

import com.sky.ddt.dao.custom.CustomUserShopMapper;
import com.sky.ddt.entity.UserShopExample;
import com.sky.ddt.service.IUserShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserShopService implements IUserShopService {
    @Autowired
    CustomUserShopMapper customUserShopMapper;
    /**
     * 判断用户是否有店铺权限
     *
     * @param dealUserId
     * @param shopId
     * @return
     */
    @Override
    public boolean userHasShop(Integer dealUserId, Integer shopId) {
        if(dealUserId==null
                ||shopId==null){
            return false;
        }
        UserShopExample example=new UserShopExample();
        example.createCriteria().andUserIdEqualTo(dealUserId).andShopIdEqualTo(shopId).andStatusEqualTo(1);
        long resCount=customUserShopMapper.countByExample(example);
        if(resCount>0){
            return true;
        }
        return false;
    }
}
