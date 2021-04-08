package com.sky.ddt.dto.product.response;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author baixueping
 * @description 导出产品信息
 * @date 2019/5/13 16:40
 */
@Data
public class ProductExportInfoResponse {
    private String productName;

    private String productCode;
    String chineseProductName;
    String englishProductName;

    Integer developmentLevel;
    private String description;

    private String remark;
}
