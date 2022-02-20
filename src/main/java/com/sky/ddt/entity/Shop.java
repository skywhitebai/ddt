package com.sky.ddt.entity;

import java.util.Date;

public class Shop {
    private Integer shopId;

    private String shopName;

    private String shopUrl;

    private String sellerId;

    private Integer countryId;

    private String shopMarketplaceId;

    private String mwsAuthToken;

    private String amazonAccessKey;

    private String amazonSecretKey;

    private String clientIp;

    private String clientMacAddress;

    private Date orderLastUpdatedAfter;

    private Date inventoryQueryStartDateTime;

    private Integer orderSynQuantity;

    private Integer orderSynIntervalMinute;

    private Integer inventorySynIntervalMinute;

    private Boolean status;

    private Integer type;

    private String remark;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl == null ? null : shopUrl.trim();
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getShopMarketplaceId() {
        return shopMarketplaceId;
    }

    public void setShopMarketplaceId(String shopMarketplaceId) {
        this.shopMarketplaceId = shopMarketplaceId == null ? null : shopMarketplaceId.trim();
    }

    public String getMwsAuthToken() {
        return mwsAuthToken;
    }

    public void setMwsAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken == null ? null : mwsAuthToken.trim();
    }

    public String getAmazonAccessKey() {
        return amazonAccessKey;
    }

    public void setAmazonAccessKey(String amazonAccessKey) {
        this.amazonAccessKey = amazonAccessKey == null ? null : amazonAccessKey.trim();
    }

    public String getAmazonSecretKey() {
        return amazonSecretKey;
    }

    public void setAmazonSecretKey(String amazonSecretKey) {
        this.amazonSecretKey = amazonSecretKey == null ? null : amazonSecretKey.trim();
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

    public Date getOrderLastUpdatedAfter() {
        return orderLastUpdatedAfter;
    }

    public void setOrderLastUpdatedAfter(Date orderLastUpdatedAfter) {
        this.orderLastUpdatedAfter = orderLastUpdatedAfter;
    }

    public Date getInventoryQueryStartDateTime() {
        return inventoryQueryStartDateTime;
    }

    public void setInventoryQueryStartDateTime(Date inventoryQueryStartDateTime) {
        this.inventoryQueryStartDateTime = inventoryQueryStartDateTime;
    }

    public Integer getOrderSynQuantity() {
        return orderSynQuantity;
    }

    public void setOrderSynQuantity(Integer orderSynQuantity) {
        this.orderSynQuantity = orderSynQuantity;
    }

    public Integer getOrderSynIntervalMinute() {
        return orderSynIntervalMinute;
    }

    public void setOrderSynIntervalMinute(Integer orderSynIntervalMinute) {
        this.orderSynIntervalMinute = orderSynIntervalMinute;
    }

    public Integer getInventorySynIntervalMinute() {
        return inventorySynIntervalMinute;
    }

    public void setInventorySynIntervalMinute(Integer inventorySynIntervalMinute) {
        this.inventorySynIntervalMinute = inventorySynIntervalMinute;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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