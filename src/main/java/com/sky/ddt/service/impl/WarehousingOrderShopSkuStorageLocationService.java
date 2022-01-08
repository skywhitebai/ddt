package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.dao.custom.CustomWarehousingOrderShopSkuStorageLocationMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.warehousingOrderShopSkuStorageLocation.request.ListWarehousingOrderShopSkuStorageLocationRequest;
import com.sky.ddt.dto.warehousingOrderShopSkuStorageLocation.request.SaveWarehousingOrderShopSkuStorageLocationRequest;
import com.sky.ddt.dto.warehousingOrderShopSkuStorageLocation.response.ListWarehousingOrderShopSkuStorageLocationResponse;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.IStorageLocationService;
import com.sky.ddt.service.IWarehousingOrderShopSkuService;
import com.sky.ddt.service.IWarehousingOrderShopSkuStorageLocationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @Description 入库仓库sku库存
 * @date 2022/1/8 0:22
 */
@Service
public class WarehousingOrderShopSkuStorageLocationService implements IWarehousingOrderShopSkuStorageLocationService {
    @Autowired
    CustomWarehousingOrderShopSkuStorageLocationMapper customWarehousingOrderShopSkuStorageLocationMapper;
    @Autowired
    IWarehousingOrderShopSkuService warehousingOrderShopSkuService;
    @Autowired
    IStorageLocationService storageLocationService;
    @Override
    public PageInfo<ListWarehousingOrderShopSkuStorageLocationResponse> listWarehousingOrderShopSkuStorageLocation(ListWarehousingOrderShopSkuStorageLocationRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListWarehousingOrderShopSkuStorageLocationResponse> list = customWarehousingOrderShopSkuStorageLocationMapper.listWarehousingOrderShopSkuStorageLocation(params);
        PageInfo<ListWarehousingOrderShopSkuStorageLocationResponse> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public BaseResponse saveWarehousingOrderShopSkuStorageLocation(SaveWarehousingOrderShopSkuStorageLocationRequest params, Integer dealUserId) {
        WarehousingOrderShopSkuStorageLocation warehousingOrderShopSkuStorageLocationOld=null;
        if(params.getId()!=null){
            warehousingOrderShopSkuStorageLocationOld=customWarehousingOrderShopSkuStorageLocationMapper.selectByPrimaryKey(params.getId());
            if(warehousingOrderShopSkuStorageLocationOld==null){
                return BaseResponse.failMessage("id不存在,请刷新后重试");
            }
        }
        WarehousingOrderShopSku warehousingOrderShopSku=warehousingOrderShopSkuService.getById(params.getWarehousingOrderShopSkuId());
        if(warehousingOrderShopSku==null){
            return BaseResponse.failMessage("入库信息不存在");
        }
        StorageLocation storageLocation=storageLocationService.getStorageLocation(params.getStorageLocationId());
        if(storageLocation==null){
            return BaseResponse.failMessage("库位id不存在");
        }
        if(existWarehousingOrderShopSkuStorageLocation(params)){
            return BaseResponse.failMessage("库位信息已存在，无需重复添加");
        }
        WarehousingOrderShopSkuStorageLocation warehousingOrderShopSkuStorageLocation=new WarehousingOrderShopSkuStorageLocation();
        BeanUtils.copyProperties(params,warehousingOrderShopSkuStorageLocation);
        if(params.getId()==null){
            warehousingOrderShopSkuStorageLocation.setCreateBy(dealUserId);
            warehousingOrderShopSkuStorageLocation.setCreateTime(new Date());
            customWarehousingOrderShopSkuStorageLocationMapper.insertSelective(warehousingOrderShopSkuStorageLocation);
        }else{
            warehousingOrderShopSkuStorageLocation.setUpdateBy(dealUserId);
            warehousingOrderShopSkuStorageLocation.setUpdateTime(new Date());
            customWarehousingOrderShopSkuStorageLocationMapper.updateByPrimaryKeySelective(warehousingOrderShopSkuStorageLocation);
        }
        return BaseResponse.success();
    }

    private boolean existWarehousingOrderShopSkuStorageLocation(SaveWarehousingOrderShopSkuStorageLocationRequest params) {
        WarehousingOrderShopSkuStorageLocationExample example=new WarehousingOrderShopSkuStorageLocationExample();
        WarehousingOrderShopSkuStorageLocationExample.Criteria criteria=example.createCriteria();
        if(params.getId()!=null){
            criteria.andIdNotEqualTo(params.getId());
        }
        criteria.andWarehousingOrderShopSkuIdEqualTo(params.getWarehousingOrderShopSkuId()).andStorageLocationIdEqualTo(params.getStorageLocationId());
        return customWarehousingOrderShopSkuStorageLocationMapper.countByExample(example)>0;
    }

    @Override
    public BaseResponse deleteWarehousingOrderShopSkuStorageLocation(Integer warehousingOrderShopSkuStorageLocationId) {
        if(warehousingOrderShopSkuStorageLocationId!=null){
            customWarehousingOrderShopSkuStorageLocationMapper.deleteByPrimaryKey(warehousingOrderShopSkuStorageLocationId);
        }
        return BaseResponse.success();
    }
}
