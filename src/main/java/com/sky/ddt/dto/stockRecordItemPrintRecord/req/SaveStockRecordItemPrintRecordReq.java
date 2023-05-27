package com.sky.ddt.dto.stockRecordItemPrintRecord.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author sky
 * @Description
 * @date 2023/5/27 15:42
 */
@Data
public class SaveStockRecordItemPrintRecordReq {
    @NotNull(message = "stockRecordItemId不能为空")
    Integer stockRecordItemId;
}
