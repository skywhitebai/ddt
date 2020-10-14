package com.sky.ddt.controller;

import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.IDeliverGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author baixueping
 * @description 发货管理
 * @date 2019/9/9 11:34
 */
@Controller
@RequestMapping("/deliverGoods")
public class DeliverGoodsController extends SuperController {
    @Autowired
    IDeliverGoodsService deliverGoodsService;

    @RequestMapping("/index")
    public String index() {
        return "deliverGoods/index";
    }

    @RequestMapping("/generateDeliveryPlan")
    @ResponseBody
    @MenuAnnotation("deliverGoods/index")
    public BaseResponse generateDeliveryPlan(MultipartFile file) {
        return deliverGoodsService.generateDeliveryPlan(file, response);
    }

    @RequestMapping("/generateWarehousePackingList")
    @ResponseBody
    @MenuAnnotation("deliverGoods/index")
    public BaseResponse generateWarehousePackingList(MultipartFile file) {
        return deliverGoodsService.generateWarehousePackingList(file, response);
    }

    @RequestMapping("/generateAmazonPackingList")
    @ResponseBody
    @MenuAnnotation("deliverGoods/index")
    public BaseResponse generateAmazonPackingList(MultipartFile file, Integer numberOfBoxes) {
        return deliverGoodsService.generateAmazonPackingList(file, numberOfBoxes, response);
    }

    @RequestMapping("/generateInvoice")
    @ResponseBody
    @MenuAnnotation("deliverGoods/index")
    public BaseResponse generateInvoice(MultipartFile file, String type,String fbaNo) {
        return deliverGoodsService.generateInvoice(file,type,fbaNo,response);
    }
}
