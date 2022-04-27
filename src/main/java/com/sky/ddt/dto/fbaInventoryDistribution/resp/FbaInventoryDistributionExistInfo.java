package com.sky.ddt.dto.fbaInventoryDistribution.resp;

import lombok.Data;

/**
 * @author sky
 * @Description
 * @date 2022/4/23 21:56
 */
@Data
public class FbaInventoryDistributionExistInfo {
    Integer id;
    String sku;
    String fulfillmentCenterId;
    String detailedDisposition;
}
