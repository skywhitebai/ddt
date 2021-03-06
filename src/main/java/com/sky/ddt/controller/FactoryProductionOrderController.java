package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.factoryProductionOrder.request.*;
import com.sky.ddt.dto.factoryProductionOrder.response.ListFactoryProductionOrderInfoResponse;
import com.sky.ddt.dto.factoryProductionOrder.response.ListFactoryProductionOrderShopParentSkuResponse;
import com.sky.ddt.dto.factoryProductionOrder.response.ListFactoryProductionOrderResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.IFactoryProductionOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
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

    @RequestMapping("/listFactoryProductionOrderShopParentSku")
    @MenuAnnotation("factoryProductionOrder/index")
    @ResponseBody
    public DataGridResponse listFactoryProductionOrderShopParentSku(@Validated ListFactoryProductionOrderShopParentSkuRequest params) {
        PageInfo<ListFactoryProductionOrderShopParentSkuResponse> page = factoryProductionOrderService.listFactoryProductionOrderShopParentSku(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    @RequestMapping("/listFactoryProductionOrderInfo")
    @MenuAnnotation("factoryProductionOrder/index")
    @ResponseBody
    public DataGridResponse listFactoryProductionOrderInfo(@Validated ListFactoryProductionOrderInfoRequest params) {
        PageInfo<ListFactoryProductionOrderInfoResponse> page = factoryProductionOrderService.listFactoryProductionOrderInfo(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    @RequestMapping("/saveProductionQuantity")
    @ResponseBody
    @MenuAnnotation("factoryProductionOrder/index")
    public BaseResponse saveProductionQuantity(SaveProductionQuantityRequest params) {
        Integer dealUserId = getCurrentUserId();
        return factoryProductionOrderService.saveProductionQuantity(params, dealUserId);
    }

    @RequestMapping("/createFactoryProductionOrder")
    @ResponseBody
    @MenuAnnotation("factoryProductionOrder/index")
    public BaseResponse createFactoryProductionOrder(Integer shopId) {
        Integer dealUserId = getCurrentUserId();
        return factoryProductionOrderService.createFactoryProductionOrder(shopId, dealUserId);
    }

    @RequestMapping("/downFactoryProductionOrderByShopParentSku")
    @ResponseBody
    @MenuAnnotation("factoryProductionOrder/index")
    public BaseResponse downFactoryProductionOrderByShopParentSku(String shopParentSku, Integer factoryProductionOrderId) {
        return factoryProductionOrderService.downFactoryProductionOrderByShopParentSku(shopParentSku, factoryProductionOrderId, response);
    }
    @RequestMapping("/downFactoryProductionOrder")
    @ResponseBody
    @MenuAnnotation("factoryProductionOrder/index")
    public BaseResponse downFactoryProductionOrder( Integer factoryProductionOrderId) {
        return factoryProductionOrderService.downFactoryProductionOrder(factoryProductionOrderId, response);
    }
    @RequestMapping("/confirmFactoryProductionOrder")
    @ResponseBody
    @MenuAnnotation("factoryProductionOrder/index")
    public BaseResponse confirmFactoryProductionOrder(Integer id) {
        Integer dealUserId = getCurrentUserId();
        return factoryProductionOrderService.confirmFactoryProductionOrder(id, dealUserId);
    }

    @RequestMapping("/cancelFactoryProductionOrder")
    @ResponseBody
    @MenuAnnotation("factoryProductionOrder/index")
    public BaseResponse cancelFactoryProductionOrder(Integer id) {
        Integer dealUserId = getCurrentUserId();
        return factoryProductionOrderService.cancelFactoryProductionOrder(id, dealUserId);
    }
}
