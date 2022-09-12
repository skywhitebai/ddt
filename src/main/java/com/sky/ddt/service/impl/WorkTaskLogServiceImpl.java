package com.sky.ddt.service.impl;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dao.custom.CustomWorkTaskLogMapper;
import com.sky.ddt.dto.workTask.req.ListWorkTaskLogReq;
import com.sky.ddt.dto.workTask.resp.ListWorkTaskLogResp;
import com.sky.ddt.dto.workTask.resp.ListWorkTaskResp;
import com.sky.ddt.entity.WorkTaskLog;
import com.sky.ddt.service.WorkTaskLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @Description
 * @date 2022/9/12 0:16
 */
@Service
public class WorkTaskLogServiceImpl implements WorkTaskLogService {

    @Autowired
    CustomWorkTaskLogMapper customWorkTaskLogMapper;

    @Override
    public void addWorkTaskLog(Integer workTaskId, String content, Integer dealUserId) {
        WorkTaskLog workTaskLog=new WorkTaskLog();
        workTaskLog.setContent(content);
        workTaskLog.setCreateBy(dealUserId.longValue());
        workTaskLog.setCreateTime(new Date());
        workTaskLog.setWorkTaskId(workTaskId.longValue());
        customWorkTaskLogMapper.insertSelective(workTaskLog);
    }

    @Override
    public PageInfo<ListWorkTaskLogResp> listWorkTaskLog(ListWorkTaskLogReq params) {
        List<ListWorkTaskLogResp> list = customWorkTaskLogMapper.listWorkTaskLog(params);
        PageInfo<ListWorkTaskLogResp> page = new PageInfo<>(list);
        return page;
    }
}
