package com.sky.ddt.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.ShopConstant;
import com.sky.ddt.common.constant.UserShopConstant;
import com.sky.ddt.dao.custom.CustomShopClientHisMapper;
import com.sky.ddt.dao.custom.CustomShopMapper;
import com.sky.ddt.dao.custom.CustomShopSkuMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shop.request.*;
import com.sky.ddt.dto.shop.response.ShopComboboxResponse;
import com.sky.ddt.dto.shop.response.ShopListResponse;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.ICountryService;
import com.sky.ddt.service.IShopClientHisService;
import com.sky.ddt.service.IShopService;
import com.sky.ddt.service.IUserShopService;
import com.sky.ddt.util.DateUtil;
import com.sky.ddt.util.StringTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class ShopService implements IShopService {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    CustomShopMapper customShopMapper;
    @Autowired
    IShopClientHisService shopClientHisService;
    @Autowired
    CustomShopClientHisMapper customShopClientHisMapper;
    @Autowired
    IUserShopService userShopService;
    @Autowired
    CustomShopSkuMapper customShopSkuMapper;
    @Autowired
    ICountryService countryService;

    /**
     * 获取店铺最后更新时间
     *
     * @param shopId
     * @return
     */
    @Override
    public BaseResponse<Date> getOrderLastUpdatedAfter(Integer shopId) {
        Date lastUpdateAfter = customShopMapper.getOrderLastUpdatedAfter(shopId);
        if (lastUpdateAfter != null) {
            return BaseResponse.successData(lastUpdateAfter);
        } else {
            lastUpdateAfter = DateUtil.strToDate("1995-01-01");
        }
        return BaseResponse.successData(lastUpdateAfter);
    }

    /**
     * 获取当前用户店铺
     *
     * @param userId
     * @param ip
     * @param macAddress
     * @return
     */
    @Override
    @Transactional
    public BaseResponse<Shop> getCurrentUserShop(Integer userId, String ip, String macAddress) {
        if (StringUtils.isEmpty(userId)) {
            return BaseResponse.failMessage(ShopConstant.USER_ID_EMPTY);
        }
        List<Shop> shopList = customShopMapper.getCurrentUserShop(userId);
        if (CollectionUtils.isEmpty(shopList)) {
            return BaseResponse.failMessage(ShopConstant.USER_HAS_NO_SHOP);
        }
        if (shopList.size() > 1) {
            log.info("loginToken:{},shop has more than one shopList:{}", userId, JSON.toJSON(shopList));
        }
        Shop shop = shopList.get(0);
        if (!StringUtils.isEmpty(shop.getClientMacAddress())) {
            if (!shop.getClientMacAddress().equals(macAddress)) {
                return BaseResponse.failMessage(ShopConstant.MAC_ADDRESS_MUST_EQUAL);
            }
        }
        Boolean clientExistsOtherShop = shopClientHisService.clientExistsOtherShop(shop.getShopId(), ip, macAddress);
        if (clientExistsOtherShop) {
            return BaseResponse.failMessage(ShopConstant.CLIENT_IS_EXISTS_OTHER_SHOP);
        }
        //判断是否要更新ip地址和macAddress
        updateShopIpMacAddress(ip, macAddress, shop);
        //判断是否是新的ip和macAddress
        insertShopClientHis(ip, macAddress, shop);
        return BaseResponse.successData(shop);
    }

    /**
     * OrderLastUpdatedAfter
     * 修改店铺
     *
     * @param dealUserId
     * @param updateOrderLastUpdatedAfterRequest
     * @return
     */
    @Override
    public BaseResponse updateOrderLastUpdatedAfter(Integer dealUserId, UpdateOrderLastUpdatedAfterRequest updateOrderLastUpdatedAfterRequest) {
        if (dealUserId == null) {
            return BaseResponse.failMessage(UserShopConstant.USER_ID_EMPTY);
        }
        if (updateOrderLastUpdatedAfterRequest.getShopId() == null) {
            return BaseResponse.failMessage(UserShopConstant.SHOP_ID_EMPTY);
        }
        if (updateOrderLastUpdatedAfterRequest.getLastUpdatedAfter() == null) {
            return BaseResponse.failMessage(UserShopConstant.LAST_UPDATED_AFTER_EMPTY);
        }
        if (!userShopService.userHasShop(dealUserId, updateOrderLastUpdatedAfterRequest.getShopId())) {
            return BaseResponse.failMessage(UserShopConstant.USER_NOT_HAS_THIS_SHOP);
        }
        Shop shop = new Shop();
        shop.setShopId(updateOrderLastUpdatedAfterRequest.getShopId());
        shop.setOrderLastUpdatedAfter(updateOrderLastUpdatedAfterRequest.getLastUpdatedAfter());
        customShopMapper.updateByPrimaryKeySelective(shop);
        return BaseResponse.success();
    }

    /**
     * 获取店铺列表
     *
     * @param params
     * @return
     */
    @Override
    public PageInfo<ShopListResponse> listShop(ShopListRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ShopListResponse> list = customShopMapper.listShop(params);
        PageInfo<ShopListResponse> page = new PageInfo<ShopListResponse>(list);
        return page;
    }

    /**
     * 修改店铺
     *
     * @param params
     * @param dealUserId
     * @return
     */
    @Override
    public BaseResponse save(ShopSaveRequest params, Integer dealUserId) {

        if (existShopName(params.getShopName(), params.getShopId())) {
            return BaseResponse.failMessage(ShopConstant.SHOP_NAME_EXIST);
        }
        if (!ShopConstant.TypeEnum.contains(params.getType())) {
            return BaseResponse.failMessage(ShopConstant.TYPE_ERRO);
        }
        if (ShopConstant.TypeEnum.SHOP.getType().equals(params.getType())) {
            if (StringUtils.isEmpty(params.getSellerId())) {
                return BaseResponse.failMessage(ShopConstant.SELLER_ID_EMPTY);
            }
            if (StringUtils.isEmpty(params.getShopMarketplaceId())) {
                return BaseResponse.failMessage(ShopConstant.SHOP_MARKETPLACE_ID_EMPTY);
            }
            if (existSellerId(params.getSellerId(), params.getShopId())) {
                return BaseResponse.failMessage(ShopConstant.SELLER_ID_EXIST);
            }
            if (existShopMarketplaceId(params.getShopMarketplaceId(), params.getShopId())) {
                return BaseResponse.failMessage(ShopConstant.SHOP_MARKETPLACE_ID_EXIST);
            }
        }
        Country country=countryService.getCountry(params.getCountryId());
        if(country==null){
            return BaseResponse.failMessage("国家不能为空");
        }
        if (params.getShopId() == null) {
            Shop shop = new Shop();
            setShop(shop, params);
            shop.setCreateBy(dealUserId);
            shop.setCreateTime(new Date());
            customShopMapper.insertSelective(shop);
            if (ShopConstant.TypeEnum.WAREHOUSE.getType().equals(params.getType())) {
                //添加仓库信息
                customShopSkuMapper.initWareHouseShopSku(shop);
            }
        } else {
            Shop shop = customShopMapper.selectByPrimaryKey(params.getShopId());
            if (shop == null) {
                return BaseResponse.failMessage(ShopConstant.SHOP_ID_NOT_EXIST);
            }
            if (!params.getType().equals(shop.getType())) {
                return BaseResponse.failMessage(ShopConstant.TYPE_NOT_ALLOW_CHANGE);
            }
            setShop(shop, params);
            shop.setUpdateBy(dealUserId);
            shop.setUpdateTime(new Date());
            customShopMapper.updateByPrimaryKeySelective(shop);
        }
        return BaseResponse.success();
    }

    /**
     * @param
     * @return
     * @description 设置保存店铺参数
     * @author baixueping
     * @date 2019/7/24 15:50
     */
    private void setShop(Shop shop, ShopSaveRequest params) {
        if (shop == null || params == null) {
            return;
        }
        shop.setShopName(params.getShopName());
        shop.setShopUrl(params.getShopUrl());
        shop.setSellerId(params.getSellerId());
        shop.setType(params.getType());
        shop.setShopMarketplaceId(params.getShopMarketplaceId());
        shop.setStatus(params.getStatus());
        shop.setRemark(params.getRemark());
        shop.setCountryId(params.getCountryId());
    }

    private boolean existShopName(String shopName, Integer shopId) {
        ShopExample example = new ShopExample();
        ShopExample.Criteria criteria = example.createCriteria();
        criteria.andShopNameEqualTo(shopName);
        if (shopId != null) {
            criteria.andShopIdNotEqualTo(shopId);
        }
        return customShopMapper.countByExample(example) > 0;
    }

    private boolean existShopMarketplaceId(String shopMarketplaceId, Integer shopId) {
        ShopExample example = new ShopExample();
        ShopExample.Criteria criteria = example.createCriteria();
        criteria.andShopMarketplaceIdEqualTo(shopMarketplaceId);
        if (shopId != null) {
            criteria.andShopIdNotEqualTo(shopId);
        }
        return customShopMapper.countByExample(example) > 0;
    }

    /**
     * 判读sellerId是否存在
     *
     * @param sellerId
     * @param shopId
     * @return
     */
    Boolean existSellerId(String sellerId, Integer shopId) {
        ShopExample example = new ShopExample();
        ShopExample.Criteria criteria = example.createCriteria();
        if (shopId != null) {
            criteria.andSellerIdEqualTo(sellerId).andShopIdNotEqualTo(shopId);
        } else {
            criteria.andSellerIdEqualTo(sellerId);
        }
        return customShopMapper.countByExample(example) > 0;
    }

    /**
     * 停用店铺
     *
     * @param shopIds
     * @param dealUserId
     * @return
     */
    @Override
    public BaseResponse delete(List<Integer> shopIds, Integer dealUserId) {
        if (shopIds == null || shopIds.size() == 0) {
            return BaseResponse.success();
        }
        Shop shop = new Shop();
        shop.setStatus(false);
        shop.setUpdateBy(dealUserId);
        ShopExample example = new ShopExample();
        example.createCriteria().andShopIdIn(shopIds);
        int res = customShopMapper.updateByExampleSelective(shop, example);
        return BaseResponse.success();
    }

    /**
     * 获取店铺下拉菜单
     *
     * @param shopComboboxlistRequest
     * @return
     */
    @Override
    public List<ShopComboboxResponse> comboboxlist(ShopComboboxlistRequest shopComboboxlistRequest) {
        return customShopMapper.comboboxlist(shopComboboxlistRequest);
    }

    /**
     * @param dealUserId
     * @param params
     * @return
     * @description 更新库存最后同步时间
     * @author baixueping
     * @date 2019/5/5 9:33
     */
    @Override
    public BaseResponse updateInventoryQueryStartDateTime(Integer dealUserId, UpdateInventoryQueryStartDateTimeRequest params) {
        if (dealUserId == null) {
            return BaseResponse.failMessage(UserShopConstant.USER_ID_EMPTY);
        }
        if (params.getShopId() == null) {
            return BaseResponse.failMessage(UserShopConstant.SHOP_ID_EMPTY);
        }
        if (params.getInventoryQueryStartDateTime() == null) {
            return BaseResponse.failMessage(UserShopConstant.LAST_UPDATED_AFTER_EMPTY);
        }
        if (!userShopService.userHasShop(dealUserId, params.getShopId())) {
            return BaseResponse.failMessage(UserShopConstant.USER_NOT_HAS_THIS_SHOP);
        }
        Shop shop = new Shop();
        shop.setShopId(params.getShopId());
        shop.setInventoryQueryStartDateTime(params.getInventoryQueryStartDateTime());
        customShopMapper.updateByPrimaryKeySelective(shop);
        return BaseResponse.success();
    }

    /**
     * @param shopList
     * @param shopName
     * @return
     * @description 获取店铺id
     * @author baixueping
     * @date 2019/8/15 10:39
     */
    @Override
    public Integer getShopId(List<Shop> shopList, String shopName) {
        if (CollectionUtils.isEmpty(shopList) || StringUtils.isEmpty(shopName)) {
            return null;
        }
        for (Shop shop : shopList) {
            if (shopName.equals(shop.getShopName())) {
                return shop.getShopId();
            }
        }
        return null;
    }

    /**
     * @param shopId@return
     * @description 获取shop
     * @author baixueping
     * @date 2019/9/9 17:47
     */
    @Override
    public Shop getShop(Integer shopId) {
        if (shopId == null) {
            return null;
        }
        return customShopMapper.selectByPrimaryKey(shopId);
    }

    @Override
    public Shop getShopByShopName(String shopName) {
        if (StringUtils.isEmpty(shopName)) {
            return null;
        }
        ShopExample shopExample = new ShopExample();
        shopExample.createCriteria().andShopNameEqualTo(shopName).andStatusEqualTo(Boolean.TRUE);
        List<Shop> list = customShopMapper.selectByExample(shopExample);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public Currency getCurrency(Integer shopId) {
        if(shopId==null){
            return null;
        }
        return customShopMapper.getCurrencyByShopId(shopId);
    }

    private void insertShopClientHis(String ip, String macAddress, Shop shop) {
        ShopClientHisExample example = new ShopClientHisExample();
        if (ip != null) {
            example.createCriteria().andClientIpEqualTo(ip);
        } else {
            example.createCriteria().andClientIpIsNull();
        }
        if (macAddress != null) {
            example.createCriteria().andClientMacAddressEqualTo(macAddress);
        } else {
            example.createCriteria().andClientMacAddressIsNull();
        }
        example.createCriteria().andShopIdEqualTo(shop.getShopId());
        long existCount = customShopClientHisMapper.countByExample(example);
        if (existCount > 0) {
            return;
        }
        ShopClientHis shopClientHis = new ShopClientHis();
        shopClientHis.setClientIp(ip);
        shopClientHis.setClientMacAddress(macAddress);
        shopClientHis.setShopId(shop.getShopId());
        customShopClientHisMapper.insertSelective(shopClientHis);
    }

    private void updateShopIpMacAddress(String ip, String macAddress, Shop shop) {
        if (StringTool.equal(shop.getClientIp(), ip)
                && StringTool.equal(shop.getClientMacAddress(), macAddress)) {
            return;
        }
        Shop shopUpdate = new Shop();
        shopUpdate.setShopId(shop.getShopId());
        shopUpdate.setClientIp(ip);
        shopUpdate.setClientMacAddress(macAddress);
        customShopMapper.updateByPrimaryKeySelective(shopUpdate);
    }
}
