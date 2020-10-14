package com.sky.ddt.service.finance;

import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.response.BaseResponse;

/**
 * @author baixueping
 * @description 月广告费
 * @date 2019/12/4 15:53
 */
public interface IMonthlyAdvertisingFeeService {
    /**
     * @param
     * @return
     * @description 导入月广告费
     * @author baixueping
     * @date 2019/12/4 16:02
    */
    BaseResponse importMonthlyAdvertisingFee(ImportFinanceRequest params, Integer dealUserId);
}
