package com.sky.ddt.dto.produceOrderShopSku.response;

import com.sky.ddt.entity.ProduceOrderShopSku;
import lombok.Data;

/**
 * @author baixueping
 * @description 生产单店铺sku返回值
 * @date 2020/4/1 15:34
 */
@Data
public class ListProduceOrderShopSkuResponse extends ProduceOrderShopSku {
    String shopName;
    String shopSku;
    String sku;
    Integer warehousingQuantity;
}
