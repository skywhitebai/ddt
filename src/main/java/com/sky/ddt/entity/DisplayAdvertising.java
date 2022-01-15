package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class DisplayAdvertising {
    private Integer id;

    private Integer financeId;

    private Date startDate;

    private Date endDate;

    private String currency;

    private String campaignName;

    private String portfolioName;

    private String costType;

    private String adGroupName;

    private String bidOptimization;

    private String advertisedSku;

    private Integer shopSkuId;

    private String advertisedAsin;

    private Integer impressions;

    private Integer viewableImpressions;

    private Integer clicks;

    private BigDecimal clickThruRate;

    private Integer pageViewsDay14;

    private BigDecimal spend;

    private BigDecimal costPerClick;

    private Integer costPer1000ViewableImpressions;

    private BigDecimal totalAdvertisingCostOfSales;

    private BigDecimal totalReturnOnAdvertisingSpend;

    private Integer totalOrdersDay14;

    private Integer totalUnitsDay14;

    private BigDecimal totalSalesDay14;

    private BigDecimal conversionRateDay14;

    private Integer newToBrandOrdersDay14;

    private BigDecimal newToBrandSalesDay14;

    private Integer newToBrandUnitsDay14;

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName == null ? null : campaignName.trim();
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName == null ? null : portfolioName.trim();
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType == null ? null : costType.trim();
    }

    public String getAdGroupName() {
        return adGroupName;
    }

    public void setAdGroupName(String adGroupName) {
        this.adGroupName = adGroupName == null ? null : adGroupName.trim();
    }

    public String getBidOptimization() {
        return bidOptimization;
    }

    public void setBidOptimization(String bidOptimization) {
        this.bidOptimization = bidOptimization == null ? null : bidOptimization.trim();
    }

    public String getAdvertisedSku() {
        return advertisedSku;
    }

    public void setAdvertisedSku(String advertisedSku) {
        this.advertisedSku = advertisedSku == null ? null : advertisedSku.trim();
    }

    public Integer getShopSkuId() {
        return shopSkuId;
    }

    public void setShopSkuId(Integer shopSkuId) {
        this.shopSkuId = shopSkuId;
    }

    public String getAdvertisedAsin() {
        return advertisedAsin;
    }

    public void setAdvertisedAsin(String advertisedAsin) {
        this.advertisedAsin = advertisedAsin == null ? null : advertisedAsin.trim();
    }

    public Integer getImpressions() {
        return impressions;
    }

    public void setImpressions(Integer impressions) {
        this.impressions = impressions;
    }

    public Integer getViewableImpressions() {
        return viewableImpressions;
    }

    public void setViewableImpressions(Integer viewableImpressions) {
        this.viewableImpressions = viewableImpressions;
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public BigDecimal getClickThruRate() {
        return clickThruRate;
    }

    public void setClickThruRate(BigDecimal clickThruRate) {
        this.clickThruRate = clickThruRate;
    }

    public Integer getPageViewsDay14() {
        return pageViewsDay14;
    }

    public void setPageViewsDay14(Integer pageViewsDay14) {
        this.pageViewsDay14 = pageViewsDay14;
    }

    public BigDecimal getSpend() {
        return spend;
    }

    public void setSpend(BigDecimal spend) {
        this.spend = spend;
    }

    public BigDecimal getCostPerClick() {
        return costPerClick;
    }

    public void setCostPerClick(BigDecimal costPerClick) {
        this.costPerClick = costPerClick;
    }

    public Integer getCostPer1000ViewableImpressions() {
        return costPer1000ViewableImpressions;
    }

    public void setCostPer1000ViewableImpressions(Integer costPer1000ViewableImpressions) {
        this.costPer1000ViewableImpressions = costPer1000ViewableImpressions;
    }

    public BigDecimal getTotalAdvertisingCostOfSales() {
        return totalAdvertisingCostOfSales;
    }

    public void setTotalAdvertisingCostOfSales(BigDecimal totalAdvertisingCostOfSales) {
        this.totalAdvertisingCostOfSales = totalAdvertisingCostOfSales;
    }

    public BigDecimal getTotalReturnOnAdvertisingSpend() {
        return totalReturnOnAdvertisingSpend;
    }

    public void setTotalReturnOnAdvertisingSpend(BigDecimal totalReturnOnAdvertisingSpend) {
        this.totalReturnOnAdvertisingSpend = totalReturnOnAdvertisingSpend;
    }

    public Integer getTotalOrdersDay14() {
        return totalOrdersDay14;
    }

    public void setTotalOrdersDay14(Integer totalOrdersDay14) {
        this.totalOrdersDay14 = totalOrdersDay14;
    }

    public Integer getTotalUnitsDay14() {
        return totalUnitsDay14;
    }

    public void setTotalUnitsDay14(Integer totalUnitsDay14) {
        this.totalUnitsDay14 = totalUnitsDay14;
    }

    public BigDecimal getTotalSalesDay14() {
        return totalSalesDay14;
    }

    public void setTotalSalesDay14(BigDecimal totalSalesDay14) {
        this.totalSalesDay14 = totalSalesDay14;
    }

    public BigDecimal getConversionRateDay14() {
        return conversionRateDay14;
    }

    public void setConversionRateDay14(BigDecimal conversionRateDay14) {
        this.conversionRateDay14 = conversionRateDay14;
    }

    public Integer getNewToBrandOrdersDay14() {
        return newToBrandOrdersDay14;
    }

    public void setNewToBrandOrdersDay14(Integer newToBrandOrdersDay14) {
        this.newToBrandOrdersDay14 = newToBrandOrdersDay14;
    }

    public BigDecimal getNewToBrandSalesDay14() {
        return newToBrandSalesDay14;
    }

    public void setNewToBrandSalesDay14(BigDecimal newToBrandSalesDay14) {
        this.newToBrandSalesDay14 = newToBrandSalesDay14;
    }

    public Integer getNewToBrandUnitsDay14() {
        return newToBrandUnitsDay14;
    }

    public void setNewToBrandUnitsDay14(Integer newToBrandUnitsDay14) {
        this.newToBrandUnitsDay14 = newToBrandUnitsDay14;
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