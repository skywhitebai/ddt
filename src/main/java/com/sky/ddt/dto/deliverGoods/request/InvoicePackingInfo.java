package com.sky.ddt.dto.deliverGoods.request;

import lombok.Data;

/**
 * @author baixueping
 * @description 发票装箱单信息
 * @date 2019/9/17 15:26
 */
@Data
public class InvoicePackingInfo {
    String containerNo;
    String chineseProductName;
    String englishProductName;
    String hsCode;
    String goodsName;
    Integer quantity;
    Double length;
    Double width;
    Double height;
    Double weight;
    String brand;
    String material;
    String purpose;
    Double unitPrice;
    Double totalPrice;
}
