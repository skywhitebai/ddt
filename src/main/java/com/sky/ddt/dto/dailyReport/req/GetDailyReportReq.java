package com.sky.ddt.dto.dailyReport.req;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author sky
 * @Description TODO
 * @date 2022/3/23 22:35
 */
@Data
public class GetDailyReportReq {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "日期不能为空")
    private Date reportDay;
    private Integer userId;
}
