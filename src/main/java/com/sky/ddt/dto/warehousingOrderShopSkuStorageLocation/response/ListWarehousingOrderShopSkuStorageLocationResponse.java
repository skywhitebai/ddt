package com.sky.ddt.dto.warehousingOrderShopSkuStorageLocation.response;

import com.sky.ddt.entity.ShopSkuStorageLocation;
import com.sky.ddt.entity.WarehousingOrderShopSkuStorageLocation;
import lombok.Data;

/**
 * @author sky
 * @Description 列表查询入库单sku库位返回值
 * @date 2022/1/8 11:29
 */
@Data
public class ListWarehousingOrderShopSkuStorageLocationResponse extends WarehousingOrderShopSkuStorageLocation {
    String shopName;
    String shopSku;
    String locationNo;
}
