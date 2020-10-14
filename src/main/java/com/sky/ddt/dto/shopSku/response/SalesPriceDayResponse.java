package com.sky.ddt.dto.shopSku.response;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author baixueping
 * @description 每天销售数量
 * @date 2019/8/30 15:14
 */
@Data
public class SalesPriceDayResponse {
    String purchaseDate;
    BigDecimal price;
    Integer shopSkuId;
    String shopParentSku;
}
