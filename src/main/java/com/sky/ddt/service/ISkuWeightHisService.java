package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.SkuWeightHisConstant;
import com.sky.ddt.dto.skuWeightHis.request.ListSkuWeightHisRequest;
import com.sky.ddt.dto.skuWeightHis.response.ListSkuWeightHisResponse;
import com.sky.ddt.entity.Sku; /**
 * @author baixueping
 * @description sky重量历史信息
 * @date 2020/1/2 10:04
 */
public interface ISkuWeightHisService {
    void saveSkuWeightHis(Sku skuOld, Sku skuNew, SkuWeightHisConstant.WeightHisTypeEnum weightHisTypeEnum, Integer dealUserId);

    PageInfo<ListSkuWeightHisResponse> list(ListSkuWeightHisRequest params);
}
