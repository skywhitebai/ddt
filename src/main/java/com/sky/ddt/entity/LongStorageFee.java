package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class LongStorageFee {
    private Integer id;

    private Integer financeId;

    private Date snapshotDate;

    private String sku;

    private Integer shopSkuId;

    private String fnsku;

    private String asin;

    private String productName;

    private String conditionType;

    private BigDecimal qtyCharged12MoLongTermStorageFee;

    private BigDecimal perUnitVolume;

    private String currency;

    private BigDecimal mo12LongTermsStorageFee;

    private BigDecimal qtyCharged6MoLongTermStorageFee;

    private BigDecimal mo6LongTermsStorageFee;

    private String volumeUnit;

    private String country;

    private String enrolledInSmallAndLight;

    private Date createTime;

    private Integer createBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFinanceId() {
        return financeId;
    }

    public void setFinanceId(Integer financeId) {
        this.financeId = financeId;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public void setSnapshotDate(Date snapshotDate) {
        this.snapshotDate = snapshotDate;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    public Integer getShopSkuId() {
        return shopSkuId;
    }

    public void setShopSkuId(Integer shopSkuId) {
        this.shopSkuId = shopSkuId;
    }

    public String getFnsku() {
        return fnsku;
    }

    public void setFnsku(String fnsku) {
        this.fnsku = fnsku == null ? null : fnsku.trim();
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin == null ? null : asin.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getConditionType() {
        return conditionType;
    }

    public void setConditionType(String conditionType) {
        this.conditionType = conditionType == null ? null : conditionType.trim();
    }

    public BigDecimal getQtyCharged12MoLongTermStorageFee() {
        return qtyCharged12MoLongTermStorageFee;
    }

    public void setQtyCharged12MoLongTermStorageFee(BigDecimal qtyCharged12MoLongTermStorageFee) {
        this.qtyCharged12MoLongTermStorageFee = qtyCharged12MoLongTermStorageFee;
    }

    public BigDecimal getPerUnitVolume() {
        return perUnitVolume;
    }

    public void setPerUnitVolume(BigDecimal perUnitVolume) {
        this.perUnitVolume = perUnitVolume;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public BigDecimal getMo12LongTermsStorageFee() {
        return mo12LongTermsStorageFee;
    }

    public void setMo12LongTermsStorageFee(BigDecimal mo12LongTermsStorageFee) {
        this.mo12LongTermsStorageFee = mo12LongTermsStorageFee;
    }

    public BigDecimal getQtyCharged6MoLongTermStorageFee() {
        return qtyCharged6MoLongTermStorageFee;
    }

    public void setQtyCharged6MoLongTermStorageFee(BigDecimal qtyCharged6MoLongTermStorageFee) {
        this.qtyCharged6MoLongTermStorageFee = qtyCharged6MoLongTermStorageFee;
    }

    public BigDecimal getMo6LongTermsStorageFee() {
        return mo6LongTermsStorageFee;
    }

    public void setMo6LongTermsStorageFee(BigDecimal mo6LongTermsStorageFee) {
        this.mo6LongTermsStorageFee = mo6LongTermsStorageFee;
    }

    public String getVolumeUnit() {
        return volumeUnit;
    }

    public void setVolumeUnit(String volumeUnit) {
        this.volumeUnit = volumeUnit == null ? null : volumeUnit.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getEnrolledInSmallAndLight() {
        return enrolledInSmallAndLight;
    }

    public void setEnrolledInSmallAndLight(String enrolledInSmallAndLight) {
        this.enrolledInSmallAndLight = enrolledInSmallAndLight == null ? null : enrolledInSmallAndLight.trim();
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
}