package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopSkuStorageLocation.request.ListShopSkuStorageLocationRequest;
import com.sky.ddt.dto.shopSkuStorageLocation.request.SaveShopSkuStorageLocationRequest;
import com.sky.ddt.dto.shopSkuStorageLocation.response.ListShopSkuStorageLocationResponse;

/**
 * @author sky
 * @Description 店铺sku库位管理
 * @date 2022/1/8 0:12
 */
public interface IShopSkuStorageLocationService {
    PageInfo<ListShopSkuStorageLocationResponse> listShopSkuStorageLocation(ListShopSkuStorageLocationRequest params);

    BaseResponse saveShopSkuStorageLocation(SaveShopSkuStorageLocationRequest params, Integer dealUserId);
}
