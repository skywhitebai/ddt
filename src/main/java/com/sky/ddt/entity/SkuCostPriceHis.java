package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class SkuCostPriceHis {
    private Integer id;

    private Integer skuId;

    private BigDecimal costPriceBefore;

    private BigDecimal costPriceAfter;

    private Integer type;

    private String remark;

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

    public BigDecimal getCostPriceBefore() {
        return costPriceBefore;
    }

    public void setCostPriceBefore(BigDecimal costPriceBefore) {
        this.costPriceBefore = costPriceBefore;
    }

    public BigDecimal getCostPriceAfter() {
        return costPriceAfter;
    }

    public void setCostPriceAfter(BigDecimal costPriceAfter) {
        this.costPriceAfter = costPriceAfter;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
}