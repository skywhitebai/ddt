package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopUser.response.ShopUserResponse;
import com.sky.ddt.dto.shopUser.Request.GetShopUserListRequest;
import com.sky.ddt.dto.shopUser.Request.SaveShopUserRequest;
import com.sky.ddt.service.IShopUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author baixueping
 * @description 店铺用户
 * @date 2019/7/25 10:49
 */
@RequestMapping("/shopUser")
@RestController
public class ShopUserController extends SuperController{
    @Autowired
    IShopUserService shopUserService;
    @RequestMapping("/getShopUserList")
    @ResponseBody
    public DataGridResponse getShopUserList(GetShopUserListRequest params){
        PageInfo<ShopUserResponse> page = shopUserService.getShopUserList(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    @RequestMapping("/deleteShopUser")
    @ResponseBody
    @MenuAnnotation("shopSku/index")
    public BaseResponse deleteShopUser(@RequestParam(required = false, value = "shopUserIds[]") List<Integer> shopUserIds) {
        return shopUserService.deleteShopUser(shopUserIds);
    }
    @RequestMapping("/saveShopUser")
    @ResponseBody
    @MenuAnnotation("shopSku/index")
    public BaseResponse saveShopUser(@Validated SaveShopUserRequest params) {
        Integer dealUserId=getCurrentUserId();
        return shopUserService.saveShopUser(params,dealUserId);
    }
}
