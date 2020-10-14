package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopHeadTripCost.request.CreateShopHeadTripCostRequest;
import com.sky.ddt.dto.shopHeadTripCost.request.ListShopHeadTripCostRequest;
import com.sky.ddt.dto.shopHeadTripCost.request.SaveShopHeadTripCostRemarkRequest;
import com.sky.ddt.dto.shopHeadTripCost.response.ListShopHeadTripCostResponse;
import com.sky.ddt.service.IShopHeadTripCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author baixueping
 * @description 店铺头程费
 * @date 2020/8/13 18:20
 */
@Controller
@RequestMapping("/shopHeadTripCost")
public class ShopHeadTripCostController extends SuperController {
    @Autowired
    IShopHeadTripCostService shopHeadTripCostService;
    @RequestMapping("/index")
    @MenuAnnotation("shopHeadTripCost/index")
    public  String index(){
        return "shopHeadTripCost/list";
    }
    @RequestMapping("/list")
    @ResponseBody
    @MenuAnnotation("shopHeadTripCost/index")
    public DataGridResponse list(ListShopHeadTripCostRequest params) {
        params.setUserId(getCurrentUserId());
        PageInfo<ListShopHeadTripCostResponse> page=shopHeadTripCostService.listShopHeadTripCost(params);
        return DataGridResponse.create(page);
    }

    @RequestMapping("/saveShopHeadTripCostRemark")
    @ResponseBody
    @MenuAnnotation("shopHeadTripCost/index")
    public BaseResponse saveShopHeadTripCostRemark(SaveShopHeadTripCostRemarkRequest params) {
        Integer dealUserId = getCurrentUserId();
        return shopHeadTripCostService.saveShopHeadTripCostRemark(params, dealUserId);
    }

    @RequestMapping("/createShopHeadTripCost")
    @ResponseBody
    @MenuAnnotation("shopHeadTripCost/index")
    public BaseResponse createShopHeadTripCost(CreateShopHeadTripCostRequest params) {
        Integer dealUserId = getCurrentUserId();
        return shopHeadTripCostService.createShopHeadTripCost(params, dealUserId);
    }
}
