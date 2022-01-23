package com.sky.ddt.dto.outboundOrderShopSku.response;

import com.sky.ddt.entity.OutboundOrderShopSku;
import lombok.Data;

/**
 * @author baixueping
 * @description 列表查询出库单店铺sku出参
 * @date 2020/5/12 12:50
 */
@Data
public class ListOutboundOrderShopSkuResponse extends OutboundOrderShopSku {
    String shopName;
    String shopSku;
    String sku;
    /**
     * 仓库库存
     */
    Integer inventoryQuantityWarehouse;
    /**
     * 其他仓库库存
     */
    Integer inventoryQuantityOtherWarehouse;
}
