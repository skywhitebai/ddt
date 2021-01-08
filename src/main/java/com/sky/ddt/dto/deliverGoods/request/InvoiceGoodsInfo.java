package com.sky.ddt.dto.deliverGoods.request;

import lombok.Data;

/**
 * @author baixueping
 * @description 发票货物信息
 * @date 2019/9/17 15:13
 */
@Data
public class InvoiceGoodsInfo {

    Integer numberOfBoxes;
    String goodsName;
    String material;
    String purpose;
    String brand;
    Integer quantity;
    Double weight;
    Double unitPrice;
    Double totalPrice;
}
