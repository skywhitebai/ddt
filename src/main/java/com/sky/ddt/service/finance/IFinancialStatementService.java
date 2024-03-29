package com.sky.ddt.service.finance;

import com.sky.ddt.dto.response.BaseResponse;

import javax.servlet.http.HttpServletResponse;

/**
 * @author baixueping
 * @description 财务报表服务
 * @date 2019/12/24 11:28
 */
public interface IFinancialStatementService {
    /**
     * @param
     * @return
     * @description
     * @author baixueping
     * @date 2019/12/24 11:39
     */
    BaseResponse createFinancialStatement(Integer financeId, Integer dealUserId);

    /**
     * @param
     * @param response
     * @return
     * @description 导出财务报表
     * @author baixueping
     * @date 2019/12/25 9:48
     */
    BaseResponse exportFinancialStatement(HttpServletResponse response, Integer financeId);

    /**
     * @param
     * @return
     * @description 导出制定月份财务数据
     * @author baixueping
     * @date 2020/12/15 14:42
     */
    BaseResponse exportFinancialStatement(HttpServletResponse response, String month, String type);

    BaseResponse exportFinancialStatementAll(HttpServletResponse response, String month);
}
