package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.SkuCostPriceHisMapper;
import com.sky.ddt.dto.skuCostPriceHis.request.ListSkuCostPriceHisRequest;
import com.sky.ddt.dto.skuCostPriceHis.response.ListSkuCostPriceHisResponse;

import java.util.List;

/**
 * @author baixueping
 * @description sku历史价格
 * @date 2019/12/30 16:32
 */
public interface CustomSkuCostPriceHisMapper extends SkuCostPriceHisMapper {
    List<ListSkuCostPriceHisResponse> list(ListSkuCostPriceHisRequest params);
}
