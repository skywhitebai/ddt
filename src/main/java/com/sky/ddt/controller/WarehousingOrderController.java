package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.common.constant.WarehousingOrderConstant;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.warehousingOrder.request.ListWarehousingOrderRequest;
import com.sky.ddt.dto.warehousingOrder.request.SaveWarehousingOrderRequest;
import com.sky.ddt.dto.warehousingOrder.response.ExportWarehousingOrderResponse;
import com.sky.ddt.dto.warehousingOrder.response.ListWarehousingOrderResponse;
import com.sky.ddt.service.IWarehousingOrderService;
import com.sky.ddt.util.ExcelExportByExcelFieldUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author baixueping
 * @description 入库单管理
 * @date 2020/4/10 9:09
 */
@Controller
@RequestMapping("/warehousingOrder")
public class WarehousingOrderController extends SuperController {
    @Autowired
    IWarehousingOrderService warehousingOrderService;

    @RequestMapping("/index")
    @MenuAnnotation("warehousingOrder/index")
    public String index() {
        return "warehousingOrder/list";
    }

    @RequestMapping("listWarehousingOrder")
    @ResponseBody
    @MenuAnnotation("warehousingOrder/index")
    public DataGridResponse listWarehousingOrder(ListWarehousingOrderRequest listWarehousingOrderRequest) {
        PageInfo<ListWarehousingOrderResponse> page = warehousingOrderService.listWarehousingOrder(listWarehousingOrderRequest);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    @RequestMapping("saveWarehousingOrder")
    @ResponseBody
    @MenuAnnotation("warehousingOrder/index")
    public BaseResponse saveWarehousingOrder(@Validated SaveWarehousingOrderRequest params) {
        Integer dealUserId = getCurrentUserId();
        return warehousingOrderService.saveWarehousingOrder(params, dealUserId);
    }

    @RequestMapping("cancelWarehousingOrder")
    @ResponseBody
    @MenuAnnotation("warehousingOrder/index")
    public BaseResponse cancelWarehousingOrder(Integer id) {
        Integer dealUserId = getCurrentUserId();
        return warehousingOrderService.cancelWarehousingOrder(id, dealUserId);
    }

    /**
     * @param
     * @return
     * @description 入库操作
     * @author baixueping
     * @date 2020/5/7 10:45
     */
    @RequestMapping("/warehousing")
    @ResponseBody
    @MenuAnnotation("warehousingOrder/index")
    public BaseResponse warehousing(Integer id) {
        Integer dealUserId = getCurrentUserId();
        return warehousingOrderService.warehousing(id, dealUserId);
    }
    ///
    @RequestMapping("/exportWarehousingOrder")
    @ResponseBody
    @MenuAnnotation("warehousingOrder/index")
    public BaseResponse exportWarehousingOrder(ListWarehousingOrderRequest params) {
        Integer dealUserId = getCurrentUserId();
        List<ExportWarehousingOrderResponse> list=warehousingOrderService.listExportWarehousingOrder(params);
        BaseResponse exportResponse = new ExcelExportByExcelFieldUtil().export(response, list, WarehousingOrderConstant.exportWarehousingOrderFieldList, "入库单");
        return exportResponse;
    }
}
