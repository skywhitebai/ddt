package com.sky.ddt.dto.report.salesReport.response;

import com.sky.ddt.util.MathUtil;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author baixueping
 * @description 列表查询销售人员业绩
 * @date 2020/11/27 11:37
 */
@Data
public class ListSalesmanReportResponse {
    /**
     * 订单数量
     */
    Integer orderQuantityTotal;
    /**
     * 商品数量
     */
    Integer quantityTotal;
    /**
     * 订单价格
     */
    BigDecimal itemPriceTotal;
    /**
     * 商品平均价格
     */
    BigDecimal itemPriceAverage;
    String userName;
    String realName;
    Integer salesmanUserId;

    public BigDecimal getItemPriceAverage() {
        if (itemPriceAverage != null) {
            return itemPriceAverage;
        }
        if (itemPriceTotal == null || BigDecimal.ZERO.equals(itemPriceTotal)) {
            itemPriceAverage = BigDecimal.ZERO;
            return itemPriceAverage;
        }
        if (quantityTotal == null || quantityTotal == 0) {
            itemPriceAverage = new BigDecimal(-1);
            return itemPriceAverage;
        }
        itemPriceAverage = MathUtil.divide(itemPriceTotal, quantityTotal, 2);
        return itemPriceAverage;
    }
}
