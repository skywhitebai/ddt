package com.sky.ddt.entity;

import java.util.Date;

public class AmazonReservedInventory {
    private Integer id;

    private String sku;

    private String fnsku;

    private Integer shopId;

    private Integer shopSkuId;

    private String asin;

    private String productName;

    private Integer reservedQty;

    private Integer reservedCustomerorders;

    private Integer reservedFcTransfers;

    private Integer reservedFcProcessing;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    public String getFnsku() {
        return fnsku;
    }

    public void setFnsku(String fnsku) {
        this.fnsku = fnsku == null ? null : fnsku.trim();
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getShopSkuId() {
        return shopSkuId;
    }

    public void setShopSkuId(Integer shopSkuId) {
        this.shopSkuId = shopSkuId;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin == null ? null : asin.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Integer getReservedQty() {
        return reservedQty;
    }

    public void setReservedQty(Integer reservedQty) {
        this.reservedQty = reservedQty;
    }

    public Integer getReservedCustomerorders() {
        return reservedCustomerorders;
    }

    public void setReservedCustomerorders(Integer reservedCustomerorders) {
        this.reservedCustomerorders = reservedCustomerorders;
    }

    public Integer getReservedFcTransfers() {
        return reservedFcTransfers;
    }

    public void setReservedFcTransfers(Integer reservedFcTransfers) {
        this.reservedFcTransfers = reservedFcTransfers;
    }

    public Integer getReservedFcProcessing() {
        return reservedFcProcessing;
    }

    public void setReservedFcProcessing(Integer reservedFcProcessing) {
        this.reservedFcProcessing = reservedFcProcessing;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }
}