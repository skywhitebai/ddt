package com.sky.ddt.dto.workOrder.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author sky
 * @Description 保存工单入参
 * @date 2021/8/17 23:40
 */
@Data
public class SaveWorkOrderRequest {
    private Integer id;
    @NotEmpty(message = "标题不能为空")
    @Length(max = 100, message = "标题长度不能超过100")
    private String title;

    @Length(max = 100, message = "备注长度不能超过250")
    private String remark;

    private Integer status;

    @NotNull(message = "处理级别不能为空")
    private Integer level;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date planEndTime;
    @NotEmpty(message = "内容不能为空")
    private String content;
}
