package com.sky.ddt.dto.fbaPackingListRemarkHis.req;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author sky
 * @Description TODO
 * @date 2023/3/16 22:52
 */
@Data
public class ListFbaPackingListRemarkHisReq extends DataGridRequest {
    @NotNull(message = "FBA装箱单号不能为空")
    Integer fbaPackingListId;
}
