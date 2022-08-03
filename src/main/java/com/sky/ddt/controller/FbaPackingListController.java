package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.fbaPackingList.request.*;
import com.sky.ddt.dto.fbaPackingList.response.ListFbaPackingListResponse;
import com.sky.ddt.dto.fbaPackingList.response.ListInvoiceInfoResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.stockRecord.request.SaveStockRecordRemarkRequest;
import com.sky.ddt.service.IFbaPackingListService;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description FBA装箱单
 * @date 2020/7/21 16:54
 */
@Controller
@RequestMapping("/fbaPackingList")
public class FbaPackingListController extends SuperController {
    @Autowired
    IFbaPackingListService fbaPackingListService;

    @RequestMapping("/index")
    @MenuAnnotation("fbaPackingList/index")
    public String index() {
        return "fbaPackingList/list";
    }

    @RequestMapping("/importFbaPackingList")
    @MenuAnnotation("fbaPackingList/index")
    @ResponseBody
    public BaseResponse importFbaPackingList(MultipartFile file) {
        Integer dealUserId = getCurrentUserId();
        return fbaPackingListService.importFbaPackingList(file, dealUserId);
    }
    @RequestMapping("/importFbaPackingList2")
    @MenuAnnotation("fbaPackingList/index")
    @ResponseBody
    public BaseResponse importFbaPackingList2(@Validated ImportFbaPackingList2Request params) {
        Integer dealUserId = getCurrentUserId();
        return fbaPackingListService.importFbaPackingList2(params,dealUserId);
    }

    @RequestMapping("/listFbaPackingList")
    @MenuAnnotation("fbaPackingList/index")
    @ResponseBody
    public DataGridResponse listFbaFbaPackingList(ListFbaPackingListRequest params) {
        params.setUserId(getCurrentUserId());
        PageInfo<ListFbaPackingListResponse> page = fbaPackingListService.listFbaPackingList(params);
        return DataGridResponse.create(page);
    }
    @RequestMapping("/listInvoiceInfo")
    @MenuAnnotation("fbaPackingList/index")
    @ResponseBody
    public DataGridResponse listInvoiceInfo(ListInvoiceInfoRequest params) {
        PageInfo<ListInvoiceInfoResponse> page = fbaPackingListService.listInvoiceInfo(params);
        return DataGridResponse.create(page);
    }
    @RequestMapping("/generateOutboundOrder")
    @MenuAnnotation("fbaPackingList/index")
    @ResponseBody
    public BaseResponse generateOutboundOrder(@Validated GenerateOutboundOrderRequest params) {
        Integer dealUserId=getCurrentUserId();
        return fbaPackingListService.generateOutboundOrder(params,dealUserId);
    }
    @RequestMapping("/downInvoice")
    @MenuAnnotation("fbaPackingList/index")
    @ResponseBody
    public BaseResponse downInvoice(Integer fbaPackingListId,String orderNumber,String type){
        return fbaPackingListService.downInvoice(fbaPackingListId,orderNumber,type,response);
    }
    @RequestMapping("/cancelFbaPackingList")
    @MenuAnnotation("fbaPackingList/index")
    @ResponseBody
    public BaseResponse cancelFbaPackingList(Integer id) {
        Integer dealUserId=getCurrentUserId();
        return fbaPackingListService.cancelFbaPackingList(id,dealUserId);
    }

    @RequestMapping("/saveFbaPackingListRemark")
    @ResponseBody
    @MenuAnnotation("fbaPackingList/index")
    public BaseResponse saveFbaPackingListRemark(SaveFbaPackingListRemarkReq params) {
        Integer dealUserId = getCurrentUserId();
        return fbaPackingListService.saveFbaPackingListRemark(params, dealUserId);
    }

    @RequestMapping("/saveFbaPackingListCheckStatus")
    @ResponseBody
    @MenuAnnotation("fbaPackingList/index")
    public BaseResponse saveFbaPackingListCheckStatus(SaveFbaPackingListCheckStatusReq params) {
        Integer dealUserId = getCurrentUserId();
        return fbaPackingListService.saveFbaPackingListCheckStatus(params, dealUserId);
    }
}
