package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.CheckOrderShopSkuStorageLocation.request.ListCheckOrderShopSkuStorageLocationRequest;
import com.sky.ddt.dto.CheckOrderShopSkuStorageLocation.request.SaveCheckOrderShopSkuStorageLocationRequest;
import com.sky.ddt.dto.CheckOrderShopSkuStorageLocation.response.ListCheckOrderShopSkuStorageLocationResponse;
import com.sky.ddt.service.ICheckOrderShopSkuStorageLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sky
 * @Description 入库店铺sku库位信息
 * @date 2022/1/8 0:40
 */
@RequestMapping("/checkOrderShopSkuStorageLocation")
@Controller
public class CheckOrderShopSkuStorageLocationController extends SuperController{
    @Autowired
    ICheckOrderShopSkuStorageLocationService CheckOrderShopSkuStorageLocationService;
    //列表查询库位信息
    @RequestMapping("/listCheckOrderShopSkuStorageLocation")
    @ResponseBody
    public DataGridResponse listCheckOrderShopSkuStorageLocation(ListCheckOrderShopSkuStorageLocationRequest params) {
        PageInfo<ListCheckOrderShopSkuStorageLocationResponse> page = CheckOrderShopSkuStorageLocationService.listCheckOrderShopSkuStorageLocation(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    //添加库位信息
    @RequestMapping("/saveCheckOrderShopSkuStorageLocation")
    @ResponseBody
    public BaseResponse saveCheckOrderShopSkuStorageLocation(@Validated SaveCheckOrderShopSkuStorageLocationRequest params) {
        Integer dealUserId=getCurrentUserId();
        return CheckOrderShopSkuStorageLocationService.saveCheckOrderShopSkuStorageLocation(params,dealUserId);
    }
    //删除库位信息
    @RequestMapping("/deleteCheckOrderShopSkuStorageLocation")
    @ResponseBody
    public BaseResponse deleteCheckOrderShopSkuStorageLocation(Integer checkOrderShopSkuStorageLocationId) {
        return CheckOrderShopSkuStorageLocationService.deleteCheckOrderShopSkuStorageLocation(checkOrderShopSkuStorageLocationId);
    }
}
