package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class InternalOrderNumber {
    private Integer id;

    private String orderNumber;

    private Integer number;

    private BigDecimal payAmount;

    private BigDecimal theoreticalAmount;

    private Integer theoreticalAmountStatus;

    private Date estimatedArrivalTime;

    private String remark;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    private Integer transportTypeId;

    private String financialRemark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getTheoreticalAmount() {
        return theoreticalAmount;
    }

    public void setTheoreticalAmount(BigDecimal theoreticalAmount) {
        this.theoreticalAmount = theoreticalAmount;
    }

    public Integer getTheoreticalAmountStatus() {
        return theoreticalAmountStatus;
    }

    public void setTheoreticalAmountStatus(Integer theoreticalAmountStatus) {
        this.theoreticalAmountStatus = theoreticalAmountStatus;
    }

    public Date getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    public void setEstimatedArrivalTime(Date estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
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

    public Integer getTransportTypeId() {
        return transportTypeId;
    }

    public void setTransportTypeId(Integer transportTypeId) {
        this.transportTypeId = transportTypeId;
    }

    public String getFinancialRemark() {
        return financialRemark;
    }

    public void setFinancialRemark(String financialRemark) {
        this.financialRemark = financialRemark == null ? null : financialRemark.trim();
    }
}