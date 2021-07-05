package com.sky.ddt.service.finance;

import com.sky.ddt.dto.response.BaseResponse;

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
}
