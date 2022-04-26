package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.common.annotation.RightAnnotation;
import com.sky.ddt.common.constant.ShopSkuConstant;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.fbaInventoryDistribution.req.DownFbaInventoryDistributionReq;
import com.sky.ddt.dto.fbaInventoryDistribution.req.ListFbaInventoryDistributionReq;
import com.sky.ddt.dto.fbaInventoryDistribution.resp.ListFbaInventoryDistributionResp;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopSku.request.ListShopSkuRequest;
import com.sky.ddt.dto.shopSku.response.ExportShopSkuResponse;
import com.sky.ddt.entity.FbaInventoryDistribution;
import com.sky.ddt.service.IFbaInventoryDistributionService;
import com.sky.ddt.util.ExcelExportByExcelFieldUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @Description TODO
 * @date 2022/4/21 23:29
 */
@Controller
@RequestMapping("/fbaInventoryDistribution")
public class FbaInventoryDistributionController extends SuperController {
    @Autowired
    IFbaInventoryDistributionService fbaInventoryDistributionService;
    @RequestMapping("/index")
    @MenuAnnotation("fbaInventoryDistribution/index")
    public String index() {
        return "fbaInventoryDistribution/list";
    }

    @RequestMapping("/listFbaInventoryDistribution")
    @ResponseBody
    @MenuAnnotation("fbaInventoryDistribution/index")
    public DataGridResponse listFbaInventoryDistribution(ListFbaInventoryDistributionReq params) {
        PageInfo<ListFbaInventoryDistributionResp> page = fbaInventoryDistributionService.listFbaInventoryDistribution(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    @RequestMapping("/importFbaInventoryDistribution")
    @ResponseBody
    @MenuAnnotation("fbaInventoryDistribution/index")
    public BaseResponse importFbaInventoryDistribution(MultipartFile file) {
        Integer dealUserId = getCurrentUserId();
        return fbaInventoryDistributionService.importFbaInventoryDistribution(file, dealUserId);
    }
    @RequestMapping("/downFbaInventoryDistribution")
    @ResponseBody
    @RightAnnotation("fbaInventoryDistribution/index")
    public BaseResponse downFbaInventoryDistribution(@Validated DownFbaInventoryDistributionReq params) {
        return fbaInventoryDistributionService.downFbaInventoryDistribution(params,response);
    }
}
