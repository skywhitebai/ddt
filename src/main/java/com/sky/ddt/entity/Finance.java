package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Finance {
    private Integer id;

    private Integer shopId;

    private Date month;

    private Boolean monthlySales;

    private Boolean lightingDeal;

    private Boolean monthlyStorageFee;

    private Boolean monthlyAdvertisingFee;

    private Boolean displayAdvertising;

    private Boolean brandAdvertising;

    private Boolean removeOrders;

    private Boolean destructionFee;

    private Boolean destructionDetails;

    private Boolean fbaCustomerReturnFee;

    private Boolean coupon;

    private Boolean earlyReviewerProgramFee;

    private Boolean longStorageFee;

    private Boolean refundOperationFee;

    private Boolean inventoryDetails;

    private Boolean headDeduction;

    private Boolean manualAdjustment;

    private Integer status;

    private String remark;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    private BigDecimal rateOfDollarExchangeRmb;

    private Integer statisticStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public Boolean getMonthlySales() {
        return monthlySales;
    }

    public void setMonthlySales(Boolean monthlySales) {
        this.monthlySales = monthlySales;
    }

    public Boolean getLightingDeal() {
        return lightingDeal;
    }

    public void setLightingDeal(Boolean lightingDeal) {
        this.lightingDeal = lightingDeal;
    }

    public Boolean getMonthlyStorageFee() {
        return monthlyStorageFee;
    }

    public void setMonthlyStorageFee(Boolean monthlyStorageFee) {
        this.monthlyStorageFee = monthlyStorageFee;
    }

    public Boolean getMonthlyAdvertisingFee() {
        return monthlyAdvertisingFee;
    }

    public void setMonthlyAdvertisingFee(Boolean monthlyAdvertisingFee) {
        this.monthlyAdvertisingFee = monthlyAdvertisingFee;
    }

    public Boolean getDisplayAdvertising() {
        return displayAdvertising;
    }

    public void setDisplayAdvertising(Boolean displayAdvertising) {
        this.displayAdvertising = displayAdvertising;
    }

    public Boolean getBrandAdvertising() {
        return brandAdvertising;
    }

    public void setBrandAdvertising(Boolean brandAdvertising) {
        this.brandAdvertising = brandAdvertising;
    }

    public Boolean getRemoveOrders() {
        return removeOrders;
    }

    public void setRemoveOrders(Boolean removeOrders) {
        this.removeOrders = removeOrders;
    }

    public Boolean getDestructionFee() {
        return destructionFee;
    }

    public void setDestructionFee(Boolean destructionFee) {
        this.destructionFee = destructionFee;
    }

    public Boolean getDestructionDetails() {
        return destructionDetails;
    }

    public void setDestructionDetails(Boolean destructionDetails) {
        this.destructionDetails = destructionDetails;
    }

    public Boolean getFbaCustomerReturnFee() {
        return fbaCustomerReturnFee;
    }

    public void setFbaCustomerReturnFee(Boolean fbaCustomerReturnFee) {
        this.fbaCustomerReturnFee = fbaCustomerReturnFee;
    }

    public Boolean getCoupon() {
        return coupon;
    }

    public void setCoupon(Boolean coupon) {
        this.coupon = coupon;
    }

    public Boolean getEarlyReviewerProgramFee() {
        return earlyReviewerProgramFee;
    }

    public void setEarlyReviewerProgramFee(Boolean earlyReviewerProgramFee) {
        this.earlyReviewerProgramFee = earlyReviewerProgramFee;
    }

    public Boolean getLongStorageFee() {
        return longStorageFee;
    }

    public void setLongStorageFee(Boolean longStorageFee) {
        this.longStorageFee = longStorageFee;
    }

    public Boolean getRefundOperationFee() {
        return refundOperationFee;
    }

    public void setRefundOperationFee(Boolean refundOperationFee) {
        this.refundOperationFee = refundOperationFee;
    }

    public Boolean getInventoryDetails() {
        return inventoryDetails;
    }

    public void setInventoryDetails(Boolean inventoryDetails) {
        this.inventoryDetails = inventoryDetails;
    }

    public Boolean getHeadDeduction() {
        return headDeduction;
    }

    public void setHeadDeduction(Boolean headDeduction) {
        this.headDeduction = headDeduction;
    }

    public Boolean getManualAdjustment() {
        return manualAdjustment;
    }

    public void setManualAdjustment(Boolean manualAdjustment) {
        this.manualAdjustment = manualAdjustment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public BigDecimal getRateOfDollarExchangeRmb() {
        return rateOfDollarExchangeRmb;
    }

    public void setRateOfDollarExchangeRmb(BigDecimal rateOfDollarExchangeRmb) {
        this.rateOfDollarExchangeRmb = rateOfDollarExchangeRmb;
    }

    public Integer getStatisticStatus() {
        return statisticStatus;
    }

    public void setStatisticStatus(Integer statisticStatus) {
        this.statisticStatus = statisticStatus;
    }
}