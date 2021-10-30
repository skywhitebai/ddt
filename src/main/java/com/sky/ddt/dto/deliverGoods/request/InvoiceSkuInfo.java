package com.sky.ddt.dto.deliverGoods.request;

import lombok.Data;

import java.math.BigDecimal;

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
    Double weight;
    String chineseProductName;
    String englishProductName;
    String hsCode;

    public Double getWeight() {
        if (weight == null || weight <= 0||weight>=1) {
            return 0.21;
        }
        return weight;
    }
}
