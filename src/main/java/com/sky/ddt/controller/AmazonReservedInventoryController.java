package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.controller.SuperController;
import com.sky.ddt.dto.amazonReservedInventory.req.ListAmazonReservedInventoryReq;
import com.sky.ddt.dto.amazonReservedInventory.resp.ListAmazonReservedInventoryResp;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.fbaImport.request.ListFbaImportRequest;
import com.sky.ddt.dto.fbaImport.response.ListFbaImportResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.amazon.IAmazonReservedInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author sky
 * @Description TODO
 * @date 2022/11/7 13:44
 */
@Controller
@RequestMapping("/amazonReservedInventory")
public class AmazonReservedInventoryController extends SuperController {
    @Autowired
    IAmazonReservedInventoryService amazonReservedInventoryService;

    @RequestMapping("/index")
    @MenuAnnotation("amazonReservedInventory/index")
    public String index() {
        return "amazonReservedInventory/list";
    }

    @RequestMapping("/importAmazonReservedInventory")
    @ResponseBody
    @MenuAnnotation("amazonReservedInventory/index")
    public BaseResponse importAmazonReservedInventory(MultipartFile file) {
        Integer dealUserId = getCurrentUserId();
        return amazonReservedInventoryService.importAmazonReservedInventory(file, dealUserId);
    }
    @RequestMapping("/listAmazonReservedInventory")
    @ResponseBody
    @MenuAnnotation("amazonReservedInventory/index")
    public DataGridResponse listAmazonReservedInventory(ListAmazonReservedInventoryReq params) {
        PageInfo<ListAmazonReservedInventoryResp> page = amazonReservedInventoryService.listAmazonReservedInventory(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
}
