package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.common.annotation.RightAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.financialDocument.request.ChangeFinancialDocumentStatusRequest;
import com.sky.ddt.dto.financialDocument.request.ListFinancialDocumentRequest;
import com.sky.ddt.dto.financialDocument.request.SaveFinancialDocumentRequest;
import com.sky.ddt.dto.financialDocument.response.ListFinancialDocumentResponse;
import com.sky.ddt.dto.productDevelop.request.ChangeProductDevelopStatusRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.IFinancialDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sky
 * @Description 财务单据管理
 * @date 2022/2/16 22:13
 */
@RequestMapping("/financialDocument")
@Controller
public class FinancialDocumentController extends SuperController{
    @Autowired
    IFinancialDocumentService financialDocumentService;

    @RequestMapping("/index")
    @MenuAnnotation("financialDocument/index")
    public String index() {
        return "financialDocument/list";
    }

    @RequestMapping("/listFinancialDocument")
    @ResponseBody
    @MenuAnnotation("financialDocument/index")
    public DataGridResponse listFinancialDocument(ListFinancialDocumentRequest params) {
        PageInfo<ListFinancialDocumentResponse> page = financialDocumentService.listFinancialDocument(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("/saveFinancialDocument")
    @ResponseBody
    @MenuAnnotation("financialDocument/index")
    public BaseResponse saveFinancialDocument(@Validated SaveFinancialDocumentRequest params) {
        Integer dealUserId=getCurrentUserId();
        return financialDocumentService.saveFinancialDocument(params,dealUserId);
    }

    @RequestMapping("/changeFinancialDocumentStatus")
    @ResponseBody
    @MenuAnnotation("financialDocument/index")
    @RightAnnotation("financialDocument/changeFinancialDocumentStatus")
    public BaseResponse changeFinancialDocumentStatus(@Validated ChangeFinancialDocumentStatusRequest params) {
        Integer dealUserId=getCurrentUserId();
        return financialDocumentService.changeFinancialDocumentStatus(params,dealUserId);
    }
}
