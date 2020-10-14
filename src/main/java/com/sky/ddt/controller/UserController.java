package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.common.annotation.RightAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.user.request.UserListRequest;
import com.sky.ddt.dto.user.request.UserSaveRequest;
import com.sky.ddt.dto.user.response.UserComboboxResponse;
import com.sky.ddt.dto.user.response.UserListResponse;
import com.sky.ddt.entity.User;
import com.sky.ddt.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController extends SuperController{
    @Autowired
    IUserService userService;

    @RequestMapping("/index")
    @MenuAnnotation("user/index")
    public  String index(){
        return "user/list";
    }
    @RequestMapping("list")
    @ResponseBody
    @MenuAnnotation("user/index")
    public DataGridResponse list(UserListRequest params) {
        PageInfo<UserListResponse> page=userService.list(params);
        DataGridResponse dataGridResponse=new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("save")
    @ResponseBody
    @MenuAnnotation("user/index")
    @RightAnnotation("user/save")
    public BaseResponse save(UserSaveRequest params) {
        Integer dealUserId=getCurrentUserId();
        return userService.save(params,dealUserId);
    }
    @RequestMapping("delete")
    @ResponseBody
    @MenuAnnotation("user/index")
    public BaseResponse delete(@RequestParam(required = false, value = "userIds[]") List<Integer> userIds) {
        Integer dealUserId=getCurrentUserId();
        return userService.delete(userIds,dealUserId);
    }
    @RequestMapping("comboboxlist")
    @ResponseBody
    public List<UserComboboxResponse> comboboxlist() {
        List<UserComboboxResponse> list=userService.comboboxlist();
        return list;
    }
}
