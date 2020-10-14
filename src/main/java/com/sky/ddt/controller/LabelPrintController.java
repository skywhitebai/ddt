package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.common.constant.LabelPrintConstant;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.labelPrint.request.LabelPrintListRequest;
import com.sky.ddt.dto.labelPrint.request.SaveLabelPrintRemarkRequest;
import com.sky.ddt.dto.labelPrint.response.LabelPrintShopSkuListResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.LabelPrint;
import com.sky.ddt.service.ILabelPrintService;
import com.sky.ddt.service.ILabelPrintShopSkuService;
import com.sky.ddt.util.ExcelExportByExcelFieldUtil;
import com.sky.ddt.util.ExcelExportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author baixueping
 * @description 标签打印
 * @date 2020/2/27 9:33
 */
@Controller
@RequestMapping("/labelPrint")
public class LabelPrintController extends SuperController {
    @Autowired
    ILabelPrintService labelPrintService;
    @Autowired
    ILabelPrintShopSkuService labelPrintShopSkuService;
    @RequestMapping("/index")
    public String index() {
        return "labelPrint/list";
    }
    @RequestMapping("list")
    @ResponseBody
    @MenuAnnotation("labelPrint/index")
    public DataGridResponse list(LabelPrintListRequest params) {
        PageInfo<LabelPrint> page=labelPrintService.list(params);
        DataGridResponse dataGridResponse=new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("/importLabelPrint")
    @ResponseBody
    @MenuAnnotation("labelPrint/index")
    public BaseResponse importLabelPrint(MultipartFile file) {
        Integer dealUserId = getCurrentUserId();
        return labelPrintService.importLabelPrint(file, dealUserId);
    }

    @RequestMapping("/saveLabelPrintRemark")
    @ResponseBody
    @MenuAnnotation("labelPrint/index")
    public BaseResponse saveLabelPrintRemark(SaveLabelPrintRemarkRequest params) {
        Integer dealUserId = getCurrentUserId();
        return labelPrintService.saveLabelPrintRemark(params, dealUserId);
    }

    @RequestMapping("/exportLablePrint")
    @ResponseBody
    @MenuAnnotation("labelPrint/index")
    public BaseResponse exportLablePrint(Integer labelPrintId) {
        List<LabelPrintShopSkuListResponse> list=labelPrintShopSkuService.listLabelPrintShopSku(labelPrintId);
        BaseResponse exportResponse = new ExcelExportByExcelFieldUtil().export(response, list, LabelPrintConstant.exprotLabelPrintFieldList, "店铺sku信息");
        return exportResponse;
    }
}
