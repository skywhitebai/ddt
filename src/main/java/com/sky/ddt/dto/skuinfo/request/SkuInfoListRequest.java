package com.sky.ddt.dto.skuinfo.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

@Data
public class SkuInfoListRequest extends DataGridRequest {
    private String skuSeller;

    private String skuWarehouse;
    private String skuSupplier;
}
