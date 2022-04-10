package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class FinanceStatistic {
    private Integer id;

    private Integer financeId;

    private Date month;

    private Integer shopId;

    private String shopName;

    private BigDecimal initialInventoryCost;

    private BigDecimal finalInventoryCost;

    private BigDecimal sendCost;

    private BigDecimal sendCostPrice;

    private BigDecimal sendHeadTripCostAfter;

    private BigDecimal saleCost;

    private BigDecimal mainBusinessIncome;

    private BigDecimal manualAdjustment;

    private BigDecimal netIncome;

    private BigDecimal mainBusinessProfit;

    private Integer saleQuantity;

    private BigDecimal productSales;

    private BigDecimal moneyBackRate;

    private BigDecimal refundRate;

    private BigDecimal advertisingSalesPercentage;

    private BigDecimal roi;

    private BigDecimal inventoryTurnover;

    private String remark;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

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

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public BigDecimal getInitialInventoryCost() {
        return initialInventoryCost;
    }

    public void setInitialInventoryCost(BigDecimal initialInventoryCost) {
        this.initialInventoryCost = initialInventoryCost;
    }

    public BigDecimal getFinalInventoryCost() {
        return finalInventoryCost;
    }

    public void setFinalInventoryCost(BigDecimal finalInventoryCost) {
        this.finalInventoryCost = finalInventoryCost;
    }

    public BigDecimal getSendCost() {
        return sendCost;
    }

    public void setSendCost(BigDecimal sendCost) {
        this.sendCost = sendCost;
    }

    public BigDecimal getSendCostPrice() {
        return sendCostPrice;
    }

    public void setSendCostPrice(BigDecimal sendCostPrice) {
        this.sendCostPrice = sendCostPrice;
    }

    public BigDecimal getSendHeadTripCostAfter() {
        return sendHeadTripCostAfter;
    }

    public void setSendHeadTripCostAfter(BigDecimal sendHeadTripCostAfter) {
        this.sendHeadTripCostAfter = sendHeadTripCostAfter;
    }

    public BigDecimal getSaleCost() {
        return saleCost;
    }

    public void setSaleCost(BigDecimal saleCost) {
        this.saleCost = saleCost;
    }

    public BigDecimal getMainBusinessIncome() {
        return mainBusinessIncome;
    }

    public void setMainBusinessIncome(BigDecimal mainBusinessIncome) {
        this.mainBusinessIncome = mainBusinessIncome;
    }

    public BigDecimal getManualAdjustment() {
        return manualAdjustment;
    }

    public void setManualAdjustment(BigDecimal manualAdjustment) {
        this.manualAdjustment = manualAdjustment;
    }

    public BigDecimal getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(BigDecimal netIncome) {
        this.netIncome = netIncome;
    }

    public BigDecimal getMainBusinessProfit() {
        return mainBusinessProfit;
    }

    public void setMainBusinessProfit(BigDecimal mainBusinessProfit) {
        this.mainBusinessProfit = mainBusinessProfit;
    }

    public Integer getSaleQuantity() {
        return saleQuantity;
    }

    public void setSaleQuantity(Integer saleQuantity) {
        this.saleQuantity = saleQuantity;
    }

    public BigDecimal getProductSales() {
        return productSales;
    }

    public void setProductSales(BigDecimal productSales) {
        this.productSales = productSales;
    }

    public BigDecimal getMoneyBackRate() {
        return moneyBackRate;
    }

    public void setMoneyBackRate(BigDecimal moneyBackRate) {
        this.moneyBackRate = moneyBackRate;
    }

    public BigDecimal getRefundRate() {
        return refundRate;
    }

    public void setRefundRate(BigDecimal refundRate) {
        this.refundRate = refundRate;
    }

    public BigDecimal getAdvertisingSalesPercentage() {
        return advertisingSalesPercentage;
    }

    public void setAdvertisingSalesPercentage(BigDecimal advertisingSalesPercentage) {
        this.advertisingSalesPercentage = advertisingSalesPercentage;
    }

    public BigDecimal getRoi() {
        return roi;
    }

    public void setRoi(BigDecimal roi) {
        this.roi = roi;
    }

    public BigDecimal getInventoryTurnover() {
        return inventoryTurnover;
    }

    public void setInventoryTurnover(BigDecimal inventoryTurnover) {
        this.inventoryTurnover = inventoryTurnover;
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
}