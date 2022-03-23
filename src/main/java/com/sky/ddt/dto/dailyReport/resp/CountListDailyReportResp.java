package com.sky.ddt.dto.dailyReport.resp;

import com.sky.ddt.entity.DailyReport;
import lombok.Data;

/**
 * @author sky
 * @Description
 * @date 2022/3/23 23:08
 */
@Data
public class CountListDailyReportResp extends DailyReport {
    String realName;
}
