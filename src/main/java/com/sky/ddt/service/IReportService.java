package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.report.salesReport.request.ListSalesReportRequest;
import com.sky.ddt.dto.report.salesReport.request.ListSalesmanReportRequest;
import com.sky.ddt.dto.report.salesReport.response.ListSalesReportResponse;
import com.sky.ddt.dto.response.BaseResponse;

/**
 * @author baixueping
 * @description 报表服务
 * @date 2020/4/16 10:33
 */
public interface IReportService {
    /**
     * @param
     * @return
     * @description 分页查询销售统计报表
     * @author baixueping
     * @date 2020/4/16 10:39
     */
    PageInfo<ListSalesReportResponse> listSalesReport(ListSalesReportRequest params);

    /**
     * @param
     * @return
     * @description 查询销售人员业绩
     * @author baixueping
     * @date 2020/11/27 11:43
     */
    BaseResponse salesmanReportChart(ListSalesmanReportRequest params);
}
