package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.dao.custom.CustomFbaPackingListRemarkHisMapper;
import com.sky.ddt.dto.fbaPackingListRemarkHis.req.ListFbaPackingListRemarkHisReq;
import com.sky.ddt.dto.fbaPackingListRemarkHis.resp.ListFbaPackingListRemarkHisResp;
import com.sky.ddt.dto.internalOrderNumberFinancialRemarkHis.resp.ListInternalOrderNumberFinancialRemarkHisResp;
import com.sky.ddt.service.IFbaPackingListRemarkHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sky
 * @Description FbaPackingListRemarkHisService
 * @date 2023/3/16 22:34
 */
@Service
public class FbaPackingListRemarkHisService implements IFbaPackingListRemarkHisService {
    @Autowired
    CustomFbaPackingListRemarkHisMapper customFbaPackingListRemarkHisMapper;

    @Override
    public PageInfo<ListFbaPackingListRemarkHisResp> listFbaPackingListRemarkHis(ListFbaPackingListRemarkHisReq params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListFbaPackingListRemarkHisResp> list = customFbaPackingListRemarkHisMapper.listFbaPackingListRemarkHis(params);
        PageInfo<ListFbaPackingListRemarkHisResp> page = new PageInfo<>(list);
        return page;
    }
}
