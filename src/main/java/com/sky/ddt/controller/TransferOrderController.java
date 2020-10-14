package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.transferOrder.request.ListTransferOrderRequest;
import com.sky.ddt.dto.transferOrder.request.SaveTransferOrderRequest;
import com.sky.ddt.dto.transferOrder.response.ListTransferOrderResponse;
import com.sky.ddt.service.ITransferOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author baixueping
 * @description 调拨控制器
 * @date 2020/8/28 16:15
 */
@Controller
@RequestMapping("/transferOrder")
public class TransferOrderController extends SuperController {
    @Autowired
    ITransferOrderService transferOrderService;

    @RequestMapping("/index")
    @MenuAnnotation("transferOrder/index")
    public String index() {
        return "transferOrder/list";
    }

    @RequestMapping("/listTransferOrder")
    @ResponseBody
    @MenuAnnotation("transferOrder/index")
    public DataGridResponse listTransferOrder(ListTransferOrderRequest params) {
        PageInfo<ListTransferOrderResponse> page = transferOrderService.listTransferOrder(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("/saveTransferOrder")
    @ResponseBody
    @MenuAnnotation("transferOrder/index")
    public BaseResponse saveTransferOrder(@Validated SaveTransferOrderRequest params){
        Integer dealUserId=getCurrentUserId();
        return transferOrderService.saveTransferOrder(params,dealUserId);
    }
    @RequestMapping("/cancelTransferOrder")
    @ResponseBody
    @MenuAnnotation("transferOrder/index")
    public BaseResponse cancelTransferOrder(Integer id) {
        Integer dealUserId = getCurrentUserId();
        return transferOrderService.cancelTransferOrder(id, dealUserId);
    }
    @RequestMapping("/transfer")
    @ResponseBody
    @MenuAnnotation("transferOrder/index")
    public BaseResponse transfer(Integer id) {
        Integer dealUserId = getCurrentUserId();
        return transferOrderService.transfer(id, dealUserId);
    }
}
