package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class AmazonOrderItem {
    private Long id;

    private String amazonOrderId;

    private String asin;

    private String sellerSku;

    private String orderItemId;

    private String title;

    private Integer quantityOrdered;

    private Integer quantityShipped;

    private Integer numberOfItems;

    private Integer pointsNumber;

    private BigDecimal pointsMonetaryValueAmount;

    private String pointsMonetaryValueCurrencyCode;

    private BigDecimal itemPriceAmount;

    private String itemPriceCurrencyCode;

    private BigDecimal shippingPriceAmount;

    private String shippingPriceCurrencyCode;

    private BigDecimal itemTaxAmount;

    private String itemTaxCurrencyCode;

    private BigDecimal shippingTaxAmount;

    private String shippingTaxCurrencyCode;

    private BigDecimal shippingDiscountAmount;

    private String shippingDiscountCurrencyCode;

    private BigDecimal shippingDiscountTaxAmount;

    private String shippingDiscountTaxCurrencyCode;

    private BigDecimal promotionDiscountAmount;

    private String promotionDiscountCurrencyCode;

    private BigDecimal promotionDiscountTaxAmount;

    private String promotionDiscountTaxCurrencyCode;

    private String promotionIdList;

    private BigDecimal coDFeeAmount;

    private String coDFeeCurrencyCode;

    private BigDecimal coDFeeDiscountAmount;

    private String coDFeeDiscountCurrencyCode;

    private Boolean isGift;

    private String conditionNote;

    private String conditionId;

    private String conditionSubtypeId;

    private Date scheduledDeliveryStartDate;

    private Date scheduledDeliveryEndDate;

    private String priceDesignation;

    private String taxCollectionModel;

    private String taxCollectionResponsibleParty;

    private Boolean serialNumberRequired;

    private Boolean isTransparency;

    private String iossNumber;

    private Date createTime;

    private Long createBy;

    private Date updateTime;

    private Long updateBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAmazonOrderId() {
        return amazonOrderId;
    }

    public void setAmazonOrderId(String amazonOrderId) {
        this.amazonOrderId = amazonOrderId == null ? null : amazonOrderId.trim();
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin == null ? null : asin.trim();
    }

    public String getSellerSku() {
        return sellerSku;
    }

    public void setSellerSku(String sellerSku) {
        this.sellerSku = sellerSku == null ? null : sellerSku.trim();
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId == null ? null : orderItemId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(Integer quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public Integer getQuantityShipped() {
        return quantityShipped;
    }

    public void setQuantityShipped(Integer quantityShipped) {
        this.quantityShipped = quantityShipped;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public Integer getPointsNumber() {
        return pointsNumber;
    }

    public void setPointsNumber(Integer pointsNumber) {
        this.pointsNumber = pointsNumber;
    }

    public BigDecimal getPointsMonetaryValueAmount() {
        return pointsMonetaryValueAmount;
    }

    public void setPointsMonetaryValueAmount(BigDecimal pointsMonetaryValueAmount) {
        this.pointsMonetaryValueAmount = pointsMonetaryValueAmount;
    }

    public String getPointsMonetaryValueCurrencyCode() {
        return pointsMonetaryValueCurrencyCode;
    }

    public void setPointsMonetaryValueCurrencyCode(String pointsMonetaryValueCurrencyCode) {
        this.pointsMonetaryValueCurrencyCode = pointsMonetaryValueCurrencyCode == null ? null : pointsMonetaryValueCurrencyCode.trim();
    }

    public BigDecimal getItemPriceAmount() {
        return itemPriceAmount;
    }

    public void setItemPriceAmount(BigDecimal itemPriceAmount) {
        this.itemPriceAmount = itemPriceAmount;
    }

    public String getItemPriceCurrencyCode() {
        return itemPriceCurrencyCode;
    }

    public void setItemPriceCurrencyCode(String itemPriceCurrencyCode) {
        this.itemPriceCurrencyCode = itemPriceCurrencyCode == null ? null : itemPriceCurrencyCode.trim();
    }

    public BigDecimal getShippingPriceAmount() {
        return shippingPriceAmount;
    }

    public void setShippingPriceAmount(BigDecimal shippingPriceAmount) {
        this.shippingPriceAmount = shippingPriceAmount;
    }

    public String getShippingPriceCurrencyCode() {
        return shippingPriceCurrencyCode;
    }

    public void setShippingPriceCurrencyCode(String shippingPriceCurrencyCode) {
        this.shippingPriceCurrencyCode = shippingPriceCurrencyCode == null ? null : shippingPriceCurrencyCode.trim();
    }

    public BigDecimal getItemTaxAmount() {
        return itemTaxAmount;
    }

    public void setItemTaxAmount(BigDecimal itemTaxAmount) {
        this.itemTaxAmount = itemTaxAmount;
    }

    public String getItemTaxCurrencyCode() {
        return itemTaxCurrencyCode;
    }

    public void setItemTaxCurrencyCode(String itemTaxCurrencyCode) {
        this.itemTaxCurrencyCode = itemTaxCurrencyCode == null ? null : itemTaxCurrencyCode.trim();
    }

    public BigDecimal getShippingTaxAmount() {
        return shippingTaxAmount;
    }

    public void setShippingTaxAmount(BigDecimal shippingTaxAmount) {
        this.shippingTaxAmount = shippingTaxAmount;
    }

    public String getShippingTaxCurrencyCode() {
        return shippingTaxCurrencyCode;
    }

    public void setShippingTaxCurrencyCode(String shippingTaxCurrencyCode) {
        this.shippingTaxCurrencyCode = shippingTaxCurrencyCode == null ? null : shippingTaxCurrencyCode.trim();
    }

    public BigDecimal getShippingDiscountAmount() {
        return shippingDiscountAmount;
    }

    public void setShippingDiscountAmount(BigDecimal shippingDiscountAmount) {
        this.shippingDiscountAmount = shippingDiscountAmount;
    }

    public String getShippingDiscountCurrencyCode() {
        return shippingDiscountCurrencyCode;
    }

    public void setShippingDiscountCurrencyCode(String shippingDiscountCurrencyCode) {
        this.shippingDiscountCurrencyCode = shippingDiscountCurrencyCode == null ? null : shippingDiscountCurrencyCode.trim();
    }

    public BigDecimal getShippingDiscountTaxAmount() {
        return shippingDiscountTaxAmount;
    }

    public void setShippingDiscountTaxAmount(BigDecimal shippingDiscountTaxAmount) {
        this.shippingDiscountTaxAmount = shippingDiscountTaxAmount;
    }

    public String getShippingDiscountTaxCurrencyCode() {
        return shippingDiscountTaxCurrencyCode;
    }

    public void setShippingDiscountTaxCurrencyCode(String shippingDiscountTaxCurrencyCode) {
        this.shippingDiscountTaxCurrencyCode = shippingDiscountTaxCurrencyCode == null ? null : shippingDiscountTaxCurrencyCode.trim();
    }

    public BigDecimal getPromotionDiscountAmount() {
        return promotionDiscountAmount;
    }

    public void setPromotionDiscountAmount(BigDecimal promotionDiscountAmount) {
        this.promotionDiscountAmount = promotionDiscountAmount;
    }

    public String getPromotionDiscountCurrencyCode() {
        return promotionDiscountCurrencyCode;
    }

    public void setPromotionDiscountCurrencyCode(String promotionDiscountCurrencyCode) {
        this.promotionDiscountCurrencyCode = promotionDiscountCurrencyCode == null ? null : promotionDiscountCurrencyCode.trim();
    }

    public BigDecimal getPromotionDiscountTaxAmount() {
        return promotionDiscountTaxAmount;
    }

    public void setPromotionDiscountTaxAmount(BigDecimal promotionDiscountTaxAmount) {
        this.promotionDiscountTaxAmount = promotionDiscountTaxAmount;
    }

    public String getPromotionDiscountTaxCurrencyCode() {
        return promotionDiscountTaxCurrencyCode;
    }

    public void setPromotionDiscountTaxCurrencyCode(String promotionDiscountTaxCurrencyCode) {
        this.promotionDiscountTaxCurrencyCode = promotionDiscountTaxCurrencyCode == null ? null : promotionDiscountTaxCurrencyCode.trim();
    }

    public String getPromotionIdList() {
        return promotionIdList;
    }

    public void setPromotionIdList(String promotionIdList) {
        this.promotionIdList = promotionIdList == null ? null : promotionIdList.trim();
    }

    public BigDecimal getCoDFeeAmount() {
        return coDFeeAmount;
    }

    public void setCoDFeeAmount(BigDecimal coDFeeAmount) {
        this.coDFeeAmount = coDFeeAmount;
    }

    public String getCoDFeeCurrencyCode() {
        return coDFeeCurrencyCode;
    }

    public void setCoDFeeCurrencyCode(String coDFeeCurrencyCode) {
        this.coDFeeCurrencyCode = coDFeeCurrencyCode == null ? null : coDFeeCurrencyCode.trim();
    }

    public BigDecimal getCoDFeeDiscountAmount() {
        return coDFeeDiscountAmount;
    }

    public void setCoDFeeDiscountAmount(BigDecimal coDFeeDiscountAmount) {
        this.coDFeeDiscountAmount = coDFeeDiscountAmount;
    }

    public String getCoDFeeDiscountCurrencyCode() {
        return coDFeeDiscountCurrencyCode;
    }

    public void setCoDFeeDiscountCurrencyCode(String coDFeeDiscountCurrencyCode) {
        this.coDFeeDiscountCurrencyCode = coDFeeDiscountCurrencyCode == null ? null : coDFeeDiscountCurrencyCode.trim();
    }

    public Boolean getIsGift() {
        return isGift;
    }

    public void setIsGift(Boolean isGift) {
        this.isGift = isGift;
    }

    public String getConditionNote() {
        return conditionNote;
    }

    public void setConditionNote(String conditionNote) {
        this.conditionNote = conditionNote == null ? null : conditionNote.trim();
    }

    public String getConditionId() {
        return conditionId;
    }

    public void setConditionId(String conditionId) {
        this.conditionId = conditionId == null ? null : conditionId.trim();
    }

    public String getConditionSubtypeId() {
        return conditionSubtypeId;
    }

    public void setConditionSubtypeId(String conditionSubtypeId) {
        this.conditionSubtypeId = conditionSubtypeId == null ? null : conditionSubtypeId.trim();
    }

    public Date getScheduledDeliveryStartDate() {
        return scheduledDeliveryStartDate;
    }

    public void setScheduledDeliveryStartDate(Date scheduledDeliveryStartDate) {
        this.scheduledDeliveryStartDate = scheduledDeliveryStartDate;
    }

    public Date getScheduledDeliveryEndDate() {
        return scheduledDeliveryEndDate;
    }

    public void setScheduledDeliveryEndDate(Date scheduledDeliveryEndDate) {
        this.scheduledDeliveryEndDate = scheduledDeliveryEndDate;
    }

    public String getPriceDesignation() {
        return priceDesignation;
    }

    public void setPriceDesignation(String priceDesignation) {
        this.priceDesignation = priceDesignation == null ? null : priceDesignation.trim();
    }

    public String getTaxCollectionModel() {
        return taxCollectionModel;
    }

    public void setTaxCollectionModel(String taxCollectionModel) {
        this.taxCollectionModel = taxCollectionModel == null ? null : taxCollectionModel.trim();
    }

    public String getTaxCollectionResponsibleParty() {
        return taxCollectionResponsibleParty;
    }

    public void setTaxCollectionResponsibleParty(String taxCollectionResponsibleParty) {
        this.taxCollectionResponsibleParty = taxCollectionResponsibleParty == null ? null : taxCollectionResponsibleParty.trim();
    }

    public Boolean getSerialNumberRequired() {
        return serialNumberRequired;
    }

    public void setSerialNumberRequired(Boolean serialNumberRequired) {
        this.serialNumberRequired = serialNumberRequired;
    }

    public Boolean getIsTransparency() {
        return isTransparency;
    }

    public void setIsTransparency(Boolean isTransparency) {
        this.isTransparency = isTransparency;
    }

    public String getIossNumber() {
        return iossNumber;
    }

    public void setIossNumber(String iossNumber) {
        this.iossNumber = iossNumber == null ? null : iossNumber.trim();
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