package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.fbaPackingListShopSku.request.ListFbaPackingListShopSkuRequest;
import com.sky.ddt.dto.fbaPackingListShopSku.response.ListFbaPackingListShopSkuResponse;
import com.sky.ddt.service.IFbaPackingListShopSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author baixueping
 * @description fba装箱单店铺sku管理
 * @date 2020/7/23 10:11
 */
@Controller
@RequestMapping("/fbaPackingListShopSku")
public class FbaPackingListShopSkuController extends SuperController {
    @Autowired
    IFbaPackingListShopSkuService fbaPackingListShopSkuService;

    @RequestMapping("/listFbaPackingListShopSku")
    @MenuAnnotation("fbaPackingList/index")
    @ResponseBody
    public DataGridResponse listFbaFbaPackingList(ListFbaPackingListShopSkuRequest params) {
        PageInfo<ListFbaPackingListShopSkuResponse> page = fbaPackingListShopSkuService.listFbaPackingListShopSku(params);
        return DataGridResponse.create(page);
    }
}
