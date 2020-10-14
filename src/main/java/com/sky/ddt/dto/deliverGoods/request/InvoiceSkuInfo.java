package com.sky.ddt.dto.deliverGoods.request;

import lombok.Data;

/**
 * @author baixueping
 * @description 发票sku基础信息
 * @date 2019/9/17 17:20
 */
@Data
public class InvoiceSkuInfo {
    Integer shopSkuId;
    String shopSku;
    String containerNo;
    Integer quantity;
    String chineseProductName;
    String englishProductName;
}
