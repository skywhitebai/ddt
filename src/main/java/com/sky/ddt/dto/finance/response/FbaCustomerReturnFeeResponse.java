package com.sky.ddt.dto.finance.response;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author baixueping
 * @description FBA返还费
 * @date 2019/12/26 12:55
 */
@Data
public class FbaCustomerReturnFeeResponse {
    BigDecimal total;
    String orderId;
    Integer shopSkuId;
}
