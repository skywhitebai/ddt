package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.salesGroup.req.ListSalesGroupReq;
import com.sky.ddt.dto.salesGroup.req.SaveSalesGroupReq;
import com.sky.ddt.dto.salesGroup.resp.ListSalesGroupResp;
import com.sky.ddt.service.ISalesGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;

/**
 * @author sky
 * @Description 销售分组
 * @date 2022/3/26 23:35
 */
@RequestMapping("/salesGroup")
@Controller
public class SalesGroupController extends SuperController {
    @Autowired
    ISalesGroupService salesGroupService;

    @RequestMapping("/index")
    @MenuAnnotation("salesGroup/index")
    public  String index(){
        return "salesGroup/list";
    }

    @RequestMapping("/listSalesGroup")
    @ResponseBody
    public DataGridResponse listSalesGroup(ListSalesGroupReq req){
        PageInfo<ListSalesGroupResp> page=salesGroupService.listSalesGroup(req);
        return DataGridResponse.create(page);
    }
    @RequestMapping("/saveSalesGroup")
    @ResponseBody
    public BaseResponse saveSalesGroup(@Validated SaveSalesGroupReq req){
        return salesGroupService.saveSalesGroup(req,getCurrentUserId());
    }
    @RequestMapping("/deleteSalesGroup")
    @ResponseBody
    public BaseResponse deleteSalesGroup(@NotNull(message = "id不能为空") Integer id){
        return salesGroupService.deleteSalesGroup(id,getCurrentUserId());
    }
}
