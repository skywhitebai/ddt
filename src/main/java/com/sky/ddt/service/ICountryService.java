package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.country.req.ListCountryReq;
import com.sky.ddt.dto.country.req.SaveCountryReq;
import com.sky.ddt.dto.country.resp.CountryComboxResp;
import com.sky.ddt.dto.country.resp.ListCountryResp;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.Country;

import java.util.List;

/**
 * @author sky
 * @Description 国家管理
 * @date 2022/2/20 16:29
 */
public interface ICountryService {
    PageInfo<ListCountryResp> listCountry(ListCountryReq params);

    BaseResponse saveCountry(SaveCountryReq params, Integer dealUserId);

    Country getCountry(Integer countryId);

    List<CountryComboxResp> countryComboboxlist();
}
