package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.*;
import com.sky.ddt.common.constant.SkuConstant;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.sku.request.GetPrintTmallSkuRequest;
import com.sky.ddt.dto.sku.request.SkuListRequest;
import com.sky.ddt.dto.sku.request.SkuSaveRequest;
import com.sky.ddt.dto.sku.response.SkuExportInfoResponse;
import com.sky.ddt.dto.sku.response.SkuListResponse;
import com.sky.ddt.service.ISkuService;
import com.sky.ddt.util.ExcelExportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author baixueping
 * @description sku管理
 * @date 2019/5/10 9:09
 */
@Controller
@RequestMapping("/sku")
public class SkuController extends SuperController {

    @Autowired
    ISkuService skuService;

    @RequestMapping("/index")
    @MenuAnnotation("sku/index")
    public String index() {
        return "sku/list";
    }

    @RequestMapping("/printTmallLable")
    @MenuAnnotation("sku/index")
    public String printTmallLable() {
        return "sku/printTmallLable";
    }

    @RequestMapping("/printTmallLable2")
    @Login(action = Action.Skip)
    public String printTmallLable2() {
        return "sku/printTmallLable2";
    }

    @RequestMapping("/list")
    @ResponseBody
    @MenuAnnotation("sku/index")
    public DataGridResponse list(SkuListRequest params) {
        PageInfo<SkuListResponse> page = skuService.list(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    @RequestMapping("/importSku")
    @ResponseBody
    @RightAnnotation("sku/importSku")
    public BaseResponse importSku(MultipartFile file) {
        Integer dealUserId = getCurrentUserId();
        return skuService.importSku(file, dealUserId);
    }

    @RequestMapping("save")
    @ResponseBody
    @RightAnnotation("sku/saveSku")
    public BaseResponse save(@Validated SkuSaveRequest params) {
        Integer dealUserId = getCurrentUserId();
        return skuService.save(params, dealUserId);
    }

    @RequestMapping("exportSku")
    @ResponseBody
    @RightAnnotation("sku/exportSku")
    public BaseResponse exportSku(SkuListRequest params) {
        List<SkuExportInfoResponse> list = skuService.listSkuExportInfo(params);
        BaseResponse exportResponse = new ExcelExportUtil<SkuExportInfoResponse>().export(response, list, SkuConstant.EXPORT_SKU_HEAD, "sku信息");
        return exportResponse;
    }

    @RequestMapping("delete")
    @ResponseBody
    @RightAnnotation("sku/deleteSku")
    public BaseResponse delete(@RequestParam(required = false, value = "skuIds[]") List<Integer> skuIds) {
        return skuService.delete(skuIds);
    }

    @RequestMapping("/importInventory")
    @ResponseBody
    @RightAnnotation("sku/saveSku")
    public BaseResponse importInventory(MultipartFile file) {
        Integer dealUserId = getCurrentUserId();
        return skuService.importInventory(file, dealUserId);
    }

    @RequestMapping("/importCostPrice")
    @ResponseBody
    @RightAnnotation("sku/importCostPrice")
    public BaseResponse importCostPrice(MultipartFile file) {
        Integer dealUserId = getCurrentUserId();
        return skuService.importCostPrice(file, dealUserId);
    }

    @RequestMapping("/importWeight")
    @ResponseBody
    @RightAnnotation("sku/importWeight")
    public BaseResponse importWeight(MultipartFile file) {
        Integer dealUserId = getCurrentUserId();
        return skuService.importWeight(file, dealUserId);
    }

    @RequestMapping("/importTmallInfo")
    @ResponseBody
    @RightAnnotation("sku/importTmallInfo")
    public BaseResponse importTmallInfo(MultipartFile file) {
        Integer dealUserId = getCurrentUserId();
        return skuService.importTmallInfo(file, dealUserId);
    }

    @RequestMapping("/importColour")
    @ResponseBody
    @RightAnnotation("sku/importColour")
    public BaseResponse importColour(MultipartFile file) {
        Integer dealUserId = getCurrentUserId();
        return skuService.importColour(file, dealUserId);
    }

    @RequestMapping("/getPrintTmallSku")
    @ResponseBody
    public BaseResponse getPrintTmallSku(GetPrintTmallSkuRequest params) {
        return skuService.getPrintTmallSku(params);
    }

}
