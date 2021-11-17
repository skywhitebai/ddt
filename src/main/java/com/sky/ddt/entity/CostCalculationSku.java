package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class CostCalculationSku {
    private Integer id;

    private Integer costCalculationId;

    private Date month;

    private String sku;

    private Integer skuId;

    private BigDecimal labourCost;

    private BigDecimal costPriceBefore;

    private Integer inventoryQuantity;

    private Integer productionQuantity;

    private BigDecimal productionCostTotal;

    private BigDecimal productionCostPrice;

    private BigDecimal costPriceAfter;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCostCalculationId() {
        return costCalculationId;
    }

    public void setCostCalculationId(Integer costCalculationId) {
        this.costCalculationId = costCalculationId;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public BigDecimal getLabourCost() {
        return labourCost;
    }

    public void setLabourCost(BigDecimal labourCost) {
        this.labourCost = labourCost;
    }

    public BigDecimal getCostPriceBefore() {
        return costPriceBefore;
    }

    public void setCostPriceBefore(BigDecimal costPriceBefore) {
        this.costPriceBefore = costPriceBefore;
    }

    public Integer getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(Integer inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public Integer getProductionQuantity() {
        return productionQuantity;
    }

    public void setProductionQuantity(Integer productionQuantity) {
        this.productionQuantity = productionQuantity;
    }

    public BigDecimal getProductionCostTotal() {
        return productionCostTotal;
    }

    public void setProductionCostTotal(BigDecimal productionCostTotal) {
        this.productionCostTotal = productionCostTotal;
    }

    public BigDecimal getProductionCostPrice() {
        return productionCostPrice;
    }

    public void setProductionCostPrice(BigDecimal productionCostPrice) {
        this.productionCostPrice = productionCostPrice;
    }

    public BigDecimal getCostPriceAfter() {
        return costPriceAfter;
    }

    public void setCostPriceAfter(BigDecimal costPriceAfter) {
        this.costPriceAfter = costPriceAfter;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}