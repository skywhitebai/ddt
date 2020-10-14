package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ShopSku {
    private Integer shopSkuId;

    private String shopSku;

    private Integer skuId;

    private Integer shopId;

    private Integer salesmanUserId;

    private String fnsku;

    private String asin;

    private String title;

    private Integer inventoryQuantity;

    private String storageLocation;

    private BigDecimal headTripCost;

    private Integer status;

    private String remark;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

    private String shopParentSku;

    private String parentAsin;

    public Integer getShopSkuId() {
        return shopSkuId;
    }

    public void setShopSkuId(Integer shopSkuId) {
        this.shopSkuId = shopSkuId;
    }

    public String getShopSku() {
        return shopSku;
    }

    public void setShopSku(String shopSku) {
        this.shopSku = shopSku == null ? null : shopSku.trim();
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getSalesmanUserId() {
        return salesmanUserId;
    }

    public void setSalesmanUserId(Integer salesmanUserId) {
        this.salesmanUserId = salesmanUserId;
    }

    public String getFnsku() {
        return fnsku;
    }

    public void setFnsku(String fnsku) {
        this.fnsku = fnsku == null ? null : fnsku.trim();
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin == null ? null : asin.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(Integer inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation == null ? null : storageLocation.trim();
    }

    public BigDecimal getHeadTripCost() {
        return headTripCost;
    }

    public void setHeadTripCost(BigDecimal headTripCost) {
        this.headTripCost = headTripCost;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getShopParentSku() {
        return shopParentSku;
    }

    public void setShopParentSku(String shopParentSku) {
        this.shopParentSku = shopParentSku == null ? null : shopParentSku.trim();
    }

    public String getParentAsin() {
        return parentAsin;
    }

    public void setParentAsin(String parentAsin) {
        this.parentAsin = parentAsin == null ? null : parentAsin.trim();
    }
}