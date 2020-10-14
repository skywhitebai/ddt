package com.sky.ddt.controller;


import com.sky.ddt.common.annotation.*;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.IAmazonSellerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 亚马逊销售数据统计
 *
 * @author baixueping
 * @date 2018/12/26
 */
@RequestMapping("/amazon")
@Controller
public class AmazonController extends SuperController {

    @Autowired
    IAmazonSellerInfoService amazonSellerInfoService;

    @RequestMapping("/amazonSellerInfo")
    @Login(action = Action.Skip)
    public  String amazonSellerInfo(){
        return "amazon/amazonSellerInfo";
    }
    /**
     * 亚马逊销售数据统计
     * @param file
     * @return
     */
    @RequestMapping("countSellerInfo")
    @ResponseBody
    @Login(action = Action.Skip)
    @Log("亚马逊销售数据统计")
    @LogRequest(action = Action.Skip)
    public BaseResponse countSellerInfo(MultipartFile file) {
        return amazonSellerInfoService.countSellerInfoAll(file,request,response);
    }

    /**
     * 订单数据下载
     * @param file
     * @return
     */
    @RequestMapping("orderExport")
    @ResponseBody
    @Login(action = Action.Skip)
    @Log("亚马逊销售数据统计")
    @LogRequest(action = Action.Skip)
    public BaseResponse orderExport(MultipartFile file) {
        return amazonSellerInfoService.orderExport(file,request,response);
    }
}
