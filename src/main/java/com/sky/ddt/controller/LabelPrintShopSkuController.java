package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.labelPrint.request.LabelPrintShopSkuListRequest;
import com.sky.ddt.dto.labelPrint.response.LabelPrintShopSkuListResponse;
import com.sky.ddt.service.ILabelPrintShopSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author baixueping
 * @description 标签打印sku
 * @date 2020/2/28 15:30
 */
@Controller
@RequestMapping("/labelPrintShopSku")
public class LabelPrintShopSkuController extends SuperController {
    @Autowired
    ILabelPrintShopSkuService labelPrintShopSkuService;
    @RequestMapping("list")
    @ResponseBody
    @MenuAnnotation("labelPrint/index")
    public DataGridResponse list(LabelPrintShopSkuListRequest params) {
        PageInfo<LabelPrintShopSkuListResponse> page=labelPrintShopSkuService.list(params);
        DataGridResponse dataGridResponse=new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
}
