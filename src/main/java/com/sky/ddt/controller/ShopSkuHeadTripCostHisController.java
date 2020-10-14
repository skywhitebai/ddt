package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.common.constant.ShopHeadTripCostConstant;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopSkuHeadTripCostHis.request.ListShopSkuHeadTripCostHisRequest;
import com.sky.ddt.dto.shopSkuHeadTripCostHis.response.ListShopSkuHeadTripCostHisResponse;
import com.sky.ddt.service.IShopSkuHeadTripCostHisService;
import com.sky.ddt.util.ExcelExportByExcelFieldUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author baixueping
 * @description shopSku头程费
 * @date 2020/8/13 18:35
 */
@Controller
@RequestMapping("/shopSkuHeadTripCostHis")
public class ShopSkuHeadTripCostHisController extends SuperController {
    @Autowired
    IShopSkuHeadTripCostHisService shopSkuHeadTripCostHisService;
    @RequestMapping("/listShopSkuHeadTripCostHis")
    @ResponseBody
    @MenuAnnotation("shopHeadTripCost/index")
    public DataGridResponse listShopSkuHeadTripCostHis(ListShopSkuHeadTripCostHisRequest params) {
        PageInfo<ListShopSkuHeadTripCostHisResponse> page=shopSkuHeadTripCostHisService.listShopSkuHeadTripCostHis(params);
        return DataGridResponse.create(page);
    }

    @RequestMapping("/exportShopSkuHeadTripCostHis")
    @ResponseBody
    @MenuAnnotation("shopHeadTripCost/index")
    public BaseResponse exportShopSkuHeadTripCostHis(ListShopSkuHeadTripCostHisRequest params) {
        List<ListShopSkuHeadTripCostHisResponse> list = shopSkuHeadTripCostHisService.listExportShopSkuHeadTripCostHis(params);
        BaseResponse exportResponse = new ExcelExportByExcelFieldUtil().export(response, list, ShopHeadTripCostConstant.exportShopSkuHeadTripCostHisFieldList, "店铺sku头程费");
        return exportResponse;
    }
}
