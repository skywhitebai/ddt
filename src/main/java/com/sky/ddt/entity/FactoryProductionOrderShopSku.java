package com.sky.ddt.entity;

import java.util.Date;

public class FactoryProductionOrderShopSku {
    private Integer id;

    private Integer factoryProductionOrderId;

    private Integer shopSkuId;

    private Integer productionQuantity;

    private String remark;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFactoryProductionOrderId() {
        return factoryProductionOrderId;
    }

    public void setFactoryProductionOrderId(Integer factoryProductionOrderId) {
        this.factoryProductionOrderId = factoryProductionOrderId;
    }

    public Integer getShopSkuId() {
        return shopSkuId;
    }

    public void setShopSkuId(Integer shopSkuId) {
        this.shopSkuId = shopSkuId;
    }

    public Integer getProductionQuantity() {
        return productionQuantity;
    }

    public void setProductionQuantity(Integer productionQuantity) {
        this.productionQuantity = productionQuantity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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