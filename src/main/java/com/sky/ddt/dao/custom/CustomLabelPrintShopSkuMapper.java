package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.LabelPrintShopSkuMapper;
import com.sky.ddt.dto.labelPrint.request.LabelPrintShopSkuListRequest;
import com.sky.ddt.dto.labelPrint.response.LabelPrintShopSkuListResponse;

import java.util.List;

/**
 * @author baixueping
 * @description 标签打印sku
 * @date 2020/2/28 15:02
 */
public interface CustomLabelPrintShopSkuMapper extends LabelPrintShopSkuMapper {
    List<LabelPrintShopSkuListResponse> listLabelPrintShopSku(LabelPrintShopSkuListRequest params);
}
