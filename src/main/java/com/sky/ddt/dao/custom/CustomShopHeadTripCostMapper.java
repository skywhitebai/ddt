package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.ShopHeadTripCostMapper;
import com.sky.ddt.dto.shopHeadTripCost.request.ListShopHeadTripCostRequest;
import com.sky.ddt.dto.shopHeadTripCost.response.ListShopHeadTripCostResponse;

import java.util.List;

/**
 * @author baixueping
 * @description 店铺头程费服务类
 * @date 2020/8/13 18:31
 */
public interface CustomShopHeadTripCostMapper extends ShopHeadTripCostMapper {

    List<ListShopHeadTripCostResponse> listShopHeadTripCost(ListShopHeadTripCostRequest params);
}
