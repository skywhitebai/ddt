package com.sky.ddt.entity;

import java.util.Date;

public class SalesGroupUser {
    private Integer id;

    private Integer salesGroupId;

    private Integer userId;

    private Date createTime;

    private Integer createBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSalesGroupId() {
        return salesGroupId;
    }

    public void setSalesGroupId(Integer salesGroupId) {
        this.salesGroupId = salesGroupId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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