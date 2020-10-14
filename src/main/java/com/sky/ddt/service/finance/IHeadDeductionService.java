package com.sky.ddt.service.finance;

import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.response.BaseResponse;

/**
 * @author baixueping
 * @description 头程抵扣
 * @date 2019/12/12 9:34
 */
public interface IHeadDeductionService {
    /**
     * @param
     * @return
     * @description 导入头程抵扣
     * @author baixueping
     * @date 2019/12/12 9:49
    */
    BaseResponse importHeadDeduction(ImportFinanceRequest params, Integer dealUserId);
}
