package com.sky.ddt.entity;

import java.util.Date;

public class CheckOrderShopSku {
    private Integer id;

    private Integer checkOrderId;

    private Integer shopSkuId;

    private String shopSku;

    private Integer inventoryQuantityNew;

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

    public Integer getCheckOrderId() {
        return checkOrderId;
    }

    public void setCheckOrderId(Integer checkOrderId) {
        this.checkOrderId = checkOrderId;
    }

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

    public Integer getInventoryQuantityNew() {
        return inventoryQuantityNew;
    }

    public void setInventoryQuantityNew(Integer inventoryQuantityNew) {
        this.inventoryQuantityNew = inventoryQuantityNew;
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