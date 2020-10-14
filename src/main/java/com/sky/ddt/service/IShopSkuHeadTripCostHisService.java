package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.shopSkuHeadTripCostHis.request.ListShopSkuHeadTripCostHisRequest;
import com.sky.ddt.dto.shopSkuHeadTripCostHis.response.ListShopSkuHeadTripCostHisResponse;

import java.util.List;

/**
 * @author baixueping
 * @description shopSku头程费
 * @date 2020/8/13 18:37
 */
public interface IShopSkuHeadTripCostHisService {
    /**
     * @param
     * @return
     * @description 列表查询店铺sku头程费历史记录
     * @author baixueping
     * @date 2020/8/18 18:19
     */
    PageInfo<ListShopSkuHeadTripCostHisResponse> listShopSkuHeadTripCostHis(ListShopSkuHeadTripCostHisRequest params);

    List<ListShopSkuHeadTripCostHisResponse> listExportShopSkuHeadTripCostHis(ListShopSkuHeadTripCostHisRequest params);
}
