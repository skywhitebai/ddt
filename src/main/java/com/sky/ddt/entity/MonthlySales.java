package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class MonthlySales {
    private Integer id;

    private Integer financeId;

    private Date dateTime;

    private Long settlementId;

    private String type;

    private String orderId;

    private String sku;

    private Integer shopSkuId;

    private String description;

    private Integer quantity;

    private String marketplace;

    private String fulfillment;

    private String orderCity;

    private String orderState;

    private String orderPostal;

    private String taxCollectionModel;

    private BigDecimal productSales;

    private BigDecimal productSalesTax;

    private BigDecimal shippingCredits;

    private BigDecimal shippingCreditsTax;

    private BigDecimal giftWrapCredits;

    private BigDecimal giftwrapCreditsTax;

    private BigDecimal promotionalRebates;

    private BigDecimal promotionalRebatesTax;

    private BigDecimal marketplaceWithheldTax;

    private BigDecimal sellingFees;

    private BigDecimal fbaFees;

    private BigDecimal otherTransactionFees;

    private BigDecimal other;

    private BigDecimal total;

    private Date createTime;

    private Integer createBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFinanceId() {
        return financeId;
    }

    public void setFinanceId(Integer financeId) {
        this.financeId = financeId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Long getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(Long settlementId) {
        this.settlementId = settlementId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    public Integer getShopSkuId() {
        return shopSkuId;
    }

    public void setShopSkuId(Integer shopSkuId) {
        this.shopSkuId = shopSkuId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getMarketplace() {
        return marketplace;
    }

    public void setMarketplace(String marketplace) {
        this.marketplace = marketplace == null ? null : marketplace.trim();
    }

    public String getFulfillment() {
        return fulfillment;
    }

    public void setFulfillment(String fulfillment) {
        this.fulfillment = fulfillment == null ? null : fulfillment.trim();
    }

    public String getOrderCity() {
        return orderCity;
    }

    public void setOrderCity(String orderCity) {
        this.orderCity = orderCity == null ? null : orderCity.trim();
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState == null ? null : orderState.trim();
    }

    public String getOrderPostal() {
        return orderPostal;
    }

    public void setOrderPostal(String orderPostal) {
        this.orderPostal = orderPostal == null ? null : orderPostal.trim();
    }

    public String getTaxCollectionModel() {
        return taxCollectionModel;
    }

    public void setTaxCollectionModel(String taxCollectionModel) {
        this.taxCollectionModel = taxCollectionModel == null ? null : taxCollectionModel.trim();
    }

    public BigDecimal getProductSales() {
        return productSales;
    }

    public void setProductSales(BigDecimal productSales) {
        this.productSales = productSales;
    }

    public BigDecimal getProductSalesTax() {
        return productSalesTax;
    }

    public void setProductSalesTax(BigDecimal productSalesTax) {
        this.productSalesTax = productSalesTax;
    }

    public BigDecimal getShippingCredits() {
        return shippingCredits;
    }

    public void setShippingCredits(BigDecimal shippingCredits) {
        this.shippingCredits = shippingCredits;
    }

    public BigDecimal getShippingCreditsTax() {
        return shippingCreditsTax;
    }

    public void setShippingCreditsTax(BigDecimal shippingCreditsTax) {
        this.shippingCreditsTax = shippingCreditsTax;
    }

    public BigDecimal getGiftWrapCredits() {
        return giftWrapCredits;
    }

    public void setGiftWrapCredits(BigDecimal giftWrapCredits) {
        this.giftWrapCredits = giftWrapCredits;
    }

    public BigDecimal getGiftwrapCreditsTax() {
        return giftwrapCreditsTax;
    }

    public void setGiftwrapCreditsTax(BigDecimal giftwrapCreditsTax) {
        this.giftwrapCreditsTax = giftwrapCreditsTax;
    }

    public BigDecimal getPromotionalRebates() {
        return promotionalRebates;
    }

    public void setPromotionalRebates(BigDecimal promotionalRebates) {
        this.promotionalRebates = promotionalRebates;
    }

    public BigDecimal getPromotionalRebatesTax() {
        return promotionalRebatesTax;
    }

    public void setPromotionalRebatesTax(BigDecimal promotionalRebatesTax) {
        this.promotionalRebatesTax = promotionalRebatesTax;
    }

    public BigDecimal getMarketplaceWithheldTax() {
        return marketplaceWithheldTax;
    }

    public void setMarketplaceWithheldTax(BigDecimal marketplaceWithheldTax) {
        this.marketplaceWithheldTax = marketplaceWithheldTax;
    }

    public BigDecimal getSellingFees() {
        return sellingFees;
    }

    public void setSellingFees(BigDecimal sellingFees) {
        this.sellingFees = sellingFees;
    }

    public BigDecimal getFbaFees() {
        return fbaFees;
    }

    public void setFbaFees(BigDecimal fbaFees) {
        this.fbaFees = fbaFees;
    }

    public BigDecimal getOtherTransactionFees() {
        return otherTransactionFees;
    }

    public void setOtherTransactionFees(BigDecimal otherTransactionFees) {
        this.otherTransactionFees = otherTransactionFees;
    }

    public BigDecimal getOther() {
        return other;
    }

    public void setOther(BigDecimal other) {
        this.other = other;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }
}