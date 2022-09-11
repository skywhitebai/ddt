package com.sky.ddt.dto.workTask.resp;

import com.sky.ddt.entity.WorkTask;
import com.sky.ddt.entity.WorkTaskWithBLOBs;
import lombok.Data;

/**
 * @author sky
 * @Description 列表查询工作任务返回值
 * @date 2022/4/29 23:07
 */
@Data
public class ListWorkTaskResp extends WorkTaskWithBLOBs {
    String dealUserRealName;
    String chargeUserRealNames;
}
