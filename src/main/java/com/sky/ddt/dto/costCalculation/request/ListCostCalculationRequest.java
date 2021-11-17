package com.sky.ddt.dto.costCalculation.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

import java.util.Date;

/**
 * @author sky
 * @Description 成本核算
 * @date 2021/11/17 23:39
 */
@Data
public class ListCostCalculationRequest extends DataGridRequest {
    String sku;
    String month;
    Date monthDate;
}
