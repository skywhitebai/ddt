package com.sky.ddt.dto.shopSku.response;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author baixueping
 * @description 导出店铺sku
 * @date 2019/7/30 11:26
 */
@Data
public class ExportShopSkuResponse {
    String shopName;
    String sku;
    String shopSku;
    String shopParentSku;
    String fnsku;
    String asin;
    String parentAsin;
    String title;
    String status;
    String produceStatus;
    Integer inventoryQuantity;
    String storageLocation;
    BigDecimal headTripCost;
    BigDecimal weight;
    BigDecimal costPrice;
    String remark;
}
