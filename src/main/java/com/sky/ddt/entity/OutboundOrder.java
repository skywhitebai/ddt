package com.sky.ddt.entity;

import java.util.Date;

public class OutboundOrder {
    private Integer id;

    private Date outboundTime;

    private Integer shopId;

    private Integer outboundShopId;

    private String batchNumber;

    private String fbaNo;

    private Integer type;

    private Integer status;

    private Integer fbaPackingListId;

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

    public Date getOutboundTime() {
        return outboundTime;
    }

    public void setOutboundTime(Date outboundTime) {
        this.outboundTime = outboundTime;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getOutboundShopId() {
        return outboundShopId;
    }

    public void setOutboundShopId(Integer outboundShopId) {
        this.outboundShopId = outboundShopId;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber == null ? null : batchNumber.trim();
    }

    public String getFbaNo() {
        return fbaNo;
    }

    public void setFbaNo(String fbaNo) {
        this.fbaNo = fbaNo == null ? null : fbaNo.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFbaPackingListId() {
        return fbaPackingListId;
    }

    public void setFbaPackingListId(Integer fbaPackingListId) {
        this.fbaPackingListId = fbaPackingListId;
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