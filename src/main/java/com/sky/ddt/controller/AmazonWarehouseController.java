package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.amazonWarehouse.req.ListAmazonWarehouseReq;
import com.sky.ddt.dto.amazonWarehouse.req.SaveAmazonWarehouseReq;
import com.sky.ddt.dto.amazonWarehouse.resp.AmazonWarehouseComboxResp;
import com.sky.ddt.dto.amazonWarehouse.resp.ListAmazonWarehouseResp;
import com.sky.ddt.dto.country.req.ListCountryReq;
import com.sky.ddt.dto.country.resp.CountryComboxResp;
import com.sky.ddt.dto.country.resp.ListCountryResp;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.IAmazonWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author sky
 * @Description 亚马逊库位管理
 * @date 2022/4/17 23:37
 */
@Controller
@RequestMapping("/amazonWarehouse")
public class AmazonWarehouseController extends SuperController{
    @Autowired
    IAmazonWarehouseService amazonWarehouseService;

    @RequestMapping("/index")
    @MenuAnnotation("amazonWarehouse/index")
    public String index() {
        return "amazonWarehouse/list";
    }

    @RequestMapping("/listAmazonWarehouse")
    @ResponseBody
    @MenuAnnotation("amazonWarehouse/index")
    public DataGridResponse listAmazonWarehouse(ListAmazonWarehouseReq params) {
        PageInfo<ListAmazonWarehouseResp> page = amazonWarehouseService.listAmazonWarehouse(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("/saveAmazonWarehouse")
    @ResponseBody
    @MenuAnnotation("amazonWarehouse/index")
    public BaseResponse saveAmazonWarehouse(@Validated SaveAmazonWarehouseReq params) {
        Integer dealUserId=getCurrentUserId();
        return amazonWarehouseService.saveAmazonWarehouse(params,dealUserId);
    }
    @RequestMapping("/amazonWarehouseComboboxlist")
    @ResponseBody
    @MenuAnnotation("amazonWarehouse/index")
    public List<AmazonWarehouseComboxResp> amazonWarehouseComboboxlist() {
        return amazonWarehouseService.amazonWarehouseComboboxlist();
    }
    @RequestMapping("/importAmazonWarehouse")
    @ResponseBody
    @MenuAnnotation("amazonWarehouse/index")
    public BaseResponse importAmazonWarehouse(MultipartFile file) {
        Integer dealUserId = getCurrentUserId();
        return amazonWarehouseService.importAmazonWarehouse(file, dealUserId);
    }
}
