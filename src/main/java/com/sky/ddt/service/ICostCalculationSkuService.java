package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.costCalculationSku.request.ListCostCalculationSkuRequest;
import com.sky.ddt.entity.CostCalculationSku;

import java.util.List;

/**
 * @author sky
 * @Description 成本核算
 * @date 2021/11/17 22:42
 */
public interface ICostCalculationSkuService {
    PageInfo<CostCalculationSku> listCostCalculationSku(ListCostCalculationSkuRequest params);

    List<CostCalculationSku> listExportCostCalculationSku(ListCostCalculationSkuRequest params);
}
