package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.dao.custom.CustomShopSkuHeadTripCostHisMapper;
import com.sky.ddt.dto.shopSkuHeadTripCostHis.request.ListShopSkuHeadTripCostHisRequest;
import com.sky.ddt.dto.shopSkuHeadTripCostHis.response.ListShopSkuHeadTripCostHisResponse;
import com.sky.ddt.service.IShopSkuHeadTripCostHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author baixueping
 * @description shopSku头程费
 * @date 2020/8/13 18:40
 */
@Service
public class ShopSkuHeadTripCostHisService implements IShopSkuHeadTripCostHisService{
    @Autowired
    CustomShopSkuHeadTripCostHisMapper customShopSkuHeadTripCostHisMapper;
    /**
     * @param params@return
     * @description 列表查询店铺sku头程费历史记录
     * @author baixueping
     * @date 2020/8/18 18:19
     */
    @Override
    public PageInfo<ListShopSkuHeadTripCostHisResponse> listShopSkuHeadTripCostHis(ListShopSkuHeadTripCostHisRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListShopSkuHeadTripCostHisResponse> list = customShopSkuHeadTripCostHisMapper.listShopSkuHeadTripCostHis(params);
        PageInfo<ListShopSkuHeadTripCostHisResponse> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public List<ListShopSkuHeadTripCostHisResponse> listExportShopSkuHeadTripCostHis(ListShopSkuHeadTripCostHisRequest params) {
        return customShopSkuHeadTripCostHisMapper.listShopSkuHeadTripCostHis(params);
    }
}
