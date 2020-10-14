package com.sky.ddt.entity;

import java.util.Date;

public class ShopClientHis {
    private Integer id;

    private Integer shopId;

    private String clientIp;

    private String clientMacAddress;

    private Date createTime;

    private Long createBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp == null ? null : clientIp.trim();
    }

    public String getClientMacAddress() {
        return clientMacAddress;
    }

    public void setClientMacAddress(String clientMacAddress) {
        this.clientMacAddress = clientMacAddress == null ? null : clientMacAddress.trim();
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