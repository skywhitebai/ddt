package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.WorkTaskMapper;
import com.sky.ddt.dto.workTask.req.ListWorkTaskReq;
import com.sky.ddt.dto.workTask.resp.ListWorkTaskResp;

import java.util.List;

/**
 * @author sky
 * @Description 工单数据库操作类
 * @date 2021/8/9 21:28
 */
public interface CustomWorkTaskMapper extends WorkTaskMapper {
    List<ListWorkTaskResp> listWorkTask(ListWorkTaskReq params);
}
