package com.sky.ddt.dao.custom;

import com.sky.ddt.dto.report.salesReport.request.ListSalesReportRequest;
import com.sky.ddt.dto.report.salesReport.request.ListSalesmanReportRequest;
import com.sky.ddt.dto.report.salesReport.response.ListSalesReportResponse;
import com.sky.ddt.dto.report.salesReport.response.ListSalesmanReportResponse;

import java.util.List;

/**
 * @author baixueping
 * @description 报表管理
 * @date 2020/4/16 11:35
 */
public interface CustomReportMapper {
    /**
     * @param
     * @return
     * @description 获取销售统计
     * @author baixueping
     * @date 2020/4/16 14:23
     */
    List<ListSalesReportResponse> listSalesReportByShopSku(ListSalesReportRequest params);
    /**
     * @param
     * @return
     * @description 获取销售统计
     * @author baixueping
     * @date 2020/4/16 14:23
     */
    List<ListSalesReportResponse> listSalesReportByShopParentSku(ListSalesReportRequest params);
    /**
     * @param params@return
     * @description 查询销售人员业绩
     * @author baixueping
     * @date 2020/11/27 11:43
     */
    List<ListSalesmanReportResponse> listSalesmanReport(ListSalesmanReportRequest params);
}
