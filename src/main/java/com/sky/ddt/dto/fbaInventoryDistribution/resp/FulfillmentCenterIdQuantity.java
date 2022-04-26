package com.sky.ddt.dto.fbaInventoryDistribution.resp;

import lombok.Data;

/**
 * @author sky
 * @Description
 * @date 2022/4/26 23:31
 */
@Data
public class FulfillmentCenterIdQuantity {
    private Integer quantity;

    private String fulfillmentCenterId;
}
