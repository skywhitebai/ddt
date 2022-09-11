package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.workTaskCreation.req.ListWorkTaskCreationReq;
import com.sky.ddt.dto.workTaskCreation.req.SaveWorkTaskCreationReq;
import com.sky.ddt.dto.workTaskCreation.resp.ListWorkTaskCreationResp;

/**
 * @author sky
 * @Description 
 * @date 2022/9/10 16:09
 */
public interface WorkTaskCreationService {
    PageInfo<ListWorkTaskCreationResp> listWorkTaskCreation(ListWorkTaskCreationReq params);

    BaseResponse saveWorkTaskCreation(SaveWorkTaskCreationReq params, Integer dealUserId);

    BaseResponse cancelWorkTaskCreation(Integer id, Integer dealUserId);

    void workTaskCreation();
}
