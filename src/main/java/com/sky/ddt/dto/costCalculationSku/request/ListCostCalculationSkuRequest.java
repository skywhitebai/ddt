package com.sky.ddt.dto.costCalculationSku.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

import java.util.Date;

/**
 * @author sky
 * @Description 列表查询sku成本
 * @date 2021/11/17 23:57
 */
@Data
public class ListCostCalculationSkuRequest extends DataGridRequest {
    String sku;
    Integer costCalculationId;
}