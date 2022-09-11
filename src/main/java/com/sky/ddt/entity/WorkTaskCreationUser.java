package com.sky.ddt.entity;

import java.util.Date;

public class WorkTaskCreationUser {
    private Long id;

    private Long workTaskCreationId;

    private Long userId;

    private Date createTime;

    private Long createBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWorkTaskCreationId() {
        return workTaskCreationId;
    }

    public void setWorkTaskCreationId(Long workTaskCreationId) {
        this.workTaskCreationId = workTaskCreationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }
}