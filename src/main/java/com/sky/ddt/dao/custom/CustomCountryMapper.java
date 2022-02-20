package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.CountryMapper;
import com.sky.ddt.dao.generate.CurrencyMapper;
import com.sky.ddt.dto.country.req.ListCountryReq;
import com.sky.ddt.dto.country.resp.CountryComboxResp;
import com.sky.ddt.dto.country.resp.ListCountryResp;

import java.util.List;

/**
 * @author sky
 * @Description 国家管理
 * @date 2022/2/20 15:12
 */
public interface CustomCountryMapper extends CountryMapper {
    List<ListCountryResp> listCountry(ListCountryReq params);

    List<CountryComboxResp> countryComboboxlist();
}
