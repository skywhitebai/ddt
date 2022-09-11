package com.sky.ddt.service;

import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.workTaskCreation.req.ListWorkTaskCreationUserReq;
import com.sky.ddt.dto.workTaskCreation.req.SaveWorkTaskCreationUserReq;

import java.util.List;

/**
 * @author sky
 * @Description
 * @date 2022/9/11 11:36
 */
public interface WorkTaskCreationUserService {
    BaseResponse listWorkTaskCreationUser(ListWorkTaskCreationUserReq params);

    BaseResponse saveWorkTaskCreationUser(Long workTaskCreationId, List<Long> userIds, Integer dealUserId);
}
