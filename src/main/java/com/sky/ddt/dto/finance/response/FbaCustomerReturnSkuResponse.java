package com.sky.ddt.dto.finance.response;

import lombok.Data;

/**
 * @author baixueping
 * @description FBA返还费Sku信息
 * @date 2019/12/26 14:23
 */
@Data
public class FbaCustomerReturnSkuResponse {
    String orderId;
    String shopSku;
    Integer shopSkuId;
    Boolean used;
}
