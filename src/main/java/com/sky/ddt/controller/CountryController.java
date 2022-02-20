package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.dto.country.req.ListCountryReq;
import com.sky.ddt.dto.country.req.SaveCountryReq;
import com.sky.ddt.dto.country.resp.CountryComboxResp;
import com.sky.ddt.dto.country.resp.ListCountryResp;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author sky
 * @Description 国家管理
 * @date 2022/2/20 22:26
 */
@Controller
@RequestMapping("/country")
public class CountryController extends SuperController{
    @Autowired
    ICountryService countryService;
    @RequestMapping("/index")
    @MenuAnnotation("country/index")
    public String index() {
        return "country/list";
    }

    @RequestMapping("/listCountry")
    @ResponseBody
    @MenuAnnotation("country/index")
    public DataGridResponse listCountry(ListCountryReq params) {
        PageInfo<ListCountryResp> page = countryService.listCountry(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    @RequestMapping("/saveCountry")
    @ResponseBody
    @MenuAnnotation("country/index")
    public BaseResponse saveCountry(SaveCountryReq params) {
        Integer dealUserId = getCurrentUserId();
        return countryService.saveCountry(params, dealUserId);
    }
    @RequestMapping("/countryComboboxlist")
    @ResponseBody
    @MenuAnnotation("country/index")
    public List<CountryComboxResp> countryComboboxlist() {
        return countryService.countryComboboxlist();
    }

}
