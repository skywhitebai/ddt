package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.orderitem.request.OrderItemListByAmazonOrderIdRequest;
import com.sky.ddt.entity.OrderItem;
import com.sky.ddt.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 订单产品管理
 *
 * @author sky
 * @date 2019/4/12
 */
@Controller
@RequestMapping("orderItem")
public class OrderItemController {
@Autowired
    IOrderItemService orderItemService;
    @RequestMapping("listByAmazonOrderId")
    @ResponseBody
    public DataGridResponse listByAmazonOrderId(@Validated OrderItemListByAmazonOrderIdRequest orderItemListByAmazonOrderIdRequest) {
        PageInfo<OrderItem> page=orderItemService.listByAmazonOrderId(orderItemListByAmazonOrderIdRequest);
        DataGridResponse dataGridResponse=new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
}
