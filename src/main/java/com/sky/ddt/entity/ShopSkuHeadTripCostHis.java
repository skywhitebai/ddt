package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ShopSkuHeadTripCostHis {
    private Integer id;

    private Integer shopSkuId;

    private Integer shopHeadTripCostId;

    private BigDecimal headTripCostBefore;

    private BigDecimal headTripCostAfter;

    private Integer inventoryQuantity;

    private Integer fbaSendQuantity;

    private BigDecimal fbaHeadTripCost;

    private BigDecimal totalHeadTripCost;

    private String createRemark;

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

    public Integer getShopHeadTripCostId() {
        return shopHeadTripCostId;
    }

    public void setShopHeadTripCostId(Integer shopHeadTripCostId) {
        this.shopHeadTripCostId = shopHeadTripCostId;
    }

    public BigDecimal getHeadTripCostBefore() {
        return headTripCostBefore;
    }

    public void setHeadTripCostBefore(BigDecimal headTripCostBefore) {
        this.headTripCostBefore = headTripCostBefore;
    }

    public BigDecimal getHeadTripCostAfter() {
        return headTripCostAfter;
    }

    public void setHeadTripCostAfter(BigDecimal headTripCostAfter) {
        this.headTripCostAfter = headTripCostAfter;
    }

    public Integer getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(Integer inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public Integer getFbaSendQuantity() {
        return fbaSendQuantity;
    }

    public void setFbaSendQuantity(Integer fbaSendQuantity) {
        this.fbaSendQuantity = fbaSendQuantity;
    }

    public BigDecimal getFbaHeadTripCost() {
        return fbaHeadTripCost;
    }

    public void setFbaHeadTripCost(BigDecimal fbaHeadTripCost) {
        this.fbaHeadTripCost = fbaHeadTripCost;
    }

    public BigDecimal getTotalHeadTripCost() {
        return totalHeadTripCost;
    }

    public void setTotalHeadTripCost(BigDecimal totalHeadTripCost) {
        this.totalHeadTripCost = totalHeadTripCost;
    }

    public String getCreateRemark() {
        return createRemark;
    }

    public void setCreateRemark(String createRemark) {
        this.createRemark = createRemark == null ? null : createRemark.trim();
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