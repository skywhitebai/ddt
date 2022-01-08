package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopSku.request.ListShopSkuRequest;
import com.sky.ddt.dto.shopSku.response.ListShopSkuResponse;
import com.sky.ddt.dto.shopSkuStorageLocation.request.ListShopSkuStorageLocationRequest;
import com.sky.ddt.dto.shopSkuStorageLocation.request.SaveShopSkuStorageLocationRequest;
import com.sky.ddt.dto.shopSkuStorageLocation.response.ListShopSkuStorageLocationResponse;
import com.sky.ddt.service.IShopSkuStorageLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sky
 * @Description 店铺sku库位管理
 * @date 2022/1/8 0:34
 */
@RequestMapping("/shopSkuStorageLocation")
@Controller
public class ShopSkuStorageLocationController extends SuperController{
    @Autowired
    IShopSkuStorageLocationService shopSkuStorageLocationService;
    //列表查询库位信息
    @RequestMapping("/listShopSkuStorageLocation")
    @ResponseBody
    @MenuAnnotation("shopSku/index")
    public DataGridResponse listShopSkuStorageLocation(ListShopSkuStorageLocationRequest params) {
        PageInfo<ListShopSkuStorageLocationResponse> page = shopSkuStorageLocationService.listShopSkuStorageLocation(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    //添加库位信息
    @RequestMapping("/saveShopSkuStorageLocation")
    @ResponseBody
    @MenuAnnotation("shopSku/index")
    public BaseResponse saveShopSkuStorageLocation(@Validated SaveShopSkuStorageLocationRequest params) {
        Integer dealUserId=getCurrentUserId();
        return shopSkuStorageLocationService.saveShopSkuStorageLocation(params,dealUserId);
    }
    //删除库位信息
}
