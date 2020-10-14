package com.sky.ddt.entity;

import java.util.Date;

public class StockRecordItem {
    private Integer id;

    private Integer stockRecordId;

    private Integer shopSkuId;

    private Integer stockQuantity;

    private Integer stockQuantityKy;

    private Integer stockQuantityKp;

    private Integer stockQuantityHy;

    private Integer productionQuantity;

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

    public Integer getStockRecordId() {
        return stockRecordId;
    }

    public void setStockRecordId(Integer stockRecordId) {
        this.stockRecordId = stockRecordId;
    }

    public Integer getShopSkuId() {
        return shopSkuId;
    }

    public void setShopSkuId(Integer shopSkuId) {
        this.shopSkuId = shopSkuId;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Integer getStockQuantityKy() {
        return stockQuantityKy;
    }

    public void setStockQuantityKy(Integer stockQuantityKy) {
        this.stockQuantityKy = stockQuantityKy;
    }

    public Integer getStockQuantityKp() {
        return stockQuantityKp;
    }

    public void setStockQuantityKp(Integer stockQuantityKp) {
        this.stockQuantityKp = stockQuantityKp;
    }

    public Integer getStockQuantityHy() {
        return stockQuantityHy;
    }

    public void setStockQuantityHy(Integer stockQuantityHy) {
        this.stockQuantityHy = stockQuantityHy;
    }

    public Integer getProductionQuantity() {
        return productionQuantity;
    }

    public void setProductionQuantity(Integer productionQuantity) {
        this.productionQuantity = productionQuantity;
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