package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.common.constant.InternalOrderNumberTransportConstant;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.internalOrderNumberTransport.request.AddInternalOrderNumberTransportRequest;
import com.sky.ddt.dto.internalOrderNumberTransport.request.ListInternalOrderNumberTransportRequest;
import com.sky.ddt.dto.internalOrderNumberTransport.request.SaveInternalOrderNumberTransportRequest;
import com.sky.ddt.dto.internalOrderNumberTransport.response.ListInternalOrderNumberTransportResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.IInternalOrderNumberTransportService;
import com.sky.ddt.util.ExcelExportByExcelFieldUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author baixueping
 * @description 内部单号运输信息
 * @date 2020/7/1 16:37
 */
@Controller
@RequestMapping("internalOrderNumberTransport")
public class InternalOrderNumberTransportController extends SuperController {
    @Autowired
    IInternalOrderNumberTransportService internalOrderNumberTransportService;

    @GetMapping("/index")
    @MenuAnnotation("internalOrderNumberTransport/index")
    public String index() {
        return "internalOrderNumberTransport/list";
    }

    @GetMapping("/add")
    @MenuAnnotation("internalOrderNumberTransport/index")
    public String add() {
        return "internalOrderNumberTransport/add";
    }

    @RequestMapping("/listInternalOrderNumberTransport")
    @ResponseBody
    @MenuAnnotation("internalOrderNumberTransport/index")
    public DataGridResponse listInternalOrderNumberTransport(ListInternalOrderNumberTransportRequest params) {
        PageInfo<ListInternalOrderNumberTransportResponse> page = internalOrderNumberTransportService.listInternalOrderNumberTransport(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    @RequestMapping("/saveInternalOrderNumberTransport")
    @ResponseBody
    @MenuAnnotation("internalOrderNumberTransport/index")
    public BaseResponse saveInternalOrderNumberTransport(@Validated SaveInternalOrderNumberTransportRequest params) {
        Integer dealUserId = getCurrentUserId();
        return internalOrderNumberTransportService.saveInternalOrderNumberTransport(params, dealUserId);
    }

    /**
     * @param
     * @return
     * @description 批量添加内部单号发货信息
     * @author baixueping
     * @date 2020/7/7 15:03
     */
    @RequestMapping("/batchAddInternalOrderNumberTransport")
    @ResponseBody
    @MenuAnnotation("internalOrderNumberTransport/index")
    public BaseResponse batchAddInternalOrderNumberTransport(@RequestBody List<AddInternalOrderNumberTransportRequest> list) {
        Integer dealUserId = getCurrentUserId();
        return internalOrderNumberTransportService.batchAddInternalOrderNumberTransport(list, dealUserId);
    }

    @RequestMapping("/importTransferOrderNo")
    @ResponseBody
    @MenuAnnotation("internalOrderNumberTransport/index")
    public BaseResponse importTransferOrderNo(MultipartFile file) {
        Integer dealUserId = getCurrentUserId();
        return internalOrderNumberTransportService.importTransferOrderNo(file, dealUserId);
    }

    @RequestMapping("/importHeadTripCostRate")
    @ResponseBody
    @MenuAnnotation("internalOrderNumberTransport/index")
    public BaseResponse importHeadTripCostRate(MultipartFile file) {
        Integer dealUserId = getCurrentUserId();
        return internalOrderNumberTransportService.importHeadTripCostRate(file, dealUserId);
    }

    @RequestMapping("/exportInternalOrderNumberTransport")
    @ResponseBody
    @MenuAnnotation("internalOrderNumberTransport/index")
    public BaseResponse exportInternalOrderNumberTransport(ListInternalOrderNumberTransportRequest params) {
        List<ListInternalOrderNumberTransportResponse> list = internalOrderNumberTransportService.listExportInternalOrderNumberTransport(params);
        BaseResponse exportResponse = new ExcelExportByExcelFieldUtil().export(response, list, InternalOrderNumberTransportConstant.exprotInternalOrderNumberTransportFieldList, "内部单号发货记录");
        return exportResponse;
    }
}
