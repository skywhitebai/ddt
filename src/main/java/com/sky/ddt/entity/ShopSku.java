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

    private Integer produceStatus;

    private String remark;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

    private String shopParentSku;

    private String parentAsin;

    private String tProductName;

    private String barcode;

    private String tSkc;

    private String tSku;

    private String tSkcItemNumber;

    private String tSkuItemNumber;

    private String salesAttributes1;

    private String salesAttributes2;

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

    public Integer getProduceStatus() {
        return produceStatus;
    }

    public void setProduceStatus(Integer produceStatus) {
        this.produceStatus = produceStatus;
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

    public String gettProductName() {
        return tProductName;
    }

    public void settProductName(String tProductName) {
        this.tProductName = tProductName == null ? null : tProductName.trim();
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    public String gettSkc() {
        return tSkc;
    }

    public void settSkc(String tSkc) {
        this.tSkc = tSkc == null ? null : tSkc.trim();
    }

    public String gettSku() {
        return tSku;
    }

    public void settSku(String tSku) {
        this.tSku = tSku == null ? null : tSku.trim();
    }

    public String gettSkcItemNumber() {
        return tSkcItemNumber;
    }

    public void settSkcItemNumber(String tSkcItemNumber) {
        this.tSkcItemNumber = tSkcItemNumber == null ? null : tSkcItemNumber.trim();
    }

    public String gettSkuItemNumber() {
        return tSkuItemNumber;
    }

    public void settSkuItemNumber(String tSkuItemNumber) {
        this.tSkuItemNumber = tSkuItemNumber == null ? null : tSkuItemNumber.trim();
    }

    public String getSalesAttributes1() {
        return salesAttributes1;
    }

    public void setSalesAttributes1(String salesAttributes1) {
        this.salesAttributes1 = salesAttributes1 == null ? null : salesAttributes1.trim();
    }

    public String getSalesAttributes2() {
        return salesAttributes2;
    }

    public void setSalesAttributes2(String salesAttributes2) {
        this.salesAttributes2 = salesAttributes2 == null ? null : salesAttributes2.trim();
    }
}