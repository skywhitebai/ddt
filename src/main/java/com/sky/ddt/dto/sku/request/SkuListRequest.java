package com.sky.ddt.dto.sku.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description sku列表查询
 * @date 2019/5/10 9:14
 */
@Data
public class SkuListRequest extends DataGridRequest {
    String sku;
    String productCode;
    String productName;
}
