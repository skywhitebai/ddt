package com.sky.ddt.dto.amazon.response;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单导出
 *
 * @author baixueping
 * @date 2018/12/26
 */
@Data
public class OrderExport {
    String sku;
    Integer quantityPurchased;
    BigDecimal priceAmount;
}
