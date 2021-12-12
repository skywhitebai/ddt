package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.InventoryQuantityHisConstant;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.inventoryQuantityHis.request.ListInventoryQuantityHisRequest;
import com.sky.ddt.dto.inventoryQuantityHis.response.ListInventoryQuantityHisResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.IProductInventoryQuantityHisService;
import com.sky.ddt.service.ISkuInventoryQuantityHisService;
import com.sky.ddt.util.DateUtil;
import com.sky.ddt.util.ExcelExportByExcelFieldUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @Description 库存历史记录
 * @date 2021/8/21 10:10
 */
@Controller
@RequestMapping("/inventoryQuantityHis")
public class InventoryQuantityHisController extends SuperController {
    @Autowired
    ISkuInventoryQuantityHisService skuInventoryQuantityHisService;
    @Autowired
    IProductInventoryQuantityHisService productInventoryQuantityHisService;
    @RequestMapping("/index")
    public String index() {
        return "inventoryQuantityHis/list";
    }

    @RequestMapping("/listInventoryQuantityHis")
    @ResponseBody
    public DataGridResponse listInventoryQuantityHis(@Validated ListInventoryQuantityHisRequest params) {
        PageInfo<ListInventoryQuantityHisResponse> page=new PageInfo<>();
        if(!StringUtils.isEmpty(params.getMonth())){
            String monthStr = params.getMonth() + "-01";
            Date monthDate = DateUtil.strToDate(monthStr);
            if (monthDate!= null) {
                params.setMonthDate(monthDate);
            }
        }
        if(params.getSearchType().equals("product")){
            page=productInventoryQuantityHisService.listProductInventoryQuantityHis(params);
        }else{
            page=skuInventoryQuantityHisService.listSkuInventoryQuantityHis(params);
        }
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    @RequestMapping("/exportInventoryQuantityHis")
    @ResponseBody
    public BaseResponse exportInventoryQuantityHis(@Validated ListInventoryQuantityHisRequest params) {
        List<ListInventoryQuantityHisResponse> list =new ArrayList<>();
        String fileName="";
        if(params.getSearchType().equals("product")){
            fileName="产品库存历史";
            list=productInventoryQuantityHisService.listExportProductInventoryQuantityHis(params);
        }else{
            fileName="sku库存历史";
            list=skuInventoryQuantityHisService.listExportSkuInventoryQuantityHis(params);
        }


        BaseResponse exportResponse = new ExcelExportByExcelFieldUtil().export(response, list, InventoryQuantityHisConstant.exportInventoryQuantityHisFieldList, fileName);
        return exportResponse;
    }
}
