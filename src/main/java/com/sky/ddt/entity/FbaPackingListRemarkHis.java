package com.sky.ddt.entity;

import java.util.Date;

public class FbaPackingListRemarkHis {
    private Integer id;

    private Integer fbaPackingListId;

    private String remark;

    private Date createTime;

    private Integer createBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}