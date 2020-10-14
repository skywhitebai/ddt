package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.checkOrder.request.SaveCheckOrderRequest;
import com.sky.ddt.dto.checkOrder.response.ListCheckOrderResponse;
import com.sky.ddt.dto.checkOrder.request.ListCheckOrderRequest;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.ICheckOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author baixueping
 * @description 盘点单控制器
 * @date 2020/5/9 10:49
 */
@Controller
@RequestMapping("/checkOrder")
public class CheckOrderController extends SuperController {
    @Autowired
    ICheckOrderService checkOrderService;

    /**
     * @param
     * @return
     * @description 盘点单主页面
     * @author baixueping
     * @date 2020/5/9 17:25
     */
    @RequestMapping("/index")
    @MenuAnnotation("checkOrder/index")
    public String index() {
        return "checkOrder/list";
    }

    @RequestMapping("listCheckOrder")
    @ResponseBody
    @MenuAnnotation("checkOrder/index")
    public DataGridResponse listCheckOrder(ListCheckOrderRequest params) {
        PageInfo<ListCheckOrderResponse> page = checkOrderService.listCheckOrder(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("saveCheckOrder")
    @ResponseBody
    @MenuAnnotation("checkOrder/index")
    public BaseResponse saveCheckOrder(@Validated SaveCheckOrderRequest params) {
        Integer dealUserId = getCurrentUserId();
        return checkOrderService.saveCheckOrder(params, dealUserId);
    }
    @RequestMapping("cancelCheckOrder")
    @ResponseBody
    @MenuAnnotation("checkOrder/index")
    public BaseResponse cancelCheckOrder(Integer id) {
        Integer dealUserId = getCurrentUserId();
        return checkOrderService.cancelCheckOrder(id, dealUserId);
    }

    /**
     * @param
     * @return
     * @description 盘点单确认
     * @author baixueping
     * @date 2020/5/7 10:45
     */
    @RequestMapping("confirmCheckOrder")
    @ResponseBody
    @MenuAnnotation("warehousingOrder/index")
    public BaseResponse confirmCheckOrder(Integer id) {
        Integer dealUserId = getCurrentUserId();
        return checkOrderService.confirmCheckOrder(id, dealUserId);
    }
}
