package com.sky.ddt.dto.stockRecordItemPrintRecord.req;

import com.sky.ddt.common.constant.StockRecordItemConstant;
import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description
 * @date 2019/8/23 10:20
 */
@Data
public class ListStockRecordItemPrintRecordReq extends DataGridRequest{
    @NotNull(message ="stockRecordItemId不能为空")
    Integer stockRecordItemId;
}
