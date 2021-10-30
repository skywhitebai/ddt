package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private Integer productId;

    private String productName;

    private String productCode;

    private String chineseProductName;

    private String englishProductName;

    private String hsCode;

    private BigDecimal labourCost;

    private String description;

    private Integer developerUserId;

    private Date developmentTime;

    private String remark;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

    private Integer developmentLevel;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getChineseProductName() {
        return chineseProductName;
    }

    public void setChineseProductName(String chineseProductName) {
        this.chineseProductName = chineseProductName == null ? null : chineseProductName.trim();
    }

    public String getEnglishProductName() {
        return englishProductName;
    }

    public void setEnglishProductName(String englishProductName) {
        this.englishProductName = englishProductName == null ? null : englishProductName.trim();
    }

    public String getHsCode() {
        return hsCode;
    }

    public void setHsCode(String hsCode) {
        this.hsCode = hsCode == null ? null : hsCode.trim();
    }

    public BigDecimal getLabourCost() {
        return labourCost;
    }

    public void setLabourCost(BigDecimal labourCost) {
        this.labourCost = labourCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getDeveloperUserId() {
        return developerUserId;
    }

    public void setDeveloperUserId(Integer developerUserId) {
        this.developerUserId = developerUserId;
    }

    public Date getDevelopmentTime() {
        return developmentTime;
    }

    public void setDevelopmentTime(Date developmentTime) {
        this.developmentTime = developmentTime;
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

    public Integer getDevelopmentLevel() {
        return developmentLevel;
    }

    public void setDevelopmentLevel(Integer developmentLevel) {
        this.developmentLevel = developmentLevel;
    }
}