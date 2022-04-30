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
public class SaveWorkTaskReq {
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
    @NotNull(message = "开始时间不能为空")
    private Date beginTime;
    @NotNull(message = "结束时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
    @NotEmpty(message = "内容不能为空")
    private String content;
    @NotNull(message = "负责人不能为空")
    private Integer chargeUserId;
    @NotNull(message = "负责小组不能为空")
    private Integer salesGroupId;
}
