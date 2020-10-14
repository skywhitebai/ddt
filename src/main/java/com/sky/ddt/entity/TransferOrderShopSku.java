package com.sky.ddt.entity;

import java.util.Date;

public class TransferOrderShopSku {
    private Integer id;

    private Integer transferOrderId;

    private Integer shopSkuIdFrom;

    private Integer shopSkuIdTo;

    private Integer transferQuantity;

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

    public Integer getTransferOrderId() {
        return transferOrderId;
    }

    public void setTransferOrderId(Integer transferOrderId) {
        this.transferOrderId = transferOrderId;
    }

    public Integer getShopSkuIdFrom() {
        return shopSkuIdFrom;
    }

    public void setShopSkuIdFrom(Integer shopSkuIdFrom) {
        this.shopSkuIdFrom = shopSkuIdFrom;
    }

    public Integer getShopSkuIdTo() {
        return shopSkuIdTo;
    }

    public void setShopSkuIdTo(Integer shopSkuIdTo) {
        this.shopSkuIdTo = shopSkuIdTo;
    }

    public Integer getTransferQuantity() {
        return transferQuantity;
    }

    public void setTransferQuantity(Integer transferQuantity) {
        this.transferQuantity = transferQuantity;
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