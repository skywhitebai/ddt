package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.fbaPackingListShopSku.request.ListFbaPackingListShopSkuRequest;
import com.sky.ddt.dto.fbaPackingListShopSku.response.ListFbaPackingListShopSkuResponse;
import com.sky.ddt.dto.shopHeadTripCost.response.FbaShopSkuHeadTripCostInfo;
import com.sky.ddt.entity.FbaPackingListShopSku;

import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description fba装箱单sku服务
 * @date 2020/7/21 17:03
 */
public interface IFbaPackingListShopSkuService {
    /**
     * @param
     * @return
     * @description 分页查询fba装箱单店铺sku信息
     * @author baixueping
     * @date 2020/7/23 10:49
     */
    PageInfo<ListFbaPackingListShopSkuResponse> listFbaPackingListShopSku(ListFbaPackingListShopSkuRequest params);

    List<FbaPackingListShopSku> listFbaPackingListShopSku(Integer fbaPackingListId);

    /**
     * @param
     * @param month
     * @return
     * @description 计算头程费时，查询店铺skufba发货信息
     * @author baixueping
     * @date 2020/8/18 10:35
     */
    List<FbaShopSkuHeadTripCostInfo> listFbaShopSkuHeadTripCostInfo(Integer shopId, Date month);
}
