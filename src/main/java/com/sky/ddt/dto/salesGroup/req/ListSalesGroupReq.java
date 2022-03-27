package com.sky.ddt.dto.salesGroup.req;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author sky
 * @Description 列表查询销售分组
 * @date 2022/3/26 23:39
 */
@Data
public class ListSalesGroupReq extends DataGridRequest {
    String groupName;
    Integer userId;
    Integer status;
}
