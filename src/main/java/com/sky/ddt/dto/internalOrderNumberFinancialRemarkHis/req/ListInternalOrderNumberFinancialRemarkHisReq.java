package com.sky.ddt.dto.internalOrderNumberFinancialRemarkHis.req;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author sky
 * @Description 内部单号财务备注
 * @date 2022/3/4 22:09
 */
@Data
public class ListInternalOrderNumberFinancialRemarkHisReq extends DataGridRequest {
    @NotNull(message = "内部单号不能为空")
    Integer internalOrderNumberId;
}
