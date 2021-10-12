package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.ShopMapper;
import com.sky.ddt.dto.shop.request.ShopComboboxlistRequest;
import com.sky.ddt.dto.shop.request.ShopListRequest;
import com.sky.ddt.dto.shop.response.ShopComboboxResponse;
import com.sky.ddt.dto.shop.response.ShopListResponse;
import com.sky.ddt.entity.Shop;

import java.util.Date;
import java.util.List;

public interface CustomShopMapper extends ShopMapper {
    Date getOrderLastUpdatedAfter(Integer shopId);

    /**
     * 获取当前用户店铺
     *
     * @param userId
     * @return
     */
    List<Shop> getCurrentUserShop(Integer userId);

    /**
     * 获取店铺列表
     *
     * @param params
     * @return
     */
    List<ShopListResponse> listShop(ShopListRequest params);

    List<ShopComboboxResponse> comboboxlist(ShopComboboxlistRequest shopComboboxlistRequest);
}
