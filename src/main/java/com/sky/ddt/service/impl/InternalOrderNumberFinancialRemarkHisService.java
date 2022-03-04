package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.dao.custom.CustomInternalOrderNumberFinancialRemarkHisMapper;
import com.sky.ddt.dto.internalOrderNumberFinancialRemarkHis.req.ListInternalOrderNumberFinancialRemarkHisReq;
import com.sky.ddt.dto.internalOrderNumberFinancialRemarkHis.resp.ListInternalOrderNumberFinancialRemarkHisResp;
import com.sky.ddt.entity.InternalOrderNumberFinancialRemarkHis;
import com.sky.ddt.service.IInternalOrderNumberFinancialRemarkHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @Description 内部单号财务备注历史
 * @date 2022/3/4 21:56
 */
@Service
public class InternalOrderNumberFinancialRemarkHisService implements IInternalOrderNumberFinancialRemarkHisService {
    @Autowired
    CustomInternalOrderNumberFinancialRemarkHisMapper customInternalOrderNumberFinancialRemarkHisMapper;

    @Override
    public void addInternalOrderNumberFinancialRemarkHis(String financialRemark, Integer internalOrderNumberId, Integer dealUserId) {
        InternalOrderNumberFinancialRemarkHis internalOrderNumberFinancialRemarkHis=new InternalOrderNumberFinancialRemarkHis();
        internalOrderNumberFinancialRemarkHis.setCreateBy(dealUserId);
        internalOrderNumberFinancialRemarkHis.setCreateTime(new Date());
        internalOrderNumberFinancialRemarkHis.setFinancialRemark(financialRemark);
        internalOrderNumberFinancialRemarkHis.setInternalOrderNumberId(internalOrderNumberId);
        customInternalOrderNumberFinancialRemarkHisMapper.insertSelective(internalOrderNumberFinancialRemarkHis);
    }

    @Override
    public PageInfo<ListInternalOrderNumberFinancialRemarkHisResp> listInternalOrderNumberFinancialRemarkHis(ListInternalOrderNumberFinancialRemarkHisReq params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListInternalOrderNumberFinancialRemarkHisResp> list = customInternalOrderNumberFinancialRemarkHisMapper.listInternalOrderNumberFinancialRemarkHis(params);
        PageInfo<ListInternalOrderNumberFinancialRemarkHisResp> page = new PageInfo<ListInternalOrderNumberFinancialRemarkHisResp>(list);
        return page;
    }
}
