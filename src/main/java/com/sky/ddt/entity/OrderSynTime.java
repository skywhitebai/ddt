package com.sky.ddt.entity;

import java.util.Date;

public class OrderSynTime extends OrderSynTimeKey {
    private Date lastUpdatedAfter;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    public Date getLastUpdatedAfter() {
        return lastUpdatedAfter;
    }

    public void setLastUpdatedAfter(Date lastUpdatedAfter) {
        this.lastUpdatedAfter = lastUpdatedAfter;
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