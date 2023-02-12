package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.Action;
import com.sky.ddt.common.annotation.LogRequest;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.stock.request.ListStockRequest;
import com.sky.ddt.dto.stock.response.ListStockResponse;
import com.sky.ddt.dto.stockRemark.req.ListStockRemarkReq;
import com.sky.ddt.dto.stockRemark.req.SaveStockRemarkReq;
import com.sky.ddt.dto.stockRemark.resp.ListStockRemarkResp;
import com.sky.ddt.service.IStockRemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author sky
 * @Description
 * @date 2022/10/25 22:00
 */
@RequestMapping("/stockRemark")
@Controller
public class StockRemarkController extends SuperController{

    @Autowired
    IStockRemarkService stockRemarkService;
    @RequestMapping("/saveStockRemark")
    @ResponseBody
    @MenuAnnotation("stock/index")
    public BaseResponse saveStockRemark(@Validated SaveStockRemarkReq req) {
        return stockRemarkService.saveStockRemark(req, getCurrentUserId());
    }

    @RequestMapping("/listStockRemark")
    @ResponseBody
    @MenuAnnotation("stock/index")
    public DataGridResponse listStockRemark(@Validated ListStockRemarkReq req) {
        PageInfo<ListStockRemarkResp> page = stockRemarkService.listStockRemark(req);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    //importFinance
    @RequestMapping("/importStockRemark")
    @ResponseBody
    @LogRequest(action = Action.Skip)
    public BaseResponse importStockRemark(MultipartFile file) {
        Integer dealUserId = getCurrentUserId();
        return stockRemarkService.importStockRemark(file, dealUserId);
    }
}
