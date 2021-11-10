package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.common.constant.StockConsatnt;
import com.sky.ddt.common.constant.StockRecordConstant;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.stockRecord.request.ListStockRecordRequest;
import com.sky.ddt.dto.stockRecord.request.SaveStockRecordRemarkRequest;
import com.sky.ddt.dto.stockRecord.request.SetStockRecordDoneRequest;
import com.sky.ddt.dto.stockRecord.response.ExportStockRecordResponse;
import com.sky.ddt.dto.stockRecord.response.ListStockRecordResponse;
import com.sky.ddt.entity.StockRecord;
import com.sky.ddt.service.IShopUserService;
import com.sky.ddt.service.IStockRecordService;
import com.sky.ddt.util.ExcelExportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author baixueping
 * @description 补货记录
 * @date 2019/8/22 16:07
 */
@RequestMapping("/stockRecord")
@Controller
public class StockRecordController extends SuperController {
    @Autowired
    IStockRecordService stockRecordService;
    @Autowired
    IShopUserService shopUserService;

    @RequestMapping("/createStockRecord")
    @ResponseBody
    @MenuAnnotation("stock/index")
    public BaseResponse createStockRecord(Integer shopId) {
        return stockRecordService.createStockRecord(shopId, getCurrentUserId());
    }

    @RequestMapping("/index")
    @MenuAnnotation("stockRecord/index")
    public String index() {
        return "stockRecord/list";
    }

    @RequestMapping("/listStockRecord")
    @ResponseBody
    @MenuAnnotation("stockRecord/index")
    public DataGridResponse listStockRecord(ListStockRecordRequest params) {
        params.setUserId(getCurrentUserId());
        PageInfo<ListStockRecordResponse> page = stockRecordService.listStockRecord(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    @RequestMapping("/exportStockRecord")
    @ResponseBody
    @MenuAnnotation("stockRecord/index")
    public BaseResponse exportStockRecord(Integer stockRecordId,String type) {
        if (stockRecordId == null) {
            return BaseResponse.failMessage(StockRecordConstant.STOCK_RECORD_ID_EMPTY);
        }
        StockRecord stockRecord = stockRecordService.getStockRecordById(stockRecordId);
        if (stockRecord == null) {
            return BaseResponse.failMessage(StockRecordConstant.STOCK_RECORD_ID_NOT_EXIST);
        }
        if(!shopUserService.exisShopUser(stockRecord.getShopId(),getCurrentUserId())){
            return BaseResponse.failMessage(StockRecordConstant.USER_NO_SHOP_RIGHT);
        }
        List<ExportStockRecordResponse> list = stockRecordService.listExportStockRecord(stockRecordId,type);
        String shopName=stockRecord.getTitle().substring(0,stockRecord.getTitle().indexOf("补货单"));
        String title=stockRecord.getTitle().substring(0,stockRecord.getTitle().indexOf(" "));

        String[] headers;
        if(StockConsatnt.StockQuantityTypeEnum.KY.getType().equals(type)){
            headers=StockRecordConstant.EXPORT_STOCK_RECORD_HEAD_KY;
            title+="空运补货单";
        }else if(StockConsatnt.StockQuantityTypeEnum.KP.getType().equals(type)){
            headers=StockRecordConstant.EXPORT_STOCK_RECORD_HEAD_KP;
            title+="空派补货单";
        }else if(StockConsatnt.StockQuantityTypeEnum.HY.getType().equals(type)){
            headers=StockRecordConstant.EXPORT_STOCK_RECORD_HEAD_HY;
            title+="海运补货单";
        }else if("production".equals(type)){
            headers=StockRecordConstant.EXPORT_PRODUCTION_HEAD;
            title+="生产单";
        }else {
            headers=StockRecordConstant.EXPORT_STOCK_RECORD_HEAD;
            title+="补货单";
        }
        Integer total=0;
        for (ExportStockRecordResponse exportStockRecordResponse:
                list) {
            total+=exportStockRecordResponse.getStockQuantity();
            exportStockRecordResponse.setShopName(shopName);
            exportStockRecordResponse.setStockRecordId(stockRecordId);
        }
        ExportStockRecordResponse exportStockRecordResponseTotal=new ExportStockRecordResponse();
        exportStockRecordResponseTotal.setFnsku("合计：");
        exportStockRecordResponseTotal.setStockQuantity(total);
        list.add(exportStockRecordResponseTotal);
        ExportStockRecordResponse exportStockRecordResponseRemark=new ExportStockRecordResponse();
        exportStockRecordResponseRemark.setShopSku("备注：");
        exportStockRecordResponseRemark.setSku(stockRecord.getRemark());
        list.add(exportStockRecordResponseRemark);
        BaseResponse exportResponse = new ExcelExportUtil<ExportStockRecordResponse>().export(response, list, headers, title);
        return exportResponse;
    }
    @RequestMapping("/saveStockRecordRemark")
    @ResponseBody
    @MenuAnnotation("stockRecord/index")
    public BaseResponse saveStockRecordRemark(SaveStockRecordRemarkRequest params) {
        Integer dealUserId = getCurrentUserId();
        return stockRecordService.saveStockRecordRemark(params, dealUserId);
    }
    @RequestMapping("/setStockRecordDone")
    @ResponseBody
    @MenuAnnotation("stockRecord/index")
    public BaseResponse setStockRecordDone(@Validated SetStockRecordDoneRequest params){
        Integer dealUserId = getCurrentUserId();
        return stockRecordService.setStockRecordDone(params, dealUserId);

    }
}
