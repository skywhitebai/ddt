package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.inventoryChangeRecord.request.ListInventoryChangeRecordRequest;
import com.sky.ddt.dto.inventoryChangeRecord.response.ListInventoryChangeRecordResponse;
import com.sky.ddt.service.IInventoryChangeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author baixueping
 * @description 库存变更记录
 * @date 2020/5/12 17:36
 */
@Controller
@RequestMapping("/inventoryChangeRecord")
public class InventoryChangeRecordController extends SuperController {
    @Autowired
    IInventoryChangeRecordService inventoryChangeRecordService;
    @RequestMapping("/index")
    @MenuAnnotation("inventoryChangeRecord/index")
    public String index() {
        return "inventoryChangeRecord/list";
    }

    @RequestMapping("/listInventoryChangeRecord")
    @ResponseBody
    @MenuAnnotation("inventoryChangeRecord/index")
    public DataGridResponse listInventoryChangeRecord(ListInventoryChangeRecordRequest params) {
        PageInfo<ListInventoryChangeRecordResponse> page = inventoryChangeRecordService.listInventoryChangeRecord(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
}
