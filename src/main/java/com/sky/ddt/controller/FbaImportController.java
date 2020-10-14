package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.fbaImport.request.ListFbaImportRequest;
import com.sky.ddt.dto.fbaImport.response.ListFbaImportResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.IFbaImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author baixueping
 * @description FBA导入管理
 * @date 2019/8/15 10:13
 */
@Controller
@RequestMapping("/fbaImport")
public class FbaImportController extends SuperController {
    @Autowired
    IFbaImportService fbaImportService;

    /**
     * @param
     * @return
     * @description fba导入页面
     * @author baixueping
     * @date 2019/8/15 10:22
     */
    @RequestMapping("/index")
    @MenuAnnotation("fbaImport/index")
    public String index() {
        return "fbaImport/list";
    }

    @RequestMapping("/importFba")
    @ResponseBody
    @MenuAnnotation("fbaImport/index")
    public BaseResponse importOrder(MultipartFile file) {
        Integer dealUserId = getCurrentUserId();
        return fbaImportService.importFba(file, dealUserId);
    }
    @RequestMapping("/listFbaImport")
    @ResponseBody
    @MenuAnnotation("fbaImport/index")
    public DataGridResponse listOrderImport(ListFbaImportRequest params) {
        params.setUserId(getCurrentUserId());
        PageInfo<ListFbaImportResponse> page = fbaImportService.listFbaImport(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
}
