package com.sky.ddt.dto.checkOrderShopSku.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description 查询盘点单店铺sku入参
 * @date 2020/5/11 14:52
 */
@Data
public class ListCheckOrderShopSkuRequest extends DataGridRequest {
    Integer checkOrderId;
}
