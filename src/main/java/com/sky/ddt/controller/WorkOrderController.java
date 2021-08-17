package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.warehousingOrder.request.SaveWarehousingOrderRequest;
import com.sky.ddt.dto.workOrder.request.ListWorkOrderRequest;
import com.sky.ddt.dto.workOrder.request.SaveWorkOrderRequest;
import com.sky.ddt.entity.WorkOrder;
import com.sky.ddt.service.IWorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sky
 * @Description TODO
 * @date 2021/8/9 21:29
 */
@Controller
@RequestMapping("/workOrder")
public class WorkOrderController extends SuperController{
    @Autowired
    IWorkOrderService workOrderService;
    @RequestMapping("/index")
    @MenuAnnotation("workOrder/index")
    public String index() {
        return "workOrder/list";
    }
    @RequestMapping("/listWorkOrder")
    @MenuAnnotation("workOrder/index")
    @ResponseBody
    public DataGridResponse listWorkOrder(ListWorkOrderRequest params) {
        PageInfo<WorkOrder> page=workOrderService.listWorkOrder(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("saveWorkOrder")
    @ResponseBody
    @MenuAnnotation("workOrder/index")
    public BaseResponse saveWorkOrder(@Validated SaveWorkOrderRequest params) {
        Integer dealUserId = getCurrentUserId();
        return workOrderService.saveWorkOrder(params, dealUserId);
    }
}
