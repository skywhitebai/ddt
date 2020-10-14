package com.sky.ddt.dto.report.salesReport.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author baixueping
 * @description 查询销售报表入参
 * @date 2020/4/16 9:42
 */
@Data
public class ListSalesReportRequest extends DataGridRequest {
    Integer shopId;
    String asin;
    String shopSku;
    String shopParentSku;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date purchaseDate;
    String skuType;
    Integer userId;
}
