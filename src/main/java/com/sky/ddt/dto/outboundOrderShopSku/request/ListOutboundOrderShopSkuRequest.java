package com.sky.ddt.dto.outboundOrderShopSku.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description 列表查询出库单店铺sku入参
 * @date 2020/5/12 12:49
 */
@Data
public class ListOutboundOrderShopSkuRequest extends DataGridRequest {
    Integer outboundOrderId;
    String shopSku;
    String sku;
}
