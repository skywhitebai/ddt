package com.sky.ddt.dto.warehousingOrderShopSkuStorageLocation.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author sky
 * @Description 入库单sku库位管理入参
 * @date 2022/1/8 11:27
 */
@Data
public class ListWarehousingOrderShopSkuStorageLocationRequest extends DataGridRequest {
    Integer warehousingOrderShopSkuId;
}
