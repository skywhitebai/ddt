package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.SkuWeightHisMapper;
import com.sky.ddt.dto.skuWeightHis.request.ListSkuWeightHisRequest;
import com.sky.ddt.dto.skuWeightHis.response.ListSkuWeightHisResponse;

import java.util.List;

/**
 * @author baixueping
 * @description sky重量历史信息
 * @date 2020/1/2 10:02
 */
public interface CustomSkuWeightHisMapper extends SkuWeightHisMapper {
    List<ListSkuWeightHisResponse> list(ListSkuWeightHisRequest params);
}
