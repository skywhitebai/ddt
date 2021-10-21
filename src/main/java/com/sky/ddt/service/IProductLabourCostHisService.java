package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.ProductLabourCostHisConstant;
import com.sky.ddt.dto.productLabourCostHis.request.ListProductLabourCostHisRequest;
import com.sky.ddt.dto.productLabourCostHis.response.ListProductLabourCostHisResponse;

import java.math.BigDecimal;

/**
 * @author sky
 * @Description 产品工价历史
 * @date 2021/10/21 19:00
 */
public interface IProductLabourCostHisService {
    void saveProductLabourCostHis(Integer productId, BigDecimal labourCostBefore, BigDecimal labourCostAfter, ProductLabourCostHisConstant.TypeEnum importLabourCost, Integer dealUserId);

    PageInfo<ListProductLabourCostHisResponse> listProductLabourCostHis(ListProductLabourCostHisRequest params);
}
