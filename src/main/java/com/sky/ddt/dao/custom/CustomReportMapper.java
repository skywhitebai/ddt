package com.sky.ddt.dao.custom;

import com.sky.ddt.dto.report.salesReport.request.ListSalesReportRequest;
import com.sky.ddt.dto.report.salesReport.response.ListSalesReportResponse;

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
}
