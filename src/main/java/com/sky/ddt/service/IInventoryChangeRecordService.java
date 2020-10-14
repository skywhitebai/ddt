package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.inventoryChangeRecord.request.AddInventoryChangeRecordRequest;
import com.sky.ddt.dto.inventoryChangeRecord.request.ListInventoryChangeRecordRequest;
import com.sky.ddt.dto.inventoryChangeRecord.response.ListInventoryChangeRecordResponse;

/**
 * @author baixueping
 * @description 店铺sku库存改变记录
 * @date 2020/5/7 16:59
 */
public interface IInventoryChangeRecordService {
    /**
     * @param
     * @return
     * @description 添加库存变更记录
     * @author baixueping
     * @date 2020/5/8 9:54
     */
    void addInventoryChangeRecord(AddInventoryChangeRecordRequest addInventoryChangeRecordRequest);

    /**
     * @param
     * @return
     * @description 列表查询库存变更记录
     * @author baixueping
     * @date 2020/5/12 17:54
     */
    PageInfo<ListInventoryChangeRecordResponse> listInventoryChangeRecord(ListInventoryChangeRecordRequest params);
}
