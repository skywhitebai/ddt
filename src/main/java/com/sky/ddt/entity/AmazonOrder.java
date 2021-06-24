package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class AmazonOrder {
    private Long id;

    private String merchantId;

    private String marketplaceId;

    private String amazonOrderId;

    private String sellerOrderId;

    private Date purchaseDate;

    private Date lastUpdateDate;

    private Date orderDate;

    private String orderStatus;

    private String orderType;

    private String fulfillmentChannel;

    private String salesChannel;

    private String orderChannel;

    private String shipServiceLevel;

    private String shipmentServiceLevelCategory;

    private String currency;

    private BigDecimal totalAmount;

    private BigDecimal rateAmount;

    private Integer numberOfItemsShipped;

    private Integer numberOfItemsUnshipped;

    private String paymentExecutionDetail;

    private String paymentMethod;

    private String paymentMethodDetails;

    private String easyShipShipmentStatus;

    private Date earliestShipDate;

    private Date latestShipDate;

    private Date earlyestDeliveryDate;

    private Date latestDeliveryDate;

    private Boolean businessOrder;

    private Boolean prime;

    private Boolean premiumOrder;

    private Boolean globalExpressEnabled;

    private Boolean replacementOrder;

    private String replacedOrderId;

    private String promiseResponseDueDate;

    private Boolean estimatedShipDateSet;

    private Boolean soldByAb;

    private String assignedShipFromLocationAddress;

    private String buyerEmail;

    private String stateOrRegion;

    private String countryCode;

    private String postalCode;

    private String city;

    private String county;

    private String addressLine1;

    private Integer syncOrderItemStatus;

    private Date syncTime;

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

    public String getMarketplaceId() {
        return marketplaceId;
    }

    public void setMarketplaceId(String marketplaceId) {
        this.marketplaceId = marketplaceId == null ? null : marketplaceId.trim();
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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
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

    public String getShipmentServiceLevelCategory() {
        return shipmentServiceLevelCategory;
    }

    public void setShipmentServiceLevelCategory(String shipmentServiceLevelCategory) {
        this.shipmentServiceLevelCategory = shipmentServiceLevelCategory == null ? null : shipmentServiceLevelCategory.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getRateAmount() {
        return rateAmount;
    }

    public void setRateAmount(BigDecimal rateAmount) {
        this.rateAmount = rateAmount;
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

    public String getPaymentExecutionDetail() {
        return paymentExecutionDetail;
    }

    public void setPaymentExecutionDetail(String paymentExecutionDetail) {
        this.paymentExecutionDetail = paymentExecutionDetail == null ? null : paymentExecutionDetail.trim();
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

    public String getEasyShipShipmentStatus() {
        return easyShipShipmentStatus;
    }

    public void setEasyShipShipmentStatus(String easyShipShipmentStatus) {
        this.easyShipShipmentStatus = easyShipShipmentStatus == null ? null : easyShipShipmentStatus.trim();
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

    public Date getEarlyestDeliveryDate() {
        return earlyestDeliveryDate;
    }

    public void setEarlyestDeliveryDate(Date earlyestDeliveryDate) {
        this.earlyestDeliveryDate = earlyestDeliveryDate;
    }

    public Date getLatestDeliveryDate() {
        return latestDeliveryDate;
    }

    public void setLatestDeliveryDate(Date latestDeliveryDate) {
        this.latestDeliveryDate = latestDeliveryDate;
    }

    public Boolean getBusinessOrder() {
        return businessOrder;
    }

    public void setBusinessOrder(Boolean businessOrder) {
        this.businessOrder = businessOrder;
    }

    public Boolean getPrime() {
        return prime;
    }

    public void setPrime(Boolean prime) {
        this.prime = prime;
    }

    public Boolean getPremiumOrder() {
        return premiumOrder;
    }

    public void setPremiumOrder(Boolean premiumOrder) {
        this.premiumOrder = premiumOrder;
    }

    public Boolean getGlobalExpressEnabled() {
        return globalExpressEnabled;
    }

    public void setGlobalExpressEnabled(Boolean globalExpressEnabled) {
        this.globalExpressEnabled = globalExpressEnabled;
    }

    public Boolean getReplacementOrder() {
        return replacementOrder;
    }

    public void setReplacementOrder(Boolean replacementOrder) {
        this.replacementOrder = replacementOrder;
    }

    public String getReplacedOrderId() {
        return replacedOrderId;
    }

    public void setReplacedOrderId(String replacedOrderId) {
        this.replacedOrderId = replacedOrderId == null ? null : replacedOrderId.trim();
    }

    public String getPromiseResponseDueDate() {
        return promiseResponseDueDate;
    }

    public void setPromiseResponseDueDate(String promiseResponseDueDate) {
        this.promiseResponseDueDate = promiseResponseDueDate == null ? null : promiseResponseDueDate.trim();
    }

    public Boolean getEstimatedShipDateSet() {
        return estimatedShipDateSet;
    }

    public void setEstimatedShipDateSet(Boolean estimatedShipDateSet) {
        this.estimatedShipDateSet = estimatedShipDateSet;
    }

    public Boolean getSoldByAb() {
        return soldByAb;
    }

    public void setSoldByAb(Boolean soldByAb) {
        this.soldByAb = soldByAb;
    }

    public String getAssignedShipFromLocationAddress() {
        return assignedShipFromLocationAddress;
    }

    public void setAssignedShipFromLocationAddress(String assignedShipFromLocationAddress) {
        this.assignedShipFromLocationAddress = assignedShipFromLocationAddress == null ? null : assignedShipFromLocationAddress.trim();
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail == null ? null : buyerEmail.trim();
    }

    public String getStateOrRegion() {
        return stateOrRegion;
    }

    public void setStateOrRegion(String stateOrRegion) {
        this.stateOrRegion = stateOrRegion == null ? null : stateOrRegion.trim();
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode == null ? null : postalCode.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1 == null ? null : addressLine1.trim();
    }

    public Integer getSyncOrderItemStatus() {
        return syncOrderItemStatus;
    }

    public void setSyncOrderItemStatus(Integer syncOrderItemStatus) {
        this.syncOrderItemStatus = syncOrderItemStatus;
    }

    public Date getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
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