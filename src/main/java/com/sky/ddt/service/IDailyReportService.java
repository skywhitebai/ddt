package com.sky.ddt.service;

import com.sky.ddt.dto.dailyReport.req.CountListDailyReportReq;
import com.sky.ddt.dto.dailyReport.req.GetDailyReportReq;
import com.sky.ddt.dto.dailyReport.req.SaveDailyReportReq;
import com.sky.ddt.dto.dailyReport.req.UserListDailyReportReq;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.DailyReport;

/**
 * @author sky
 * @Description 日报
 * @date 2022/3/22 0:25
 */
public interface IDailyReportService {
    BaseResponse<DailyReport> getDailyReport(GetDailyReportReq req);

    BaseResponse saveDailyReport(SaveDailyReportReq req);

    DataGridResponse countListDailyReport(CountListDailyReportReq req);

    DataGridResponse userListDailyReport(UserListDailyReportReq req);
}
