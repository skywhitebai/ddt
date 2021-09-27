package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.common.annotation.RightAnnotation;
import com.sky.ddt.common.constant.InternalOrderNumberConstant;
import com.sky.ddt.common.constant.ShopSkuConstant;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.internalOrderNumber.request.*;
import com.sky.ddt.dto.internalOrderNumber.response.ListInternalOrderNumberResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopSku.request.ListShopSkuRequest;
import com.sky.ddt.dto.shopSku.response.ExportShopSkuResponse;
import com.sky.ddt.service.IInternalOrderNumberService;
import com.sky.ddt.util.ExcelExportByExcelFieldUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author baixueping
 * @description 内部单号
 * @date 2020/6/30 10:40
 */
@Controller
@RequestMapping("/internalOrderNumber")
public class InternalOrderNumberController extends SuperController {
    @Autowired
    IInternalOrderNumberService internalOrderNumberService;

    @GetMapping("/index")
    @MenuAnnotation("internalOrderNumber/index")
    public String index() {
        return "internalOrderNumber/list";
    }
    @GetMapping("/payAmountIndex")
    @MenuAnnotation("internalOrderNumber/payAmountIndex")
    public String payAmountIndex() {
        return "internalOrderNumber/payAmountList";
    }

    @RequestMapping("/listInternalOrderNumber")
    @ResponseBody
    @MenuAnnotation("internalOrderNumber/index")
    public DataGridResponse listInternalOrderNumber(ListInternalOrderNumberRequest params) {
        PageInfo<ListInternalOrderNumberResponse> page = internalOrderNumberService.listInternalOrderNumber(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    @RequestMapping("/saveInternalOrderNumber")
    @ResponseBody
    @MenuAnnotation("internalOrderNumber/index")
    public BaseResponse saveInternalOrderNumber(@Validated SaveInternalOrderNumberRequest params) {
        Integer dealUserId=getCurrentUserId();
        return internalOrderNumberService.saveInternalOrderNumber(params,dealUserId);
    }
    @RequestMapping("/saveFinancialRemark")
    @ResponseBody
    @MenuAnnotation("internalOrderNumber/index")
    public BaseResponse saveFinancialRemark(@Validated SaveInternalOrderNumberFinancialRemarkRequest params) {
        Integer dealUserId=getCurrentUserId();
        return internalOrderNumberService.saveFinancialRemark(params,dealUserId);
    }
    @RequestMapping("/downPDF")
    @ResponseBody
    @MenuAnnotation("internalOrderNumber/index")
    public BaseResponse downPDF(Integer id) {
        return internalOrderNumberService.downPDF(id,response);
    }

    @RequestMapping("/savePayAmount")
    @ResponseBody
    @MenuAnnotation("internalOrderNumber/index")
    public BaseResponse savePayAmount(@Validated SaveInternalOrderNumberPayAmountRequest params) {
        Integer dealUserId=getCurrentUserId();
        return internalOrderNumberService.savePayAmount(params,dealUserId);
    }
    @RequestMapping("/generateTheoreticalAmount")
    @ResponseBody
    @MenuAnnotation("internalOrderNumber/payAmountIndex")
    public BaseResponse generateTheoreticalAmount(@Validated GenerateTheoreticalAmountRequest params) {
        params.setDealUserId(getCurrentUserId());
        return internalOrderNumberService.generateTheoreticalAmount(params);
    }
    @RequestMapping("/exportInternalOrderNumber")
    @ResponseBody
    public BaseResponse exportInternalOrderNumber(ListInternalOrderNumberRequest params) {
        List<ListInternalOrderNumberResponse> list = internalOrderNumberService.listExportInternalOrderNumber(params);
        BaseResponse exportResponse = new ExcelExportByExcelFieldUtil().export(response, list, InternalOrderNumberConstant.exportInternalOrderNumberFieldList, "内部单号信息");
        return exportResponse;
    }
}
