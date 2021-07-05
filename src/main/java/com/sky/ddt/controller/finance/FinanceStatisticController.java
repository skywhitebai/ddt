package com.sky.ddt.controller.finance;

import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.controller.SuperController;
import com.sky.ddt.dto.response.BaseResponse;
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
@RequestMapping("financeStatistic")
public class FinanceStatisticController extends SuperController {
    @Autowired
    IFinanceStatisticService financeStatisticService;
    @RequestMapping("/createFinanceStatistic")
    @ResponseBody
    @MenuAnnotation("finance/index")
    public BaseResponse createFinanceStatistic(Integer financeId) {
        Integer dealUserId = getCurrentUserId();
        return financeStatisticService.createFinanceStatistic(financeId, dealUserId);
    }
}
