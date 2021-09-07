package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.productDevelop.request.ChangeProductDevelopStatusRequest;
import com.sky.ddt.dto.productDevelop.request.ListProductDevelopRequest;
import com.sky.ddt.dto.productDevelop.request.SaveProductDevelopRequest;
import com.sky.ddt.dto.productDevelop.response.ListProductDevelopResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.IProductDevelopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sky
 * @Description 产品开发
 * @date 2021/9/1 21:45
 */
@Controller
@RequestMapping("/productDevelop")
public class ProductDevelopController extends SuperController{
    @Autowired
    IProductDevelopService productDevelopService;
    @RequestMapping("/index")
    @MenuAnnotation("productDevelop/index")
    public  String index(){
        return "productDevelop/list";
    }

    @RequestMapping("/listProductDevelop")
    @ResponseBody
    @MenuAnnotation("productDevelop/index")
    public DataGridResponse list(ListProductDevelopRequest params) {
        PageInfo<ListProductDevelopResponse> page=productDevelopService.listProductDevelop(params);
        DataGridResponse dataGridResponse=new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("/saveProductDevelop")
    @ResponseBody
    @MenuAnnotation("productDevelop/index")
    public BaseResponse saveProductDevelop(@Validated SaveProductDevelopRequest params) {
        Integer dealUserId=getCurrentUserId();
        return productDevelopService.saveProductDevelop(params,dealUserId);
    }
    @RequestMapping("/changeProductDevelopStatus")
    @ResponseBody
    @MenuAnnotation("productDevelop/index")
    public BaseResponse changeProductDevelopStatus(@Validated ChangeProductDevelopStatusRequest params) {
        Integer dealUserId=getCurrentUserId();
        return productDevelopService.changeProductDevelopStatus(params,dealUserId);
    }
}
