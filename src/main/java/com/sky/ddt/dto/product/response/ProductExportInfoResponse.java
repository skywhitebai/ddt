package com.sky.ddt.dto.product.response;

import com.sky.ddt.entity.Product;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author baixueping
 * @description 导出产品信息
 * @date 2019/5/13 16:40
 */
@Data
public class ProductExportInfoResponse extends Product {
    //开发人员名称
    String developerUserName;
    private BigDecimal costPriceMin;
    private BigDecimal costPriceMax;
    private BigDecimal headTripCostMin;
    private BigDecimal headTripCostMax;
}
