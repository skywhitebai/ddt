package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.dao.custom.CustomDailyReportMapper;
import com.sky.ddt.dto.dailyReport.DailyReportTypeEnum;
import com.sky.ddt.dto.dailyReport.req.CountListDailyReportReq;
import com.sky.ddt.dto.dailyReport.req.GetDailyReportReq;
import com.sky.ddt.dto.dailyReport.req.SaveDailyReportReq;
import com.sky.ddt.dto.dailyReport.req.UserListDailyReportReq;
import com.sky.ddt.dto.dailyReport.resp.CountListDailyReportResp;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.Currency;
import com.sky.ddt.entity.DailyReport;
import com.sky.ddt.entity.DailyReportExample;
import com.sky.ddt.service.IDailyReportService;
import com.sky.ddt.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @Description TODO
 * @date 2022/3/22 0:25
 */
@Service
public class DailyReportService implements IDailyReportService {
    @Autowired
    CustomDailyReportMapper customDailyReportMapper;

    @Override
    public BaseResponse<DailyReport> getDailyReport(GetDailyReportReq req) {
        DailyReport dailyReport = getDailyReport(req.getReportDay(), req.getUserId());
        return BaseResponse.successData(dailyReport);
    }

    @Override
    public BaseResponse saveDailyReport(SaveDailyReportReq req) {
        DailyReport dailyReportOld = getDailyReport(req.getReportDay(), req.getUserId());
        DailyReport dailyReport=new DailyReport();
        BeanUtils.copyProperties(req,dailyReport);
        if(req.getReportDay().after(DateUtil.getToday())){
            return BaseResponse.failMessage("不能提前填写日报");
        }
        if(dailyReportOld==null){
            dailyReport.setCreateBy(req.getUserId());
            dailyReport.setCreateTime(new Date());
            if(dailyReport.getReportDay().equals(DateUtil.getToday())){
                dailyReport.setType(DailyReportTypeEnum.NORMAL.getType());
            }else{
                dailyReport.setType(DailyReportTypeEnum.SUPPLEMENT.getType());
            }
            customDailyReportMapper.insertSelective(dailyReport);
        }else{
            if(dailyReport.getCreateTime().before(DateUtil.plusDay(-2,new Date()))){
                return BaseResponse.failMessage("填写两天后不允许修改");
            }
            dailyReport.setUpdateBy(req.getUserId());
            dailyReport.setUpdateTime(new Date());
            dailyReport.setId(dailyReportOld.getId());
            customDailyReportMapper.updateByPrimaryKeySelective(dailyReport);
        }
        return BaseResponse.success();
    }

    @Override
    public DataGridResponse countListDailyReport(CountListDailyReportReq req) {
        List<CountListDailyReportResp> list=customDailyReportMapper.countListDailyReport(req);
        for(CountListDailyReportResp countListDailyReportResp:list){
            countListDailyReportResp.setTodayWorkContent(countListDailyReportResp.getTodayWorkContent().replace("\r\n","<br/>"));
            countListDailyReportResp.setTomorrowWorkPlan(countListDailyReportResp.getTomorrowWorkPlan().replace("\r\n","<br/>"));
        }
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setRows(list);
        return dataGridResponse;
    }

    @Override
    public DataGridResponse userListDailyReport(UserListDailyReportReq req) {
        PageHelper.startPage(req.getPage(), req.getRows(), true);
        List<CountListDailyReportResp> list=customDailyReportMapper.userListDailyReport(req);
        for(CountListDailyReportResp countListDailyReportResp:list){
            countListDailyReportResp.setTodayWorkContent(countListDailyReportResp.getTodayWorkContent().replace("\r\n","<br/>"));
            countListDailyReportResp.setTomorrowWorkPlan(countListDailyReportResp.getTomorrowWorkPlan().replace("\r\n","<br/>"));
        }
        PageInfo<CountListDailyReportResp> page = new PageInfo<>(list);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(list);
        return dataGridResponse;
    }

    private DailyReport getDailyReport(Date reportDay, Integer userId) {
        DailyReportExample dailyReportExample = new DailyReportExample();
        dailyReportExample.createCriteria().andUserIdEqualTo(userId).andReportDayEqualTo(reportDay);
        List<DailyReport> list = customDailyReportMapper.selectByExample(dailyReportExample);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }
}
