package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.fbaPackingListRemarkHis.req.ListFbaPackingListRemarkHisReq;
import com.sky.ddt.dto.fbaPackingListRemarkHis.resp.ListFbaPackingListRemarkHisResp;
import com.sky.ddt.dto.internalOrderNumberFinancialRemarkHis.req.ListInternalOrderNumberFinancialRemarkHisReq;
import com.sky.ddt.dto.internalOrderNumberFinancialRemarkHis.resp.ListInternalOrderNumberFinancialRemarkHisResp;
import com.sky.ddt.service.IFbaPackingListRemarkHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sky
 * @Description FbaPackingListRemarkHisController
 * @date 2023/3/16 22:33
 */
@Controller
@RequestMapping("/fbaPackingListRemarkHis")
public class FbaPackingListRemarkHisController extends SuperController{
    @Autowired
    IFbaPackingListRemarkHisService fbaPackingListRemarkHisService;

    @RequestMapping("/listFbaPackingListRemarkHis")
    @ResponseBody
    @MenuAnnotation("fbaPackingList/index")
    public DataGridResponse listFbaPackingListRemarkHis(ListFbaPackingListRemarkHisReq params) {
        PageInfo<ListFbaPackingListRemarkHisResp> page = fbaPackingListRemarkHisService.listFbaPackingListRemarkHis(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
}
