package com.sky.ddt.service.finance;

import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.response.BaseResponse;

/**
 * @author baixueping
 * @description 秒杀
 * @date 2019/12/11 10:21
 */
public interface ILightingDealService {
    /**
     * @param
     * @return
     * @description 导入秒杀
     * @author baixueping
     * @date 2019/12/11 10:27
    */
    BaseResponse importLightingDeal(ImportFinanceRequest params, Integer dealUserId);
}
