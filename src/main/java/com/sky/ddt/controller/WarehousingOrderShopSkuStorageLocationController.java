package com.sky.ddt.controller;

import com.sky.ddt.service.IWarehousingOrderShopSkuStorageLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    //添加库位信息
    //删除库位信息
}
