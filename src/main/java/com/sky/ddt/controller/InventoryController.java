package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.InventoryConstant;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.inventory.request.InventoryListRequest;
import com.sky.ddt.dto.inventory.response.InventoryListResponse;
import com.sky.ddt.dto.inventory.response.ShopInventoryInfoResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.IInventoryService;
import com.sky.ddt.util.ExcelExportUtil;
import com.sky.ddt.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author baixueping
 * @description 库存接口
 * @date 2019/4/22 18:11
 */
@Controller
@RequestMapping("/inventory")
public class InventoryController extends SuperController {
    @Autowired
    IInventoryService inventoryService;

    /**
     * @param
     * @return
     * @description 保存库存信息
     * @author baixueping
     * @date 2019/4/22 18:16
     */
    @RequestMapping(value = "saveInventory", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse saveInventory(Integer shopId, String inventoryJson) {
        Integer dealUserId = getCurrentUserId();
        return inventoryService.saveInventory(dealUserId, shopId, inventoryJson);
    }

    @RequestMapping("/index")
    public String index() {
        return "inventory/list";
    }

    @RequestMapping("list")
    @ResponseBody
    public DataGridResponse list(InventoryListRequest params) {
        PageInfo<InventoryListResponse> page = inventoryService.list(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    @RequestMapping("downShopInventoryInfo")
    @ResponseBody
    public BaseResponse downShopInventoryInfo(InventoryListRequest params) {
        if (StringUtils.isEmpty(params.getShopId())) {
            return BaseResponse.failMessage(InventoryConstant.SHOP_ID_EMPTY);
        }
        List<ShopInventoryInfoResponse> list=inventoryService.listShopInventoryInfo(params);
        BaseResponse exportResponse= new ExcelExportUtil<ShopInventoryInfoResponse>().export(response,list,InventoryConstant.SHOP_INVENTORY_INFO_HEAD,"店铺库存数据");
        return exportResponse;
    }
}
