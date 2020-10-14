package com.sky.ddt.service.finance;

import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.response.BaseResponse;

/**
 * @author baixueping
 * @description 长期仓储费
 * @date 2019/12/2 18:25
 */
public interface ILongStorageFeeService {
    /**
     * @param
     * @return
     * @description 导入长期仓储费
     * @author baixueping
     * @date 2019/12/2 18:36
    */
    BaseResponse importLongStorageFee(ImportFinanceRequest params, Integer dealUserId);
}
