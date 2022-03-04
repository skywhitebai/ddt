package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.InternalOrderNumberFinancialRemarkHisMapper;
import com.sky.ddt.dto.internalOrderNumber.request.ListInternalOrderNumberRequest;
import com.sky.ddt.dto.internalOrderNumberFinancialRemarkHis.req.ListInternalOrderNumberFinancialRemarkHisReq;
import com.sky.ddt.dto.internalOrderNumberFinancialRemarkHis.resp.ListInternalOrderNumberFinancialRemarkHisResp;

import java.util.List;

/**
 * @author sky
 * @Description 内部单号财务备注
 * @date 2022/3/4 21:53
 */
public interface CustomInternalOrderNumberFinancialRemarkHisMapper extends InternalOrderNumberFinancialRemarkHisMapper {

    List<ListInternalOrderNumberFinancialRemarkHisResp> listInternalOrderNumberFinancialRemarkHis(ListInternalOrderNumberFinancialRemarkHisReq params);
}
