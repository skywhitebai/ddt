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

    private BigDecimal saleCost;

    private BigDecimal mainBusinessIncome;

    private BigDecimal manualAdjustment;

    private BigDecimal netIncome;

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