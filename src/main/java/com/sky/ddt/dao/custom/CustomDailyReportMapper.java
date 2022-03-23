package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.DailyReportMapper;
import com.sky.ddt.dto.dailyReport.req.CountListDailyReportReq;
import com.sky.ddt.dto.dailyReport.resp.CountListDailyReportResp;

import java.util.List;

/**
 * @author sky
 * @Description 日报
 * @date 2022/3/21 23:47
 */
public interface CustomDailyReportMapper extends DailyReportMapper {
    List<CountListDailyReportResp> countListDailyReport(CountListDailyReportReq req);
}
