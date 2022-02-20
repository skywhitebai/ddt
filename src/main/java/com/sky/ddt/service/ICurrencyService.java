package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.currency.req.ListCurrencyReq;
import com.sky.ddt.dto.currency.req.SaveCurrencyReq;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.Currency;

/**
 * @author sky
 * @Description 货币服务
 * @date 2022/2/20 15:15
 */
public interface ICurrencyService {
    PageInfo<Currency> listCurrency(ListCurrencyReq params);

    BaseResponse saveCurrency(SaveCurrencyReq params, Integer dealUserId);
}
