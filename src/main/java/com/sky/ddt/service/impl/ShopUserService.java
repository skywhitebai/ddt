package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.ProductConstant;
import com.sky.ddt.common.constant.ShopConstant;
import com.sky.ddt.dao.custom.CustomShopMapper;
import com.sky.ddt.dao.custom.CustomShopUserMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopUser.response.ShopUserResponse;
import com.sky.ddt.dto.shopUser.Request.GetShopUserListRequest;
import com.sky.ddt.dto.shopUser.Request.SaveShopUserRequest;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.IShopUserService;
import com.sky.ddt.util.ExcelUtil;
import com.sky.ddt.util.MathUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author baixueping
 * @description 店铺用户
 * @date 2019/7/25 10:48
 */
@Service
public class ShopUserService implements IShopUserService {

    @Autowired
    CustomShopUserMapper customShopUserMapper;
    @Autowired
    CustomShopMapper customShopMapper;

    /**
     * @param params@return
     * @description 获取店铺用户
     * @author baixueping
     * @date 2019/7/25 11:15
     */
    @Override
    public PageInfo<ShopUserResponse> getShopUserList(GetShopUserListRequest params) {
        if (params.getShopId() == null) {
            return new PageInfo<>();
        }
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ShopUserResponse> list = customShopUserMapper.getShopUserList(params);
        PageInfo<ShopUserResponse> page = new PageInfo<ShopUserResponse>(list);
        return page;
    }

    /**
     * @param shopUserIds@return
     * @description 删除店铺用户
     * @author baixueping
     * @date 2019/7/25 14:16
     */
    @Override
    public BaseResponse deleteShopUser(List<Integer> shopUserIds) {
        if (CollectionUtils.isEmpty(shopUserIds)) {
            return BaseResponse.success();
        }
        ShopUserExample example = new ShopUserExample();
        example.createCriteria().andShopUserIdIn(shopUserIds);
        customShopUserMapper.deleteByExample(example);
        return BaseResponse.success();
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 保存店铺用户
     * @author baixueping
     * @date 2019/7/25 14:16
     */
    @Override
    public BaseResponse saveShopUser(SaveShopUserRequest params, Integer dealUserId) {
        ShopUser shopUser = new ShopUser();
        if (exisShopUser(params.getShopId(),params.getUserId())) {
            return BaseResponse.failMessage(ShopConstant.USER_ID_EXIST);
        }
        BeanUtils.copyProperties(params, shopUser);
        shopUser.setCreateBy(dealUserId);
        shopUser.setCreateTime(new Date());
        customShopUserMapper.insertSelective(shopUser);
        return BaseResponse.success();
    }

    /**
     * @param userId @return
     * @description 获取用户店铺
     * @author baixueping
     * @date 2019/7/29 10:08
     */
    @Override
    public List<Shop> listUserShop(Integer userId) {
        if (userId == null) {
            return null;
        }
        ShopUserExample shopUserExample = new ShopUserExample();
        shopUserExample.createCriteria().andUserIdEqualTo(userId);
        List<ShopUser> shopUserList = customShopUserMapper.selectByExample(shopUserExample);
        if (CollectionUtils.isEmpty(shopUserList)) {
            return null;
        }
        List<Integer> listUserShop = shopUserList.stream().map(ShopUser::getShopId).collect(Collectors.toList());
        ShopExample shopExample = new ShopExample();
        shopExample.createCriteria().andShopIdIn(listUserShop);
        return customShopMapper.selectByExample(shopExample);
    }

    /**
     * @param shopId
     * @param userId
     * @return
     * @description 判断用户是否存在指定店铺权限
     * @author baixueping
     * @date 2019/8/22 16:23
     */
    @Override
    public boolean exisShopUser(Integer shopId, Integer userId) {
        ShopUserExample example = new ShopUserExample();
        example.createCriteria().andShopIdEqualTo(shopId).andUserIdEqualTo(userId);
        return customShopUserMapper.countByExample(example) > 0;
    }
}
