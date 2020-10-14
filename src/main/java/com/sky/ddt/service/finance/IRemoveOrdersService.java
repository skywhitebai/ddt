package com.sky.ddt.service.finance;

import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.response.BaseResponse;

/**
 * @author baixueping
 * @description 移除订单服务
 * @date 2019/12/3 16:38
 */
public interface IRemoveOrdersService {
    /**
     * @param
     * @return
     * @description 导入移除订单
     * @author baixueping
     * @date 2019/12/3 16:43
    */
    BaseResponse importRemoveOrders(ImportFinanceRequest params, Integer dealUserId);
}
