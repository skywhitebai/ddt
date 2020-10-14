package com.sky.ddt.entity;

import java.util.Date;

public class Inventory {
    private Integer id;

    private Integer shopId;

    private String sellerSku;

    private String fnSku;

    private String asin;

    private String productCondition;

    private Integer totalSupplyQuantity;

    private Integer inStockSupplyQuantity;

    private String earliestAvailabilityTimepointType;

    private Date earliestAvailabilityDatetime;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getSellerSku() {
        return sellerSku;
    }

    public void setSellerSku(String sellerSku) {
        this.sellerSku = sellerSku == null ? null : sellerSku.trim();
    }

    public String getFnSku() {
        return fnSku;
    }

    public void setFnSku(String fnSku) {
        this.fnSku = fnSku == null ? null : fnSku.trim();
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin == null ? null : asin.trim();
    }

    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition == null ? null : productCondition.trim();
    }

    public Integer getTotalSupplyQuantity() {
        return totalSupplyQuantity;
    }

    public void setTotalSupplyQuantity(Integer totalSupplyQuantity) {
        this.totalSupplyQuantity = totalSupplyQuantity;
    }

    public Integer getInStockSupplyQuantity() {
        return inStockSupplyQuantity;
    }

    public void setInStockSupplyQuantity(Integer inStockSupplyQuantity) {
        this.inStockSupplyQuantity = inStockSupplyQuantity;
    }

    public String getEarliestAvailabilityTimepointType() {
        return earliestAvailabilityTimepointType;
    }

    public void setEarliestAvailabilityTimepointType(String earliestAvailabilityTimepointType) {
        this.earliestAvailabilityTimepointType = earliestAvailabilityTimepointType == null ? null : earliestAvailabilityTimepointType.trim();
    }

    public Date getEarliestAvailabilityDatetime() {
        return earliestAvailabilityDatetime;
    }

    public void setEarliestAvailabilityDatetime(Date earliestAvailabilityDatetime) {
        this.earliestAvailabilityDatetime = earliestAvailabilityDatetime;
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
}