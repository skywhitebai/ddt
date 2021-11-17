package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.costCalculation.request.ListCostCalculationRequest;
import com.sky.ddt.dto.costCalculation.request.SaveCostCalculationRemarkRequest;
import com.sky.ddt.dto.costCalculationSku.request.ListCostCalculationSkuRequest;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.CostCalculation;
import com.sky.ddt.service.ICostCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sky
 * @Description 成本核算
 * @date 2021/11/17 23:35
 */
@Controller
@RequestMapping("/costCalculation")
public class CostCalculationController extends SuperController {
    @Autowired
    ICostCalculationService costCalculationService;
    @RequestMapping("/index")
    @MenuAnnotation("costCalculation/index")
    public  String index(){
        return "costCalculation/list";
    }
    @RequestMapping("list")
    @ResponseBody
    @MenuAnnotation("costCalculation/index")
    public DataGridResponse list(ListCostCalculationRequest params) {
        PageInfo<CostCalculation> page=costCalculationService.listCostCalculation(params);
        return DataGridResponse.create(page);
    }

    @RequestMapping("/saveCostCalculationRemark")
    @ResponseBody
    @MenuAnnotation("costCalculation/index")
    public BaseResponse saveCostCalculationRemark(@Validated SaveCostCalculationRemarkRequest params) {
        return costCalculationService.saveCostCalculationRemark(params);
    }
}
