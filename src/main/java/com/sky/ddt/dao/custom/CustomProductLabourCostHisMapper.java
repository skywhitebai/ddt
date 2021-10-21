package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.ProductLabourCostHisMapper;
import com.sky.ddt.dto.productLabourCostHis.request.ListProductLabourCostHisRequest;
import com.sky.ddt.dto.productLabourCostHis.response.ListProductLabourCostHisResponse;

import java.util.List;

/**
 * @author sky
 * @Description CustomProductLabourCostHisMapper
 * @date 2021/10/21 18:59
 */
public interface CustomProductLabourCostHisMapper extends ProductLabourCostHisMapper {
    List<ListProductLabourCostHisResponse> listProductLabourCostHis(ListProductLabourCostHisRequest params);
}
