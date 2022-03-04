package com.sky.ddt.entity;

import java.util.Date;

public class InternalOrderNumberFinancialRemarkHis {
    private Integer id;

    private Integer internalOrderNumberId;

    private String financialRemark;

    private Date createTime;

    private Integer createBy;

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

    public String getFinancialRemark() {
        return financialRemark;
    }

    public void setFinancialRemark(String financialRemark) {
        this.financialRemark = financialRemark == null ? null : financialRemark.trim();
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