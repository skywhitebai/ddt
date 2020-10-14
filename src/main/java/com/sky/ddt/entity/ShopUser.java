package com.sky.ddt.entity;

import java.util.Date;

public class ShopUser extends ShopUserKey {
    private Integer createBy;

    private Date createTime;

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}