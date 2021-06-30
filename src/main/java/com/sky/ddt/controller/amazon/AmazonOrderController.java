package com.sky.ddt.controller.amazon;

import com.sky.ddt.controller.SuperController;
import com.sky.ddt.service.amazon.IAmazonOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author baixueping
 * @description 亚马逊订单控制器
 * @date 2021/6/30 16:12
 */
@Controller
public class AmazonOrderController extends SuperController {
    @Autowired
    IAmazonOrderService amazonOrderService;
}
