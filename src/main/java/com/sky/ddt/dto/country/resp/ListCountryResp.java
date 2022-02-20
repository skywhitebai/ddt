package com.sky.ddt.dto.country.resp;

import com.sky.ddt.entity.Country;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author sky
 * @Description 列表查询国家信息
 * @date 2022/2/20 22:31
 */
@Data
public class ListCountryResp extends Country {
    String currencyName;
    BigDecimal exchangeRate;
}
