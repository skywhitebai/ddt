package com.sky.ddt.dto.factoryProductionOrder.response;

import lombok.Data;

/**
 * @author baixueping
 * @description 列表查询工厂生产单产品信息
 * @date 2020/10/15 16:44
 */
@Data
public class ListFactoryProductionOrderShopParentSkuResponse {
    String shopParentSku;
    Integer productionQuantity;
}
