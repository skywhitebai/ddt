package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.ShopSkuStorageLocationMapper;
import com.sky.ddt.dto.shopSku.request.BatchSaveShopSkuStorageLocationRequest;
import com.sky.ddt.dto.shopSkuStorageLocation.request.ListShopSkuStorageLocationRequest;
import com.sky.ddt.dto.shopSkuStorageLocation.response.ListShopSkuStorageLocationResponse;

import java.util.List;

/**
 * @author sky
 * @Description 仓库sku库位管理
 * @date 2022/1/8 0:08
 */
public interface CustomShopSkuStorageLocationMapper extends ShopSkuStorageLocationMapper {
    List<ListShopSkuStorageLocationResponse> listShopSkuStorageLocation(ListShopSkuStorageLocationRequest params);

    void batchSaveShopSkuStorageLocation(BatchSaveShopSkuStorageLocationRequest batchSaveShopSkuStorageLocationRequest);
}
