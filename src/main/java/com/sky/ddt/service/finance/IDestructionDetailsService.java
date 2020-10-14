package com.sky.ddt.service.finance;

import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.response.BaseResponse;

/**
 * @author baixueping
 * @description 销毁明细
 * @date 2019/12/11 15:19
 */
public interface IDestructionDetailsService {
    /**
     * @param
     * @return
     * @description 导入销毁明细
     * @author baixueping
     * @date 2019/12/11 15:30
    */
    BaseResponse importDestructionDetails(ImportFinanceRequest params, Integer dealUserId);
}
