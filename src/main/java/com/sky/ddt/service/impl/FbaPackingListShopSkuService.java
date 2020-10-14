package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.dao.custom.CustomFbaPackingListShopSkuMapper;
import com.sky.ddt.dto.fbaPackingListShopSku.request.ListFbaPackingListShopSkuRequest;
import com.sky.ddt.dto.fbaPackingListShopSku.response.ListFbaPackingListShopSkuResponse;
import com.sky.ddt.dto.shopHeadTripCost.response.FbaShopSkuHeadTripCostInfo;
import com.sky.ddt.entity.FbaPackingListShopSku;
import com.sky.ddt.entity.FbaPackingListShopSkuExample;
import com.sky.ddt.service.IFbaPackingListShopSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description fba装箱单服务
 * @date 2020/7/21 17:04
 */
@Service
public class FbaPackingListShopSkuService implements IFbaPackingListShopSkuService {
    @Autowired
    CustomFbaPackingListShopSkuMapper customFbaPackingListShopSkuMapper;

    /**
     * @param params@return
     * @description 分页查询fba装箱单店铺sku信息
     * @author baixueping
     * @date 2020/7/23 10:49
     */
    @Override
    public PageInfo<ListFbaPackingListShopSkuResponse> listFbaPackingListShopSku(ListFbaPackingListShopSkuRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListFbaPackingListShopSkuResponse> list = customFbaPackingListShopSkuMapper.listFbaPackingListShopSku(params);
        PageInfo<ListFbaPackingListShopSkuResponse> page = new PageInfo<ListFbaPackingListShopSkuResponse>(list);
        return page;
    }

    @Override
    public List<FbaPackingListShopSku> listFbaPackingListShopSku(Integer fbaPackingListId) {
        if(fbaPackingListId==null){
            return null;
        }
        FbaPackingListShopSkuExample example=new FbaPackingListShopSkuExample();
        example.createCriteria().andFbaPackingListIdEqualTo(fbaPackingListId);
        return customFbaPackingListShopSkuMapper.selectByExample(example);
    }

    /**
     * @param shopId
     * @param month
     * @return
     * @description 计算头程费时，查询店铺skufba发货信息
     * @author baixueping
     * @date 2020/8/18 10:35
     */
    @Override
    public List<FbaShopSkuHeadTripCostInfo> listFbaShopSkuHeadTripCostInfo(Integer shopId, Date month) {
        return customFbaPackingListShopSkuMapper.listFbaShopSkuHeadTripCostInfo(shopId,month);
    }
}
