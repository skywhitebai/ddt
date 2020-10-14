package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.SkuCostPriceHisConstant;
import com.sky.ddt.dto.skuCostPriceHis.request.ListSkuCostPriceHisRequest;
import com.sky.ddt.dto.skuCostPriceHis.response.ListSkuCostPriceHisResponse;

import java.math.BigDecimal;

/**
 * @author baixueping
 * @description sky成本价历史
 * @date 2019/12/30 16:35
 */
public interface ISkuCostPriceHisService {
    void saveSkuCostPriceHis(Integer skuId, BigDecimal costPriceBefore, BigDecimal costPriceAfter, SkuCostPriceHisConstant.TypeEnum typeEnum, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 列表显示价格修改记录
     * @author baixueping
     * @date 2019/12/31 9:59
     */
    PageInfo<ListSkuCostPriceHisResponse> list(ListSkuCostPriceHisRequest params);
}
