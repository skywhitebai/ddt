package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shop.request.*;
import com.sky.ddt.dto.shop.response.ShopComboboxResponse;
import com.sky.ddt.dto.shop.response.ShopListResponse;
import com.sky.ddt.entity.Currency;
import com.sky.ddt.entity.Shop;

import java.util.Date;
import java.util.List;

public interface IShopService {

    /**
     * 获取店铺最后更新时间
     *
     * @param shopId
     * @return
     */
    BaseResponse<Date> getOrderLastUpdatedAfter(Integer shopId);


    /**
     * 获取当前用户店铺
     *
     * @param userId
     * @param ip
     * @param macAddress
     * @return
     */
    BaseResponse<Shop> getCurrentUserShop(Integer userId, String ip, String macAddress);

    /**
     * OrderLastUpdatedAfter
     * 修改店铺
     *
     * @param dealUserId
     * @param updateOrderLastUpdatedAfterRequest
     * @return
     */
    BaseResponse updateOrderLastUpdatedAfter(Integer dealUserId, UpdateOrderLastUpdatedAfterRequest updateOrderLastUpdatedAfterRequest);

    /**
     * 获取店铺列表
     *
     * @param params
     * @return
     */
    PageInfo<ShopListResponse> listShop(ShopListRequest params);

    /**
     * 修改店铺
     *
     * @param params
     * @param dealUserId
     * @return
     */
    BaseResponse save(ShopSaveRequest params, Integer dealUserId);

    /**
     * 停用店铺
     *
     * @param shopIds
     * @param dealUserId
     * @return
     */
    BaseResponse delete(List<Integer> shopIds, Integer dealUserId);

    /**
     * 获取店铺下拉菜单
     *
     * @return
     * @param shopComboboxlistRequest
     */
    List<ShopComboboxResponse> comboboxlist(ShopComboboxlistRequest shopComboboxlistRequest);

    /**
     * @param
     * @return
     * @description 更新库存最后同步时间
     * @author baixueping
     * @date 2019/5/5 9:33
     */
    BaseResponse updateInventoryQueryStartDateTime(Integer dealUserId, UpdateInventoryQueryStartDateTimeRequest params);

    /**
     * @param
     * @return
     * @description 获取店铺id
     * @author baixueping
     * @date 2019/8/15 10:39
     */
    Integer getShopId(List<Shop> shopList, String shopName);

    /**
     * @param
     * @return
     * @description 获取shop
     * @author baixueping
     * @date 2019/9/9 17:47
     */
    Shop getShop(Integer shopId);

    Shop getShopByShopName(String shopName);

    Currency getCurrency(Integer shopId);
}
