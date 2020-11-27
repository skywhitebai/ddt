package com.sky.ddt.dto.report.salesReport.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author baixueping
 * @description 销售人员信息报表入参
 * @date 2020/11/27 11:01
 */
@Data
public class ListSalesmanReportRequest {
    @NotNull(message = "开始时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date purchaseDateStart;
    @NotNull(message = "结束时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date purchaseDateEnd;
}
