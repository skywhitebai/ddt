package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class MonthlyAdvertisingFee {
    private Integer id;

    private Integer financeId;

    private Date startDate;

    private Date endDate;

    private String adMixName;

    private String currency;

    private String adName;

    private String adGroupName;

    private String sku;

    private Integer shopSkuId;

    private String asin;

    private Integer displayQuantity;

    private Integer clickQuantity;

    private BigDecimal clickThroughRate;

    private BigDecimal costPerClick;

    private BigDecimal cost;

    private BigDecimal totalSalesIn7Days;

    private BigDecimal advertisingCostSalesRatio;

    private BigDecimal inputOutputRatio;

    private Integer totalOrdersIn7Days;

    private Integer totalSalesQuantityIn7Days;

    private BigDecimal conversionIn7Days;

    private Integer adSkuSalesQuantityIn7Days;

    private Integer otherSkuSalesQuantityIn7Days;

    private BigDecimal adSkuSalesIn7Days;

    private BigDecimal otherSkuSalesIn7Days;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAdMixName() {
        return adMixName;
    }

    public void setAdMixName(String adMixName) {
        this.adMixName = adMixName == null ? null : adMixName.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName == null ? null : adName.trim();
    }

    public String getAdGroupName() {
        return adGroupName;
    }

    public void setAdGroupName(String adGroupName) {
        this.adGroupName = adGroupName == null ? null : adGroupName.trim();
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

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin == null ? null : asin.trim();
    }

    public Integer getDisplayQuantity() {
        return displayQuantity;
    }

    public void setDisplayQuantity(Integer displayQuantity) {
        this.displayQuantity = displayQuantity;
    }

    public Integer getClickQuantity() {
        return clickQuantity;
    }

    public void setClickQuantity(Integer clickQuantity) {
        this.clickQuantity = clickQuantity;
    }

    public BigDecimal getClickThroughRate() {
        return clickThroughRate;
    }

    public void setClickThroughRate(BigDecimal clickThroughRate) {
        this.clickThroughRate = clickThroughRate;
    }

    public BigDecimal getCostPerClick() {
        return costPerClick;
    }

    public void setCostPerClick(BigDecimal costPerClick) {
        this.costPerClick = costPerClick;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getTotalSalesIn7Days() {
        return totalSalesIn7Days;
    }

    public void setTotalSalesIn7Days(BigDecimal totalSalesIn7Days) {
        this.totalSalesIn7Days = totalSalesIn7Days;
    }

    public BigDecimal getAdvertisingCostSalesRatio() {
        return advertisingCostSalesRatio;
    }

    public void setAdvertisingCostSalesRatio(BigDecimal advertisingCostSalesRatio) {
        this.advertisingCostSalesRatio = advertisingCostSalesRatio;
    }

    public BigDecimal getInputOutputRatio() {
        return inputOutputRatio;
    }

    public void setInputOutputRatio(BigDecimal inputOutputRatio) {
        this.inputOutputRatio = inputOutputRatio;
    }

    public Integer getTotalOrdersIn7Days() {
        return totalOrdersIn7Days;
    }

    public void setTotalOrdersIn7Days(Integer totalOrdersIn7Days) {
        this.totalOrdersIn7Days = totalOrdersIn7Days;
    }

    public Integer getTotalSalesQuantityIn7Days() {
        return totalSalesQuantityIn7Days;
    }

    public void setTotalSalesQuantityIn7Days(Integer totalSalesQuantityIn7Days) {
        this.totalSalesQuantityIn7Days = totalSalesQuantityIn7Days;
    }

    public BigDecimal getConversionIn7Days() {
        return conversionIn7Days;
    }

    public void setConversionIn7Days(BigDecimal conversionIn7Days) {
        this.conversionIn7Days = conversionIn7Days;
    }

    public Integer getAdSkuSalesQuantityIn7Days() {
        return adSkuSalesQuantityIn7Days;
    }

    public void setAdSkuSalesQuantityIn7Days(Integer adSkuSalesQuantityIn7Days) {
        this.adSkuSalesQuantityIn7Days = adSkuSalesQuantityIn7Days;
    }

    public Integer getOtherSkuSalesQuantityIn7Days() {
        return otherSkuSalesQuantityIn7Days;
    }

    public void setOtherSkuSalesQuantityIn7Days(Integer otherSkuSalesQuantityIn7Days) {
        this.otherSkuSalesQuantityIn7Days = otherSkuSalesQuantityIn7Days;
    }

    public BigDecimal getAdSkuSalesIn7Days() {
        return adSkuSalesIn7Days;
    }

    public void setAdSkuSalesIn7Days(BigDecimal adSkuSalesIn7Days) {
        this.adSkuSalesIn7Days = adSkuSalesIn7Days;
    }

    public BigDecimal getOtherSkuSalesIn7Days() {
        return otherSkuSalesIn7Days;
    }

    public void setOtherSkuSalesIn7Days(BigDecimal otherSkuSalesIn7Days) {
        this.otherSkuSalesIn7Days = otherSkuSalesIn7Days;
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