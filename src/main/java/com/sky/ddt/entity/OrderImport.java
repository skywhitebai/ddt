package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderImport {
    private Integer id;

    private Integer shopId;

    private String amazonOrderId;

    private String merchantOrderId;

    private Date purchaseDate;

    private Date purchaseDateReal;

    private Date lastUpdatedDate;

    private Date lastUpdatedDateReal;

    private String orderStatus;

    private String fulfillmentChannel;

    private String salesChannel;

    private String orderChannel;

    private String url;

    private String shipServiceLevel;

    private String productName;

    private String sku;

    private Integer shopSkuId;

    private String asin;

    private String itemStatus;

    private Integer quantity;

    private String currency;

    private BigDecimal itemPrice;

    private BigDecimal itemTax;

    private BigDecimal shippingPrice;

    private BigDecimal shippingTax;

    private BigDecimal giftWrapPrice;

    private BigDecimal giftWrapTax;

    private BigDecimal itemPromotionDiscount;

    private BigDecimal shipPromotionDiscount;

    private String shipCity;

    private String shipState;

    private String shipPostalCode;

    private String shipCountry;

    private String promotionIds;

    private String isBusinessOrder;

    private Integer purchaseOrderNumber;

    private String priceDesignation;

    private String remark;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

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

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId == null ? null : merchantOrderId.trim();
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getPurchaseDateReal() {
        return purchaseDateReal;
    }

    public void setPurchaseDateReal(Date purchaseDateReal) {
        this.purchaseDateReal = purchaseDateReal;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Date getLastUpdatedDateReal() {
        return lastUpdatedDateReal;
    }

    public void setLastUpdatedDateReal(Date lastUpdatedDateReal) {
        this.lastUpdatedDateReal = lastUpdatedDateReal;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getShipServiceLevel() {
        return shipServiceLevel;
    }

    public void setShipServiceLevel(String shipServiceLevel) {
        this.shipServiceLevel = shipServiceLevel == null ? null : shipServiceLevel.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
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

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin == null ? null : asin.trim();
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus == null ? null : itemStatus.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public BigDecimal getItemTax() {
        return itemTax;
    }

    public void setItemTax(BigDecimal itemTax) {
        this.itemTax = itemTax;
    }

    public BigDecimal getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(BigDecimal shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public BigDecimal getShippingTax() {
        return shippingTax;
    }

    public void setShippingTax(BigDecimal shippingTax) {
        this.shippingTax = shippingTax;
    }

    public BigDecimal getGiftWrapPrice() {
        return giftWrapPrice;
    }

    public void setGiftWrapPrice(BigDecimal giftWrapPrice) {
        this.giftWrapPrice = giftWrapPrice;
    }

    public BigDecimal getGiftWrapTax() {
        return giftWrapTax;
    }

    public void setGiftWrapTax(BigDecimal giftWrapTax) {
        this.giftWrapTax = giftWrapTax;
    }

    public BigDecimal getItemPromotionDiscount() {
        return itemPromotionDiscount;
    }

    public void setItemPromotionDiscount(BigDecimal itemPromotionDiscount) {
        this.itemPromotionDiscount = itemPromotionDiscount;
    }

    public BigDecimal getShipPromotionDiscount() {
        return shipPromotionDiscount;
    }

    public void setShipPromotionDiscount(BigDecimal shipPromotionDiscount) {
        this.shipPromotionDiscount = shipPromotionDiscount;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity == null ? null : shipCity.trim();
    }

    public String getShipState() {
        return shipState;
    }

    public void setShipState(String shipState) {
        this.shipState = shipState == null ? null : shipState.trim();
    }

    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode == null ? null : shipPostalCode.trim();
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry == null ? null : shipCountry.trim();
    }

    public String getPromotionIds() {
        return promotionIds;
    }

    public void setPromotionIds(String promotionIds) {
        this.promotionIds = promotionIds == null ? null : promotionIds.trim();
    }

    public String getIsBusinessOrder() {
        return isBusinessOrder;
    }

    public void setIsBusinessOrder(String isBusinessOrder) {
        this.isBusinessOrder = isBusinessOrder == null ? null : isBusinessOrder.trim();
    }

    public Integer getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(Integer purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public String getPriceDesignation() {
        return priceDesignation;
    }

    public void setPriceDesignation(String priceDesignation) {
        this.priceDesignation = priceDesignation == null ? null : priceDesignation.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
}