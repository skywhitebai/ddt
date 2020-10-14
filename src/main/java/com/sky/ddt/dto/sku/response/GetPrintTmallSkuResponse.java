package com.sky.ddt.dto.sku.response;

import lombok.Data;

/**
 * @author baixueping
 * @description 获取天猫打印sku返回值
 * @date 2020/4/30 17:07
 */
@Data
public class GetPrintTmallSkuResponse {
    String brand;
    String secondSku;
    String productName;
    String productCode;
    String material;
    String grade;
    String executiveStandard;
    String securityCategory;
    String inspector;
    String suggestedRetailPrice;
    String size;
    String colour;
}
