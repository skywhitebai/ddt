package com.sky.ddt.controller.finance;

import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.controller.SuperController;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.finance.IFinancialStatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author baixueping
 * @description 财务报表
 * @date 2019/12/24 11:22
 */
@Controller
@RequestMapping("financialStatement")
public class FinancialStatementController extends SuperController {

    @Autowired
    IFinancialStatementService financialStatementService;

    @RequestMapping("/createFinancialStatement")
    @ResponseBody
    @MenuAnnotation("finance/index")
    public BaseResponse createFinancialStatement(Integer financeId) {
        Integer dealUserId = getCurrentUserId();
        return financialStatementService.createFinancialStatement(financeId, dealUserId);
    }
    @RequestMapping("/exportFinancialStatement")
    @ResponseBody
    @MenuAnnotation("finance/index")
    public BaseResponse exportFinancialStatement(Integer financeId) {
        return financialStatementService.exportFinancialStatement(response,financeId);
    }
    @RequestMapping("/exportDeveloperFinancialStatement")
    @ResponseBody
    @MenuAnnotation("finance/index")
    public BaseResponse exportDeveloperFinancialStatement(String month) {
        return financialStatementService.exportFinancialStatement(response,month,"developer");
    }
    @RequestMapping("/exportSalesmanFinancialStatement")
    @ResponseBody
    @MenuAnnotation("finance/index")
    public BaseResponse exportSalesmanFinancialStatement(String month) {
        return financialStatementService.exportFinancialStatement(response,month,"salesman");
    }
    @RequestMapping("/exportCurrentUserDeveloperFinancialStatement")
    @ResponseBody
    public BaseResponse exportCurrentUserDeveloperFinancialStatement(String month) {
        return financialStatementService.exportCurrentUserFinancialStatement(response,month,"developer",getCurrentUserId());
    }
    @RequestMapping("/exportCurrentUserSalesmanFinancialStatement")
    @ResponseBody
    public BaseResponse exportCurrentUserSalesmanFinancialStatement(String month) {
        return financialStatementService.exportCurrentUserFinancialStatement(response,month,"salesman",getCurrentUserId());
    }
    @RequestMapping("/exportFinancialStatementAll")
    @ResponseBody
    @MenuAnnotation("finance/index")
    public BaseResponse exportFinancialStatementAll(String month) {
        return financialStatementService.exportFinancialStatementAll(response,month);
    }
}
