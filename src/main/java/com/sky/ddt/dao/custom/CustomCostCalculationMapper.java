package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.CostCalculationMapper;
import com.sky.ddt.dto.costCalculation.request.ListCostCalculationRequest;
import com.sky.ddt.entity.CostCalculation;

import java.util.List;

/**
 * @author sky
 * @Description 成本核算
 * @date 2021/11/17 20:45
 */
public interface CustomCostCalculationMapper extends CostCalculationMapper {

    List<CostCalculation> listCostCalculation(ListCostCalculationRequest params);
}
