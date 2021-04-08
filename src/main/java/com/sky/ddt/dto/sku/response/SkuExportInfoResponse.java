package com.sky.ddt.dto.sku.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author baixueping
 * @description sku信息
 * @date 2019/5/13 14:49
 */
@Data
public class SkuExportInfoResponse {
    String productName;
    private String productCode;

    private String sku;

    private String colour;

    private String colourNumber;

    private String size;

    private Double weight;

    private BigDecimal costPrice;
    BigDecimal headTripCost;
    Integer inventoryQuantity;
    Date createTime;
    String remark;

}
