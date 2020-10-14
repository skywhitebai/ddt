package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.common.constant.OutboundOrderConstant;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.outboundOrder.request.SaveOutboundOrderRequest;
import com.sky.ddt.dto.outboundOrder.response.ListOutboundOrderResponse;
import com.sky.ddt.dto.outboundOrder.request.ListOutboundOrderRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.IOutboundOrderService;
import com.sky.ddt.util.ExcelExportByExcelFieldUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * @author baixueping
 * @description 出库单控制器
 * @date 2020/5/12 9:48
 */
@Controller
@RequestMapping("/outboundOrder")
public class OutboundOrderController extends SuperController {
    @Autowired
    IOutboundOrderService outboundOrderService;
    /**
     * @param
     * @return
     * @description 出库单主页面
     * @author baixueping
     * @date 2020/5/9 17:25
     */
    @RequestMapping("/index")
    @MenuAnnotation("outboundOrder/index")
    public String index() {
        return "outboundOrder/list";
    }

    @RequestMapping("/listOutboundOrder")
    @ResponseBody
    @MenuAnnotation("outboundOrder/index")
    public DataGridResponse listOutboundOrder(ListOutboundOrderRequest params) {
        PageInfo<ListOutboundOrderResponse> page = outboundOrderService.listOutboundOrder(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("/saveOutboundOrder")
    @ResponseBody
    @MenuAnnotation("outboundOrder/index")
    public BaseResponse saveOutboundOrder(@Validated SaveOutboundOrderRequest params) {
        Integer dealUserId = getCurrentUserId();
        return outboundOrderService.saveOutboundOrder(params, dealUserId);
    }
    @RequestMapping("/cancelOutboundOrder")
    @ResponseBody
    @MenuAnnotation("outboundOrder/index")
    public BaseResponse cancelOutboundOrder(Integer id) {
        Integer dealUserId = getCurrentUserId();
        return outboundOrderService.cancelOutboundOrder(id, dealUserId);
    }
    /**
     * @param
     * @return
     * @description 出库
     * @author baixueping
     * @date 2020/5/7 10:45
     */
    @RequestMapping("/outbound")
    @ResponseBody
    @MenuAnnotation("outboundOrder/index")
    public BaseResponse outbound(Integer id) {
        Integer dealUserId = getCurrentUserId();
        return outboundOrderService.outbound(id, dealUserId);
    }
}
