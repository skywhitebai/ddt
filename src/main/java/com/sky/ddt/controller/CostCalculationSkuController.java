package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.common.constant.CostCalculationConstant;
import com.sky.ddt.common.constant.ShopHeadTripCostConstant;
import com.sky.ddt.dto.costCalculation.request.ListCostCalculationRequest;
import com.sky.ddt.dto.costCalculationSku.request.ListCostCalculationSkuRequest;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopSkuHeadTripCostHis.request.ExportShopSkuHeadTripCostHisRequest;
import com.sky.ddt.dto.shopSkuHeadTripCostHis.response.ExportShopSkuHeadTripCostHisResponse;
import com.sky.ddt.entity.CostCalculation;
import com.sky.ddt.entity.CostCalculationSku;
import com.sky.ddt.service.ICostCalculationSkuService;
import com.sky.ddt.util.ExcelExportByExcelFieldUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author sky
 * @Description 成本核算
 * @date 2021/11/17 23:35
 */
@Controller
@RequestMapping("/costCalculationSku")
public class CostCalculationSkuController extends SuperController {
    @Autowired
    ICostCalculationSkuService costCalculationSkuService;
    @RequestMapping("/listCostCalculationSku")
    @ResponseBody
    @MenuAnnotation("costCalculation/index")
    public DataGridResponse listCostCalculationSku(ListCostCalculationSkuRequest params) {
        PageInfo<CostCalculationSku> page=costCalculationSkuService.listCostCalculationSku(params);
        return DataGridResponse.create(page);
    }
    @RequestMapping("/exportCostCalculationSku")
    @ResponseBody
    @MenuAnnotation("costCalculation/index")
    public BaseResponse exportCostCalculationSku(ListCostCalculationSkuRequest params) {
        List<CostCalculationSku> list = costCalculationSkuService.listExportCostCalculationSku(params);
        BaseResponse exportResponse = new ExcelExportByExcelFieldUtil().export(response, list, CostCalculationConstant.exportCostCalculationSkuFieldList, "sku成本核算");
        return exportResponse;
    }

}
