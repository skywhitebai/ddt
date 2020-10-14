package com.sky.ddt.dto.product.response;

import com.sky.ddt.entity.Product;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 产品列表出参
 */
@Data
public class ProductListResponse extends Product {
    //图片
    String imgUrl;
    //开发人员名称
    String developerUserName;
    private BigDecimal costPriceMin;
    private BigDecimal costPriceMax;
    private BigDecimal headTripCostMin;
    private BigDecimal headTripCostMax;
}
