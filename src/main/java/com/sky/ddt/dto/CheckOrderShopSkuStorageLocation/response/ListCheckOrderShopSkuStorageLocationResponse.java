package com.sky.ddt.dto.CheckOrderShopSkuStorageLocation.response;

import com.sky.ddt.entity.CheckOrderShopSkuStorageLocation;
import com.sky.ddt.entity.WarehousingOrderShopSkuStorageLocation;
import lombok.Data;

/**
 * @author sky
 * @Description 列表查询入库单sku库位返回值
 * @date 2022/1/8 11:29
 */
@Data
public class ListCheckOrderShopSkuStorageLocationResponse extends CheckOrderShopSkuStorageLocation {
    String shopName;
    String shopSku;
    String locationNo;
}
