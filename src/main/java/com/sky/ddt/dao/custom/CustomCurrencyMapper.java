package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.CurrencyMapper;
import com.sky.ddt.dto.currency.resp.CurrencyComboxResp;

import java.util.List;

/**
 * @author sky
 * @Description 货币类型
 * @date 2022/2/20 15:12
 */
public interface CustomCurrencyMapper extends CurrencyMapper {
    List<CurrencyComboxResp> currencyComboboxlist();
}
