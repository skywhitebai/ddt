package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderInfo {
    private Integer id;

    private Integer shopId;

    private String amazonOrderId;

    private String sellerOrderId;

    private Date purchaseDate;

    private Date lastUpdateDate;

    private String orderStatus;

    private String fulfillmentChannel;

    private String salesChannel;

    private String orderChannel;

    private String shipServiceLevel;

    private String orderTotalCurrencyCode;

    private BigDecimal orderTotalAmount;

    private Integer numberOfItemsShipped;

    private Integer numberOfItemsUnshipped;

    private String paymentMethod;

    private String paymentMethodDetails;

    private String marketplaceId;

    private String buyerEmail;

    private String buyerName;

    private String buyerCounty;

    private String shipmentServiceLevelCategory;

    private Boolean shippedByAmazonTfm;

    private String tfmShipmentStatus;

    private String easyShipShipmentStatus;

    private String cbaDisplayableShippingLabel;

    private String orderType;

    private Date earliestShipDate;

    private Date latestShipDate;

    private Date earliestDeliveryDate;

    private Date latestDeliveryDate;

    private Boolean isBusinessOrder;

    private String purchaseOrderNumber;

    private Boolean isPrime;

    private Boolean isPremiumOrder;

    private String replacedOrderId;

    private Boolean isReplacementOrder;

    private Date promiseResponseDueDate;

    private Boolean isEstimatedShipDateSet;

    private Date createTime;

    private Long createBy;

    private Date updateTime;

    private Long updateBy;

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

    public String getAmazonOrderId() {
        return amazonOrderId;
    }

    public void setAmazonOrderId(String amazonOrderId) {
        this.amazonOrderId = amazonOrderId == null ? null : amazonOrderId.trim();
    }

    public String getSellerOrderId() {
        return sellerOrderId;
    }

    public void setSellerOrderId(String sellerOrderId) {
        this.sellerOrderId = sellerOrderId == null ? null : sellerOrderId.trim();
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getFulfillmentChannel() {
        return fulfillmentChannel;
    }

    public void setFulfillmentChannel(String fulfillmentChannel) {
        this.fulfillmentChannel = fulfillmentChannel == null ? null : fulfillmentChannel.trim();
    }

    public String getSalesChannel() {
        return salesChannel;
    }

    public void setSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel == null ? null : salesChannel.trim();
    }

    public String getOrderChannel() {
        return orderChannel;
    }

    public void setOrderChannel(String orderChannel) {
        this.orderChannel = orderChannel == null ? null : orderChannel.trim();
    }

    public String getShipServiceLevel() {
        return shipServiceLevel;
    }

    public void setShipServiceLevel(String shipServiceLevel) {
        this.shipServiceLevel = shipServiceLevel == null ? null : shipServiceLevel.trim();
    }

    public String getOrderTotalCurrencyCode() {
        return orderTotalCurrencyCode;
    }

    public void setOrderTotalCurrencyCode(String orderTotalCurrencyCode) {
        this.orderTotalCurrencyCode = orderTotalCurrencyCode == null ? null : orderTotalCurrencyCode.trim();
    }

    public BigDecimal getOrderTotalAmount() {
        return orderTotalAmount;
    }

    public void setOrderTotalAmount(BigDecimal orderTotalAmount) {
        this.orderTotalAmount = orderTotalAmount;
    }

    public Integer getNumberOfItemsShipped() {
        return numberOfItemsShipped;
    }

    public void setNumberOfItemsShipped(Integer numberOfItemsShipped) {
        this.numberOfItemsShipped = numberOfItemsShipped;
    }

    public Integer getNumberOfItemsUnshipped() {
        return numberOfItemsUnshipped;
    }

    public void setNumberOfItemsUnshipped(Integer numberOfItemsUnshipped) {
        this.numberOfItemsUnshipped = numberOfItemsUnshipped;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod == null ? null : paymentMethod.trim();
    }

    public String getPaymentMethodDetails() {
        return paymentMethodDetails;
    }

    public void setPaymentMethodDetails(String paymentMethodDetails) {
        this.paymentMethodDetails = paymentMethodDetails == null ? null : paymentMethodDetails.trim();
    }

    public String getMarketplaceId() {
        return marketplaceId;
    }

    public void setMarketplaceId(String marketplaceId) {
        this.marketplaceId = marketplaceId == null ? null : marketplaceId.trim();
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail == null ? null : buyerEmail.trim();
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName == null ? null : buyerName.trim();
    }

    public String getBuyerCounty() {
        return buyerCounty;
    }

    public void setBuyerCounty(String buyerCounty) {
        this.buyerCounty = buyerCounty == null ? null : buyerCounty.trim();
    }

    public String getShipmentServiceLevelCategory() {
        return shipmentServiceLevelCategory;
    }

    public void setShipmentServiceLevelCategory(String shipmentServiceLevelCategory) {
        this.shipmentServiceLevelCategory = shipmentServiceLevelCategory == null ? null : shipmentServiceLevelCategory.trim();
    }

    public Boolean getShippedByAmazonTfm() {
        return shippedByAmazonTfm;
    }

    public void setShippedByAmazonTfm(Boolean shippedByAmazonTfm) {
        this.shippedByAmazonTfm = shippedByAmazonTfm;
    }

    public String getTfmShipmentStatus() {
        return tfmShipmentStatus;
    }

    public void setTfmShipmentStatus(String tfmShipmentStatus) {
        this.tfmShipmentStatus = tfmShipmentStatus == null ? null : tfmShipmentStatus.trim();
    }

    public String getEasyShipShipmentStatus() {
        return easyShipShipmentStatus;
    }

    public void setEasyShipShipmentStatus(String easyShipShipmentStatus) {
        this.easyShipShipmentStatus = easyShipShipmentStatus == null ? null : easyShipShipmentStatus.trim();
    }

    public String getCbaDisplayableShippingLabel() {
        return cbaDisplayableShippingLabel;
    }

    public void setCbaDisplayableShippingLabel(String cbaDisplayableShippingLabel) {
        this.cbaDisplayableShippingLabel = cbaDisplayableShippingLabel == null ? null : cbaDisplayableShippingLabel.trim();
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public Date getEarliestShipDate() {
        return earliestShipDate;
    }

    public void setEarliestShipDate(Date earliestShipDate) {
        this.earliestShipDate = earliestShipDate;
    }

    public Date getLatestShipDate() {
        return latestShipDate;
    }

    public void setLatestShipDate(Date latestShipDate) {
        this.latestShipDate = latestShipDate;
    }

    public Date getEarliestDeliveryDate() {
        return earliestDeliveryDate;
    }

    public void setEarliestDeliveryDate(Date earliestDeliveryDate) {
        this.earliestDeliveryDate = earliestDeliveryDate;
    }

    public Date getLatestDeliveryDate() {
        return latestDeliveryDate;
    }

    public void setLatestDeliveryDate(Date latestDeliveryDate) {
        this.latestDeliveryDate = latestDeliveryDate;
    }

    public Boolean getIsBusinessOrder() {
        return isBusinessOrder;
    }

    public void setIsBusinessOrder(Boolean isBusinessOrder) {
        this.isBusinessOrder = isBusinessOrder;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber == null ? null : purchaseOrderNumber.trim();
    }

    public Boolean getIsPrime() {
        return isPrime;
    }

    public void setIsPrime(Boolean isPrime) {
        this.isPrime = isPrime;
    }

    public Boolean getIsPremiumOrder() {
        return isPremiumOrder;
    }

    public void setIsPremiumOrder(Boolean isPremiumOrder) {
        this.isPremiumOrder = isPremiumOrder;
    }

    public String getReplacedOrderId() {
        return replacedOrderId;
    }

    public void setReplacedOrderId(String replacedOrderId) {
        this.replacedOrderId = replacedOrderId == null ? null : replacedOrderId.trim();
    }

    public Boolean getIsReplacementOrder() {
        return isReplacementOrder;
    }

    public void setIsReplacementOrder(Boolean isReplacementOrder) {
        this.isReplacementOrder = isReplacementOrder;
    }

    public Date getPromiseResponseDueDate() {
        return promiseResponseDueDate;
    }

    public void setPromiseResponseDueDate(Date promiseResponseDueDate) {
        this.promiseResponseDueDate = promiseResponseDueDate;
    }

    public Boolean getIsEstimatedShipDateSet() {
        return isEstimatedShipDateSet;
    }

    public void setIsEstimatedShipDateSet(Boolean isEstimatedShipDateSet) {
        this.isEstimatedShipDateSet = isEstimatedShipDateSet;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }
}