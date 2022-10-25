package com.sky.ddt.dto.produceOrderShopSku.response;

import lombok.Data;

import java.util.Date;

/**
 * @author baixueping
 * @description 列表查询其他生产单生产中数量
 * @date 2021/3/30 16:15
 */
@Data
public class ListProduceOrderShopSkuProductionQuantityResponse {
    Integer shopSkuId;
    Integer shopId;
    String shopName;
    String shopSku;
    Integer productionQuantity;
    Integer warehousingQuantity;
    Date productionTime;
    String batchNumber;
}
