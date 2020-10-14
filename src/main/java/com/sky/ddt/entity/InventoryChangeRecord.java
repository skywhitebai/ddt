package com.sky.ddt.entity;

import java.util.Date;

public class InventoryChangeRecord {
    private Integer id;

    private Integer shopSkuId;

    private Integer inventoryQuantityOld;

    private Integer inventoryQuantityNew;

    private Integer modifiedQuantity;

    private Integer changeType;

    private Integer entityId;

    private Integer mainEntityId;

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

    public Integer getShopSkuId() {
        return shopSkuId;
    }

    public void setShopSkuId(Integer shopSkuId) {
        this.shopSkuId = shopSkuId;
    }

    public Integer getInventoryQuantityOld() {
        return inventoryQuantityOld;
    }

    public void setInventoryQuantityOld(Integer inventoryQuantityOld) {
        this.inventoryQuantityOld = inventoryQuantityOld;
    }

    public Integer getInventoryQuantityNew() {
        return inventoryQuantityNew;
    }

    public void setInventoryQuantityNew(Integer inventoryQuantityNew) {
        this.inventoryQuantityNew = inventoryQuantityNew;
    }

    public Integer getModifiedQuantity() {
        return modifiedQuantity;
    }

    public void setModifiedQuantity(Integer modifiedQuantity) {
        this.modifiedQuantity = modifiedQuantity;
    }

    public Integer getChangeType() {
        return changeType;
    }

    public void setChangeType(Integer changeType) {
        this.changeType = changeType;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public Integer getMainEntityId() {
        return mainEntityId;
    }

    public void setMainEntityId(Integer mainEntityId) {
        this.mainEntityId = mainEntityId;
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