package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.factoryProductionOrder.request.ListFactoryProductionOrderRequest;
import com.sky.ddt.dto.factoryProductionOrder.request.SaveFactoryProductionOrderRemark;
import com.sky.ddt.dto.factoryProductionOrder.response.ListFactoryProductionOrderResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.IFactoryProductionOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author baixueping
 * @description 工厂生产单控制器
 * @date 2020/10/10 10:04
 */
@Controller
@RequestMapping("/factoryProductionOrder")
public class FactoryProductionOrderController extends SuperController {
    @Autowired
    IFactoryProductionOrderService factoryProductionOrderService;

    @RequestMapping("/index")
    @MenuAnnotation("factoryProductionOrder/index")
    public String index() {
        return "factoryProductionOrder/list";
    }

    @RequestMapping("/listFactoryProductionOrder")
    @MenuAnnotation("factoryProductionOrder/index")
    @ResponseBody
    public DataGridResponse listFactoryProductionOrder(ListFactoryProductionOrderRequest params) {
        params.setCurrentUserId(getCurrentUserId());
        PageInfo<ListFactoryProductionOrderResponse> page = factoryProductionOrderService.listFactoryProductionOrder(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("/saveFactoryProductionOrderRemark")
    @ResponseBody
    @MenuAnnotation("factoryProductionOrder/index")
    public BaseResponse saveFactoryProductionOrderRemark(SaveFactoryProductionOrderRemark params) {
        Integer dealUserId = getCurrentUserId();
        return factoryProductionOrderService.saveFactoryProductionOrderRemark(params, dealUserId);
    }
}
