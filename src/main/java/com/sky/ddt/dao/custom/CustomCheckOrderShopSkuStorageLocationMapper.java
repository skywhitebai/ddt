package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.CheckOrderShopSkuStorageLocationMapper;
import com.sky.ddt.dto.CheckOrderShopSkuStorageLocation.request.ListCheckOrderShopSkuStorageLocationRequest;
import com.sky.ddt.dto.CheckOrderShopSkuStorageLocation.response.ListCheckOrderShopSkuStorageLocationResponse;

import java.util.List;

/**
 * @author sky
 * @Description 盘点单
 * @date 2022/1/9 11:04
 */
public interface CustomCheckOrderShopSkuStorageLocationMapper extends CheckOrderShopSkuStorageLocationMapper {
    List<ListCheckOrderShopSkuStorageLocationResponse> listCheckOrderShopSkuStorageLocation(ListCheckOrderShopSkuStorageLocationRequest params);
}
