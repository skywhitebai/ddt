package com.sky.ddt.controller.amazon;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.controller.SuperController;
import com.sky.ddt.dto.amazon.amazonFbaInventory.request.ListAmazonFbaInventoryRequest;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.entity.AmazonFbaInventory;
import com.sky.ddt.service.amazon.IAmazonFbaInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author baixueping
 * @description 亚马逊库存
 * @date 2021/6/28 14:53
 */
@Controller
public class AmazonFbaInventoryController extends SuperController {
    @Autowired
    IAmazonFbaInventoryService amazonFbaInventoryService;
    @RequestMapping("/index")
    public String index() {
        return "amazon/amazonFbaInventory/list";
    }

    @RequestMapping("/listAmazonFbaInventory")
    @ResponseBody
    public DataGridResponse listAmazonFbaInventory(@Validated ListAmazonFbaInventoryRequest params){
        PageInfo<AmazonFbaInventory> page = amazonFbaInventoryService.listAmazonFbaInventory(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
}
