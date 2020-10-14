package com.sky.ddt.dto.shopHeadTripCost.response;

import com.sky.ddt.entity.ShopHeadTripCost;
import lombok.Data;

/**
 * @author baixueping
 * @description 列表查询店铺头程费返回值
 * @date 2020/8/13 19:06
 */
@Data
public class ListShopHeadTripCostResponse extends ShopHeadTripCost {
    String shopName;
}
