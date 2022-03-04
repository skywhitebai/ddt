package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.internalOrderNumber.request.ListInternalOrderNumberRequest;
import com.sky.ddt.dto.internalOrderNumber.response.ListInternalOrderNumberResponse;
import com.sky.ddt.dto.internalOrderNumberFinancialRemarkHis.req.ListInternalOrderNumberFinancialRemarkHisReq;
import com.sky.ddt.dto.internalOrderNumberFinancialRemarkHis.resp.ListInternalOrderNumberFinancialRemarkHisResp;
import com.sky.ddt.service.IInternalOrderNumberFinancialRemarkHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sky
 * @Description 内部单号财务备注历史
 * @date 2022/3/4 22:06
 */
@Controller
@RequestMapping("/internalOrderNumberFinancialRemarkHis")
public class InternalOrderNumberFinancialRemarkHisController extends SuperController{
    @Autowired
    IInternalOrderNumberFinancialRemarkHisService internalOrderNumberFinancialRemarkHisService;

    @RequestMapping("/listInternalOrderNumberFinancialRemarkHis")
    @ResponseBody
    @MenuAnnotation("internalOrderNumber/index")
    public DataGridResponse listInternalOrderNumber(ListInternalOrderNumberFinancialRemarkHisReq params) {
        PageInfo<ListInternalOrderNumberFinancialRemarkHisResp> page = internalOrderNumberFinancialRemarkHisService.listInternalOrderNumberFinancialRemarkHis(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
}
