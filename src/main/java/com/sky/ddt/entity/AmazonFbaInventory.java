package com.sky.ddt.entity;

import java.util.Date;

public class AmazonFbaInventory {
    private Long id;

    private String merchantId;

    private String asin;

    private String fnSku;

    private String sellerSku;

    private String conditionStr;

    private Integer fulfillableQuantity;

    private Integer inboundWorkingQuantity;

    private Integer inboundReceivingQuantity;

    private Integer totalReservedQuantity;

    private Integer pendingCustomerOrderQuantity;

    private Integer pendingTransshipmentQuantity;

    private Integer fcProcessingQuantity;

    private Integer totalResearchingQuantity;

    private Integer researchingQuantityInShortTerm;

    private Integer researchingQuantityInMidUerm;

    private Integer researchingQuantityInLongTerm;

    private Integer unfulfillableQuantity;

    private Date lastUpdatedTime;

    private String productName;

    private Integer totalQuantity;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin == null ? null : asin.trim();
    }

    public String getFnSku() {
        return fnSku;
    }

    public void setFnSku(String fnSku) {
        this.fnSku = fnSku == null ? null : fnSku.trim();
    }

    public String getSellerSku() {
        return sellerSku;
    }

    public void setSellerSku(String sellerSku) {
        this.sellerSku = sellerSku == null ? null : sellerSku.trim();
    }

    public String getConditionStr() {
        return conditionStr;
    }

    public void setConditionStr(String conditionStr) {
        this.conditionStr = conditionStr == null ? null : conditionStr.trim();
    }

    public Integer getFulfillableQuantity() {
        return fulfillableQuantity;
    }

    public void setFulfillableQuantity(Integer fulfillableQuantity) {
        this.fulfillableQuantity = fulfillableQuantity;
    }

    public Integer getInboundWorkingQuantity() {
        return inboundWorkingQuantity;
    }

    public void setInboundWorkingQuantity(Integer inboundWorkingQuantity) {
        this.inboundWorkingQuantity = inboundWorkingQuantity;
    }

    public Integer getInboundReceivingQuantity() {
        return inboundReceivingQuantity;
    }

    public void setInboundReceivingQuantity(Integer inboundReceivingQuantity) {
        this.inboundReceivingQuantity = inboundReceivingQuantity;
    }

    public Integer getTotalReservedQuantity() {
        return totalReservedQuantity;
    }

    public void setTotalReservedQuantity(Integer totalReservedQuantity) {
        this.totalReservedQuantity = totalReservedQuantity;
    }

    public Integer getPendingCustomerOrderQuantity() {
        return pendingCustomerOrderQuantity;
    }

    public void setPendingCustomerOrderQuantity(Integer pendingCustomerOrderQuantity) {
        this.pendingCustomerOrderQuantity = pendingCustomerOrderQuantity;
    }

    public Integer getPendingTransshipmentQuantity() {
        return pendingTransshipmentQuantity;
    }

    public void setPendingTransshipmentQuantity(Integer pendingTransshipmentQuantity) {
        this.pendingTransshipmentQuantity = pendingTransshipmentQuantity;
    }

    public Integer getFcProcessingQuantity() {
        return fcProcessingQuantity;
    }

    public void setFcProcessingQuantity(Integer fcProcessingQuantity) {
        this.fcProcessingQuantity = fcProcessingQuantity;
    }

    public Integer getTotalResearchingQuantity() {
        return totalResearchingQuantity;
    }

    public void setTotalResearchingQuantity(Integer totalResearchingQuantity) {
        this.totalResearchingQuantity = totalResearchingQuantity;
    }

    public Integer getResearchingQuantityInShortTerm() {
        return researchingQuantityInShortTerm;
    }

    public void setResearchingQuantityInShortTerm(Integer researchingQuantityInShortTerm) {
        this.researchingQuantityInShortTerm = researchingQuantityInShortTerm;
    }

    public Integer getResearchingQuantityInMidUerm() {
        return researchingQuantityInMidUerm;
    }

    public void setResearchingQuantityInMidUerm(Integer researchingQuantityInMidUerm) {
        this.researchingQuantityInMidUerm = researchingQuantityInMidUerm;
    }

    public Integer getResearchingQuantityInLongTerm() {
        return researchingQuantityInLongTerm;
    }

    public void setResearchingQuantityInLongTerm(Integer researchingQuantityInLongTerm) {
        this.researchingQuantityInLongTerm = researchingQuantityInLongTerm;
    }

    public Integer getUnfulfillableQuantity() {
        return unfulfillableQuantity;
    }

    public void setUnfulfillableQuantity(Integer unfulfillableQuantity) {
        this.unfulfillableQuantity = unfulfillableQuantity;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}