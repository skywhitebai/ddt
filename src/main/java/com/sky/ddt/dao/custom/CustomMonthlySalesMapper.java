package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.MonthlySalesMapper;
import com.sky.ddt.dto.finance.response.FbaCustomerReturnFeeResponse;
import com.sky.ddt.dto.finance.response.FbaCustomerReturnSkuResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author baixueping
 * @description 月流水
 * @date 2019/11/27 14:29
 */
public interface CustomMonthlySalesMapper extends MonthlySalesMapper {
    /**
     * @param
     * @return
     * @description 获取退款服务费
     * @author baixueping
     * @date 2019/12/26 12:59
     */
    List<FbaCustomerReturnFeeResponse> listFbaCustomerReturnFee(Integer financeId);

    /**
     * @param
     * @return
     * @description 获取退款服务费对应的sku
     * @author baixueping
     * @date 2019/12/26 14:28
     */
    List<FbaCustomerReturnSkuResponse> listFbaCustomerReturnFeeSku(@Param("financeId")Integer financeId, @Param("shopId") Integer shopId);
}
