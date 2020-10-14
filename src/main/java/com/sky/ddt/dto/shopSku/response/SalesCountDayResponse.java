package com.sky.ddt.dto.shopSku.response;

import lombok.Data;

/**
 * @author baixueping
 * @description 每天销售数量
 * @date 2019/8/30 15:14
 */
@Data
public class SalesCountDayResponse {
    String purchaseDate;
    Integer quantity;
    Integer shopSkuId;
    String shopParentSku;
}
