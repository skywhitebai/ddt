package com.sky.ddt.dto.factoryProductionOrder.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description 列表查询工厂生产单入参
 * @date 2020/10/12 14:52
 */
@Data
public class ListFactoryProductionOrderRequest extends DataGridRequest{
    Integer shopId;
    Integer id;
    String shopSku;
    String sku;
    Integer stockRecordId;
    Integer currentUserId;
    Integer status;
}
