package com.sky.ddt.dto.salesGroupUser.req;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author sky
 * @Description
 * @date 2022/3/27 13:42
 */
@Data
public class ListSalesGroupUserReq extends DataGridRequest {
    @NotNull(message = "分组ID不能为空")
    Integer salesGroupId;
}
