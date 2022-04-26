package com.sky.ddt.dto.fbaInventoryDistribution.resp;

import lombok.Data;

import java.util.List;

/**
 * @author sky
 * @Description
 * @date 2022/4/26 23:32
 */
@Data
public class SkuFulfillmentCenterIdQuantity {
    String sku;
    List<FulfillmentCenterIdQuantity> fulfillmentCenterIdQuantityList;
    Integer quantity;
}
