package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.stockRecordItem.request.SavePrintRemarkRequest;
import com.sky.ddt.dto.stockRecordItemPrintRecord.req.ListStockRecordItemPrintRecordReq;
import com.sky.ddt.dto.stockRecordItemPrintRecord.req.SaveStockRecordItemPrintRecordRemarkReq;
import com.sky.ddt.dto.stockRecordItemPrintRecord.req.SaveStockRecordItemPrintRecordReq;
import com.sky.ddt.dto.stockRecordItemPrintRecord.resp.ListStockRecordItemPrintRecordResp;
import com.sky.ddt.service.IStockRecordItemPrintRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sky
 * @Description
 * @date 2023/5/27 15:31
 */
@RequestMapping("/stockRecordItemPrintRecord")
@Controller
public class StockRecordItemPrintRecordController extends SuperController {
    @Autowired
    IStockRecordItemPrintRecordService stockRecordItemPrintRecordService;
    @RequestMapping("/saveStockRecordItemPrintRecord")
    @ResponseBody
    @MenuAnnotation("stockRecord/index")
    public BaseResponse saveStockRecordItemPrintRecord(@Validated SaveStockRecordItemPrintRecordReq params) {
        Integer dealUserId=getCurrentUserId();
        return stockRecordItemPrintRecordService.saveStockRecordItemPrintRecord(params,dealUserId);
    }

    @RequestMapping("/listStockRecordItemPrintRecord")
    @ResponseBody
    @MenuAnnotation("stockRecord/index")
    public DataGridResponse listStockRecordItemPrintRecord(@Validated ListStockRecordItemPrintRecordReq params) {
        PageInfo<ListStockRecordItemPrintRecordResp> page = stockRecordItemPrintRecordService.listStockRecordItemPrintRecord(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("/saveStockRecordItemPrintRecordRemark")
    @ResponseBody
    @MenuAnnotation("stockRecord/index")
    public BaseResponse saveStockRecordItemPrintRecordRemark(@Validated SaveStockRecordItemPrintRecordRemarkReq params) {
        return stockRecordItemPrintRecordService.saveStockRecordItemPrintRecordRemark(params);
    }

}
