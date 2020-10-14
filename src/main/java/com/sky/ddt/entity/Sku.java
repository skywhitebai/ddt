package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Sku {
    private Integer skuId;

    private Integer productId;

    private String sku;

    private String colour;

    private String colourNumber;

    private String size;

    private BigDecimal weight;

    private BigDecimal costPrice;

    private BigDecimal headTripCost;

    private BigDecimal headTripCostMin;

    private Integer inventoryQuantity;

    private String remark;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    private String secondSku;

    private String brand;

    private String productName;

    private String material;

    private String grade;

    private String executiveStandard;

    private String securityCategory;

    private String inspector;

    private String suggestedRetailPrice;

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour == null ? null : colour.trim();
    }

    public String getColourNumber() {
        return colourNumber;
    }

    public void setColourNumber(String colourNumber) {
        this.colourNumber = colourNumber == null ? null : colourNumber.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getHeadTripCost() {
        return headTripCost;
    }

    public void setHeadTripCost(BigDecimal headTripCost) {
        this.headTripCost = headTripCost;
    }

    public BigDecimal getHeadTripCostMin() {
        return headTripCostMin;
    }

    public void setHeadTripCostMin(BigDecimal headTripCostMin) {
        this.headTripCostMin = headTripCostMin;
    }

    public Integer getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(Integer inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
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

    public String getSecondSku() {
        return secondSku;
    }

    public void setSecondSku(String secondSku) {
        this.secondSku = secondSku == null ? null : secondSku.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material == null ? null : material.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getExecutiveStandard() {
        return executiveStandard;
    }

    public void setExecutiveStandard(String executiveStandard) {
        this.executiveStandard = executiveStandard == null ? null : executiveStandard.trim();
    }

    public String getSecurityCategory() {
        return securityCategory;
    }

    public void setSecurityCategory(String securityCategory) {
        this.securityCategory = securityCategory == null ? null : securityCategory.trim();
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector == null ? null : inspector.trim();
    }

    public String getSuggestedRetailPrice() {
        return suggestedRetailPrice;
    }

    public void setSuggestedRetailPrice(String suggestedRetailPrice) {
        this.suggestedRetailPrice = suggestedRetailPrice == null ? null : suggestedRetailPrice.trim();
    }
}