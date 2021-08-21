package com.sky.ddt.controller;

import com.sky.ddt.service.IProductInventoryQuantityHisService;
import com.sky.ddt.service.ISkuInventoryQuantityHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sky
 * @Description 库存历史记录
 * @date 2021/8/21 10:10
 */
@Controller
@RequestMapping("/inventoryQuantityHis")
public class InventoryQuantityHisController extends SuperController {
    @Autowired
    ISkuInventoryQuantityHisService skuInventoryQuantityHisService;
    @Autowired
    IProductInventoryQuantityHisService productInventoryQuantityHisService;
    @RequestMapping("/index")
    public String index() {
        return "list";
    }
}
