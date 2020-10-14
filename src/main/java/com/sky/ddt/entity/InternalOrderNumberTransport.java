package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class InternalOrderNumberTransport {
    private Integer id;

    private Integer internalOrderNumberId;

    private String subOrderNumber;

    private String fbaShipmentId;

    private String fbaShipmentIdShort;

    private String shipmentId;

    private String transferOrderNo;

    private Integer transportTypeId;

    private BigDecimal headTripCostRate;

    private Integer lockHeadTripCostRate;

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

    public Integer getInternalOrderNumberId() {
        return internalOrderNumberId;
    }

    public void setInternalOrderNumberId(Integer internalOrderNumberId) {
        this.internalOrderNumberId = internalOrderNumberId;
    }

    public String getSubOrderNumber() {
        return subOrderNumber;
    }

    public void setSubOrderNumber(String subOrderNumber) {
        this.subOrderNumber = subOrderNumber == null ? null : subOrderNumber.trim();
    }

    public String getFbaShipmentId() {
        return fbaShipmentId;
    }

    public void setFbaShipmentId(String fbaShipmentId) {
        this.fbaShipmentId = fbaShipmentId == null ? null : fbaShipmentId.trim();
    }

    public String getFbaShipmentIdShort() {
        return fbaShipmentIdShort;
    }

    public void setFbaShipmentIdShort(String fbaShipmentIdShort) {
        this.fbaShipmentIdShort = fbaShipmentIdShort == null ? null : fbaShipmentIdShort.trim();
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId == null ? null : shipmentId.trim();
    }

    public String getTransferOrderNo() {
        return transferOrderNo;
    }

    public void setTransferOrderNo(String transferOrderNo) {
        this.transferOrderNo = transferOrderNo == null ? null : transferOrderNo.trim();
    }

    public Integer getTransportTypeId() {
        return transportTypeId;
    }

    public void setTransportTypeId(Integer transportTypeId) {
        this.transportTypeId = transportTypeId;
    }

    public BigDecimal getHeadTripCostRate() {
        return headTripCostRate;
    }

    public void setHeadTripCostRate(BigDecimal headTripCostRate) {
        this.headTripCostRate = headTripCostRate;
    }

    public Integer getLockHeadTripCostRate() {
        return lockHeadTripCostRate;
    }

    public void setLockHeadTripCostRate(Integer lockHeadTripCostRate) {
        this.lockHeadTripCostRate = lockHeadTripCostRate;
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