package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.currency.req.ListCurrencyReq;
import com.sky.ddt.dto.currency.req.SaveCurrencyReq;
import com.sky.ddt.dto.currency.resp.CurrencyComboxResp;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shop.response.ShopComboboxResponse;
import com.sky.ddt.dto.transportType.request.ListTransportTypeRequest;
import com.sky.ddt.dto.transportType.request.SaveTransportTypeRequest;
import com.sky.ddt.entity.Currency;
import com.sky.ddt.entity.TransportType;
import com.sky.ddt.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author sky
 * @Description 货币管理
 * @date 2022/2/20 15:19
 */
@Controller
@RequestMapping("/currency")
public class CurrencyController extends SuperController{
    @Autowired
    ICurrencyService currencyService;
    @RequestMapping("/index")
    @MenuAnnotation("currency/index")
    public String index() {
        return "currency/list";
    }

    @RequestMapping("/listCurrency")
    @ResponseBody
    @MenuAnnotation("currency/index")
    public DataGridResponse listCurrency(ListCurrencyReq params) {
        PageInfo<Currency> page = currencyService.listCurrency(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    @RequestMapping("/saveCurrency")
    @ResponseBody
    @MenuAnnotation("currency/index")
    public BaseResponse saveCurrency(SaveCurrencyReq params) {
        Integer dealUserId = getCurrentUserId();
        return currencyService.saveCurrency(params, dealUserId);
    }
    @RequestMapping("/currencyComboboxlist")
    @ResponseBody
    @MenuAnnotation("currency/index")
    public List<CurrencyComboxResp> currencyComboboxlist() {
        return currencyService.currencyComboboxlist();
    }
}
