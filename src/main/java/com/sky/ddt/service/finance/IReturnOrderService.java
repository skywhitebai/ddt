package com.sky.ddt.service.finance;

import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.response.BaseResponse;

/**
 * @author baixueping
 * @description 退换货订单
 * @date 2019/12/4 11:25
 */
public interface IReturnOrderService {

    BaseResponse importReturnOrder(ImportFinanceRequest params, Integer dealUserId);
}
