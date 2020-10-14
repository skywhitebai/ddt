package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopHeadTripCost.request.CreateShopHeadTripCostRequest;
import com.sky.ddt.dto.shopHeadTripCost.request.ListShopHeadTripCostRequest;
import com.sky.ddt.dto.shopHeadTripCost.request.SaveShopHeadTripCostRemarkRequest;
import com.sky.ddt.dto.shopHeadTripCost.response.ListShopHeadTripCostResponse;

/**
 * @author baixueping
 * @description 店铺头程费服务类
 * @date 2020/8/13 18:28
 */
public interface IShopHeadTripCostService {
    /**
     * @param
     * @return
     * @description 分页查询店铺头程费
     * @author baixueping
     * @date 2020/8/13 19:09
     */
    PageInfo<ListShopHeadTripCostResponse> listShopHeadTripCost(ListShopHeadTripCostRequest params);

    BaseResponse saveShopHeadTripCostRemark(SaveShopHeadTripCostRemarkRequest params, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 创建店铺头程费信息
     * @author baixueping
     * @date 2020/8/14 13:00
     */
    BaseResponse createShopHeadTripCost(CreateShopHeadTripCostRequest params, Integer dealUserId);
}
