package com.sky.ddt.dto.workTask.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author sky
 * @Description
 * @date 2022/9/12 22:00
 */
@Data
public class ListWorkTaskLogReq {
    @NotNull(message = "任务id不能为空")
    Long workTaskId;
}
