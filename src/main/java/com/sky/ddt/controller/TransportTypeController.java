package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.transportType.request.ListTransportTypeRequest;
import com.sky.ddt.dto.transportType.request.SaveTransportTypeRequest;
import com.sky.ddt.dto.transportType.response.ListTransportTypeResponse;
import com.sky.ddt.entity.TransportType;
import com.sky.ddt.service.ITransportTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author baixueping
 * @description 运输方式控制器
 * @date 2020/7/2 9:42
 */
@Controller
@RequestMapping("/transportType")
public class TransportTypeController extends SuperController {
    @Autowired
    ITransportTypeService transportTypeService;

    @RequestMapping("/index")
    @MenuAnnotation("transportType/index")
    public String index() {
        return "transportType/list";
    }

    @RequestMapping("/listTransportType")
    @ResponseBody
    @MenuAnnotation("transportType/index")
    public DataGridResponse listTransportType(ListTransportTypeRequest params) {
        PageInfo<TransportType> page = transportTypeService.listTransportType(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    @RequestMapping("/saveTransportType")
    @ResponseBody
    @MenuAnnotation("transportType/index")
    public BaseResponse saveTransportType(SaveTransportTypeRequest params) {
        Integer dealUserId = getCurrentUserId();
        return transportTypeService.saveTransportType(params, dealUserId);
    }

    @RequestMapping("comboboxlist")
    @ResponseBody
    public List<TransportType> comboboxlist() {
        List<TransportType> list = transportTypeService.comboboxlist();
        return list;
    }
}
