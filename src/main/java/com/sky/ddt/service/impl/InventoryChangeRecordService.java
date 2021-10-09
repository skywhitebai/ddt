package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.InventoryChangeRecordConstant;
import com.sky.ddt.dao.custom.CustomInventoryChangeRecordMapper;
import com.sky.ddt.dto.inventoryChangeRecord.request.AddInventoryChangeRecordRequest;
import com.sky.ddt.dto.inventoryChangeRecord.request.ListInventoryChangeRecordRequest;
import com.sky.ddt.dto.inventoryChangeRecord.response.ListInventoryChangeRecordResponse;
import com.sky.ddt.entity.InventoryChangeRecord;
import com.sky.ddt.service.IInventoryChangeRecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description 店铺sku库存变更记录
 * @date 2020/5/7 17:01
 */
@Service
public class InventoryChangeRecordService implements IInventoryChangeRecordService {
    @Autowired
    CustomInventoryChangeRecordMapper customInventoryChangeRecordMapper;

    /**
     * @param addInventoryChangeRecordRequest@return
     * @description 添加库存变更记录
     * @author baixueping
     * @date 2020/5/8 9:54
     */
    @Override
    public void addInventoryChangeRecord(AddInventoryChangeRecordRequest addInventoryChangeRecordRequest) {
        InventoryChangeRecord inventoryChangeRecord=new InventoryChangeRecord();
        BeanUtils.copyProperties(addInventoryChangeRecordRequest,inventoryChangeRecord);
        inventoryChangeRecord.setCreateTime(new Date());
        customInventoryChangeRecordMapper.insertSelective(inventoryChangeRecord);
    }

    /**
     * @param params@return
     * @description 列表查询库存变更记录
     * @author baixueping
     * @date 2020/5/12 17:54
     */
    @Override
    public PageInfo<ListInventoryChangeRecordResponse> listInventoryChangeRecord(ListInventoryChangeRecordRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListInventoryChangeRecordResponse> list = customInventoryChangeRecordMapper.listInventoryChangeRecord(params);
        if (!CollectionUtils.isEmpty(list)) {
            for (ListInventoryChangeRecordResponse listInventoryChangeRecordResponse : list) {
                listInventoryChangeRecordResponse.setChangeTypeName(InventoryChangeRecordConstant.ChangeTypeEnum.getChangeTypeName(listInventoryChangeRecordResponse.getChangeType()));
            }
        }
        PageInfo<ListInventoryChangeRecordResponse> page = new PageInfo<ListInventoryChangeRecordResponse>(list);
        return page;
    }

    @Override
    public List<ListInventoryChangeRecordResponse> listExportInventoryChangeRecord(ListInventoryChangeRecordRequest params) {
        return  customInventoryChangeRecordMapper.listInventoryChangeRecord(params);
    }
}
