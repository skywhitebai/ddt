package com.sky.ddt.controller;

import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.service.IWorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
