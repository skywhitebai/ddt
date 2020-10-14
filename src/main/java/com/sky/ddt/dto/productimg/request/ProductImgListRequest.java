package com.sky.ddt.dto.productimg.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

@Data
public class ProductImgListRequest extends DataGridRequest {
    private Integer productId;
}
