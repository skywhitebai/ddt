package com.sky.ddt.dto.workTask.resp;

import com.sky.ddt.entity.WorkTask;
import lombok.Data;

/**
 * @author sky
 * @Description 列表查询工作任务返回值
 * @date 2022/4/29 23:07
 */
@Data
public class ListWorkTaskResp extends WorkTask {
    String dealUserRealName;
    String chargeUserRealName;
    String salesGroupName;
    String salesGroupUserRealNames;
    Integer salesGroupId;
}
