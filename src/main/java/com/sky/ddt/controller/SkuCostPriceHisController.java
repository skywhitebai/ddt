package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.sku.request.SkuListRequest;
import com.sky.ddt.dto.sku.response.SkuListResponse;
import com.sky.ddt.dto.skuCostPriceHis.request.ListSkuCostPriceHisRequest;
import com.sky.ddt.dto.skuCostPriceHis.response.ListSkuCostPriceHisResponse;
import com.sky.ddt.service.ISkuCostPriceHisService;
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
@RequestMapping("/skuCostPriceHis")
public class SkuCostPriceHisController extends SuperController {
    @Autowired
    ISkuCostPriceHisService skuCostPriceHisService;
    @RequestMapping("/list")
    @ResponseBody
    @MenuAnnotation("sku/index")
    public DataGridResponse list(ListSkuCostPriceHisRequest params) {
        PageInfo<ListSkuCostPriceHisResponse> page=skuCostPriceHisService.list(params);
        return DataGridResponse.create(page);
    }
}
