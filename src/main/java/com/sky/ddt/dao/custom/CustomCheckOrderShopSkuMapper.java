package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.CheckOrderShopSkuMapper;
import com.sky.ddt.dto.checkOrderShopSku.request.ListCheckOrderShopSkuRequest;
import com.sky.ddt.dto.checkOrderShopSku.response.ListCheckOrderShopSkuResponse;

import java.util.List;

/**
 * @author baixueping
 * @description 盘点单店铺sku
 * @date 2020/5/11 10:51
 */
public interface CustomCheckOrderShopSkuMapper extends CheckOrderShopSkuMapper {
    /**
     * @param
     * @return
     * @description 查询盘点单店铺sku
     * @author baixueping
     * @date 2020/5/11 15:09
     */
    List<ListCheckOrderShopSkuResponse> listCheckOrderShopSku(ListCheckOrderShopSkuRequest params);
}
