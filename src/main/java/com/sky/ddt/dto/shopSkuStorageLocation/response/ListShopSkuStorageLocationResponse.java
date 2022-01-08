package com.sky.ddt.dto.shopSkuStorageLocation.response;

import com.sky.ddt.entity.ShopSkuStorageLocation;
import lombok.Data;

/**
 * @author sky
 * @Description 列表查询仓库sku库位返回值
 * @date 2022/1/8 11:29
 */
@Data
public class ListShopSkuStorageLocationResponse extends ShopSkuStorageLocation {
    String shopName;
    String shopSku;
    String locationNo;
}
