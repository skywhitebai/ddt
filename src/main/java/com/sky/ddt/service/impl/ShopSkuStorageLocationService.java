package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.dao.custom.CustomShopSkuMapper;
import com.sky.ddt.dao.custom.CustomShopSkuStorageLocationMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopSku.response.ListShopSkuResponse;
import com.sky.ddt.dto.shopSkuStorageLocation.request.ListShopSkuStorageLocationRequest;
import com.sky.ddt.dto.shopSkuStorageLocation.request.SaveShopSkuStorageLocationRequest;
import com.sky.ddt.dto.shopSkuStorageLocation.response.ListShopSkuStorageLocationResponse;
import com.sky.ddt.entity.ShopSku;
import com.sky.ddt.entity.ShopSkuStorageLocation;
import com.sky.ddt.entity.ShopSkuStorageLocationExample;
import com.sky.ddt.entity.StorageLocation;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.service.IShopSkuStorageLocationService;
import com.sky.ddt.service.IStorageLocationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @Description 店铺sku库位管理
 * @date 2022/1/8 0:17
 */
@Service
public class ShopSkuStorageLocationService implements IShopSkuStorageLocationService {
    @Autowired
    CustomShopSkuStorageLocationMapper customShopSkuStorageLocationMapper;
    @Autowired
    IShopSkuService shopSkuService;
    @Autowired
    IStorageLocationService storageLocationService;

    @Override
    public PageInfo<ListShopSkuStorageLocationResponse> listShopSkuStorageLocation(ListShopSkuStorageLocationRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListShopSkuStorageLocationResponse> list = customShopSkuStorageLocationMapper.listShopSkuStorageLocation(params);
        PageInfo<ListShopSkuStorageLocationResponse> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public BaseResponse saveShopSkuStorageLocation(SaveShopSkuStorageLocationRequest params, Integer dealUserId) {
        ShopSkuStorageLocation shopSkuStorageLocationOld=null;
        if(params.getId()!=null){
            shopSkuStorageLocationOld=customShopSkuStorageLocationMapper.selectByPrimaryKey(params.getId());
            if(shopSkuStorageLocationOld==null){
                return BaseResponse.failMessage("id不存在,请刷新后重试");
            }
        }
        ShopSku shopSku=shopSkuService.getShopSku(params.getShopSkuId());
        if(shopSku==null){
            return BaseResponse.failMessage("仓库skuid不存在");
        }
        StorageLocation storageLocation=storageLocationService.getStorageLocation(params.getStorageLocationId());
        if(storageLocation==null){
            return BaseResponse.failMessage("库位id不存在");
        }
        if(existShopSkuStorageLocation(params)){
            return BaseResponse.failMessage("仓库sku的库位信息已存在，无需重复添加");
        }
        ShopSkuStorageLocation shopSkuStorageLocation=new ShopSkuStorageLocation();
        BeanUtils.copyProperties(params,shopSkuStorageLocation);
        if(params.getId()==null){
            shopSkuStorageLocation.setCreateBy(dealUserId);
            shopSkuStorageLocation.setCreateTime(new Date());
            customShopSkuStorageLocationMapper.insertSelective(shopSkuStorageLocation);
        }else{
            shopSkuStorageLocation.setUpdateBy(dealUserId);
            shopSkuStorageLocation.setUpdateTime(new Date());
            customShopSkuStorageLocationMapper.updateByPrimaryKeySelective(shopSkuStorageLocation);
        }
        return BaseResponse.success();
    }

    private boolean existShopSkuStorageLocation(SaveShopSkuStorageLocationRequest params) {
        ShopSkuStorageLocationExample example=new ShopSkuStorageLocationExample();
        ShopSkuStorageLocationExample.Criteria criteria=example.createCriteria();
        if(params.getId()!=null){
            criteria.andIdNotEqualTo(params.getId());
        }
        criteria.andShopSkuIdEqualTo(params.getShopSkuId()).andStorageLocationIdEqualTo(params.getStorageLocationId());
        return customShopSkuStorageLocationMapper.countByExample(example)>0;
    }
}
