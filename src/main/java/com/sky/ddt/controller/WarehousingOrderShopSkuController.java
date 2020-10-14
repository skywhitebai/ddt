package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.common.constant.WarehousingOrderShopSkuConstant;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.stock.request.SaveProductionQuantityRequest;
import com.sky.ddt.dto.warehousingOrderShopSku.request.ListWarehousingOrderShopSkuRequest;
import com.sky.ddt.dto.warehousingOrderShopSku.request.SaveWarehousingOrderShopSkuRequest;
import com.sky.ddt.dto.warehousingOrderShopSku.request.SaveWarehousingQuantityRequest;
import com.sky.ddt.dto.warehousingOrderShopSku.response.ListWarehousingOrderShopSkuResponse;
import com.sky.ddt.entity.WarehousingOrder;
import com.sky.ddt.service.IWarehousingOrderShopSkuService;
import com.sky.ddt.util.ExcelExportByExcelFieldUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author baixueping
 * @description 入库单店铺sku管理
 * @date 2020/4/23 16:02
 */
@Controller
@RequestMapping("/warehousingOrderShopSku")
public class WarehousingOrderShopSkuController extends SuperController{
    @Autowired
    IWarehousingOrderShopSkuService warehousingOrderShopSkuService;
    @RequestMapping("/listWarehousingOrderShopSku")
    @ResponseBody
    @MenuAnnotation("warehousingOrder/index")
    public DataGridResponse listWarehousingOrderShopSku(ListWarehousingOrderShopSkuRequest listWarehousingOrderShopSkuRequest) {
        PageInfo<ListWarehousingOrderShopSkuResponse> page = warehousingOrderShopSkuService.listWarehousingOrderShopSku(listWarehousingOrderShopSkuRequest);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    @RequestMapping("saveWarehousingOrderShopSku")
    @ResponseBody
    @MenuAnnotation("warehousingOrder/index")
    public BaseResponse saveWarehousingOrderShopSku(@Validated SaveWarehousingOrderShopSkuRequest params) {
        Integer dealUserId = getCurrentUserId();
        return warehousingOrderShopSkuService.saveWarehousingOrderShopSku(params, dealUserId);
    }
    @RequestMapping("deleteWarehousingOrderShopSku")
    @ResponseBody
    @MenuAnnotation("warehousingOrder/index")
    public BaseResponse deleteWarehousingOrderShopSku(Integer id) {
        return warehousingOrderShopSkuService.deleteWarehousingOrderShopSku(id);
    }
    @RequestMapping("/importWarehousingOrderShopSku")
    @ResponseBody
    @MenuAnnotation("warehousingOrder/index")
    public BaseResponse importWarehousingOrderShopSku(MultipartFile file, Integer warehousingOrderId) {
        Integer dealUserId = getCurrentUserId();
        return warehousingOrderShopSkuService.importWarehousingOrderShopSku(file,warehousingOrderId,dealUserId);
    }

    @RequestMapping("/exportWarehousingOrderShopSku")
    @ResponseBody
    @MenuAnnotation("warehousingOrder/index")
    public BaseResponse exportWarehousingOrderShopSku(Integer warehousingOrderId) {
        if(warehousingOrderId==null){
            return BaseResponse.failMessage(WarehousingOrderShopSkuConstant.WAREHOUSING_ORDER_ID_EMPTY);
        }
        List<ListWarehousingOrderShopSkuResponse> list=warehousingOrderShopSkuService.listWarehousingOrderShopSkuByWarehousingOrderId(warehousingOrderId);
        BaseResponse exportResponse = new ExcelExportByExcelFieldUtil().export(response, list, WarehousingOrderShopSkuConstant.exportWarehousingOrderShopSkuFieldList, "入库单店铺sku");
        return exportResponse;
    }

    @RequestMapping("/saveWarehousingQuantity")
    @ResponseBody
    @MenuAnnotation("warehousingOrder/index")
    public BaseResponse saveWarehousingQuantity(@Validated SaveWarehousingQuantityRequest params) {
        Integer dealUserId = getCurrentUserId();
        return warehousingOrderShopSkuService.saveWarehousingQuantity(params,dealUserId);
    }
}
