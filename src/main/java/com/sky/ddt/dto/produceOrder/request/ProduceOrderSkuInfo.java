package com.sky.ddt.dto.produceOrder.request;

import lombok.Data;

/**
 * @author sky
 * @Description 生产单产品sku信息
 * @date 2021/11/17 0:42
 */
@Data
public class ProduceOrderSkuInfo {
    Integer produceOrderId;
    Integer skuId;
    Integer quantity;
}
