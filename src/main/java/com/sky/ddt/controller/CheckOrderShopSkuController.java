package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.common.constant.CheckOrderShopSkuConstant;
import com.sky.ddt.dto.checkOrderShopSku.request.ListCheckOrderShopSkuRequest;
import com.sky.ddt.dto.checkOrderShopSku.request.SaveCheckOrderShopSkuRequest;
import com.sky.ddt.dto.checkOrderShopSku.request.SaveInventoryQuantityNewRequest;
import com.sky.ddt.dto.checkOrderShopSku.response.ListCheckOrderShopSkuResponse;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.ICheckOrderShopSkuService;
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
 * @description 盘点单控制器
 * @date 2020/5/11 14:36
 */
@Controller
@RequestMapping("/checkOrderShopSku")
public class CheckOrderShopSkuController extends SuperController {
    @Autowired
    ICheckOrderShopSkuService checkOrderShopSkuService;

    @RequestMapping("/listCheckOrderShopSku")
    @ResponseBody
    @MenuAnnotation("checkOrder/index")
    public DataGridResponse listCheckOrderShopSku(ListCheckOrderShopSkuRequest params) {
        PageInfo<ListCheckOrderShopSkuResponse> page = checkOrderShopSkuService.listCheckOrderShopSku(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    @RequestMapping("saveCheckOrderShopSku")
    @ResponseBody
    @MenuAnnotation("checkOrder/index")
    public BaseResponse saveCheckOrderShopSku(@Validated SaveCheckOrderShopSkuRequest params) {
        Integer dealUserId = getCurrentUserId();
        return checkOrderShopSkuService.saveCheckOrderShopSku(params, dealUserId);
    }
    @RequestMapping("deleteCheckOrderShopSku")
    @ResponseBody
    @MenuAnnotation("checkOrder/index")
    public BaseResponse deleteCheckOrderShopSku(Integer id) {
        return checkOrderShopSkuService.deleteCheckOrderShopSku(id);
    }
    @RequestMapping("/importCheckOrderShopSku")
    @ResponseBody
    @MenuAnnotation("checkOrder/index")
    public BaseResponse importCheckOrderShopSku(MultipartFile file, Integer checkOrderId) {
        Integer dealUserId = getCurrentUserId();
        return checkOrderShopSkuService.importCheckOrderShopSku(file,checkOrderId,dealUserId);
    }
    @RequestMapping("/exportCheckOrderShopSku")
    @ResponseBody
    @MenuAnnotation("checkOrder/index")
    public BaseResponse exportCheckOrderShopSku(Integer checkOrderId) {
        if(checkOrderId==null){
            return BaseResponse.failMessage(CheckOrderShopSkuConstant.CHECK_ORDER_ID_EMPTY);
        }
        List<ListCheckOrderShopSkuResponse> list=checkOrderShopSkuService.listCheckOrderShopSkuByCheckOrderId(checkOrderId);
        BaseResponse exportResponse = new ExcelExportByExcelFieldUtil().export(response, list, CheckOrderShopSkuConstant.exportCheckOrderShopSkuFieldList, "盘点单店铺sku");
        return exportResponse;
    }
    /**
     * @param
     * @return
     * @description 保存最新库存数量
     * @author baixueping
     * @date 2019/8/22 14:57
     */
    @RequestMapping("/saveInventoryQuantityNew")
    @ResponseBody
    @MenuAnnotation("checkOrder/index")
    public BaseResponse saveInventoryQuantityNew(@Validated SaveInventoryQuantityNewRequest params) {
        return checkOrderShopSkuService.saveInventoryQuantityNew(params,getCurrentUserId());
    }
}
