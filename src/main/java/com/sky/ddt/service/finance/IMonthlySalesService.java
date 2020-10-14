package com.sky.ddt.service.finance;

import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.response.BaseResponse;

/**
 * @author baixueping
 * @description 月流水
 * @date 2019/11/27 14:24
 */
public interface IMonthlySalesService {
    /**
     * @param
     * @return
     * @description 导入月流水
     * @author baixueping
     * @date 2019/11/27 14:36
    */
    BaseResponse importMonthlySales(ImportFinanceRequest params, Integer dealUserId);
}
