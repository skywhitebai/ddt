package com.sky.ddt.entity;

import java.util.Date;

public class ShopSenderAddress {
    private Integer shopId;

    private String shipToCountry;

    private String addressName;

    private String addressFieldOne;

    private String addressFieldTwo;

    private String addressCity;

    private String addressCountryCode;

    private String addressStateOrRegion;

    private String addressPostalCode;

    private String addressDistrict;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShipToCountry() {
        return shipToCountry;
    }

    public void setShipToCountry(String shipToCountry) {
        this.shipToCountry = shipToCountry == null ? null : shipToCountry.trim();
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName == null ? null : addressName.trim();
    }

    public String getAddressFieldOne() {
        return addressFieldOne;
    }

    public void setAddressFieldOne(String addressFieldOne) {
        this.addressFieldOne = addressFieldOne == null ? null : addressFieldOne.trim();
    }

    public String getAddressFieldTwo() {
        return addressFieldTwo;
    }

    public void setAddressFieldTwo(String addressFieldTwo) {
        this.addressFieldTwo = addressFieldTwo == null ? null : addressFieldTwo.trim();
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity == null ? null : addressCity.trim();
    }

    public String getAddressCountryCode() {
        return addressCountryCode;
    }

    public void setAddressCountryCode(String addressCountryCode) {
        this.addressCountryCode = addressCountryCode == null ? null : addressCountryCode.trim();
    }

    public String getAddressStateOrRegion() {
        return addressStateOrRegion;
    }

    public void setAddressStateOrRegion(String addressStateOrRegion) {
        this.addressStateOrRegion = addressStateOrRegion == null ? null : addressStateOrRegion.trim();
    }

    public String getAddressPostalCode() {
        return addressPostalCode;
    }

    public void setAddressPostalCode(String addressPostalCode) {
        this.addressPostalCode = addressPostalCode == null ? null : addressPostalCode.trim();
    }

    public String getAddressDistrict() {
        return addressDistrict;
    }

    public void setAddressDistrict(String addressDistrict) {
        this.addressDistrict = addressDistrict == null ? null : addressDistrict.trim();
    }

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

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}