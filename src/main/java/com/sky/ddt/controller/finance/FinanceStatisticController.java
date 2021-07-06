package com.sky.ddt.controller.finance;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.controller.SuperController;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.finance.financeStatistic.request.ListFinanceStatisticRequest;
import com.sky.ddt.dto.finance.financeStatistic.response.ListFinanceStatisticResponse;
import com.sky.ddt.dto.finance.request.FinanceListRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.FinanceStatistic;
import com.sky.ddt.service.finance.IFinanceStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author baixueping
 * @description 财务回款信息
 * @date 2021/7/5 11:32
 */
@Controller
@RequestMapping("/financeStatistic")
public class FinanceStatisticController extends SuperController {
    @Autowired
    IFinanceStatisticService financeStatisticService;
    @RequestMapping("/index")
    public String index() {
        return "finance/financeStatistic/list";
    }
    @RequestMapping("/createFinanceStatistic")
    @ResponseBody
    @MenuAnnotation("finance/index")
    public BaseResponse createFinanceStatistic(Integer financeId) {
        Integer dealUserId = getCurrentUserId();
        return financeStatisticService.createFinanceStatistic(financeId, dealUserId);
    }
    @RequestMapping("/listFinanceStatistic")
    @ResponseBody
    public DataGridResponse listFinanceStatistic(ListFinanceStatisticRequest params) {
        PageInfo<ListFinanceStatisticResponse> page = financeStatisticService.listFinanceStatistic(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("/exportFinanceStatistic")
    @ResponseBody
    @MenuAnnotation("financeStatistic/index")
    public BaseResponse exportFinanceStatistic(ListFinanceStatisticRequest params) {
        return financeStatisticService.exportFinanceStatistic(response,params);
    }
}
