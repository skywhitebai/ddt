package com.sky.ddt.controller;

import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.workTaskCreation.req.ListWorkTaskCreationRoleReq;
import com.sky.ddt.dto.workTaskCreation.req.ListWorkTaskCreationUserReq;
import com.sky.ddt.service.IWorkTaskCreationRoleService;
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
@RequestMapping("/workTaskCreationRole")
@Controller
public class WorkTaskCreationRoleController extends SuperController {
    @Autowired
    IWorkTaskCreationRoleService workTaskCreationRoleService;

    @RequestMapping("/listWorkTaskCreationRole")
    @MenuAnnotation("workTaskCreation/index")
    @ResponseBody
    public BaseResponse listWorkTaskCreationRole(ListWorkTaskCreationRoleReq params) {
        return workTaskCreationRoleService.listWorkTaskCreationRole(params);
    }

    @RequestMapping("/saveWorkTaskCreationRole")
    @MenuAnnotation("workTaskCreation/index")
    @ResponseBody
    public BaseResponse saveWorkTaskCreationRole(Long workTaskCreationId, @RequestParam(required = false, value = "roleIds[]") List<Long> roleIds) {
        Integer dealUserId = getCurrentUserId();
        return workTaskCreationRoleService.saveWorkTaskCreationRole(workTaskCreationId, roleIds, dealUserId);
    }

}
