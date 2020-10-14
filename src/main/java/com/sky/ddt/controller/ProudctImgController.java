package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.Action;
import com.sky.ddt.common.annotation.LogRequest;
import com.sky.ddt.common.annotation.Login;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.productimg.request.ProductImgAddRequest;
import com.sky.ddt.dto.productimg.request.ProductImgListRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.ProductImg;
import com.sky.ddt.service.IProductImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@RestController
@RequestMapping("productImg")
public class ProudctImgController extends SuperController{
    @Autowired
    IProductImgService productImgService;
    @RequestMapping("add")
    @LogRequest(action = Action.Skip)
    public BaseResponse addProductImg(ProductImgAddRequest params){
        Integer dealUserId=getCurrentUserId();
        return productImgService.addProductImg(params,dealUserId);
    }

    @RequestMapping("list")
    public DataGridResponse list(ProductImgListRequest params){
        PageInfo<ProductImg> page=productImgService.list(params);
        DataGridResponse dataGridResponse=new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("delete")
    @ResponseBody
    public BaseResponse delete(@RequestParam(required = false, value = "ids[]") List<Integer> ids) {
        return productImgService.delete(ids);
    }
    @RequestMapping("get")
    public void get(Integer id) throws IOException {
        ProductImg productImg=productImgService.getProductImgById(id);
        response.setContentType("image/jpeg");  //设置图片格式
        OutputStream out = response.getOutputStream(); //打开输出流
        out.write(productImg.getImgData());  //输出图片
        out.flush();	//输出
        out.close();  //关闭输出
    }
}
