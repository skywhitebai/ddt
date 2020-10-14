package com.sky.ddt.dto.shopSku.response;

import lombok.Data;

/**
 * @author baixueping
 * @description 销售数据
 * @date 2019/8/30 15:11
 */
@Data
public class SalesCountResponse {
    Integer shopSkuId;
    String  shopName;
    String  shopSku;
    String  shopParentSku;
    String  productName;
    String productCode;
}
