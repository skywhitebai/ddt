package com.sky.ddt.entity;

import java.util.Date;

public class JdSku {
    private Integer id;

    private String jdSku;

    private String productName;

    private String jdPopCode;

    private String category;

    private String brand;

    private String model;

    private String spec;

    private String material;

    private String criteria;

    private String securityCategories;

    private String qualityGrade;

    private String inspector;

    private String manufacturer;

    private String productionAddress;

    private Integer printTemplate;

    private String remark;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJdSku() {
        return jdSku;
    }

    public void setJdSku(String jdSku) {
        this.jdSku = jdSku == null ? null : jdSku.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getJdPopCode() {
        return jdPopCode;
    }

    public void setJdPopCode(String jdPopCode) {
        this.jdPopCode = jdPopCode == null ? null : jdPopCode.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material == null ? null : material.trim();
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria == null ? null : criteria.trim();
    }

    public String getSecurityCategories() {
        return securityCategories;
    }

    public void setSecurityCategories(String securityCategories) {
        this.securityCategories = securityCategories == null ? null : securityCategories.trim();
    }

    public String getQualityGrade() {
        return qualityGrade;
    }

    public void setQualityGrade(String qualityGrade) {
        this.qualityGrade = qualityGrade == null ? null : qualityGrade.trim();
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector == null ? null : inspector.trim();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public String getProductionAddress() {
        return productionAddress;
    }

    public void setProductionAddress(String productionAddress) {
        this.productionAddress = productionAddress == null ? null : productionAddress.trim();
    }

    public Integer getPrintTemplate() {
        return printTemplate;
    }

    public void setPrintTemplate(Integer printTemplate) {
        this.printTemplate = printTemplate;
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
}