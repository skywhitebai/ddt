package com.sky.ddt.dto.product.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

@Data
public class ProductListRequest extends DataGridRequest {
    private String productName;

    private String productCode;
}