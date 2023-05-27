package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.stockRecordItemPrintRecord.req.ListStockRecordItemPrintRecordReq;
import com.sky.ddt.dto.stockRecordItemPrintRecord.req.SaveStockRecordItemPrintRecordRemarkReq;
import com.sky.ddt.dto.stockRecordItemPrintRecord.req.SaveStockRecordItemPrintRecordReq;
import com.sky.ddt.dto.stockRecordItemPrintRecord.resp.ListStockRecordItemPrintRecordResp;

/**
 * @author sky
 * @Description
 * @date 2023/5/27 15:33
 */
public interface IStockRecordItemPrintRecordService {
    BaseResponse saveStockRecordItemPrintRecord(SaveStockRecordItemPrintRecordReq params, Integer dealUserId);

    PageInfo<ListStockRecordItemPrintRecordResp> listStockRecordItemPrintRecord(ListStockRecordItemPrintRecordReq params);

    BaseResponse saveStockRecordItemPrintRecordRemark(SaveStockRecordItemPrintRecordRemarkReq params);
}
