package com.sky.ddt.dto.finance.financeStatistic.response;

import com.sky.ddt.entity.FinanceStatistic;
import lombok.Data;

/**
 * @author baixueping
 * @description
 * @date 2021/7/6 16:34
 */
@Data
public class ListFinanceStatisticResponse extends FinanceStatistic {
    String monthStr;
}
