package com.sky.ddt.dto.shopSkuHeadTripCostHis.response;

import com.sky.ddt.entity.ShopSkuHeadTripCostHis;
import lombok.Data;

import java.util.Date;

/**
 * @author baixueping
 * @description 列表查询店铺sku头程费历史记录
 * @date 2020/8/18 18:11
 */
@Data
public class ExportShopSkuHeadTripCostHisResponse extends ShopSkuHeadTripCostHis {
    String shopSku;
    String shopName;
    Date month;
}
