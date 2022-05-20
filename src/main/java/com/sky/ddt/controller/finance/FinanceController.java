package com.sky.ddt.controller.finance;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.Action;
import com.sky.ddt.common.annotation.LogRequest;
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
@RequestMapping("/finance")
public class FinanceController extends SuperController {

    @Autowired
    IFinanceService financeService;

    /**
     * @param
     * @return
     * @description 财务统计统计信息
     * @author baixueping
     * @date 2019/11/19 15:51
     */
    @RequestMapping("/countIndex")
    public String importIndex() {
        return "finance/listCount";
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
    /**
     * @param
     * @return
     * @description 财务统计列表页面
     * @author baixueping
     * @date 2019/11/19 15:51
     */
    @RequestMapping("/operatorList")
    public String operatorList() {
        return "finance/operatorList";
    }
    @RequestMapping("list")
    @ResponseBody
    public DataGridResponse list(FinanceListRequest params) {
        params.setCurrentUserId(getCurrentUserId());
        PageInfo<FinanceListResponse> page = financeService.list(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    //importFinance
    @RequestMapping("/importFinance")
    @ResponseBody
    @LogRequest(action = Action.Skip)
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

    @RequestMapping("/unlockFinance")
    @ResponseBody
    @MenuAnnotation("finance/index")
    public BaseResponse unlockFinance(Integer id) {
        Integer dealUserId = getCurrentUserId();
        return financeService.unlockFinance(id, dealUserId);
    }

    @RequestMapping("/lockFinanceStatistic")
    @ResponseBody
    @MenuAnnotation("finance/index")
    public BaseResponse lockFinanceStatistic(Integer id) {
        Integer dealUserId = getCurrentUserId();
        return financeService.lockFinanceStatistic(id, dealUserId);
    }
    @RequestMapping("/unlockFinanceStatistic")
    @ResponseBody
    @MenuAnnotation("finance/index")
    public BaseResponse unlockFinanceStatistic(Integer id) {
        Integer dealUserId = getCurrentUserId();
        return financeService.unlockFinanceStatistic(id, dealUserId);
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
