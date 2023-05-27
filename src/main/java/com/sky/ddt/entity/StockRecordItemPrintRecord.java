package com.sky.ddt.entity;

import java.util.Date;

public class StockRecordItemPrintRecord {
    private Integer id;

    private Integer stockRecordItemId;

    private Integer printQuantity;

    private String remark;

    private Integer createBy;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStockRecordItemId() {
        return stockRecordItemId;
    }

    public void setStockRecordItemId(Integer stockRecordItemId) {
        this.stockRecordItemId = stockRecordItemId;
    }

    public Integer getPrintQuantity() {
        return printQuantity;
    }

    public void setPrintQuantity(Integer printQuantity) {
        this.printQuantity = printQuantity;
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