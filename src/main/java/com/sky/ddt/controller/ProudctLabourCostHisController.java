package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.productLabourCostHis.request.ListProductLabourCostHisRequest;
import com.sky.ddt.dto.productLabourCostHis.response.ListProductLabourCostHisResponse;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.service.IProductLabourCostHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sky
 * @Description 产品工价历史
 * @date 2021/10/21 19:23
 */
@Controller
@RequestMapping("/productLabourCostHis")
public class ProudctLabourCostHisController extends SuperController {
    @Autowired
    IProductLabourCostHisService productLabourCostHisService;
    @RequestMapping("/listProductLabourCostHis")
    @ResponseBody
    @MenuAnnotation("product/index")
    public DataGridResponse list(ListProductLabourCostHisRequest params) {
        PageInfo<ListProductLabourCostHisResponse> page=productLabourCostHisService.listProductLabourCostHis(params);
        return DataGridResponse.create(page);
    }
}
