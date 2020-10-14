package com.sky.ddt.service.impl;

import com.sky.ddt.common.constant.ShopConstant;
import com.sky.ddt.dao.generate.ShopSenderAddressMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.ShopSenderAddress;
import com.sky.ddt.service.IShopSenderAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author baixueping
 * @description 店铺发货地址
 * @date 2019/7/26 15:28
 */
@Service
public class ShopSenderAddressService implements IShopSenderAddressService{
    @Autowired
    ShopSenderAddressMapper shopSenderAddressMapper;

    /**
     * @param shopId@return
     * @description 获取店铺发货地址
     * @author baixueping
     * @date 2019/7/26 15:37
     */
    @Override
    public BaseResponse getShopSenderAddress(Integer shopId) {
        if(shopId==null){
            return BaseResponse.failMessage(ShopConstant.SHOP_ID_EMPTY);
        }
        ShopSenderAddress shopSenderAddress=shopSenderAddressMapper.selectByPrimaryKey(shopId);
        return BaseResponse.successData(shopSenderAddress);
    }

    /**
     * @param params @return
     * @param currentUserId
     * @description 保存店铺发货地址
     * @author baixueping
     * @date 2019/7/26 15:54
     */
    @Override
    public BaseResponse saveShopSenderAddress(ShopSenderAddress params, Integer currentUserId) {
        ShopSenderAddress shopSenderAddress=shopSenderAddressMapper.selectByPrimaryKey(params.getShopId());
        if(shopSenderAddress==null){
            params.setCreateTime(new Date());
            params.setCreateBy(currentUserId);
            shopSenderAddressMapper.insert(params);
            return BaseResponse.success();
        }
        shopSenderAddress.setAddressCity(params.getAddressCity());
        shopSenderAddress.setAddressCountryCode(params.getAddressCountryCode());
        shopSenderAddress.setAddressFieldOne(params.getAddressFieldOne());
        shopSenderAddress.setAddressFieldTwo(params.getAddressFieldTwo());
        shopSenderAddress.setAddressName(params.getAddressName());
        shopSenderAddress.setAddressStateOrRegion(params.getAddressStateOrRegion());
        shopSenderAddress.setShipToCountry(params.getShipToCountry());
        shopSenderAddress.setAddressDistrict(params.getAddressDistrict());
        shopSenderAddress.setAddressPostalCode(params.getAddressPostalCode());
        shopSenderAddress.setUpdateBy(currentUserId);
        shopSenderAddress.setUpdateTime(new Date());
        shopSenderAddressMapper.updateByPrimaryKey(shopSenderAddress);
        return BaseResponse.success();
    }
}
