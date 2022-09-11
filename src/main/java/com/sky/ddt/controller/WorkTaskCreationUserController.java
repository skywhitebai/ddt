package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dao.generate.WorkTaskCreationUserMapper;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.workTaskCreation.req.ListWorkTaskCreationReq;
import com.sky.ddt.dto.workTaskCreation.req.ListWorkTaskCreationUserReq;
import com.sky.ddt.dto.workTaskCreation.req.SaveWorkTaskCreationUserReq;
import com.sky.ddt.dto.workTaskCreation.resp.ListWorkTaskCreationResp;
import com.sky.ddt.service.WorkTaskCreationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author sky
 * @Description
 * @date 2022/9/11 11:36
 */
@RequestMapping("/workTaskCreationUser")
@Controller
public class WorkTaskCreationUserController extends SuperController{
    @Autowired
    WorkTaskCreationUserService workTaskCreationUserService;

    @RequestMapping("/listWorkTaskCreationUser")
    @MenuAnnotation("workTaskCreation/index")
    @ResponseBody
    public BaseResponse listWorkTaskCreationUser(ListWorkTaskCreationUserReq params) {
        return workTaskCreationUserService.listWorkTaskCreationUser(params);
    }

    @RequestMapping("/saveWorkTaskCreationUser")
    @MenuAnnotation("workTaskCreation/index")
    @ResponseBody
    public BaseResponse saveWorkTaskCreationUser(Long workTaskCreationId, @RequestParam(required = false, value = "userIds[]") List<Long> userIds) {
        Integer dealUserId=getCurrentUserId();
        return workTaskCreationUserService.saveWorkTaskCreationUser(workTaskCreationId,userIds,dealUserId);
    }

}
