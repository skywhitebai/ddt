package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.FinanceStatisticMapper;
import com.sky.ddt.dto.finance.financeStatistic.request.ListFinanceStatisticRequest;
import com.sky.ddt.dto.finance.financeStatistic.response.ListFinanceStatisticResponse;
import com.sky.ddt.entity.FinanceStatistic;

import java.util.List;

/**
 * @author baixueping
 * @description 财务回款统计信息
 * @date 2021/7/5 11:38
 */
public interface CustomFinanceStatisticMapper extends FinanceStatisticMapper {
    FinanceStatistic getFinanceStatisticInfo(Integer financeId);

    List<ListFinanceStatisticResponse> listFinanceStatistic(ListFinanceStatisticRequest params);
}
