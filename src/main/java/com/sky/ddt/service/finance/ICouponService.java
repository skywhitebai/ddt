package com.sky.ddt.service.finance;

import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.response.BaseResponse;

/**
 * @author baixueping
 * @description 优惠券
 * @date 2019/12/5 18:13
 */
public interface ICouponService {
    /**
     * @param
     * @return
     * @description 导入优惠券
     * @author baixueping
     * @date 2019/12/5 18:32
    */
    BaseResponse importCoupon(ImportFinanceRequest params, Integer dealUserId);
}
