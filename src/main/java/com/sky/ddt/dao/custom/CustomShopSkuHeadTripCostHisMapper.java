package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.ShopSkuHeadTripCostHisMapper;
import com.sky.ddt.dto.shopSkuHeadTripCostHis.request.ExportShopSkuHeadTripCostHisRequest;
import com.sky.ddt.dto.shopSkuHeadTripCostHis.request.ListShopSkuHeadTripCostHisRequest;
import com.sky.ddt.dto.shopSkuHeadTripCostHis.response.ExportShopSkuHeadTripCostHisResponse;
import com.sky.ddt.dto.shopSkuHeadTripCostHis.response.ListShopSkuHeadTripCostHisResponse;

import java.util.List;

/**
 * @author baixueping
 * @description shopSku头程费
 * @date 2020/8/13 18:41
 */
public interface CustomShopSkuHeadTripCostHisMapper  extends ShopSkuHeadTripCostHisMapper{
    List<ListShopSkuHeadTripCostHisResponse> listShopSkuHeadTripCostHis(ListShopSkuHeadTripCostHisRequest params);

    List<ExportShopSkuHeadTripCostHisResponse> listExportShopSkuHeadTripCostHis(ExportShopSkuHeadTripCostHisRequest params);
}
