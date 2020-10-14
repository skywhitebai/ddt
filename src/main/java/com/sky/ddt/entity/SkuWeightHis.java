package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class SkuWeightHis {
    private Integer id;

    private Integer skuId;

    private BigDecimal weightBefore;

    private BigDecimal weightAfter;

    private BigDecimal headTripCostBefore;

    private BigDecimal headTripCostAfter;

    private BigDecimal headTripCostMinBefore;

    private BigDecimal headTripCostMinAfter;

    private Integer type;

    private Integer createBy;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public BigDecimal getWeightBefore() {
        return weightBefore;
    }

    public void setWeightBefore(BigDecimal weightBefore) {
        this.weightBefore = weightBefore;
    }

    public BigDecimal getWeightAfter() {
        return weightAfter;
    }

    public void setWeightAfter(BigDecimal weightAfter) {
        this.weightAfter = weightAfter;
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

    public BigDecimal getHeadTripCostMinBefore() {
        return headTripCostMinBefore;
    }

    public void setHeadTripCostMinBefore(BigDecimal headTripCostMinBefore) {
        this.headTripCostMinBefore = headTripCostMinBefore;
    }

    public BigDecimal getHeadTripCostMinAfter() {
        return headTripCostMinAfter;
    }

    public void setHeadTripCostMinAfter(BigDecimal headTripCostMinAfter) {
        this.headTripCostMinAfter = headTripCostMinAfter;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
}