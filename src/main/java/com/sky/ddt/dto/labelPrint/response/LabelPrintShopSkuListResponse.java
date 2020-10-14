package com.sky.ddt.dto.labelPrint.response;

import com.sky.ddt.entity.LabelPrintShopSku;
import lombok.Data;

/**
 * @author baixueping
 * @description 标签sku列表返回值
 * @date 2020/2/28 15:49
 */
@Data
public class LabelPrintShopSkuListResponse{
    Integer id;
    Integer shopSkuId;
    Integer quantity;
    String shopSku;
    String sku;
    String fnsku;
    String createTime;
    String imgUrl;
    String remark;
}
