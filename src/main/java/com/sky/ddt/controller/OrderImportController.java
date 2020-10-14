package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.common.constant.OrderImportConstant;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.orderImport.request.ListOrderImportRequest;
import com.sky.ddt.dto.orderImport.response.ListOrderImportResponse;
import com.sky.ddt.dto.orderImport.response.OrderShopSkuResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.IOrderImportService;
import com.sky.ddt.util.ExcelExportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author baixueping
 * @description 导入订单管理
 * @date 2019/8/14 9:42
 */
@Controller
@RequestMapping("/orderImport")
public class OrderImportController extends SuperController {
    @Autowired
    IOrderImportService orderImportService;
    /**
     * @param
     * @return
     * @description 订单导入页面
     * @author baixueping
     * @date 2019/8/14 9:50
    */
    @RequestMapping("/index")
    @MenuAnnotation("orderImport/index")
    public  String index(){
        return "orderImport/list";
    }

    @RequestMapping("/importOrder")
    @ResponseBody
    @MenuAnnotation("orderImport/index")
    public BaseResponse importOrder(MultipartFile file) {
        Integer dealUserId = getCurrentUserId();
        return orderImportService.importOrder(file, dealUserId);
    }
    @RequestMapping("/getShopSku")
    @ResponseBody
    @MenuAnnotation("orderImport/index")
    public BaseResponse getShopSku(MultipartFile file) {
        BaseResponse<List<OrderShopSkuResponse>> listBaseResponse = orderImportService.listGetShopSku(file);
        if(!listBaseResponse.isSuccess()){
            return listBaseResponse;
        }
        BaseResponse exportResponse = new ExcelExportUtil<OrderShopSkuResponse>().export(response, listBaseResponse.getData(), OrderImportConstant.GET_SHOP_SKU_HEAD, "订单sku信息");
        return exportResponse;
    }
    @RequestMapping("/listOrderImport")
    @ResponseBody
    @MenuAnnotation("shopSku/index")
    public DataGridResponse listOrderImport(ListOrderImportRequest params) {
        params.setUserId(getCurrentUserId());
        PageInfo<ListOrderImportResponse> page = orderImportService.listOrderImport(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
}
