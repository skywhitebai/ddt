package com.sky.ddt.dto.workOrder.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author sky
 * @Description 列表查询工单
 * @date 2021/8/17 23:26
 */
@Data
public class ListWorkOrderRequest extends DataGridRequest {
    String title;
    Integer status;
}
