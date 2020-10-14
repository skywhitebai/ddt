package com.sky.ddt.dto.warehousingOrderShopSku.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description 列表查询入库单店铺sku
 * @date 2020/4/23 16:22
 */
@Data
public class ListWarehousingOrderShopSkuRequest extends DataGridRequest {
    Integer warehousingOrderId;
}
