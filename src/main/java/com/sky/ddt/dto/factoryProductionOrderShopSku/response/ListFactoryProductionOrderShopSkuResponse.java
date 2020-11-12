package com.sky.ddt.dto.factoryProductionOrderShopSku.response;

import com.sky.ddt.entity.FactoryProductionOrderShopSku;
import lombok.Data;

/**
 * @author baixueping
 * @description 列表查詢工厂生产单店铺sku
 * @date 2020/11/12 12:19
 */
@Data
public class ListFactoryProductionOrderShopSkuResponse extends FactoryProductionOrderShopSku {
    String shopParentSku;
}
