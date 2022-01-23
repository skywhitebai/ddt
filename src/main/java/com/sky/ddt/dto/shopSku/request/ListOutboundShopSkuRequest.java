package com.sky.ddt.dto.shopSku.request;

import lombok.Data;

import java.util.List;

/**
 * @author sky
 * @Description 查询出库店铺sku入参
 * @date 2022/1/23 13:56
 */
@Data
public class ListOutboundShopSkuRequest {
    List<Integer> shopSkuIdList;
    Integer shopId;
}
