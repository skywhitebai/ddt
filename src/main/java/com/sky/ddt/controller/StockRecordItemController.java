package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.stockRecordItem.request.ListStockRecordItemRequest;
import com.sky.ddt.dto.stockRecordItem.request.SavePrintRemarkRequest;
import com.sky.ddt.dto.stockRecordItem.response.ListStockRecordItemResponse;
import com.sky.ddt.service.IStockRecordItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author baixueping
 * @description 发货单详情
 * @date 2019/8/23 10:18
 */
@RequestMapping("/stockRecordItem")
@Controller
public class StockRecordItemController extends SuperController {
    @Autowired
    IStockRecordItemService stockRecordItemService;

    @RequestMapping("/listStockRecordItem")
    @ResponseBody
    @MenuAnnotation("stockRecord/index")
    public DataGridResponse listStockRecordItem(@Validated ListStockRecordItemRequest params) {
        PageInfo<ListStockRecordItemResponse> page = stockRecordItemService.listStockRecordItem(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    @RequestMapping("/savePrintRemark")
    @ResponseBody
    @MenuAnnotation("stockRecord/index")
    public BaseResponse savePrintRemark(@Validated SavePrintRemarkRequest params) {
        return stockRecordItemService.savePrintRemark(params);
    }
}
