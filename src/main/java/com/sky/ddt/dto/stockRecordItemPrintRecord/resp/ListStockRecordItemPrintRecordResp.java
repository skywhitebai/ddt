package com.sky.ddt.dto.stockRecordItemPrintRecord.resp;

import com.sky.ddt.entity.StockRecordItem;
import com.sky.ddt.entity.StockRecordItemPrintRecord;
import lombok.Data;

/**
 * @author baixueping
 * @description 发货单明细表
 * @date 2019/8/23 10:25
 */
@Data
public class ListStockRecordItemPrintRecordResp extends StockRecordItemPrintRecord {
    String createRealName;
}
