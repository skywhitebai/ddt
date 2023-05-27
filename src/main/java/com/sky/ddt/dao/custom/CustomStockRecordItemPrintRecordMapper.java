package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.StockRecordItemPrintRecordMapper;
import com.sky.ddt.dto.stockRecordItemPrintRecord.req.ListStockRecordItemPrintRecordReq;
import com.sky.ddt.dto.stockRecordItemPrintRecord.resp.ListStockRecordItemPrintRecordResp;

import java.util.List;

/**
 * @author sky
 * @Description
 * @date 2023/5/27 15:29
 */
public interface CustomStockRecordItemPrintRecordMapper extends StockRecordItemPrintRecordMapper {

    List<ListStockRecordItemPrintRecordResp> listStockRecordItemPrintRecord(ListStockRecordItemPrintRecordReq params);
}
