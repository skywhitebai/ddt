package com.sky.ddt.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.Action;
import com.sky.ddt.common.annotation.Login;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shop.request.*;
import com.sky.ddt.dto.shop.response.ShopComboboxResponse;
import com.sky.ddt.dto.shop.response.ShopListResponse;
import com.sky.ddt.entity.Shop;
import com.sky.ddt.service.IShopService;
import com.sky.ddt.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;


/**
 * 店鋪管理
 *
 * @author sky
 * @date 2019/3/26
 */
@Controller
@RequestMapping("shop")
public class ShopController extends SuperController {

    @Autowired
    IShopService shopService;
    @RequestMapping("/index")
    @MenuAnnotation("shop/index")
    public  String index(){
        return "shop/list";
    }

    @RequestMapping("/getCurrentUserShop")
    @ResponseBody
    public BaseResponse<Shop> getCurrentUserShop(String macAddress) {
        //获取ip macAddress 判断是否有其他账号已久登陆过这个ip，如果有则不能登录 防止被封号
        String ip= HttpUtil.getIp(request);
        Integer userId=getCurrentUserId();
        BaseResponse<Shop> shopResponse = shopService.getCurrentUserShop(userId,ip,macAddress);
        if(!shopResponse.isSuccess()){
            return  shopResponse;
        }
        return shopResponse;
    }
    @RequestMapping("getOrderLastUpdatedAfter")
    @ResponseBody
    public BaseResponse<Date> getOrderLastUpdatedAfter(Integer shopId) {
        return shopService.getOrderLastUpdatedAfter(shopId);
    }
    @RequestMapping("updateInventoryQueryStartDateTime")
    @ResponseBody
    public BaseResponse updateInventoryQueryStartDateTime(UpdateInventoryQueryStartDateTimeRequest params) {
        Integer dealUserId=getCurrentUserId();
        return shopService.updateInventoryQueryStartDateTime(dealUserId,params);
    }
    @RequestMapping("updateOrderLastUpdatedAfter")
    @ResponseBody
    public BaseResponse updateOrderLastUpdatedAfter(UpdateOrderLastUpdatedAfterRequest updateOrderLastUpdatedAfterRequest) {
        Integer dealUserId=getCurrentUserId();
        return shopService.updateOrderLastUpdatedAfter(dealUserId,updateOrderLastUpdatedAfterRequest);
    }
    @RequestMapping("list")
    @ResponseBody
    @MenuAnnotation("shop/index")
    public DataGridResponse list(ShopListRequest params) {
        PageInfo<ShopListResponse> page=shopService.listShop(params);
        return DataGridResponse.create(page);
    }
    @RequestMapping("/comboboxlist")
    @ResponseBody
    public List<ShopComboboxResponse> comboboxlist(ShopComboboxlistRequest shopComboboxlistRequest) {
        List<ShopComboboxResponse> list=shopService.comboboxlist(shopComboboxlistRequest);
        return list;
    }
    @RequestMapping("/userShopComboboxlist")
    @ResponseBody
    public List<ShopComboboxResponse> userShopComboboxlist(ShopComboboxlistRequest shopComboboxlistRequest) {
        shopComboboxlistRequest.setUserId(getCurrentUserId());
        List<ShopComboboxResponse> list=shopService.comboboxlist(shopComboboxlistRequest);
        return list;
    }
    @RequestMapping("/save")
    @ResponseBody
    @MenuAnnotation("shop/index")
    public BaseResponse save(@Validated ShopSaveRequest params) {
        Integer dealUserId=getCurrentUserId();
        return shopService.save(params,dealUserId);
    }
    @RequestMapping("delete")
    @ResponseBody
    @MenuAnnotation("shop/index")
    public BaseResponse delete(@RequestParam(required = false, value = "shopIds[]") List<Integer> shopIds) {
        Integer dealUserId=getCurrentUserId();
        return shopService.delete(shopIds,dealUserId);
    }
}
