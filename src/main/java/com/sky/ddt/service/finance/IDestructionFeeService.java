package com.sky.ddt.service.finance;

import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.response.BaseResponse;

/**
 * @author baixueping
 * @description 销毁费
 * @date 2019/12/5 15:32
 */
public interface IDestructionFeeService {
    /**
     * @param
     * @return
     * @description 导入销毁费
     * @author baixueping
     * @date 2019/12/5 15:38
    */
    BaseResponse importDestructionFee(ImportFinanceRequest params, Integer dealUserId);
}
