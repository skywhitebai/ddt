package com.sky.ddt.entity;

import java.util.Date;

public class WorkTaskCreationRole {
    private Long id;

    private Long workTaskCreationId;

    private Long roleId;

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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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