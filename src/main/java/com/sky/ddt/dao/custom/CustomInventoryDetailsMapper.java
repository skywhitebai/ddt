package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.InventoryDetailsMapper;
import com.sky.ddt.dto.shopHeadTripCost.response.ShopSkuInventoryDetails;

import java.util.List;

/**
 * @author baixueping
 * @description 库存明细
 * @date 2019/12/12 15:00
 */
public interface CustomInventoryDetailsMapper extends InventoryDetailsMapper{
    /**
     * @param
     * @return
     * @description 查询店铺sku库存
     * @author baixueping
     * @date 2020/8/17 19:13
    */
    List<ShopSkuInventoryDetails> listShopSkuInventoryDetails(Integer financeId);
}
