package com.sky.ddt.dto.produceOrder.request;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author sky
 * @Description 财务信息
 * @date 2021/11/17 0:07
 */
@Data
public class GenerationCostInfo {
    Integer skuId;
    Integer quantity;
    BigDecimal costPrice;
}
