package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.WorkTaskLogMapper;
import com.sky.ddt.dto.workTask.req.ListWorkTaskLogReq;
import com.sky.ddt.dto.workTask.resp.ListWorkTaskLogResp;

import java.util.List;

/**
 * @author sky
 * @Description
 * @date 2022/9/12 0:17
 */
public interface CustomWorkTaskLogMapper extends WorkTaskLogMapper {
    List<ListWorkTaskLogResp> listWorkTaskLog(ListWorkTaskLogReq params);
}
