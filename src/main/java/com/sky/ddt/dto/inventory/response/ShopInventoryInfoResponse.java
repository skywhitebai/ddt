package com.sky.ddt.dto.inventory.response;

import lombok.Data;

/**
 * @author baixueping
 * @description 店铺库存
 * @date 2019/4/24 9:21
 */
@Data
public class ShopInventoryInfoResponse {
    String shopName;
    /**
     * 仓库sky
     */
    String skuWarehouse;
    /**
     * 卖家sku
     */
    String sellerSku;
    /**
     * 最近7天销量
     */
    Integer salesForTheLast7Days;
    /**
     * 最近14天销量
     */
    Integer salesForTheLast14Days;
    /**
     * 最近21天销量
     */
    Integer salesForTheLast21Days;
    /**
     * 最近28天销量
     */
    Integer salesForTheLast28Days;
    /**
     * 30天参考销量
     */
    Integer referenceSales30Days;
    /**
     * 45天参考销量
     */
    Integer referenceSales45Days;
    /**
     * 60天参考销量
     */
    Integer referenceSales60Days;
    /**
     * 90天参考销量
     */
    Integer referenceSales90Days;
    /**
     * 库存数量
     */
    Integer totalSupplyQuantity;
    /**
     * 库存供货天数
     */
    Integer daysUntilStockRunsOut;
    /**
     * 30天建议补货数量
     */
    Integer recommendedInboundQuantity30Days;
    /**
     * 45天建议补货数量
     */
    Integer recommendedInboundQuantity45Days;
    /**
     * 60天建议补货数量
     */
    Integer recommendedInboundQuantity60Days;
    /**
     * 90天建议补货数量
     */
    Integer recommendedInboundQuantity90Days;
}
