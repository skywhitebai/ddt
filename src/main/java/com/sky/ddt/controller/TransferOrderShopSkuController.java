package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.common.constant.TransferOrderShopSkuConstant;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.transferOrderShopSku.request.ListTransferOrderShopSkuRequest;
import com.sky.ddt.dto.transferOrderShopSku.request.SaveTransferOrderShopSkuRequest;
import com.sky.ddt.dto.transferOrderShopSku.request.SaveTransferQuantityRequest;
import com.sky.ddt.dto.transferOrderShopSku.response.ListTransferOrderShopSkuResponse;
import com.sky.ddt.service.ITransferOrderShopSkuService;
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
 * @description 调拨控制器
 * @date 2020/8/28 16:15
 */
@Controller
@RequestMapping("/transferOrderShopSku")
public class TransferOrderShopSkuController extends SuperController{
    @Autowired
    ITransferOrderShopSkuService transferOrderShopSkuService;
    //listTransferOrderShopSku
    @RequestMapping("/listTransferOrderShopSku")
    @ResponseBody
    @MenuAnnotation("transferOrder/index")
    public DataGridResponse listTransferOrderShopSku(ListTransferOrderShopSkuRequest params) {
        PageInfo<ListTransferOrderShopSkuResponse> page = transferOrderShopSkuService.listTransferOrderShopSku(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("saveTransferOrderShopSku")
    @ResponseBody
    @MenuAnnotation("transferOrder/index")
    public BaseResponse saveTransferOrderShopSku(@Validated SaveTransferOrderShopSkuRequest params) {
        Integer dealUserId = getCurrentUserId();
        return transferOrderShopSkuService.saveTransferOrderShopSku(params, dealUserId);
    }
    @RequestMapping("deleteTransferOrderShopSku")
    @ResponseBody
    @MenuAnnotation("transferOrder/index")
    public BaseResponse deleteTransferOrderShopSku(Integer id) {
        return transferOrderShopSkuService.deleteTransferOrderShopSku(id);
    }

    @RequestMapping("/importTransferOrderShopSku")
    @ResponseBody
    @MenuAnnotation("transferOrder/index")
    public BaseResponse importTransferOrderShopSku(MultipartFile file, Integer transferOrderId) {
        Integer dealUserId = getCurrentUserId();
        return transferOrderShopSkuService.importTransferOrderShopSku(file,transferOrderId,dealUserId);
    }
    @RequestMapping("/exportTransferOrderShopSku")
    @ResponseBody
    @MenuAnnotation("transferOrder/index")
    public BaseResponse exportTransferOrderShopSku(Integer transferOrderId) {
        if(transferOrderId==null){
            return BaseResponse.failMessage(TransferOrderShopSkuConstant.TRANSFER_ORDER_ID_EMPTY);
        }
        List<ListTransferOrderShopSkuResponse> list=transferOrderShopSkuService.listTransferOrderShopSkuByTransferOrderId(transferOrderId);
        BaseResponse exportResponse = new ExcelExportByExcelFieldUtil().export(response, list, TransferOrderShopSkuConstant.exportTransferOrderShopSkuFieldList, "调拨单店铺sku");
        return exportResponse;
    }

    @RequestMapping("/saveTransferQuantity")
    @ResponseBody
    @MenuAnnotation("outboundOrder/index")
    public BaseResponse saveTransferQuantity(@Validated SaveTransferQuantityRequest params) {
        Integer dealUserId = getCurrentUserId();
        return transferOrderShopSkuService.saveTransferQuantity(params,dealUserId);
    }
}
