package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.*;
import com.sky.ddt.common.constant.ProductConstant;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.product.request.ProductListRequest;
import com.sky.ddt.dto.product.request.ProductSaveRequest;
import com.sky.ddt.dto.product.response.ProductExportInfoResponse;
import com.sky.ddt.dto.product.response.ProductListResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.Product;
import com.sky.ddt.service.IProductService;
import com.sky.ddt.util.ExcelExportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProudctController extends SuperController {
    @Autowired
    IProductService productService;
    @RequestMapping("/index")
    @MenuAnnotation("product/index")
    public  String index(){
        return "product/list";
    }

    @RequestMapping("/productList")
    @MenuAnnotation("product/index")
    public  String productList(){
        return "product/productList";
    }

    @RequestMapping("list")
    @ResponseBody
    @MenuAnnotation("product/index")
    public DataGridResponse list(ProductListRequest params) {
        PageInfo<ProductListResponse> page=productService.list(params);
        DataGridResponse dataGridResponse=new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("save")
    @ResponseBody
    @RightAnnotation("product/saveProduct")
    public BaseResponse save(@Validated ProductSaveRequest params) {
        Integer dealUserId=getCurrentUserId();
        return productService.save(params,dealUserId);
    }
    @RequestMapping("delete")
    @RightAnnotation("product/deleteProduct")
    public BaseResponse delete(@RequestParam(required = false, value = "productIds[]") List<Integer> productIds) {
        Integer dealUserId=getCurrentUserId();
        return productService.delete(productIds,dealUserId);
    }
    @RequestMapping("/importProduct")
    @ResponseBody
    @RightAnnotation("product/importProduct")
    public BaseResponse importProduct(MultipartFile file) {
        Integer dealUserId=getCurrentUserId();
        return productService.importProduct(file,dealUserId);
    }
    @RequestMapping("exportProduct")
    @RightAnnotation("product/exportProduct")
    public BaseResponse exportProduct(ProductListRequest params) {
        List<ProductExportInfoResponse> list=productService.listProductExportInfo(params);
        BaseResponse exportResponse= new ExcelExportUtil<ProductExportInfoResponse>().export(response,list, ProductConstant.EXPORT_PRODUCT_HEAD,"产品信息");
        return exportResponse;
    }
    @RequestMapping("/importDeveloperUser")
    @ResponseBody
    @RightAnnotation("product/importDeveloperUser")
    public BaseResponse importDeveloperUser(MultipartFile file) {
        Integer dealUserId=getCurrentUserId();
        return productService.importDeveloperUser(file,dealUserId);
    }
}
