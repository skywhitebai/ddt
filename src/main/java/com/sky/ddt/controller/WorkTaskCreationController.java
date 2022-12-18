package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.workTask.req.ListWorkTaskReq;
import com.sky.ddt.dto.workTask.req.SaveWorkTaskReq;
import com.sky.ddt.dto.workTask.resp.ListWorkTaskResp;
import com.sky.ddt.dto.workTaskCreation.req.ListWorkTaskCreationReq;
import com.sky.ddt.dto.workTaskCreation.req.SaveWorkTaskCreationReq;
import com.sky.ddt.dto.workTaskCreation.resp.ListWorkTaskCreationResp;
import com.sky.ddt.service.WorkTaskCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sky
 * @Description
 * @date 2022/9/10 16:09
 */
@RequestMapping("/workTaskCreation")
@Controller
public class WorkTaskCreationController extends SuperController{
    @Autowired
    WorkTaskCreationService workTaskCreationService;
    @RequestMapping("/index")
    @MenuAnnotation("workTaskCreation/index")
    public String index() {
        return "workTaskCreation/list";
    }

    @RequestMapping("/listWorkTaskCreation")
    @MenuAnnotation("workTaskCreation/index")
    @ResponseBody
    public DataGridResponse listWorkTaskCreation(ListWorkTaskCreationReq params) {
        PageInfo<ListWorkTaskCreationResp> page=workTaskCreationService.listWorkTaskCreation(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("/saveWorkTaskCreation")
    @ResponseBody
    @MenuAnnotation("workTaskCreation/index")
    public BaseResponse saveWorkTaskCreation(@Validated SaveWorkTaskCreationReq params) {
        Integer dealUserId = getCurrentUserId();
        return workTaskCreationService.saveWorkTaskCreation(params, dealUserId);
    }
    @RequestMapping("cancelWorkTaskCreation")
    @ResponseBody
    @MenuAnnotation("cancelWorkTaskCreation/index")
    public BaseResponse cancelWorkTaskCreation(Integer id) {
        Integer dealUserId = getCurrentUserId();
        return workTaskCreationService.cancelWorkTaskCreation(id, dealUserId);
    }
}
