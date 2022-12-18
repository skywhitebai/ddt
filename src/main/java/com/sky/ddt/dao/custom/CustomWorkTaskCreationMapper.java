package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.WorkTaskCreationMapper;
import com.sky.ddt.dto.workTaskCreation.req.ListWorkTaskCreationReq;
import com.sky.ddt.dto.workTaskCreation.resp.ListWorkTaskCreationResp;

import java.util.List;

/**
 * @author sky
 * @Description
 ** @date 2022/9/10 16:15
 */
public interface CustomWorkTaskCreationMapper extends WorkTaskCreationMapper {
    List<ListWorkTaskCreationResp> listWorkTaskCreation(ListWorkTaskCreationReq params);

    List<Integer> listWorkTaskCreationUser(Integer workTaskCreationId);
}
