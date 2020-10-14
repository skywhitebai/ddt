package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.InventoryChangeRecordMapper;
import com.sky.ddt.dto.inventoryChangeRecord.request.ListInventoryChangeRecordRequest;
import com.sky.ddt.dto.inventoryChangeRecord.response.ListInventoryChangeRecordResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author baixueping
 * @description 店铺sku库存变更记录数据库操作类
 * @date 2020/5/7 17:28
 */
public interface CustomInventoryChangeRecordMapper extends InventoryChangeRecordMapper {
    @Autowired
    /**
     * @param
     * @return
     * @description 分页查询店铺sku库存记录
     * @author baixueping
     * @date 2020/5/12 17:57
     */
    List<ListInventoryChangeRecordResponse> listInventoryChangeRecord(ListInventoryChangeRecordRequest params);
}
