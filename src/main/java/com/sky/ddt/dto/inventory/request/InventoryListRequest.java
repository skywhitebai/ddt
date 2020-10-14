package com.sky.ddt.dto.inventory.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description 库存列表查询入参
 * @date 2019/4/23 9:10
 */
@Data
public class InventoryListRequest extends DataGridRequest {
    Integer shopId;
    String sellerSku;
}
