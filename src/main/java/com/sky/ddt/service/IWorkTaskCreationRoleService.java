package com.sky.ddt.service;

import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.workTaskCreation.req.ListWorkTaskCreationRoleReq;

import java.util.List;

/**
 * @author sky
 * @Description
 * @date 2022/9/11 11:36
 */
public interface IWorkTaskCreationRoleService {
    BaseResponse listWorkTaskCreationRole(ListWorkTaskCreationRoleReq params);

    BaseResponse saveWorkTaskCreationRole(Long workTaskCreationId, List<Long> roleIds, Integer dealUserId);
}
