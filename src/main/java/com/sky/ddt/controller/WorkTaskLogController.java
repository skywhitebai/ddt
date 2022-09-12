package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.common.annotation.RightAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.workTask.req.AuditWorkTaskReq;
import com.sky.ddt.dto.workTask.req.ListWorkTaskLogReq;
import com.sky.ddt.dto.workTask.req.ListWorkTaskReq;
import com.sky.ddt.dto.workTask.req.SaveWorkTaskReq;
import com.sky.ddt.dto.workTask.resp.ListWorkTaskLogResp;
import com.sky.ddt.dto.workTask.resp.ListWorkTaskResp;
import com.sky.ddt.service.IWorkTaskService;
import com.sky.ddt.service.WorkTaskLogService;
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
@RequestMapping("/workTaskLog")
public class WorkTaskLogController extends SuperController {
    @Autowired
    WorkTaskLogService workTaskLogService;

    @RequestMapping("/listWorkTaskLog")
    @MenuAnnotation("workTask/index")
    @ResponseBody
    public DataGridResponse listWorkTaskLog(@Validated ListWorkTaskLogReq params) {
        PageInfo<ListWorkTaskLogResp> page = workTaskLogService.listWorkTaskLog(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
}
