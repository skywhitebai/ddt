package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class MonthlyStorageFee {
    private Integer id;

    private Integer financeId;

    private String asin;

    private String fnsku;

    private String sku;

    private Integer shopSkuId;

    private String productName;

    private String fulfillmentCenter;

    private String countryCode;

    private BigDecimal longestSide;

    private BigDecimal medianSide;

    private BigDecimal shortestSide;

    private String measurementUnits;

    private BigDecimal weight;

    private String weightUnits;

    private BigDecimal itemVolume;

    private String volumeUnits;

    private String productSizeTier;

    private BigDecimal averageQuantityOnHand;

    private BigDecimal averageQuantityPendingRemoval;

    private BigDecimal estimatedTotalItemVolume;

    private String monthOfCharge;

    private BigDecimal storageRate;

    private String currency;

    private BigDecimal estimatedMonthlyStorageFee;

    private String dangerousGoodsStorageType;

    private Boolean eligibleForInventoryDiscount;

    private Boolean qualifiesForInventoryDiscount;

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

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin == null ? null : asin.trim();
    }

    public String getFnsku() {
        return fnsku;
    }

    public void setFnsku(String fnsku) {
        this.fnsku = fnsku == null ? null : fnsku.trim();
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getFulfillmentCenter() {
        return fulfillmentCenter;
    }

    public void setFulfillmentCenter(String fulfillmentCenter) {
        this.fulfillmentCenter = fulfillmentCenter == null ? null : fulfillmentCenter.trim();
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
    }

    public BigDecimal getLongestSide() {
        return longestSide;
    }

    public void setLongestSide(BigDecimal longestSide) {
        this.longestSide = longestSide;
    }

    public BigDecimal getMedianSide() {
        return medianSide;
    }

    public void setMedianSide(BigDecimal medianSide) {
        this.medianSide = medianSide;
    }

    public BigDecimal getShortestSide() {
        return shortestSide;
    }

    public void setShortestSide(BigDecimal shortestSide) {
        this.shortestSide = shortestSide;
    }

    public String getMeasurementUnits() {
        return measurementUnits;
    }

    public void setMeasurementUnits(String measurementUnits) {
        this.measurementUnits = measurementUnits == null ? null : measurementUnits.trim();
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getWeightUnits() {
        return weightUnits;
    }

    public void setWeightUnits(String weightUnits) {
        this.weightUnits = weightUnits == null ? null : weightUnits.trim();
    }

    public BigDecimal getItemVolume() {
        return itemVolume;
    }

    public void setItemVolume(BigDecimal itemVolume) {
        this.itemVolume = itemVolume;
    }

    public String getVolumeUnits() {
        return volumeUnits;
    }

    public void setVolumeUnits(String volumeUnits) {
        this.volumeUnits = volumeUnits == null ? null : volumeUnits.trim();
    }

    public String getProductSizeTier() {
        return productSizeTier;
    }

    public void setProductSizeTier(String productSizeTier) {
        this.productSizeTier = productSizeTier == null ? null : productSizeTier.trim();
    }

    public BigDecimal getAverageQuantityOnHand() {
        return averageQuantityOnHand;
    }

    public void setAverageQuantityOnHand(BigDecimal averageQuantityOnHand) {
        this.averageQuantityOnHand = averageQuantityOnHand;
    }

    public BigDecimal getAverageQuantityPendingRemoval() {
        return averageQuantityPendingRemoval;
    }

    public void setAverageQuantityPendingRemoval(BigDecimal averageQuantityPendingRemoval) {
        this.averageQuantityPendingRemoval = averageQuantityPendingRemoval;
    }

    public BigDecimal getEstimatedTotalItemVolume() {
        return estimatedTotalItemVolume;
    }

    public void setEstimatedTotalItemVolume(BigDecimal estimatedTotalItemVolume) {
        this.estimatedTotalItemVolume = estimatedTotalItemVolume;
    }

    public String getMonthOfCharge() {
        return monthOfCharge;
    }

    public void setMonthOfCharge(String monthOfCharge) {
        this.monthOfCharge = monthOfCharge == null ? null : monthOfCharge.trim();
    }

    public BigDecimal getStorageRate() {
        return storageRate;
    }

    public void setStorageRate(BigDecimal storageRate) {
        this.storageRate = storageRate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public BigDecimal getEstimatedMonthlyStorageFee() {
        return estimatedMonthlyStorageFee;
    }

    public void setEstimatedMonthlyStorageFee(BigDecimal estimatedMonthlyStorageFee) {
        this.estimatedMonthlyStorageFee = estimatedMonthlyStorageFee;
    }

    public String getDangerousGoodsStorageType() {
        return dangerousGoodsStorageType;
    }

    public void setDangerousGoodsStorageType(String dangerousGoodsStorageType) {
        this.dangerousGoodsStorageType = dangerousGoodsStorageType == null ? null : dangerousGoodsStorageType.trim();
    }

    public Boolean getEligibleForInventoryDiscount() {
        return eligibleForInventoryDiscount;
    }

    public void setEligibleForInventoryDiscount(Boolean eligibleForInventoryDiscount) {
        this.eligibleForInventoryDiscount = eligibleForInventoryDiscount;
    }

    public Boolean getQualifiesForInventoryDiscount() {
        return qualifiesForInventoryDiscount;
    }

    public void setQualifiesForInventoryDiscount(Boolean qualifiesForInventoryDiscount) {
        this.qualifiesForInventoryDiscount = qualifiesForInventoryDiscount;
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