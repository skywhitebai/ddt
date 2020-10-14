package com.sky.ddt.service.finance;

import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.response.BaseResponse;

/**
 * @author baixueping
 * @description 人工调整
 * @date 2020/1/6 10:00
 */
public interface IManualAdjustmentService {
    BaseResponse importManualAdjustment(ImportFinanceRequest params, Integer dealUserId);
}
