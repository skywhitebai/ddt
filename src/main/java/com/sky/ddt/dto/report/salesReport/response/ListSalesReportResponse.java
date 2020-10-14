package com.sky.ddt.dto.report.salesReport.response;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author baixueping
 * @description 销售报表返回值
 * @date 2020/4/16 10:17
 */
@Data
public class ListSalesReportResponse {
    Integer shopSkuId;
    Integer skuId;
    String imgUrl;
    String shopName;
    String asin;
    String shopSku;
    String shopParentSku;
    Integer quantityToday;
    BigDecimal netSalesToday;
    BigDecimal unitPriceToday;
    Integer quantityYesterday;
    BigDecimal netSalesYesterday;
    BigDecimal unitPriceYesterday;
    Integer quantitySameDayLastWeek;
    BigDecimal netSalesSameDayLastWeek;
    BigDecimal unitPriceSameDayLastWeek;
    Integer availableQuantity;
    Integer inboundQuantity;
    Integer reservedQuantity;

}
