package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.FinancialStatementMapper;
import com.sky.ddt.dto.finance.response.FinancialStatementResponse;

import java.util.List;

/**
 * @author baixueping
 * @description 财务报表
 * @date 2019/12/24 11:31
 */
public interface CustomFinancialStatementMapper extends FinancialStatementMapper {
    /**
     * @param
     * @return
     * @description 获取财务报表信息
     * @author baixueping
     * @date 2019/12/24 12:33
     */
    List<FinancialStatementResponse> getFinancialStatementResponse(Integer financeId);
}
