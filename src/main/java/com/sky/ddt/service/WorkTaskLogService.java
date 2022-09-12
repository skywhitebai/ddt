package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.workTask.req.ListWorkTaskLogReq;
import com.sky.ddt.dto.workTask.resp.ListWorkTaskLogResp;

/**
 * @author sky
 * @Description
 * @date 2022/9/12 0:15
 */
public interface WorkTaskLogService {
    void addWorkTaskLog(Integer id, String content, Integer dealUserId);

    PageInfo<ListWorkTaskLogResp> listWorkTaskLog(ListWorkTaskLogReq params);
}
