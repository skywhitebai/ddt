package com.sky.ddt.dto.warehousingOrderShopSku.response;

import com.sky.ddt.entity.WarehousingOrderShopSku;
import lombok.Data;

/**
 * @author baixueping
 * @description 入库单列表返回值
 * @date 2020/4/23 16:58
 */
@Data
public class ListWarehousingOrderShopSkuResponse extends WarehousingOrderShopSku {
    String shopName;
    String sku;
    Integer productionQuantity;
}
