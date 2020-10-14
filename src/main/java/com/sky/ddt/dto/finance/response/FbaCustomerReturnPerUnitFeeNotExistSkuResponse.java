package com.sky.ddt.dto.finance.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author baixueping
 * @description 退款服务费不存在sku
 * @date 2019/12/27 11:18
 */
@Data
public class FbaCustomerReturnPerUnitFeeNotExistSkuResponse {
    String orderId;
    BigDecimal total;
    Date dateTime;
}
