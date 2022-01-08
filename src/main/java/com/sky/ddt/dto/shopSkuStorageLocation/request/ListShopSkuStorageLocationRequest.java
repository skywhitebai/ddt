package com.sky.ddt.dto.shopSkuStorageLocation.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author sky
 * @Description 仓库sku库位管理入参
 * @date 2022/1/8 11:27
 */
@Data
public class ListShopSkuStorageLocationRequest extends DataGridRequest {
    Integer shopSkuId;
}
