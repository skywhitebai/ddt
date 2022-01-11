package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.WarehousingOrderShopSkuStorageLocationMapper;
import com.sky.ddt.dto.warehousingOrderShopSkuStorageLocation.request.BatchSaveWarehousingOrderShopSkuStorageLocationRequest;
import com.sky.ddt.dto.warehousingOrderShopSkuStorageLocation.request.ListWarehousingOrderShopSkuStorageLocationRequest;
import com.sky.ddt.dto.warehousingOrderShopSkuStorageLocation.response.ListWarehousingOrderShopSkuStorageLocationResponse;

import java.util.List;

/**
 * @author sky
 * @Description 产品入库库位管理
 * @date 2022/1/8 0:08
 */
public interface CustomWarehousingOrderShopSkuStorageLocationMapper extends WarehousingOrderShopSkuStorageLocationMapper {
    List<ListWarehousingOrderShopSkuStorageLocationResponse> listWarehousingOrderShopSkuStorageLocation(ListWarehousingOrderShopSkuStorageLocationRequest params);

    void batchSaveWarehousingOrderShopSkuStorageLocation(BatchSaveWarehousingOrderShopSkuStorageLocationRequest batchSaveWarehousingOrderShopSkuStorageLocationRequest);
}
