package com.sky.ddt.dto.inventoryChangeRecord.response;

import com.sky.ddt.entity.InventoryChangeRecord;
import lombok.Data;

/**
 * @author baixueping
 * @description 列表查询库存返回值
 * @date 2020/5/12 17:51
 */
@Data
public class ListInventoryChangeRecordResponse extends InventoryChangeRecord {
    String  shopName;
    String changeTypeName;
    String createByRealName;
    String batchNumber;
    String  shopSku;
}
