package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.report.salesReport.request.ListSalesReportRequest;
import com.sky.ddt.dto.report.salesReport.request.ListSalesmanReportRequest;
import com.sky.ddt.dto.report.salesReport.response.ListSalesReportResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author baixueping
 * @description 统计报告
 * @date 2020/4/14 11:35
 */
@Controller
@RequestMapping("report")
public class ReportController extends SuperController {

    @Autowired
    IReportService reportService;

    @RequestMapping("/salesReport")
    @MenuAnnotation("report/salesReport")
    public String salesReport() {
        return "report/salesReport";
    }

    @RequestMapping("listSalesReport")
    @ResponseBody
    @MenuAnnotation("report/salesReport")
    public DataGridResponse listSalesReport(ListSalesReportRequest params) {
        params.setUserId(getCurrentUserId());
        PageInfo<ListSalesReportResponse> page = reportService.listSalesReport(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("/salesmanReportChart")
    @ResponseBody
    public BaseResponse salesmanReportChart(@Validated  ListSalesmanReportRequest params) {
        return reportService.salesmanReportChart(params);
    }
}
