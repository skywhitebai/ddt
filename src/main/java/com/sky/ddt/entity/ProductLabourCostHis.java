package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ProductLabourCostHis {
    private Integer id;

    private Integer productId;

    private BigDecimal labourCostBefore;

    private BigDecimal labourCostAfter;

    private Integer type;

    private String remark;

    private Integer createBy;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getLabourCostBefore() {
        return labourCostBefore;
    }

    public void setLabourCostBefore(BigDecimal labourCostBefore) {
        this.labourCostBefore = labourCostBefore;
    }

    public BigDecimal getLabourCostAfter() {
        return labourCostAfter;
    }

    public void setLabourCostAfter(BigDecimal labourCostAfter) {
        this.labourCostAfter = labourCostAfter;
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