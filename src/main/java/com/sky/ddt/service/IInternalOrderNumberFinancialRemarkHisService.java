package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.internalOrderNumberFinancialRemarkHis.req.ListInternalOrderNumberFinancialRemarkHisReq;
import com.sky.ddt.dto.internalOrderNumberFinancialRemarkHis.resp.ListInternalOrderNumberFinancialRemarkHisResp;

/**
 * @author sky
 * @Description TODO
 * @date 2022/3/4 21:56
 */
public interface IInternalOrderNumberFinancialRemarkHisService {

    void addInternalOrderNumberFinancialRemarkHis(String financialRemark, Integer id, Integer dealUserId);

    PageInfo<ListInternalOrderNumberFinancialRemarkHisResp> listInternalOrderNumberFinancialRemarkHis(ListInternalOrderNumberFinancialRemarkHisReq params);
}
