package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.produceOrder.request.ListProduceOrderRequest;
import com.sky.ddt.dto.produceOrder.request.SaveProduceOrderRequest;
import com.sky.ddt.dto.produceOrder.response.ListProduceOrderResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.IProduceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author baixueping
 * @description 生产单
 * @date 2020/3/25 10:30
 */
@Controller
@RequestMapping("produceOrder")
public class ProduceOrderController extends SuperController {

    @Autowired
    IProduceOrderService produceOrderService;

    @RequestMapping("/index")
    @MenuAnnotation("produceOrder/index")
    public String index() {
        return "produceOrder/list";
    }

    @RequestMapping("listProduceOrder")
    @ResponseBody
    @MenuAnnotation("produceOrder/index")
    public DataGridResponse listProduceOrder(ListProduceOrderRequest listProduceOrderRequest) {
        PageInfo<ListProduceOrderResponse> page = produceOrderService.listProduceOrder(listProduceOrderRequest);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    @RequestMapping("saveProduceOrder")
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
}
