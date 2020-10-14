package com.sky.ddt.entity;

import java.util.Date;

public class SkuInfo {
    private Integer id;

    private String skuSeller;

    private String skuWarehouse;

    private String skuSupplier;

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

    public String getSkuSeller() {
        return skuSeller;
    }

    public void setSkuSeller(String skuSeller) {
        this.skuSeller = skuSeller == null ? null : skuSeller.trim();
    }

    public String getSkuWarehouse() {
        return skuWarehouse;
    }

    public void setSkuWarehouse(String skuWarehouse) {
        this.skuWarehouse = skuWarehouse == null ? null : skuWarehouse.trim();
    }

    public String getSkuSupplier() {
        return skuSupplier;
    }

    public void setSkuSupplier(String skuSupplier) {
        this.skuSupplier = skuSupplier == null ? null : skuSupplier.trim();
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