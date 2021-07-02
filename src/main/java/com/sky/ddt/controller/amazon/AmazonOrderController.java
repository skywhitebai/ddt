package com.sky.ddt.controller.amazon;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.controller.SuperController;
import com.sky.ddt.dto.amazon.amazonOrder.request.ListAmazonOrderRequest;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.entity.AmazonOrder;
import com.sky.ddt.service.amazon.IAmazonOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author baixueping
 * @description 亚马逊订单控制器
 * @date 2021/6/30 16:12
 */
@Controller
@RequestMapping("/amazonOrder")
public class AmazonOrderController extends SuperController {
    @Autowired
    IAmazonOrderService amazonOrderService;
    @RequestMapping("/index")
    public String index() {
        return "amazon/amazonOrder/list";
    }
    @RequestMapping("listAmazonOrder")
    @ResponseBody
    public DataGridResponse listAmazonOrder(@Validated ListAmazonOrderRequest params){
        PageInfo<AmazonOrder> page = amazonOrderService.listAmazonOrder(params);
        DataGridResponse dataGridResponse = new DataGridResponse(page);
        return dataGridResponse;
    }
}
