package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.internalOrderNumber.request.ListInternalOrderNumberRequest;
import com.sky.ddt.dto.internalOrderNumber.request.SaveInternalOrderNumberFinancialRemarkRequest;
import com.sky.ddt.dto.internalOrderNumber.request.SaveInternalOrderNumberRequest;
import com.sky.ddt.dto.internalOrderNumber.response.ListInternalOrderNumberResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.IInternalOrderNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author baixueping
 * @description 内部单号
 * @date 2020/6/30 10:40
 */
@Controller
@RequestMapping("internalOrderNumber")
public class InternalOrderNumberController extends SuperController {
    @Autowired
    IInternalOrderNumberService internalOrderNumberService;

    @GetMapping("/index")
    @MenuAnnotation("internalOrderNumber/index")
    public String index() {
        return "internalOrderNumber/list";
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

    @RequestMapping("saveInternalOrderNumber")
    @ResponseBody
    @MenuAnnotation("internalOrderNumber/index")
    public BaseResponse saveInternalOrderNumber(@Validated SaveInternalOrderNumberRequest params) {
        Integer dealUserId=getCurrentUserId();
        return internalOrderNumberService.saveInternalOrderNumber(params,dealUserId);
    }
    @RequestMapping("saveFinancialRemark")
    @ResponseBody
    @MenuAnnotation("internalOrderNumber/index")
    public BaseResponse saveFinancialRemark(@Validated SaveInternalOrderNumberFinancialRemarkRequest params) {
        Integer dealUserId=getCurrentUserId();
        return internalOrderNumberService.saveFinancialRemark(params,dealUserId);
    }
    @RequestMapping("downPDF")
    @ResponseBody
    @MenuAnnotation("internalOrderNumber/index")
    public BaseResponse downPDF(Integer id) {
        return internalOrderNumberService.downPDF(id,response);
    }
}
