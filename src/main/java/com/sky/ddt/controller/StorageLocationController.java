package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.common.annotation.RightAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shop.request.ShopComboboxlistRequest;
import com.sky.ddt.dto.shop.response.ShopComboboxResponse;
import com.sky.ddt.dto.storageLocation.request.ListStorageLocationRequest;
import com.sky.ddt.dto.storageLocation.request.SaveStorageLocationRequest;
import com.sky.ddt.dto.storageLocation.response.ListStorageLocationResponse;
import com.sky.ddt.dto.storageLocation.response.StorageLocationCmoboboxResponse;
import com.sky.ddt.dto.transportType.request.ListTransportTypeRequest;
import com.sky.ddt.entity.TransportType;
import com.sky.ddt.service.IStorageLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author sky
 * @Description 库存管理
 * @date 2022/1/3 20:39
 */
@RequestMapping("/storageLocation")
@Controller
public class StorageLocationController extends SuperController{
    @Autowired
    IStorageLocationService storageLocationService;
    @RequestMapping("/index")
    @MenuAnnotation("storageLocation/index")
    public String index() {
        return "storageLocation/list";
    }
    @RequestMapping("/listStorageLocation")
    @ResponseBody
    @MenuAnnotation("storageLocation/index")
    public DataGridResponse listStorageLocation(ListStorageLocationRequest params) {
        PageInfo<ListStorageLocationResponse> page = storageLocationService.listStorageLocation(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    @RequestMapping("/saveStorageLocation")
    @ResponseBody
    @MenuAnnotation("storageLocation/index")
    public BaseResponse saveStorageLocation(SaveStorageLocationRequest params) {
        Integer dealUserId = getCurrentUserId();
        return storageLocationService.saveStorageLocation(params,dealUserId);
    }
    @RequestMapping("/importStorageLocation")
    @ResponseBody
    @MenuAnnotation("storageLocation/index")
    public BaseResponse importStorageLocation(MultipartFile file) {
        Integer dealUserId = getCurrentUserId();
        return storageLocationService.importStorageLocation(file, dealUserId);
    }
    @RequestMapping("/comboboxlist")
    @ResponseBody
    public List<StorageLocationCmoboboxResponse> comboboxlist() {
        List<StorageLocationCmoboboxResponse> list=storageLocationService.comboboxlist();
        return list;
    }
}
