package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class FbaImport {
    private Integer id;

    private String sku;

    private Integer shopId;

    private Integer shopSkuId;

    private String fnsku;

    private String asin;

    private String productName;

    private String conditions;

    private BigDecimal yourPrice;

    private String mfnListingExists;

    private Integer mfnFulfillableQuantity;

    private String afnListingExists;

    private Integer afnWarehouseQuantity;

    private Integer afnFulfillableQuantity;

    private Integer afnUnsellableQuantity;

    private Integer afnReservedQuantity;

    private Integer afnTotalQuantity;

    private Integer perUnitVolume;

    private Integer afnInboundWorkingQuantity;

    private Integer afnInboundShippedQuantity;

    private Integer afnInboundReceivingQuantity;

    private String remark;

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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions == null ? null : conditions.trim();
    }

    public BigDecimal getYourPrice() {
        return yourPrice;
    }

    public void setYourPrice(BigDecimal yourPrice) {
        this.yourPrice = yourPrice;
    }

    public String getMfnListingExists() {
        return mfnListingExists;
    }

    public void setMfnListingExists(String mfnListingExists) {
        this.mfnListingExists = mfnListingExists == null ? null : mfnListingExists.trim();
    }

    public Integer getMfnFulfillableQuantity() {
        return mfnFulfillableQuantity;
    }

    public void setMfnFulfillableQuantity(Integer mfnFulfillableQuantity) {
        this.mfnFulfillableQuantity = mfnFulfillableQuantity;
    }

    public String getAfnListingExists() {
        return afnListingExists;
    }

    public void setAfnListingExists(String afnListingExists) {
        this.afnListingExists = afnListingExists == null ? null : afnListingExists.trim();
    }

    public Integer getAfnWarehouseQuantity() {
        return afnWarehouseQuantity;
    }

    public void setAfnWarehouseQuantity(Integer afnWarehouseQuantity) {
        this.afnWarehouseQuantity = afnWarehouseQuantity;
    }

    public Integer getAfnFulfillableQuantity() {
        return afnFulfillableQuantity;
    }

    public void setAfnFulfillableQuantity(Integer afnFulfillableQuantity) {
        this.afnFulfillableQuantity = afnFulfillableQuantity;
    }

    public Integer getAfnUnsellableQuantity() {
        return afnUnsellableQuantity;
    }

    public void setAfnUnsellableQuantity(Integer afnUnsellableQuantity) {
        this.afnUnsellableQuantity = afnUnsellableQuantity;
    }

    public Integer getAfnReservedQuantity() {
        return afnReservedQuantity;
    }

    public void setAfnReservedQuantity(Integer afnReservedQuantity) {
        this.afnReservedQuantity = afnReservedQuantity;
    }

    public Integer getAfnTotalQuantity() {
        return afnTotalQuantity;
    }

    public void setAfnTotalQuantity(Integer afnTotalQuantity) {
        this.afnTotalQuantity = afnTotalQuantity;
    }

    public Integer getPerUnitVolume() {
        return perUnitVolume;
    }

    public void setPerUnitVolume(Integer perUnitVolume) {
        this.perUnitVolume = perUnitVolume;
    }

    public Integer getAfnInboundWorkingQuantity() {
        return afnInboundWorkingQuantity;
    }

    public void setAfnInboundWorkingQuantity(Integer afnInboundWorkingQuantity) {
        this.afnInboundWorkingQuantity = afnInboundWorkingQuantity;
    }

    public Integer getAfnInboundShippedQuantity() {
        return afnInboundShippedQuantity;
    }

    public void setAfnInboundShippedQuantity(Integer afnInboundShippedQuantity) {
        this.afnInboundShippedQuantity = afnInboundShippedQuantity;
    }

    public Integer getAfnInboundReceivingQuantity() {
        return afnInboundReceivingQuantity;
    }

    public void setAfnInboundReceivingQuantity(Integer afnInboundReceivingQuantity) {
        this.afnInboundReceivingQuantity = afnInboundReceivingQuantity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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