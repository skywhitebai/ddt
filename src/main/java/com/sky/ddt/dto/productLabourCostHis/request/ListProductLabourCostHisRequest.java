package com.sky.ddt.dto.productLabourCostHis.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author sky
 * @Description 查询产品工价历史
 * @date 2021/10/21 19:25
 */
@Data
public class ListProductLabourCostHisRequest extends DataGridRequest {
    Integer productId;
}
