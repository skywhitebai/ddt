package com.sky.ddt.dto.inventory.response;

import com.sky.ddt.entity.Inventory;
import lombok.Data;

/**
 * @author baixueping
 * @description 列表返回值
 * @date 2019/4/23 9:31
 */
@Data
public class InventoryListResponse extends Inventory {
    String shopName;
}
