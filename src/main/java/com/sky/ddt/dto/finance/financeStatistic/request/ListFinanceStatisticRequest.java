package com.sky.ddt.dto.finance.financeStatistic.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

import java.util.Date;

/**
 * @author baixueping
 * @description ListFinanceStatisticRequest
 * @date 2021/7/6 11:38
 */
@Data
public class ListFinanceStatisticRequest extends DataGridRequest {
    Integer financeId;
    Integer shopId;
    String month;
    Date monthDate;
}
