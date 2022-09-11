package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.workTask.req.ListWorkTaskReq;
import com.sky.ddt.dto.workTask.req.SaveWorkTaskReq;
import com.sky.ddt.dto.workTask.resp.ListWorkTaskResp;

/**
 * @author sky
 * @Description 
 * @date 2022/4/29 23:02
 */
public interface IWorkTaskService {
    PageInfo<ListWorkTaskResp> listWorkTask(ListWorkTaskReq params);

    BaseResponse saveWorkTask(SaveWorkTaskReq params, Integer dealUserId);

    BaseResponse cancelWorkTask(Integer id, Integer dealUserId);

    String getWorderTaskNo();
}
