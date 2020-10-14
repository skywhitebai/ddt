package com.sky.ddt.service.finance;

import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.response.BaseResponse;

/**
 * @author baixueping
 * @description 早评
 * @date 2019/12/5 19:00
 */
public interface IEarlyReviewerProgramFeeService {
    /**
     * @param
     * @return
     * @description 导入早评
     * @author baixueping
     * @date 2019/12/5 19:11
    */
    BaseResponse importEarlyReviewerProgramFee(ImportFinanceRequest params, Integer dealUserId);
}
