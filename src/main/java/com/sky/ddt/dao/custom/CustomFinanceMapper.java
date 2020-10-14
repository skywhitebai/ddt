package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.FinanceMapper;
import com.sky.ddt.dto.finance.request.FinanceListRequest;
import com.sky.ddt.dto.finance.response.FbaCustomerReturnPerUnitFeeNotExistSkuResponse;
import com.sky.ddt.dto.finance.response.FinanceListResponse;

import java.util.List;

/**
 * @author baixueping
 * @description 财务管理接口
 * @date 2019/11/20 16:03
 */
public interface CustomFinanceMapper extends FinanceMapper {
    List<FinanceListResponse> financeList(FinanceListRequest params);

    List<FbaCustomerReturnPerUnitFeeNotExistSkuResponse> listFbaCustomerReturnPerUnitFeeNotExistSkuResponse(Integer financeId);
}
