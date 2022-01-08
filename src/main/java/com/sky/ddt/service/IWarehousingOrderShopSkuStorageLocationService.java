package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.warehousingOrderShopSkuStorageLocation.request.ListWarehousingOrderShopSkuStorageLocationRequest;
import com.sky.ddt.dto.warehousingOrderShopSkuStorageLocation.request.SaveWarehousingOrderShopSkuStorageLocationRequest;
import com.sky.ddt.dto.warehousingOrderShopSkuStorageLocation.response.ListWarehousingOrderShopSkuStorageLocationResponse;

/**
 * @author sky
 * @Description 店铺sku入库库位
 * @date 2022/1/8 0:11
 */
public interface IWarehousingOrderShopSkuStorageLocationService {
    PageInfo<ListWarehousingOrderShopSkuStorageLocationResponse> listWarehousingOrderShopSkuStorageLocation(ListWarehousingOrderShopSkuStorageLocationRequest params);

    BaseResponse saveWarehousingOrderShopSkuStorageLocation(SaveWarehousingOrderShopSkuStorageLocationRequest params, Integer dealUserId);

    BaseResponse deleteWarehousingOrderShopSkuStorageLocation(Integer warehousingOrderShopSkuStorageLocationId);
}
