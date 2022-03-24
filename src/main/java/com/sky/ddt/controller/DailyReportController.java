package com.sky.ddt.controller;

import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.dailyReport.req.CountListDailyReportReq;
import com.sky.ddt.dto.dailyReport.req.GetDailyReportReq;
import com.sky.ddt.dto.dailyReport.req.SaveDailyReportReq;
import com.sky.ddt.dto.dailyReport.req.UserListDailyReportReq;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.DailyReport;
import com.sky.ddt.service.IDailyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sky
 * @Description 日报
 * @date 2022/3/22 0:27
 */
@Controller
@RequestMapping("/dailyReport")
public class DailyReportController extends SuperController {
    @Autowired
    IDailyReportService dailyReportService;

    @RequestMapping("/saveIndex")
    @MenuAnnotation("dailyReport/saveIndex")
    public String index() {
        return "dailyReport/saveIndex";
    }

    @RequestMapping("/countListIndex")
    public String countListIndex() {
        return "dailyReport/countListIndex";
    }

    @RequestMapping("/userListIndex")
    public String userListIndex() {
        return "dailyReport/userListIndex";
    }

    @RequestMapping("/getDailyReport")
    @ResponseBody
    public BaseResponse<DailyReport> getDailyReport(@Validated GetDailyReportReq req) {
        req.setUserId(getCurrentUserId());
        return dailyReportService.getDailyReport(req);
    }

    @RequestMapping("/saveDailyReport")
    @ResponseBody
    public BaseResponse saveDailyReport(@Validated SaveDailyReportReq req) {
        req.setUserId(getCurrentUserId());
        return dailyReportService.saveDailyReport(req);
    }
    @RequestMapping("/countListDailyReport")
    @ResponseBody
    public DataGridResponse countListDailyReport(@Validated CountListDailyReportReq req) {
        return dailyReportService.countListDailyReport(req);
    }
    @RequestMapping("/userListDailyReport")
    @ResponseBody
    public DataGridResponse userListDailyReport(@Validated UserListDailyReportReq req) {
        if(req.getUserId()==null){
            req.setUserId(getCurrentUserId());
        }
        return dailyReportService.userListDailyReport(req);
    }

}
