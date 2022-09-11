package com.sky.ddt.dto.workTaskCreation.req;

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
public class SaveWorkTaskCreationReq {
    private Integer id;
    @NotEmpty(message = "标题不能为空")
    @Length(max = 100, message = "标题长度不能超过100")
    private String title;
    @NotEmpty(message = "内容不能为空")
    private String content;
    @NotNull(message = "处理级别不能为空")
    private Integer level;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "开始时间不能为空")
    private Date beginTime;
    @NotNull(message = "结束时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
    @Length(max = 100, message = "备注长度不能超过250")
    private String remark;
    //默认进行中
    private Integer status;
    @NotNull(message = "类型不能为空")
    private Integer type;
    @NotNull(message = "是否需要审核不能为空")
    private Integer needAudit;
}
