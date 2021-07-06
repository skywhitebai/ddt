package com.sky.ddt.service.finance;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.finance.financeStatistic.request.ListFinanceStatisticRequest;
import com.sky.ddt.dto.finance.financeStatistic.request.SaveFinanceStatisticManualAdjustmentRequest;
import com.sky.ddt.dto.finance.financeStatistic.request.SaveFinanceStatisticRemarkRequest;
import com.sky.ddt.dto.finance.financeStatistic.response.ListFinanceStatisticResponse;
import com.sky.ddt.dto.response.BaseResponse;

import javax.servlet.http.HttpServletResponse;

/**
 * @author baixueping
 * @description 财务回款统计信息
 * @date 2021/7/5 11:39
 */
public interface IFinanceStatisticService {
    /**
     * @param
     * @return
     * @description 生成财务回款信息
     * @author baixueping
     * @date 2021/7/5 15:12
     */
    BaseResponse createFinanceStatistic(Integer financeId, Integer dealUserId);

    PageInfo<ListFinanceStatisticResponse> listFinanceStatistic(ListFinanceStatisticRequest params);

    BaseResponse exportFinanceStatistic(HttpServletResponse response, ListFinanceStatisticRequest params);

    BaseResponse saveFinanceStatisticManualAdjustment(SaveFinanceStatisticManualAdjustmentRequest params, Integer dealUserId);

    BaseResponse saveFinanceStatisticRemark(SaveFinanceStatisticRemarkRequest params, Integer dealUserId);
}
