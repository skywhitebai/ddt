package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class DestructionDetails {
    private Integer id;

    private Integer financeId;

    private Date requestDate;

    private String orderId;

    private String orderType;

    private String orderStatus;

    private Date lastUpdatedDate;

    private String sku;

    private Integer shopSkuId;

    private String fnsku;

    private String disposition;

    private Integer requestedQuantity;

    private Integer cancelledQuantity;

    private Integer disposedQuantity;

    private Integer shippedQuantity;

    private Integer inProcessQuantity;

    private BigDecimal removalFee;

    private String currency;

    private Date createTime;

    private Integer createBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFinanceId() {
        return financeId;
    }

    public void setFinanceId(Integer financeId) {
        this.financeId = financeId;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    public Integer getShopSkuId() {
        return shopSkuId;
    }

    public void setShopSkuId(Integer shopSkuId) {
        this.shopSkuId = shopSkuId;
    }

    public String getFnsku() {
        return fnsku;
    }

    public void setFnsku(String fnsku) {
        this.fnsku = fnsku == null ? null : fnsku.trim();
    }

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition == null ? null : disposition.trim();
    }

    public Integer getRequestedQuantity() {
        return requestedQuantity;
    }

    public void setRequestedQuantity(Integer requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
    }

    public Integer getCancelledQuantity() {
        return cancelledQuantity;
    }

    public void setCancelledQuantity(Integer cancelledQuantity) {
        this.cancelledQuantity = cancelledQuantity;
    }

    public Integer getDisposedQuantity() {
        return disposedQuantity;
    }

    public void setDisposedQuantity(Integer disposedQuantity) {
        this.disposedQuantity = disposedQuantity;
    }

    public Integer getShippedQuantity() {
        return shippedQuantity;
    }

    public void setShippedQuantity(Integer shippedQuantity) {
        this.shippedQuantity = shippedQuantity;
    }

    public Integer getInProcessQuantity() {
        return inProcessQuantity;
    }

    public void setInProcessQuantity(Integer inProcessQuantity) {
        this.inProcessQuantity = inProcessQuantity;
    }

    public BigDecimal getRemovalFee() {
        return removalFee;
    }

    public void setRemovalFee(BigDecimal removalFee) {
        this.removalFee = removalFee;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
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