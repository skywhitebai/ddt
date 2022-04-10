package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.salesGroup.req.ListSalesGroupReq;
import com.sky.ddt.dto.salesGroup.req.SaveSalesGroupReq;
import com.sky.ddt.dto.salesGroupUser.req.ListSalesGroupUserReq;
import com.sky.ddt.dto.salesGroupUser.req.SaveSalesGroupUserReq;
import com.sky.ddt.dto.salesGroupUser.resp.ListSalesGroupUserResp;
import com.sky.ddt.service.ISalesGroupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;

/**
 * @author sky
 * @Description 销售分组用户管理
 * @date 2022/3/26 23:35
 */
@RequestMapping("/salesGroupUser")
@Controller
public class SalesGroupUserController extends SuperController {
    @Autowired
    ISalesGroupUserService salesGroupUserService;

    @RequestMapping("/listSalesGroupUser")
    @ResponseBody
    public DataGridResponse listSalesGroupUser(@Validated ListSalesGroupUserReq req) {
        PageInfo<ListSalesGroupUserResp> page = salesGroupUserService.listSalesGroupUser(req);
        return DataGridResponse.create(page);
    }
    @RequestMapping("/saveSalesGroupUser")
    @ResponseBody
    public BaseResponse saveSalesGroupUser(@Validated SaveSalesGroupUserReq req){
        return salesGroupUserService.saveSalesGroupUser(req,getCurrentUserId());
    }
    @RequestMapping("/deleteSalesGroupUser")
    @ResponseBody
    public BaseResponse deleteSalesGroupUser(@NotNull(message = "id不能为空") Integer id){
        return salesGroupUserService.deleteSalesGroupUser(id,getCurrentUserId());
    }
}
