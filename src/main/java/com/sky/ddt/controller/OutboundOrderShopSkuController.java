package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.common.constant.OutboundOrderShopSkuConstant;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.outboundOrderShopSku.request.ListOutboundOrderShopSkuRequest;
import com.sky.ddt.dto.outboundOrderShopSku.request.SaveOutboundOrderShopSkuRequest;
import com.sky.ddt.dto.outboundOrderShopSku.request.SaveOutboundQuantityRequest;
import com.sky.ddt.dto.outboundOrderShopSku.response.ListOutboundOrderShopSkuResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.IOutboundOrderShopSkuService;
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
 * @description 出库单店铺sku控制器
 * @date 2020/5/12 12:46
 */
@Controller
@RequestMapping("outboundOrderShopSku")
public class OutboundOrderShopSkuController extends SuperController{
    @Autowired
    IOutboundOrderShopSkuService outboundOrderShopSkuService;
    @RequestMapping("/listOutboundOrderShopSku")
    @ResponseBody
    @MenuAnnotation("outboundOrder/index")
    public DataGridResponse listOutboundOrderShopSku(ListOutboundOrderShopSkuRequest params) {
        PageInfo<ListOutboundOrderShopSkuResponse> page = outboundOrderShopSkuService.listOutboundOrderShopSku(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("saveOutboundOrderShopSku")
    @ResponseBody
    @MenuAnnotation("outboundOrder/index")
    public BaseResponse saveOutboundOrderShopSku(@Validated SaveOutboundOrderShopSkuRequest params) {
        Integer dealUserId = getCurrentUserId();
        return outboundOrderShopSkuService.saveOutboundOrderShopSku(params, dealUserId);
    }
    @RequestMapping("deleteOutboundOrderShopSku")
    @ResponseBody
    @MenuAnnotation("outboundOrder/index")
    public BaseResponse deleteOutboundOrderShopSku(Integer id) {
        return outboundOrderShopSkuService.deleteOutboundOrderShopSku(id);
    }

    @RequestMapping("/importOutboundOrderShopSku")
    @ResponseBody
    @MenuAnnotation("outboundOrder/index")
    public BaseResponse importOutboundOrderShopSku(MultipartFile file, Integer outboundOrderId) {
        Integer dealUserId = getCurrentUserId();
        return outboundOrderShopSkuService.importOutboundOrderShopSku(file,outboundOrderId,dealUserId);
    }
    @RequestMapping("/exportOutboundOrderShopSku")
    @ResponseBody
    @MenuAnnotation("outboundOrder/index")
    public BaseResponse exportOutboundOrderShopSku(Integer outboundOrderId) {
        if(outboundOrderId==null){
            return BaseResponse.failMessage(OutboundOrderShopSkuConstant.OUTBOUND_ORDER_ID_EMPTY);
        }
        List<ListOutboundOrderShopSkuResponse> list=outboundOrderShopSkuService.listOutboundOrderShopSkuByOutboundOrderId(outboundOrderId);
        BaseResponse exportResponse = new ExcelExportByExcelFieldUtil().export(response, list, OutboundOrderShopSkuConstant.exportOutboundOrderShopSkuFieldList, "出库单店铺sku");
        return exportResponse;
    }
    @RequestMapping("/saveOutboundQuantity")
    @ResponseBody
    @MenuAnnotation("outboundOrder/index")
    public BaseResponse saveOutboundQuantity(@Validated SaveOutboundQuantityRequest params) {
        Integer dealUserId = getCurrentUserId();
        return outboundOrderShopSkuService.saveOutboundQuantity(params,dealUserId);
    }
}
