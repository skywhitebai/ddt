package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.TransportTypeConstant;
import com.sky.ddt.dao.custom.CustomCurrencyMapper;
import com.sky.ddt.dto.currency.req.ListCurrencyReq;
import com.sky.ddt.dto.currency.req.SaveCurrencyReq;
import com.sky.ddt.dto.currency.resp.CurrencyComboxResp;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.Currency;
import com.sky.ddt.entity.CurrencyExample;
import com.sky.ddt.entity.TransportType;
import com.sky.ddt.service.ICurrencyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @Description 货币服务
 * @date 2022/2/20 15:16
 */
@Service
public class CurrencyService implements ICurrencyService {
    @Autowired
    CustomCurrencyMapper customCurrencyMapper;

    @Override
    public PageInfo<Currency> listCurrency(ListCurrencyReq params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        CurrencyExample example = new CurrencyExample();
        if (!StringUtils.isEmpty(params.getCurrencyName())) {
            example.createCriteria().andCurrencyNameLike("%" + params.getCurrencyName() + "%");
        }
        if (!StringUtils.isEmpty(params.getCurrencyCode())) {
            example.createCriteria().andCurrencyCodeLike("%" + params.getCurrencyCode() + "%");
        }
        example.setOrderByClause(" create_time asc ");
        List<Currency> list = customCurrencyMapper.selectByExample(example);
        PageInfo<Currency> page = new PageInfo<Currency>(list);
        return page;
    }

    @Override
    public BaseResponse saveCurrency(SaveCurrencyReq params, Integer dealUserId) {
        Currency currency = new Currency();
        if (params.getId() != null) {
            Currency currencyOld = customCurrencyMapper.selectByPrimaryKey(params.getId());
            if (currencyOld == null) {
                return BaseResponse.failMessage("货币id不存在");
            }
        }
        BeanUtils.copyProperties(params, currency);
        if (existCurrencyName(currency)) {
            return BaseResponse.failMessage("货币名称已存在");
        }
        if (existCurrencyCode(currency)) {
            return BaseResponse.failMessage("货币编码已存在");
        }
        if (currency.getId() == null) {
            currency.setCreateBy(dealUserId);
            currency.setCreateTime(new Date());
            customCurrencyMapper.insertSelective(currency);
        } else {
            currency.setUpdateBy(dealUserId);
            currency.setUpdateTime(new Date());
            customCurrencyMapper.updateByPrimaryKeySelective(currency);
        }
        return BaseResponse.success();
    }

    @Override
    public List<CurrencyComboxResp> currencyComboboxlist() {
        return customCurrencyMapper.currencyComboboxlist();
    }

    private boolean existCurrencyCode(Currency currency) {
        CurrencyExample currencyExample = new CurrencyExample();
        CurrencyExample.Criteria criteriaCurrency = currencyExample.createCriteria();
        criteriaCurrency.andCurrencyCodeEqualTo(currency.getCurrencyCode());
        if (currency.getId() != null) {
            criteriaCurrency.andIdNotEqualTo(currency.getId());
        }
        if (customCurrencyMapper.countByExample(currencyExample) > 0) {
            return true;
        }
        return false;
    }

    private boolean existCurrencyName(Currency currency) {
        CurrencyExample currencyExampleCurrency = new CurrencyExample();
        CurrencyExample.Criteria criteriaCurrency = currencyExampleCurrency.createCriteria();
        criteriaCurrency.andCurrencyNameEqualTo(currency.getCurrencyName());
        if (currency.getId() != null) {
            criteriaCurrency.andIdNotEqualTo(currency.getId());
        }
        if (customCurrencyMapper.countByExample(currencyExampleCurrency) > 0) {
            return true;
        }
        return false;
    }
}
