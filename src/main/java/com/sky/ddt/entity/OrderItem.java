package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderItem {
    private Integer id;

    private String amazonOrderId;

    private String asin;

    private String sellerSku;

    private String orderItemId;

    private String title;

    private Integer quantityOrdered;

    private Integer quantityShipped;

    private String itemPriceCurrencyCode;

    private BigDecimal itemPriceAmount;

    private String shippingPriceCurrencyCode;

    private BigDecimal shippingPriceAmount;

    private String giftWrapPriceCurrencyCode;

    private BigDecimal giftWrapPriceAmount;

    private String itemTaxCurrencyCode;

    private BigDecimal itemTaxAmount;

    private String shippingTaxCurrencyCode;

    private BigDecimal shippingTaxAmount;

    private String giftWrapTaxCurrencyCode;

    private BigDecimal giftWrapTaxAmount;

    private String shippingDiscountCurrencyCode;

    private BigDecimal shippingDiscountAmount;

    private String shippingDiscountTaxCurrencyCode;

    private BigDecimal shippingDiscountTaxAmount;

    private String promotionDiscountCurrencyCode;

    private BigDecimal promotionDiscountAmount;

    private String promotionDiscountTaxCurrencyCode;

    private BigDecimal promotionDiscountTaxAmount;

    private String promotionIds;

    private Boolean isGift;

    private String giftMessageText;

    private String giftWrapLevel;

    private String conditionNote;

    private String conditionId;

    private String conditionSubtypeId;

    private String scheduledDeliveryStartDate;

    private String scheduledDeliveryEndDate;

    private Boolean serialNumberRequired;

    private Boolean isRransparency;

    private Date createTime;

    private Integer ceateBy;

    private Date updateTime;

    private Integer updateBy;

    private String codFeeCurrencyCode;

    private BigDecimal codFeeAmount;

    private String codFeeDiscountCurrencyCode;

    private BigDecimal codFeeDiscountAmount;

    private String priceDesignation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getItemPriceCurrencyCode() {
        return itemPriceCurrencyCode;
    }

    public void setItemPriceCurrencyCode(String itemPriceCurrencyCode) {
        this.itemPriceCurrencyCode = itemPriceCurrencyCode == null ? null : itemPriceCurrencyCode.trim();
    }

    public BigDecimal getItemPriceAmount() {
        return itemPriceAmount;
    }

    public void setItemPriceAmount(BigDecimal itemPriceAmount) {
        this.itemPriceAmount = itemPriceAmount;
    }

    public String getShippingPriceCurrencyCode() {
        return shippingPriceCurrencyCode;
    }

    public void setShippingPriceCurrencyCode(String shippingPriceCurrencyCode) {
        this.shippingPriceCurrencyCode = shippingPriceCurrencyCode == null ? null : shippingPriceCurrencyCode.trim();
    }

    public BigDecimal getShippingPriceAmount() {
        return shippingPriceAmount;
    }

    public void setShippingPriceAmount(BigDecimal shippingPriceAmount) {
        this.shippingPriceAmount = shippingPriceAmount;
    }

    public String getGiftWrapPriceCurrencyCode() {
        return giftWrapPriceCurrencyCode;
    }

    public void setGiftWrapPriceCurrencyCode(String giftWrapPriceCurrencyCode) {
        this.giftWrapPriceCurrencyCode = giftWrapPriceCurrencyCode == null ? null : giftWrapPriceCurrencyCode.trim();
    }

    public BigDecimal getGiftWrapPriceAmount() {
        return giftWrapPriceAmount;
    }

    public void setGiftWrapPriceAmount(BigDecimal giftWrapPriceAmount) {
        this.giftWrapPriceAmount = giftWrapPriceAmount;
    }

    public String getItemTaxCurrencyCode() {
        return itemTaxCurrencyCode;
    }

    public void setItemTaxCurrencyCode(String itemTaxCurrencyCode) {
        this.itemTaxCurrencyCode = itemTaxCurrencyCode == null ? null : itemTaxCurrencyCode.trim();
    }

    public BigDecimal getItemTaxAmount() {
        return itemTaxAmount;
    }

    public void setItemTaxAmount(BigDecimal itemTaxAmount) {
        this.itemTaxAmount = itemTaxAmount;
    }

    public String getShippingTaxCurrencyCode() {
        return shippingTaxCurrencyCode;
    }

    public void setShippingTaxCurrencyCode(String shippingTaxCurrencyCode) {
        this.shippingTaxCurrencyCode = shippingTaxCurrencyCode == null ? null : shippingTaxCurrencyCode.trim();
    }

    public BigDecimal getShippingTaxAmount() {
        return shippingTaxAmount;
    }

    public void setShippingTaxAmount(BigDecimal shippingTaxAmount) {
        this.shippingTaxAmount = shippingTaxAmount;
    }

    public String getGiftWrapTaxCurrencyCode() {
        return giftWrapTaxCurrencyCode;
    }

    public void setGiftWrapTaxCurrencyCode(String giftWrapTaxCurrencyCode) {
        this.giftWrapTaxCurrencyCode = giftWrapTaxCurrencyCode == null ? null : giftWrapTaxCurrencyCode.trim();
    }

    public BigDecimal getGiftWrapTaxAmount() {
        return giftWrapTaxAmount;
    }

    public void setGiftWrapTaxAmount(BigDecimal giftWrapTaxAmount) {
        this.giftWrapTaxAmount = giftWrapTaxAmount;
    }

    public String getShippingDiscountCurrencyCode() {
        return shippingDiscountCurrencyCode;
    }

    public void setShippingDiscountCurrencyCode(String shippingDiscountCurrencyCode) {
        this.shippingDiscountCurrencyCode = shippingDiscountCurrencyCode == null ? null : shippingDiscountCurrencyCode.trim();
    }

    public BigDecimal getShippingDiscountAmount() {
        return shippingDiscountAmount;
    }

    public void setShippingDiscountAmount(BigDecimal shippingDiscountAmount) {
        this.shippingDiscountAmount = shippingDiscountAmount;
    }

    public String getShippingDiscountTaxCurrencyCode() {
        return shippingDiscountTaxCurrencyCode;
    }

    public void setShippingDiscountTaxCurrencyCode(String shippingDiscountTaxCurrencyCode) {
        this.shippingDiscountTaxCurrencyCode = shippingDiscountTaxCurrencyCode == null ? null : shippingDiscountTaxCurrencyCode.trim();
    }

    public BigDecimal getShippingDiscountTaxAmount() {
        return shippingDiscountTaxAmount;
    }

    public void setShippingDiscountTaxAmount(BigDecimal shippingDiscountTaxAmount) {
        this.shippingDiscountTaxAmount = shippingDiscountTaxAmount;
    }

    public String getPromotionDiscountCurrencyCode() {
        return promotionDiscountCurrencyCode;
    }

    public void setPromotionDiscountCurrencyCode(String promotionDiscountCurrencyCode) {
        this.promotionDiscountCurrencyCode = promotionDiscountCurrencyCode == null ? null : promotionDiscountCurrencyCode.trim();
    }

    public BigDecimal getPromotionDiscountAmount() {
        return promotionDiscountAmount;
    }

    public void setPromotionDiscountAmount(BigDecimal promotionDiscountAmount) {
        this.promotionDiscountAmount = promotionDiscountAmount;
    }

    public String getPromotionDiscountTaxCurrencyCode() {
        return promotionDiscountTaxCurrencyCode;
    }

    public void setPromotionDiscountTaxCurrencyCode(String promotionDiscountTaxCurrencyCode) {
        this.promotionDiscountTaxCurrencyCode = promotionDiscountTaxCurrencyCode == null ? null : promotionDiscountTaxCurrencyCode.trim();
    }

    public BigDecimal getPromotionDiscountTaxAmount() {
        return promotionDiscountTaxAmount;
    }

    public void setPromotionDiscountTaxAmount(BigDecimal promotionDiscountTaxAmount) {
        this.promotionDiscountTaxAmount = promotionDiscountTaxAmount;
    }

    public String getPromotionIds() {
        return promotionIds;
    }

    public void setPromotionIds(String promotionIds) {
        this.promotionIds = promotionIds == null ? null : promotionIds.trim();
    }

    public Boolean getIsGift() {
        return isGift;
    }

    public void setIsGift(Boolean isGift) {
        this.isGift = isGift;
    }

    public String getGiftMessageText() {
        return giftMessageText;
    }

    public void setGiftMessageText(String giftMessageText) {
        this.giftMessageText = giftMessageText == null ? null : giftMessageText.trim();
    }

    public String getGiftWrapLevel() {
        return giftWrapLevel;
    }

    public void setGiftWrapLevel(String giftWrapLevel) {
        this.giftWrapLevel = giftWrapLevel == null ? null : giftWrapLevel.trim();
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

    public String getScheduledDeliveryStartDate() {
        return scheduledDeliveryStartDate;
    }

    public void setScheduledDeliveryStartDate(String scheduledDeliveryStartDate) {
        this.scheduledDeliveryStartDate = scheduledDeliveryStartDate == null ? null : scheduledDeliveryStartDate.trim();
    }

    public String getScheduledDeliveryEndDate() {
        return scheduledDeliveryEndDate;
    }

    public void setScheduledDeliveryEndDate(String scheduledDeliveryEndDate) {
        this.scheduledDeliveryEndDate = scheduledDeliveryEndDate == null ? null : scheduledDeliveryEndDate.trim();
    }

    public Boolean getSerialNumberRequired() {
        return serialNumberRequired;
    }

    public void setSerialNumberRequired(Boolean serialNumberRequired) {
        this.serialNumberRequired = serialNumberRequired;
    }

    public Boolean getIsRransparency() {
        return isRransparency;
    }

    public void setIsRransparency(Boolean isRransparency) {
        this.isRransparency = isRransparency;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCeateBy() {
        return ceateBy;
    }

    public void setCeateBy(Integer ceateBy) {
        this.ceateBy = ceateBy;
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

    public String getCodFeeCurrencyCode() {
        return codFeeCurrencyCode;
    }

    public void setCodFeeCurrencyCode(String codFeeCurrencyCode) {
        this.codFeeCurrencyCode = codFeeCurrencyCode == null ? null : codFeeCurrencyCode.trim();
    }

    public BigDecimal getCodFeeAmount() {
        return codFeeAmount;
    }

    public void setCodFeeAmount(BigDecimal codFeeAmount) {
        this.codFeeAmount = codFeeAmount;
    }

    public String getCodFeeDiscountCurrencyCode() {
        return codFeeDiscountCurrencyCode;
    }

    public void setCodFeeDiscountCurrencyCode(String codFeeDiscountCurrencyCode) {
        this.codFeeDiscountCurrencyCode = codFeeDiscountCurrencyCode == null ? null : codFeeDiscountCurrencyCode.trim();
    }

    public BigDecimal getCodFeeDiscountAmount() {
        return codFeeDiscountAmount;
    }

    public void setCodFeeDiscountAmount(BigDecimal codFeeDiscountAmount) {
        this.codFeeDiscountAmount = codFeeDiscountAmount;
    }

    public String getPriceDesignation() {
        return priceDesignation;
    }

    public void setPriceDesignation(String priceDesignation) {
        this.priceDesignation = priceDesignation == null ? null : priceDesignation.trim();
    }
}