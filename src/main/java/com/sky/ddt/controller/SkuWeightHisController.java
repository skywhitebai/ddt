package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.skuWeightHis.request.ListSkuWeightHisRequest;
import com.sky.ddt.dto.skuWeightHis.response.ListSkuWeightHisResponse;
import com.sky.ddt.service.ISkuWeightHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author baixueping
 * @description sky成本
 * @date 2019/12/31 9:09
 */
@Controller
@RequestMapping("/skuWeightHis")
public class SkuWeightHisController extends SuperController {
    @Autowired
    ISkuWeightHisService skuWeightHisService;
    @RequestMapping("/list")
    @ResponseBody
    @MenuAnnotation("sku/index")
    public DataGridResponse list(ListSkuWeightHisRequest params) {
        PageInfo<ListSkuWeightHisResponse> page=skuWeightHisService.list(params);
        return DataGridResponse.create(page);
    }
}
