package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.fbaPackingList.request.ListFbaPackingListRequest;
import com.sky.ddt.dto.fbaPackingList.request.ListInvoiceInfoRequest;
import com.sky.ddt.dto.fbaPackingList.response.ListFbaPackingListResponse;
import com.sky.ddt.dto.fbaPackingList.response.ListInvoiceInfoResponse;
import com.sky.ddt.dto.response.BaseResponse;
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
    public BaseResponse importFbaPackingList2(@Validated @NotEmpty(message = "FBAshipment id不能为空")String fbaShipmentId, MultipartFile file) {
        Integer dealUserId = getCurrentUserId();
        return fbaPackingListService.importFbaPackingList2(fbaShipmentId,file, dealUserId);
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
    public BaseResponse generateOutboundOrder(Integer id) {
        Integer dealUserId=getCurrentUserId();
        return fbaPackingListService.generateOutboundOrder(id,dealUserId);
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
}
