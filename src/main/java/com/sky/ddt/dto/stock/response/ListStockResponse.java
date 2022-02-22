package com.sky.ddt.dto.stock.response;

import com.sky.ddt.dto.easyui.response.DataGridResponse;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author baixueping
 * @description 备货信息查询结果
 * @date 2019/8/21 11:21
 */
@Data
public class ListStockResponse {
    Integer shopId;
    String shopName;
    String saleShopNames;
    String shopSku;
    String shopParentSku;
    String sku;
    String imgUrl;
    Integer skuId;
    Integer produceStatus;
    String shopSkuId;
    Integer salesForTheLast7Days;
    Integer salesForTheLast14Days;
    Integer salesForTheLast21Days;
    Integer salesForTheLast28Days;
    Integer salesForTheLast35Days;
    Double estimateAverageDailySales;
    Integer estimateSales14Days;
    Integer estimateSales28Days;
    Integer estimateSales42Days;
    Integer estimateSales56Days;
    Integer estimateSales90Days;
    Integer fbaTotalCanSaleQuantity;
    /**
     * 总库存周转 库存可售天数
     */
    Double estimateCanSaleDay;
    Integer replenishQuantity28Days;
    Integer replenishQuantity42Days;
    Integer replenishQuantity56Days;
    Integer replenishQuantity90Days;
    /**
     * 总库存
     */
    Integer inventoryQuantityTotal;
    /**
     * 国内仓库数量
     */
    Integer inventoryQuantity;
    /**
     * 其他店铺库存
     */
    Integer inventoryQuantityOtherShop;
    /**
     * 仓库库存
     */
    Integer inventoryQuantityWarehouse;
    /**
     * 补货数量
     */
    Integer stockQuantity;
    private Integer stockQuantityKy;
    private Integer stockQuantityKp;
    private Integer stockQuantityHy;
    Date skuCreateTime;
    Date createTime;
    Date updateTime;
    /**
     * FBA当前可售库存
     */
    Integer afnFulfillableQuantity;
    /**
     * F当前可售库存可售天数 当前库存周转
     */
    Double ableCanSaleDay;
    /**
     * 在途数量
     */
    Integer onTheWayQuantity;
    Integer afnReservedQuantity;
    private Integer afnInboundWorkingQuantity;

    private Integer afnInboundShippedQuantity;

    private Integer afnInboundReceivingQuantity;
    /**
     * 在途周转
     */
    Double onTheWayQuantityCanSaleDay;
    /**
     * 补货数量周转
     */
    Double stockQuantityCanSaleDay;

    private Integer estimateProductionQuantity;
    /**
     * 备货购物车准备生产数量
     */
    private Integer productionQuantity;

    private String salesmanRealName;
    /**
     *总生产中数量
     */
    private Integer produceOrderShopSkuProductionQuantityTotal;
    /**
     * 生产单店铺sku生产数量
     */
    private Integer produceOrderShopSkuProductionQuantity;
    /**
     * 生产单其他店铺店铺sku生产数量
     */
    private Integer produceOrderShopSkuProductionQuantityOtherShop;
    /**
     * 生产单其他仓库店铺sku生产数量
     */
    private Integer produceOrderShopSkuProductionQuantityWarehouse;
    private BigDecimal itemPrice30;
}
