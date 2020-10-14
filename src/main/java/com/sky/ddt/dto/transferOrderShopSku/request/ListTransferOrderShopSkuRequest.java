package com.sky.ddt.dto.transferOrderShopSku.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description 列表查询调拨单店铺sku
 * @date 2020/9/1 10:37
 */
@Data
public class ListTransferOrderShopSkuRequest extends DataGridRequest{
    Integer transferOrderId;
    String sku;
    String shopSkuFrom;
    String shopSkuTo;
}
