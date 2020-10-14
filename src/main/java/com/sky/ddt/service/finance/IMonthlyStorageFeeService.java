package com.sky.ddt.service.finance;

import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.response.BaseResponse;

/**
 * @author baixueping
 * @description 仓储费
 * @date 2019/11/29 15:48
 */
public interface IMonthlyStorageFeeService {
    /**
     * @param
     * @return
     * @description 导入仓储费
     * @author baixueping
     * @date 2019/11/29 15:59
    */
    BaseResponse importMonthlyStorageFee(ImportFinanceRequest params, Integer dealUserId);
}
