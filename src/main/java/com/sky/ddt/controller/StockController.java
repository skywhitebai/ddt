package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.Action;
import com.sky.ddt.common.annotation.LogRequest;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.common.annotation.RightAnnotation;
import com.sky.ddt.common.constant.StockConsatnt;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.stock.request.ListSendQuntityReq;
import com.sky.ddt.dto.stock.request.ListStockRequest;
import com.sky.ddt.dto.stock.request.SaveProductionQuantityRequest;
import com.sky.ddt.dto.stock.request.SaveStockQuantityRequest;
import com.sky.ddt.dto.stock.response.ListSendQuantityResp;
import com.sky.ddt.dto.stock.response.ListStockResponse;
import com.sky.ddt.service.IStockCartService;
import com.sky.ddt.util.ExcelExportByExcelFieldUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author baixueping
 * @description 备货管理
 * @date 2019/8/21 8:46
 */
@RequestMapping("/stock")
@Controller
public class StockController extends SuperController {
    @Autowired
    IStockCartService stockCartService;

    @RequestMapping("/index")
    @MenuAnnotation("stock/index")
    public String index() {
        return "stock/list";
    }
    @RequestMapping("/warehouseIndex")
    @MenuAnnotation("stock/warehouseIndex")
    public String warehouseIndex() {
        return "stock/warehouseList";
    }

    @RequestMapping("/listStock")
    @ResponseBody
    @MenuAnnotation("stock/index")
    public DataGridResponse listStock(@Validated ListStockRequest params) {
        params.setUserId(getCurrentUserId());
        PageInfo<ListStockResponse> page = stockCartService.listStock(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("/listWarehouseStock")
    @ResponseBody
    @MenuAnnotation("stock/warehouseIndex")
    public DataGridResponse listWarehouseStock(@Validated ListStockRequest params) {
        params.setUserId(getCurrentUserId());
        PageInfo<ListStockResponse> page = stockCartService.listWarehouseStock(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    /**
     * @param
     * @return
     * @description 保存补货数量
     * @author baixueping
     * @date 2019/8/22 14:57
     */
    @RequestMapping("/saveStockQuantity")
    @ResponseBody
    public BaseResponse saveStockQuantity(@Validated SaveStockQuantityRequest params) {
        return stockCartService.saveStockQuantity(params,getCurrentUserId());
    }

    /**
     * @param
     * @return
     * @description 保存补货数量
     * @author baixueping
     * @date 2019/8/22 14:57
     */
    @RequestMapping("/saveProductionQuantity")
    @ResponseBody
    @MenuAnnotation("stock/index")
    public BaseResponse saveProductionQuantity(@Validated SaveProductionQuantityRequest params) {
        return stockCartService.saveProductionQuantity(params,getCurrentUserId());
    }
    @RequestMapping("/listSendQuantity")
    @ResponseBody
    @MenuAnnotation("stock/index")
    public DataGridResponse listSendQuantity(@Validated ListSendQuntityReq params) {
        PageInfo<ListSendQuantityResp> page = stockCartService.listSendQuantity(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("/exportStock")
    @ResponseBody
    @MenuAnnotation("stock/index")
    public BaseResponse exportStock(ListStockRequest params) {
        params.setUserId(getCurrentUserId());
        List<ListStockResponse> list = stockCartService.listExportStock(params);
        BaseResponse exportResponse = new ExcelExportByExcelFieldUtil().export(response, list, StockConsatnt.exportStockFieldList, "补货信息");
        return exportResponse;
    }
    @RequestMapping("/exportWarehouseStock")
    @ResponseBody
    @MenuAnnotation("stock/warehouseIndex")
    public BaseResponse exportWarehouseStock(ListStockRequest params) {
        params.setUserId(getCurrentUserId());
        List<ListStockResponse> list = stockCartService.listExportWarehouseStock(params);
        BaseResponse exportResponse = new ExcelExportByExcelFieldUtil().export(response, list, StockConsatnt.exportStockWarehouseFieldList, "产品sku补货信息");
        return exportResponse;
    }
}
