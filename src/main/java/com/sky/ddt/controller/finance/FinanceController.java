package com.sky.ddt.controller.finance;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.controller.SuperController;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.finance.request.FinanceListRequest;
import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.finance.request.SaveFinanceRemarkRequest;
import com.sky.ddt.dto.finance.response.FinanceListResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.finance.IFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author baixueping
 * @description 财务统计
 * @date 2019/11/19 15:49
 */
@Controller
@RequestMapping("finance")
public class FinanceController extends SuperController {

    @Autowired
    IFinanceService financeService;

    /**
     * @param
     * @return
     * @description 财务统计导入页面
     * @author baixueping
     * @date 2019/11/19 15:51
     */
    @RequestMapping("/importIndex")
    public String importIndex() {
        return "finance/importIndex";
    }

    /**
     * @param
     * @return
     * @description 财务统计列表页面
     * @author baixueping
     * @date 2019/11/19 15:51
     */
    @RequestMapping("/index")
    public String index() {
        return "finance/list";
    }

    @RequestMapping("list")
    @ResponseBody
    public DataGridResponse list(FinanceListRequest params) {
        PageInfo<FinanceListResponse> page = financeService.list(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    //importFinance
    @RequestMapping("/importFinance")
    @ResponseBody
    @MenuAnnotation("finance/index")
    public BaseResponse importFinance(ImportFinanceRequest params) {
        Integer dealUserId = getCurrentUserId();
        return financeService.importFinance(params, dealUserId);
    }
    @RequestMapping("/lockFinance")
    @ResponseBody
    @MenuAnnotation("finance/index")
    public BaseResponse lockFinance(Integer id) {
        Integer dealUserId = getCurrentUserId();
        return financeService.lockFinance(id, dealUserId);
    }
    @RequestMapping("/exportFbaCustomerReturnPerUnitFeeNotExistSku")
    @ResponseBody
    @MenuAnnotation("finance/index")
    public BaseResponse exportFbaCustomerReturnPerUnitFeeNotExistSku(Integer financeId) {
        return financeService.exportFbaCustomerReturnPerUnitFeeNotExistSku(response,financeId);
    }
    @RequestMapping("/saveFinanceRemark")
    @ResponseBody
    @MenuAnnotation("finance/index")
    public BaseResponse saveFinanceRemark(SaveFinanceRemarkRequest params) {
        Integer dealUserId = getCurrentUserId();
        return financeService.saveFinanceRemark(params, dealUserId);
    }
}
