package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.produceOrder.request.*;
import com.sky.ddt.dto.produceOrder.response.ListProduceOrderResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.IProduceOrderService;
import com.sky.ddt.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @author baixueping
 * @description 生产单
 * @date 2020/3/25 10:30
 */
@Controller
@RequestMapping("/produceOrder")
public class ProduceOrderController extends SuperController {

    @Autowired
    IProduceOrderService produceOrderService;

    @RequestMapping("/index")
    @MenuAnnotation("produceOrder/index")
    public String index() {
        return "produceOrder/list";
    }

    @RequestMapping("/listProduceOrder")
    @ResponseBody
    @MenuAnnotation("produceOrder/index")
    public DataGridResponse listProduceOrder(ListProduceOrderRequest listProduceOrderRequest) {
        if(!StringUtils.isEmpty(listProduceOrderRequest.getMonth())){
            String monthStr = listProduceOrderRequest.getMonth() + "-01";
            Date monthDate = DateUtil.strToDate(monthStr);
            if (monthDate!= null) {
                listProduceOrderRequest.setMonthDate(monthDate);
            }
        }
        PageInfo<ListProduceOrderResponse> page = produceOrderService.listProduceOrder(listProduceOrderRequest);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    @RequestMapping("/saveProduceOrder")
    @ResponseBody
    @MenuAnnotation("produceOrder/index")
    public BaseResponse saveProduceOrder(@Validated SaveProduceOrderRequest params) {
        Integer dealUserId = getCurrentUserId();
        return produceOrderService.saveProduceOrder(params, dealUserId);
    }

    @RequestMapping("cancelProduceOrder")
    @ResponseBody
    @MenuAnnotation("produceOrder/index")
    public BaseResponse cancelProduceOrder(Integer id) {
        Integer dealUserId = getCurrentUserId();
        return produceOrderService.cancelProduceOrder(id, dealUserId);
    }
    @RequestMapping("finishedProduction")
    @ResponseBody
    @MenuAnnotation("produceOrder/index")
    public BaseResponse finishedProduction(Integer id) {
        Integer dealUserId = getCurrentUserId();
        return produceOrderService.finishedProduction(id, dealUserId);
    }

    @RequestMapping("/importProduceOrder")
    @ResponseBody
    @MenuAnnotation("produceOrder/index")
    public BaseResponse importProduceOrder(MultipartFile file) {
        Integer dealUserId = getCurrentUserId();
        return produceOrderService.importProduceOrder(file, dealUserId);
    }
    @RequestMapping("/printProductLabel")
    @MenuAnnotation("sku/index")
    public String printProduceLable() {
        return "produceOrder/printProductLabel";
    }

    @RequestMapping("saveProduceOrderCostRemark")
    @ResponseBody
    @MenuAnnotation("produceOrder/index")
    public BaseResponse saveProduceOrderCostRemark(@Validated SaveProduceOrderCostRemarkRequest params) {
        return produceOrderService.saveProduceOrderCostRemark(params);
    }
    @RequestMapping("/saveFabricCost")
    @ResponseBody
    @MenuAnnotation("produceOrder/index")
    public BaseResponse saveFabricCost(@Validated SaveProduceOrderFabricCostRequest params) {
        return produceOrderService.saveFabricCost(params);
    }
    @RequestMapping("/saveAuxiliaryMaterialCost")
    @ResponseBody
    @MenuAnnotation("produceOrder/index")
    public BaseResponse saveAuxiliaryMaterialCost(@Validated SaveProduceOrderAuxiliaryMaterialCostRequest params) {
        return produceOrderService.saveAuxiliaryMaterialCost(params);
    }

    @RequestMapping("/generationCost")
    @ResponseBody
    @MenuAnnotation("produceOrder/index")
    public BaseResponse generationCost(@Validated GenerationCostRequest params) {
        return produceOrderService.generationCost(params,getCurrentUserId());
    }
}
