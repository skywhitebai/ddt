package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.costCalculation.request.ListCostCalculationRequest;
import com.sky.ddt.dto.costCalculation.request.SaveCostCalculationRemarkRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.CostCalculation;

/**
 * @author sky
 * @Description 成本核算
 * @date 2021/11/17 22:42
 */
public interface ICostCalculationService {
    PageInfo<CostCalculation> listCostCalculation(ListCostCalculationRequest params);

    BaseResponse saveCostCalculationRemark(SaveCostCalculationRemarkRequest params);
}
