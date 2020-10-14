package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.SkuInfoMapper;
import com.sky.ddt.dto.skuinfo.response.SkuInfoResponse;

import java.util.List;

/**
 * @author baixueping
 * @description skuInfo
 * @date 2019/7/8 11:07
 */
public interface CustomSkuInfoMapper extends SkuInfoMapper {
    /**
     * @param
     * @return
     * @description 获取sku信息
     * @author baixueping
     * @date 2019/7/8 11:09
     */
    List<SkuInfoResponse> selectBySellerSku(List<String> sellerSkuList);
}
