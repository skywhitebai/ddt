package com.sky.ddt.dto.produceOrderShopSku.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description 查询生产单店铺sku入参
 * @date 2020/4/1 15:31
 */
@Data
public class ListProduceOrderShopSkuRequest extends DataGridRequest {
    Integer produceOrderId;
}
