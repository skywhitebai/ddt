package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.dao.custom.CustomCheckOrderShopSkuStorageLocationMapper;
import com.sky.ddt.dto.CheckOrderShopSkuStorageLocation.request.*;
import com.sky.ddt.dto.CheckOrderShopSkuStorageLocation.response.ListCheckOrderShopSkuStorageLocationResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.CheckOrderShopSkuStorageLocation.request.ListCheckOrderShopSkuStorageLocationRequest;
import com.sky.ddt.dto.CheckOrderShopSkuStorageLocation.request.SaveCheckOrderShopSkuStorageLocationRequest;
import com.sky.ddt.dto.CheckOrderShopSkuStorageLocation.response.ListCheckOrderShopSkuStorageLocationResponse;
import com.sky.ddt.entity.StorageLocation;
import com.sky.ddt.entity.CheckOrderShopSku;
import com.sky.ddt.entity.CheckOrderShopSkuStorageLocation;
import com.sky.ddt.entity.CheckOrderShopSkuStorageLocationExample;
import com.sky.ddt.service.ICheckOrderShopSkuStorageLocationService;
import com.sky.ddt.service.IStorageLocationService;
import com.sky.ddt.service.ICheckOrderShopSkuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @Description 盘点单库位服务
 * @date 2022/1/9 11:13
 */
@Service
public class CheckOrderShopSkuStorageLocationService implements ICheckOrderShopSkuStorageLocationService {
    @Autowired
    CustomCheckOrderShopSkuStorageLocationMapper customCheckOrderShopSkuStorageLocationMapper;

    @Autowired
    ICheckOrderShopSkuService CheckOrderShopSkuService;
    @Autowired
    IStorageLocationService storageLocationService;
    @Override
    public PageInfo<ListCheckOrderShopSkuStorageLocationResponse> listCheckOrderShopSkuStorageLocation(ListCheckOrderShopSkuStorageLocationRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListCheckOrderShopSkuStorageLocationResponse> list = customCheckOrderShopSkuStorageLocationMapper.listCheckOrderShopSkuStorageLocation(params);
        PageInfo<ListCheckOrderShopSkuStorageLocationResponse> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public BaseResponse saveCheckOrderShopSkuStorageLocation(SaveCheckOrderShopSkuStorageLocationRequest params, Integer dealUserId) {
        CheckOrderShopSkuStorageLocation CheckOrderShopSkuStorageLocationOld=null;
        if(params.getId()!=null){
            CheckOrderShopSkuStorageLocationOld=customCheckOrderShopSkuStorageLocationMapper.selectByPrimaryKey(params.getId());
            if(CheckOrderShopSkuStorageLocationOld==null){
                return BaseResponse.failMessage("id不存在,请刷新后重试");
            }
        }
        CheckOrderShopSku CheckOrderShopSku=CheckOrderShopSkuService.getById(params.getCheckOrderShopSkuId());
        if(CheckOrderShopSku==null){
            return BaseResponse.failMessage("盘点信息不存在");
        }
        StorageLocation storageLocation=storageLocationService.getStorageLocation(params.getStorageLocationId());
        if(storageLocation==null){
            return BaseResponse.failMessage("库位id不存在");
        }
        if(existCheckOrderShopSkuStorageLocation(params)){
            return BaseResponse.failMessage("库位信息已存在，无需重复添加");
        }
        CheckOrderShopSkuStorageLocation CheckOrderShopSkuStorageLocation=new CheckOrderShopSkuStorageLocation();
        BeanUtils.copyProperties(params,CheckOrderShopSkuStorageLocation);
        if(params.getId()==null){
            CheckOrderShopSkuStorageLocation.setCreateBy(dealUserId);
            CheckOrderShopSkuStorageLocation.setCreateTime(new Date());
            customCheckOrderShopSkuStorageLocationMapper.insertSelective(CheckOrderShopSkuStorageLocation);
        }else{
            CheckOrderShopSkuStorageLocation.setUpdateBy(dealUserId);
            CheckOrderShopSkuStorageLocation.setUpdateTime(new Date());
            customCheckOrderShopSkuStorageLocationMapper.updateByPrimaryKeySelective(CheckOrderShopSkuStorageLocation);
        }
        return BaseResponse.success();
    }

    private boolean existCheckOrderShopSkuStorageLocation(SaveCheckOrderShopSkuStorageLocationRequest params) {
        CheckOrderShopSkuStorageLocationExample example=new CheckOrderShopSkuStorageLocationExample();
        CheckOrderShopSkuStorageLocationExample.Criteria criteria=example.createCriteria();
        if(params.getId()!=null){
            criteria.andIdNotEqualTo(params.getId());
        }
        criteria.andCheckOrderShopSkuIdEqualTo(params.getCheckOrderShopSkuId()).andStorageLocationIdEqualTo(params.getStorageLocationId());
        return customCheckOrderShopSkuStorageLocationMapper.countByExample(example)>0;
    }

    @Override
    public BaseResponse deleteCheckOrderShopSkuStorageLocation(Integer checkOrderShopSkuStorageLocationId) {
        if(checkOrderShopSkuStorageLocationId!=null){
            customCheckOrderShopSkuStorageLocationMapper.deleteByPrimaryKey(checkOrderShopSkuStorageLocationId);
        }
        return BaseResponse.success();
    }

    @Override
    public void batchSaveCheckOrderShopSkuStorageLocation(BatchSaveCheckOrderShopSkuStorageLocationRequest batchSaveWarehousingOrderShopSkuStorageLocationRequest) {
        if(batchSaveWarehousingOrderShopSkuStorageLocationRequest.getCheckOrderShopSkuId()==null|| CollectionUtils.isEmpty(batchSaveWarehousingOrderShopSkuStorageLocationRequest.getStorageLocationIdList())){
            return;
        }
        customCheckOrderShopSkuStorageLocationMapper.batchSaveCheckOrderShopSkuStorageLocation(batchSaveWarehousingOrderShopSkuStorageLocationRequest);
    }
}
