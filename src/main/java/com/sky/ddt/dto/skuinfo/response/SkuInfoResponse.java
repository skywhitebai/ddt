package com.sky.ddt.dto.skuinfo.response;

import lombok.Data;

/**
 * @author baixueping
 * @description 简单的sku信息
 * @date 2019/7/8 11:06
 */
@Data
public class SkuInfoResponse {
    private String skuSeller;

    private String skuWarehouse;

    private String skuSupplier;
}
