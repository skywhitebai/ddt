package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopSkuStorageLocation.request.ListShopSkuStorageLocationRequest;
import com.sky.ddt.dto.shopSkuStorageLocation.request.SaveShopSkuStorageLocationRequest;
import com.sky.ddt.dto.shopSkuStorageLocation.response.ListShopSkuStorageLocationResponse;
import com.sky.ddt.dto.warehousingOrderShopSkuStorageLocation.request.ListWarehousingOrderShopSkuStorageLocationRequest;
import com.sky.ddt.dto.warehousingOrderShopSkuStorageLocation.request.SaveWarehousingOrderShopSkuStorageLocationRequest;
import com.sky.ddt.dto.warehousingOrderShopSkuStorageLocation.response.ListWarehousingOrderShopSkuStorageLocationResponse;
import com.sky.ddt.service.IWarehousingOrderShopSkuStorageLocationService;
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
@RequestMapping("/warehousingOrderShopSkuStorageLocation")
@Controller
public class WarehousingOrderShopSkuStorageLocationController extends SuperController{
    @Autowired
    IWarehousingOrderShopSkuStorageLocationService warehousingOrderShopSkuStorageLocationService;
    //列表查询库位信息
    @RequestMapping("/listWarehousingOrderShopSkuStorageLocation")
    @ResponseBody
    @MenuAnnotation("shopSku/index")
    public DataGridResponse listWarehousingOrderShopSkuStorageLocation(ListWarehousingOrderShopSkuStorageLocationRequest params) {
        PageInfo<ListWarehousingOrderShopSkuStorageLocationResponse> page = warehousingOrderShopSkuStorageLocationService.listWarehousingOrderShopSkuStorageLocation(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    //添加库位信息
    @RequestMapping("/saveWarehousingOrderShopSkuStorageLocation")
    @ResponseBody
    @MenuAnnotation("shopSku/index")
    public BaseResponse saveWarehousingOrderShopSkuStorageLocation(@Validated SaveWarehousingOrderShopSkuStorageLocationRequest params) {
        Integer dealUserId=getCurrentUserId();
        return warehousingOrderShopSkuStorageLocationService.saveWarehousingOrderShopSkuStorageLocation(params,dealUserId);
    }
    //删除库位信息
    @RequestMapping("/deleteWarehousingOrderShopSkuStorageLocation")
    @ResponseBody
    @MenuAnnotation("shopSku/index")
    public BaseResponse deleteWarehousingOrderShopSkuStorageLocation(Integer WarehousingOrderShopSkuStorageLocationId) {
        return warehousingOrderShopSkuStorageLocationService.deleteWarehousingOrderShopSkuStorageLocation(WarehousingOrderShopSkuStorageLocationId);
    }
}
