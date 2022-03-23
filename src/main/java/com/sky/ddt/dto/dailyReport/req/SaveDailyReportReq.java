package com.sky.ddt.dto.dailyReport.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author sky
 * @Description 保存日报入参
 * @date 2022/3/22 22:16
 */
@Data
public class SaveDailyReportReq {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date reportDay;
    @NotEmpty(message = "今日总结不能空")
    private String todayWorkContent;
    @NotEmpty(message = "明日计划不能空")
    private String tomorrowWorkPlan;
    private Integer userId;
}
