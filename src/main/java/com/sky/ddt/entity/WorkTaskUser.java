package com.sky.ddt.entity;

import java.util.Date;

public class WorkTaskUser {
    private Long id;

    private Integer workTaskId;

    private Integer userId;

    private Date createTime;

    private Integer createBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getWorkTaskId() {
        return workTaskId;
    }

    public void setWorkTaskId(Integer workTaskId) {
        this.workTaskId = workTaskId;
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