package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.enums.YesOrNoEnum;
import com.sky.ddt.dao.custom.CustomCountryMapper;
import com.sky.ddt.dao.custom.CustomCurrencyMapper;
import com.sky.ddt.dto.country.req.ListCountryReq;
import com.sky.ddt.dto.country.req.SaveCountryReq;
import com.sky.ddt.dto.country.resp.CountryComboxResp;
import com.sky.ddt.dto.country.resp.ListCountryResp;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.Country;
import com.sky.ddt.entity.CountryExample;
import com.sky.ddt.entity.Currency;
import com.sky.ddt.service.ICountryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @Description 国家管理
 * @date 2022/2/20 16:30
 */
@Service
public class CountryService implements ICountryService {
    @Autowired
    CustomCountryMapper customCountryMapper;
    @Autowired
    CustomCurrencyMapper customCurrencyMapper;
    @Override
    public PageInfo<ListCountryResp> listCountry(ListCountryReq params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListCountryResp> list = customCountryMapper.listCountry(params);
        PageInfo<ListCountryResp> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public BaseResponse saveCountry(SaveCountryReq params, Integer dealUserId) {
        Country country = new Country();
        if (params.getId() != null) {
            Country countryOld = customCountryMapper.selectByPrimaryKey(params.getId());
            if (countryOld == null) {
                return BaseResponse.failMessage("国家id不存在");
            }
        }
        if(!YesOrNoEnum.containValue(params.getStatus())){
            return BaseResponse.failMessage("状态错误");
        }
        if (notExistCurrency(params.getCurrencyId())) {
            return BaseResponse.failMessage("货币id不存在");
        }
        BeanUtils.copyProperties(params, country);
        if (existCountryName(params)) {
            return BaseResponse.failMessage("国家名称已存在");
        }
        if (country.getId() == null) {
            country.setCreateBy(dealUserId);
            country.setCreateTime(new Date());
            customCountryMapper.insertSelective(country);
        } else {
            country.setUpdateBy(dealUserId);
            country.setUpdateTime(new Date());
            customCountryMapper.updateByPrimaryKeySelective(country);
        }
        return BaseResponse.success();
    }

    @Override
    public Country getCountry(Integer countryId) {
        if(countryId==null){
            return null;
        }
        return customCountryMapper.selectByPrimaryKey(countryId);
    }

    @Override
    public List<CountryComboxResp> countryComboboxlist() {
        return customCountryMapper.countryComboboxlist();
    }

    private boolean existCountryName(SaveCountryReq params) {
        CountryExample countryExample=new CountryExample();
        CountryExample.Criteria criteria=countryExample.createCriteria();
        criteria.andCountryNameEqualTo(params.getCountryName());
        if(params.getId()!=null){
            criteria.andIdNotEqualTo(params.getId());
        }
        return customCountryMapper.countByExample(countryExample)>0;
    }

    private boolean notExistCurrency(Integer currencyId) {
        if(currencyId==null){
            return true;
        }
        Currency currency=customCurrencyMapper.selectByPrimaryKey(currencyId);
        if(currency==null){
            return true;
        }
        return false;
    }
}
