package com.sky.ddt.controller.amazon;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.controller.SuperController;
import com.sky.ddt.dto.amazon.amazonOrder.request.ListAmazonOrderRequest;
import com.sky.ddt.dto.amazon.amazonOrderItem.request.ListAmazonOrderItemRequest;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.entity.AmazonOrder;
import com.sky.ddt.entity.AmazonOrderItem;
import com.sky.ddt.service.amazon.IAmazonOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author baixueping
 * @description 亚马逊订单商品
 * @date 2021/7/2 12:35
 */
@Controller
@RequestMapping("/amazonOrderItem")
public class AmazonOrderItemController extends SuperController {
    @Autowired
    IAmazonOrderItemService amazonOrderItemService;
    @RequestMapping("/index")
    public String index() {
        return "amazon/amazonOrderItem/list";
    }
    @RequestMapping("listAmazonOrderItem")
    @ResponseBody
    public DataGridResponse listAmazonOrderItem(@Validated ListAmazonOrderItemRequest params){
        PageInfo<AmazonOrderItem> page = amazonOrderItemService.listAmazonOrderItem(params);
        DataGridResponse dataGridResponse = new DataGridResponse(page);
        return dataGridResponse;
    }
}
