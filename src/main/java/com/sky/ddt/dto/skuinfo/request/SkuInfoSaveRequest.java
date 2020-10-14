package com.sky.ddt.dto.skuinfo.request;
import lombok.Data;
@Data
public class SkuInfoSaveRequest {
    private Integer id;

    private String skuSeller;

    private String skuWarehouse;
    private String skuSupplier;
}
