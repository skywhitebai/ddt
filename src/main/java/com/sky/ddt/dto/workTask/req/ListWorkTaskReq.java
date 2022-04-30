package com.sky.ddt.dto.workTask.req;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author sky
 * @Description 工作任务列表查询入参
 * @date 2022/4/29 23:05
 */
@Data
public class ListWorkTaskReq extends DataGridRequest {
    private String title;
    private String workTaskNo;
    private Integer status;
    private Integer dealUserId;
    private Integer chargeUserId;
    private Integer salesGroupId;
}
