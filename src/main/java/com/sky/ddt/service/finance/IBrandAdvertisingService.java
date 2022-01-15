package com.sky.ddt.service.finance;

import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.response.BaseResponse;

/**
 * @author sky
 * @Description 展示广告
 * @date 2022/1/13 23:28
 */
public interface IBrandAdvertisingService {
    BaseResponse importBrandAdvertising(ImportFinanceRequest params, Integer dealUserId);
}
