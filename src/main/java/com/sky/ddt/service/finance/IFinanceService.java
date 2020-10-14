package com.sky.ddt.service.finance;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.finance.request.FinanceListRequest;
import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.finance.request.SaveFinanceRemarkRequest;
import com.sky.ddt.dto.finance.response.FinanceListResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.Finance;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author baixueping
 * @description 财务服务类
 * @date 2019/11/20 16:05
 */
public interface IFinanceService {
    /**
     * @param
     * @return
     * @description 分页查询财务信息
     * @author baixueping
     * @date 2019/11/20 16:14
     */
    PageInfo<FinanceListResponse> list(FinanceListRequest params);

    /**
     * @param
     * @return
     * @description 导入财务信息
     * @author baixueping
     * @date 2019/11/22 10:22
     */
    BaseResponse importFinance(ImportFinanceRequest params, Integer dealUserId);

    /**
     * @param
     * @param month
     * @return
     * @description 根据shopId和month获取财务信息
     * @author baixueping
     * @date 2019/11/28 11:33
     */
    Finance getFinance(Integer shopId, Date month);

    /**
     * @param
     * @param month
     * @param dealUserId @return
     * @description 获取财务信息
     * @author baixueping
     * @date 2019/12/2 10:35
     */
    BaseResponse<Finance> getOrCreateFinance(Integer shopId, Date month, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 锁定财务报表
     * @author baixueping
     * @date 2019/12/24 11:03
     */
    BaseResponse lockFinance(Integer id, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 获取财务信息
     * @author baixueping
     * @date 2019/12/24 11:41
     */
    Finance getFinance(Integer financeId);

    /**
     * @param
     * @return
     * @description 导出退款费没有sku的订单
     * @author baixueping
     * @date 2019/12/27 11:17
     */
    BaseResponse exportFbaCustomerReturnPerUnitFeeNotExistSku(HttpServletResponse response, Integer financeId);

    /**
     * @param
     * @return
     * @description 保存备注
     * @author baixueping
     * @date 2020/1/3 11:15
     */
    BaseResponse saveFinanceRemark(SaveFinanceRemarkRequest params, Integer dealUserId);
}
