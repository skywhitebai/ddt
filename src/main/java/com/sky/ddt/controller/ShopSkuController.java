package com.sky.ddt.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.common.annotation.RightAnnotation;
import com.sky.ddt.common.constant.ShopSkuConstant;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopSku.request.*;
import com.sky.ddt.dto.shopSku.response.ExportShopSkuResponse;
import com.sky.ddt.dto.shopSku.response.ListInventoryQuantityResponse;
import com.sky.ddt.dto.shopSku.response.ListShopSkuResponse;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.util.ExcelExportByExcelFieldUtil;
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
 * @description 店铺sku
 * @date 2019/7/26 17:16
 */
@RequestMapping("/shopSku")
@Controller
public class ShopSkuController extends SuperController {
    @Autowired
    IShopSkuService shopSkuService;

    @RequestMapping("/index")
    @MenuAnnotation("shopSku/index")
    public String index() {
        return "shopSku/list";
    }

    @RequestMapping("/print")
    public String print() {
        return "shopSku/print";
    }

    @RequestMapping("/print7040")
    public String print7040() {
        return "shopSku/print7040";
    }

    @RequestMapping("/importShopSku")
    @ResponseBody
    @MenuAnnotation("shopSku/index")
    public BaseResponse importShopSku(MultipartFile file) {
        Integer dealUserId = getCurrentUserId();
        return shopSkuService.importShopSku(file, dealUserId);
    }

    @RequestMapping("/importShopParentSku")
    @ResponseBody
    @RightAnnotation("shopSku/importShopParentSku")
    public BaseResponse importShopParentSku(MultipartFile file) {
        Integer dealUserId = getCurrentUserId();
        return shopSkuService.importShopParentSku(file, dealUserId);
    }

    @RequestMapping("/importShopSkuStatus")
    @ResponseBody
    @RightAnnotation("shopSku/importShopSkuStatus")
    public BaseResponse importShopSkuStatus(MultipartFile file) {
        Integer dealUserId = getCurrentUserId();
        return shopSkuService.importShopSkuStatus(file, dealUserId);
    }

    @RequestMapping("/listShopSku")
    @ResponseBody
    @MenuAnnotation("shopSku/index")
    public DataGridResponse listShopSku(ListShopSkuRequest params) {
        params.setUserId(getCurrentUserId());
        PageInfo<ListShopSkuResponse> page = shopSkuService.listShopSku(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    @RequestMapping("/saveShopSku")
    @ResponseBody
    @RightAnnotation("shopSku/saveShopSku")
    public BaseResponse saveShopSku(@Validated SaveShopSkuRequest params) {
        params.setUserId(getCurrentUserId());
        return shopSkuService.saveShopSku(params);
    }

    @RequestMapping("/exportShopSku")
    @ResponseBody
    @RightAnnotation("shopSku/exportShopSku")
    public BaseResponse exportShopSku(ListShopSkuRequest params) {
        params.setUserId(getCurrentUserId());
        List<ExportShopSkuResponse> list = shopSkuService.listExportShopSku(params);
        BaseResponse exportResponse = new ExcelExportByExcelFieldUtil().export(response, list, ShopSkuConstant.exportShopSkuFieldList, "店铺sku信息");
        return exportResponse;
    }

    @RequestMapping("/deleteShopSku")
    @ResponseBody
    @RightAnnotation("shopSku/deleteShopSku")
    public BaseResponse deleteShopSku(@RequestParam(required = false, value = "shopSkuIds[]") List<Integer> shopSkuIds) {
        return shopSkuService.deleteShopSku(shopSkuIds);
    }
    @RequestMapping("/stopShopSku")
    @ResponseBody
    public BaseResponse stopShopSku(Integer shopSkuId) {
        return shopSkuService.stopShopSku(shopSkuId,getCurrentUserId());
    }

    /**
     * @param
     * @return
     * @description 店铺sku信息转换
     * @author baixueping
     * @date 2019/8/5 9:35
     */
    @RequestMapping("/transformShopSku")
    public String transformShopSku() {
        return "shopSku/transformShopSku";
    }

    /**
     * 用的这个方法
     *
     * @param file
     * @return
     */
    @RequestMapping("/transformShopSkuInfo")
    @ResponseBody
    public BaseResponse transformShopSkuInfo(MultipartFile file) {
        return shopSkuService.transformShopSkuInfo(file, request, response);
    }

    @RequestMapping("/getPrintShopSku")
    @ResponseBody
    public BaseResponse getPrintShopSku(GetPrintShopSkuRequest params) {
        return shopSkuService.getPrintShopSku(params);
    }

    @RequestMapping("/salesInfo")
    @MenuAnnotation("shopSku/index")
    public String salesInfo() {
        return "shopSku/salesInfo";
    }

    @RequestMapping("/salesCount")
    @ResponseBody
    @MenuAnnotation("shopSku/index")
    public JSONObject salesCount(SalesCountRequest params) {
        params.setUserId(getCurrentUserId());
        return shopSkuService.salesCount(params);
    }

    /**
     * @param
     * @return
     * @description 折线图显示某父sku子sku销售数量
     * @author baixueping
     * @date 2019/11/4 11:43
     */
    @RequestMapping("/salesCountChart")
    @ResponseBody
    @MenuAnnotation("shopSku/index")
    public BaseResponse salesCountChart(SalesCountRequest params) {
        params.setUserId(getCurrentUserId());
        return shopSkuService.salesCountChart(params);
    }

    /**
     * @param
     * @return
     * @description 折线图显示某父sku子sku销售数量
     * @author baixueping
     * @date 2019/11/4 11:43
     */
    @RequestMapping("/salesInfoChart")
    @MenuAnnotation("shopSku/index")
    public String salesCountChart() {
        return "shopSku/salesInfoChart";
    }


    @RequestMapping("/importSalesmanUser")
    @ResponseBody
    @RightAnnotation("shopSku/importSalesmanUser")
    public BaseResponse importSalesmanUser(MultipartFile file) {
        Integer dealUserId = getCurrentUserId();
        return shopSkuService.importSalesmanUser(file, dealUserId);
    }

    @RequestMapping("/listInventoryQuantity")
    @ResponseBody
    public DataGridResponse listInventoryQuantity(@Validated ListInventoryQuantityRequest params) {
        PageInfo<ListInventoryQuantityResponse> page=shopSkuService.listInventoryQuantity(params);
        DataGridResponse dataGridResponse=new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
}
