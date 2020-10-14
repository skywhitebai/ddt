package com.sky.ddt.dto.stockRecordItem.request;

import com.sky.ddt.common.constant.StockRecordItemConstant;
import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 发货单详情查询
 * @date 2019/8/23 10:20
 */
@Data
public class ListStockRecordItemRequest extends DataGridRequest{
    @NotNull(message = StockRecordItemConstant.STOCK_RECORD_ID_EMPTY)
    Integer stockRecordId;
    String shopSku;
    String sku;
}
