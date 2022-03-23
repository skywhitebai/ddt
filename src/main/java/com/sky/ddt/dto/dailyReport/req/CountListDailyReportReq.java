package com.sky.ddt.dto.dailyReport.req;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author sky
 * @Description
 * @date 2022/3/23 23:08
 */
@Data
public class CountListDailyReportReq {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "日期不能为空")
    private Date reportDay;
}
