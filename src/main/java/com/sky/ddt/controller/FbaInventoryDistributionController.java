package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.fbaInventoryDistribution.req.ListFbaInventoryDistributionReq;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.FbaInventoryDistribution;
import com.sky.ddt.service.IFbaInventoryDistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
        PageInfo<FbaInventoryDistribution> page = fbaInventoryDistributionService.listFbaInventoryDistribution(params);
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
}
