package com.sky.ddt.entity;

import java.util.Date;

public class ProductDevelop {
    private Integer id;

    private String productName;

    private String productCode;

    private String description;

    private String chineseProductName;

    private String englishProductName;

    private Integer developerUserId;

    private Date developmentTime;

    private Integer status;

    private Integer productId;

    private String remark;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    private Integer developmentLevel;

    private String developmentDocUrl;

    private String confirmDocUrl;

    private String rawMaterial;

    private String productionSupplier;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public Integer getDevelopmentLevel() {
        return developmentLevel;
    }

    public void setDevelopmentLevel(Integer developmentLevel) {
        this.developmentLevel = developmentLevel;
    }

    public String getDevelopmentDocUrl() {
        return developmentDocUrl;
    }

    public void setDevelopmentDocUrl(String developmentDocUrl) {
        this.developmentDocUrl = developmentDocUrl == null ? null : developmentDocUrl.trim();
    }

    public String getConfirmDocUrl() {
        return confirmDocUrl;
    }

    public void setConfirmDocUrl(String confirmDocUrl) {
        this.confirmDocUrl = confirmDocUrl == null ? null : confirmDocUrl.trim();
    }

    public String getRawMaterial() {
        return rawMaterial;
    }

    public void setRawMaterial(String rawMaterial) {
        this.rawMaterial = rawMaterial == null ? null : rawMaterial.trim();
    }

    public String getProductionSupplier() {
        return productionSupplier;
    }

    public void setProductionSupplier(String productionSupplier) {
        this.productionSupplier = productionSupplier == null ? null : productionSupplier.trim();
    }
}