package com.sky.ddt.dto.factoryProductionOrder.response;

import lombok.Data;

/**
 * @author baixueping
 * @description 查詢店鋪sku生產數量
 * @date 2020/10/15 18:53
 */
@Data
public class ListFactoryProductionOrderInfoResponse {
    String shopParentSku;
    String colour;
    Integer productionQuantityXS;
    Integer productionQuantityS;
    Integer productionQuantityM;
    Integer productionQuantityL;
    Integer productionQuantityXL;
    Integer productionQuantity2XL;
    Integer productionQuantity3XL;
    Integer productionQuantity4XL;
    Integer productionQuantity5XL;
    Integer productionQuantity6XL;
    String remark;
}
