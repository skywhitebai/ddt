package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.labelPrint.request.LabelPrintShopSkuListRequest;
import com.sky.ddt.dto.labelPrint.response.LabelPrintShopSkuListResponse;

import java.util.List;

/**
 * @author baixueping
 * @description 标签打印sku服务
 * @date 2020/2/28 15:32
 */
public interface ILabelPrintShopSkuService {
    /**
     * @param
     * @return
     * @description 查询标签打印sku列表
     * @author baixueping
     * @date 2020/2/28 15:54
     */
    PageInfo<LabelPrintShopSkuListResponse> list(LabelPrintShopSkuListRequest params);

    /**
     * @param
     * @return
     * @description 获取店铺sku
     * @author baixueping
     * @date 2020/4/20 14:52
     */
    List<LabelPrintShopSkuListResponse> listLabelPrintShopSku(Integer labelPrintId);
}
