package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.common.annotation.RightAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.workOrder.request.ListWorkOrderRequest;
import com.sky.ddt.dto.workOrder.request.SaveWorkOrderRequest;
import com.sky.ddt.dto.workTask.req.AuditWorkTaskReq;
import com.sky.ddt.dto.workTask.req.ListWorkTaskReq;
import com.sky.ddt.dto.workTask.req.SaveWorkTaskReq;
import com.sky.ddt.dto.workTask.resp.ListWorkTaskResp;
import com.sky.ddt.entity.WorkOrder;
import com.sky.ddt.service.IWorkOrderService;
import com.sky.ddt.service.IWorkTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sky
 * @Description
 * @date 2022/4/29 21:29
 */
@Controller
@RequestMapping("/workTask")
public class WorkTaskController extends SuperController {
    @Autowired
    IWorkTaskService workTaskService;

    @RequestMapping("/index")
    @MenuAnnotation("workTask/index")
    public String index() {
        return "workTask/list";
    }

    @RequestMapping("/listWorkTask")
    @MenuAnnotation("workTask/index")
    @ResponseBody
    public DataGridResponse listWorkTask(ListWorkTaskReq params) {
        if (getCurrentUserInfo().getRoleNameList().contains("超级管理员")) {
            params.setAdmin(1);
        }
        params.setCurrentUserId(getCurrentUserId());
        PageInfo<ListWorkTaskResp> page = workTaskService.listWorkTask(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    @RequestMapping("saveWorkTask")
    @ResponseBody
    @MenuAnnotation("workTask/index")
    public BaseResponse saveWorkTask(@Validated SaveWorkTaskReq params) {
        Integer dealUserId = getCurrentUserId();
        return workTaskService.saveWorkTask(params, dealUserId);
    }

    @RequestMapping("cancelWorkTask")
    @ResponseBody
    @MenuAnnotation("workTask/index")
    public BaseResponse cancelWorkTask(Integer id) {
        Integer dealUserId = getCurrentUserId();
        return workTaskService.cancelWorkTask(id, dealUserId);
    }
    @RequestMapping("completeWorkTask")
    @ResponseBody
    @MenuAnnotation("workTask/index")
    public BaseResponse completeWorkTask(Integer id) {
        Integer dealUserId = getCurrentUserId();
        return workTaskService.completeWorkTask(id, dealUserId);
    }
    @RequestMapping("auditWorkTask")
    @ResponseBody
    @RightAnnotation("auditWorkTask")
    public BaseResponse auditWorkTask(@Validated AuditWorkTaskReq params) {
        Integer dealUserId = getCurrentUserId();
        return workTaskService.auditWorkTask(params, dealUserId);
    }
}
