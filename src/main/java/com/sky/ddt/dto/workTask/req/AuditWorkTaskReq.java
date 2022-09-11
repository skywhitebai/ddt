package com.sky.ddt.dto.workTask.req;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author sky
 * @Description
 * @date 2022/4/29 23:32
 */
@Data
public class AuditWorkTaskReq {
    private Integer workTaskId;

    @NotNull(message = "审核状态不能为空")
    private Integer auditStatus;

    @NotEmpty(message = "审核意见")
    private String auditContent;
}
