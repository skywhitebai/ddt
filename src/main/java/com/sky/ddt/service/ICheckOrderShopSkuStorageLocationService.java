package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.CheckOrderShopSkuStorageLocation.request.ListCheckOrderShopSkuStorageLocationRequest;
import com.sky.ddt.dto.CheckOrderShopSkuStorageLocation.request.SaveCheckOrderShopSkuStorageLocationRequest;
import com.sky.ddt.dto.CheckOrderShopSkuStorageLocation.response.ListCheckOrderShopSkuStorageLocationResponse;
import com.sky.ddt.dto.response.BaseResponse;

/**
 * @author sky
 * @Description 盘点单库位服务
 * @date 2022/1/9 11:13
 */
public interface ICheckOrderShopSkuStorageLocationService {
    PageInfo<ListCheckOrderShopSkuStorageLocationResponse> listCheckOrderShopSkuStorageLocation(ListCheckOrderShopSkuStorageLocationRequest params);

    BaseResponse saveCheckOrderShopSkuStorageLocation(SaveCheckOrderShopSkuStorageLocationRequest params, Integer dealUserId);

    BaseResponse deleteCheckOrderShopSkuStorageLocation(Integer checkOrderShopSkuStorageLocationId);
}
