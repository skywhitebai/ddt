package com.sky.ddt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class FinancialStatement {
    private Integer id;

    private Integer financeId;

    private Date month;

    private Integer shopId;

    private String shopName;

    private Integer developerUserId;

    private String developerUserName;

    private Integer salesmanUserId;

    private String salesmanUserName;

    private String shopParentSku;

    private String sku;

    private String shopSku;

    private Integer shopSkuId;

    private String productCode;

    private Integer saleQuantity;

    private BigDecimal productSales;

    private BigDecimal productSalesTax;

    private BigDecimal shippingCredits;

    private BigDecimal shippingCreditsTax;

    private BigDecimal giftWrapCredits;

    private BigDecimal giftWrapCreditsTax;

    private BigDecimal promotionalRebates;

    private BigDecimal promotionalRebatesTax;

    private BigDecimal marketplaceWithheldTax;

    private BigDecimal sellingFees;

    private BigDecimal fbaFees;

    private BigDecimal otherTransactionFees;

    private BigDecimal other;

    private BigDecimal total;

    private Integer refundSaleQuantity;

    private BigDecimal refundProductSales;

    private BigDecimal refundProductSalesTax;

    private BigDecimal refundShippingCredits;

    private BigDecimal refundShippingCreditsTax;

    private BigDecimal refundGiftWrapCredits;

    private BigDecimal refundGiftWrapCreditsTax;

    private BigDecimal refundPromotionalRebates;

    private BigDecimal refundPromotionalRebatesTax;

    private BigDecimal refundMarketplaceWithheldTax;

    private BigDecimal refundSellingFees;

    private BigDecimal refundFbaFees;

    private BigDecimal refundOtherTransactionFees;

    private BigDecimal refundOther;

    private BigDecimal refundTotal;

    private BigDecimal sellerpaymentsReportFeeSubscription;

    private BigDecimal lightningDealFee;

    private BigDecimal costOfAdvertising;

    private BigDecimal fbaInventoryReimbursementCustomerReturn;

    private BigDecimal fbaInventoryReimbursementDamagedWarehouse;

    private BigDecimal fbaInventoryReimbursementCustomerServiceIssue;

    private BigDecimal fbaInventoryReimbursementFeeCorrection;

    private BigDecimal fbaInventoryReimbursementGeneralAdjustment;

    private BigDecimal fbaInventoryReimbursementLostInbound;

    private BigDecimal fbaInventoryReimbursementLostWarehouse;

    private BigDecimal nonSubscriptionFeeAdjustment;

    private BigDecimal fbaInventoryPlacementServiceFee;

    private BigDecimal fbaCustomerReturnPerUnitFee;

    private BigDecimal fbaInventoryStorageFee;

    private BigDecimal fbaLongTermStorageFee;

    private BigDecimal fbaRemovalOrderDisposalFee;

    private BigDecimal couponRedemptionFee;

    private BigDecimal earlyReviewerProgramFee;

    private BigDecimal moneyBack;

    private BigDecimal moneyBackRate;

    private BigDecimal mainBusinessIncome;

    private BigDecimal totalEffectiveReceipts;

    private Integer sellableRequestedQuantity;

    private BigDecimal sellableCost;

    private Integer unsellableRequestedQuantity;

    private BigDecimal unsellableCost;

    private BigDecimal procurementCost;

    private BigDecimal fbaHeadTripCost;

    private BigDecimal headDeductionFee;

    private BigDecimal mainBusinessProfit;

    private BigDecimal grossMarginOnSales;

    private BigDecimal roi;

    private Integer initialQuantity;

    private BigDecimal initialInventoryCost;

    private Integer finalQuantity;

    private BigDecimal finalInventoryCost;

    private BigDecimal inventoryTurnover;

    private BigDecimal manualAdjustment;

    private Integer newProduct;

    private BigDecimal refundRate;

    private Date createTime;

    private Integer createBy;

    private BigDecimal advertisingSalesPercentage;

    private Integer productMonth;

    private BigDecimal exchangeRate;

    private String currencyName;

    private String currencyCode;

    private BigDecimal costPrice;

    private BigDecimal headTripCost;

    private Integer developmentLevel;

    private BigDecimal displayAdvertising;

    private BigDecimal brandAdvertising;

    private BigDecimal liquidations;

    private BigDecimal liquidationsAdjustments;

    private BigDecimal tbybOrderPayment;

    private BigDecimal tbybTrialShipment;

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

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public Integer getDeveloperUserId() {
        return developerUserId;
    }

    public void setDeveloperUserId(Integer developerUserId) {
        this.developerUserId = developerUserId;
    }

    public String getDeveloperUserName() {
        return developerUserName;
    }

    public void setDeveloperUserName(String developerUserName) {
        this.developerUserName = developerUserName == null ? null : developerUserName.trim();
    }

    public Integer getSalesmanUserId() {
        return salesmanUserId;
    }

    public void setSalesmanUserId(Integer salesmanUserId) {
        this.salesmanUserId = salesmanUserId;
    }

    public String getSalesmanUserName() {
        return salesmanUserName;
    }

    public void setSalesmanUserName(String salesmanUserName) {
        this.salesmanUserName = salesmanUserName == null ? null : salesmanUserName.trim();
    }

    public String getShopParentSku() {
        return shopParentSku;
    }

    public void setShopParentSku(String shopParentSku) {
        this.shopParentSku = shopParentSku == null ? null : shopParentSku.trim();
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    public String getShopSku() {
        return shopSku;
    }

    public void setShopSku(String shopSku) {
        this.shopSku = shopSku == null ? null : shopSku.trim();
    }

    public Integer getShopSkuId() {
        return shopSkuId;
    }

    public void setShopSkuId(Integer shopSkuId) {
        this.shopSkuId = shopSkuId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public Integer getSaleQuantity() {
        return saleQuantity;
    }

    public void setSaleQuantity(Integer saleQuantity) {
        this.saleQuantity = saleQuantity;
    }

    public BigDecimal getProductSales() {
        return productSales;
    }

    public void setProductSales(BigDecimal productSales) {
        this.productSales = productSales;
    }

    public BigDecimal getProductSalesTax() {
        return productSalesTax;
    }

    public void setProductSalesTax(BigDecimal productSalesTax) {
        this.productSalesTax = productSalesTax;
    }

    public BigDecimal getShippingCredits() {
        return shippingCredits;
    }

    public void setShippingCredits(BigDecimal shippingCredits) {
        this.shippingCredits = shippingCredits;
    }

    public BigDecimal getShippingCreditsTax() {
        return shippingCreditsTax;
    }

    public void setShippingCreditsTax(BigDecimal shippingCreditsTax) {
        this.shippingCreditsTax = shippingCreditsTax;
    }

    public BigDecimal getGiftWrapCredits() {
        return giftWrapCredits;
    }

    public void setGiftWrapCredits(BigDecimal giftWrapCredits) {
        this.giftWrapCredits = giftWrapCredits;
    }

    public BigDecimal getGiftWrapCreditsTax() {
        return giftWrapCreditsTax;
    }

    public void setGiftWrapCreditsTax(BigDecimal giftWrapCreditsTax) {
        this.giftWrapCreditsTax = giftWrapCreditsTax;
    }

    public BigDecimal getPromotionalRebates() {
        return promotionalRebates;
    }

    public void setPromotionalRebates(BigDecimal promotionalRebates) {
        this.promotionalRebates = promotionalRebates;
    }

    public BigDecimal getPromotionalRebatesTax() {
        return promotionalRebatesTax;
    }

    public void setPromotionalRebatesTax(BigDecimal promotionalRebatesTax) {
        this.promotionalRebatesTax = promotionalRebatesTax;
    }

    public BigDecimal getMarketplaceWithheldTax() {
        return marketplaceWithheldTax;
    }

    public void setMarketplaceWithheldTax(BigDecimal marketplaceWithheldTax) {
        this.marketplaceWithheldTax = marketplaceWithheldTax;
    }

    public BigDecimal getSellingFees() {
        return sellingFees;
    }

    public void setSellingFees(BigDecimal sellingFees) {
        this.sellingFees = sellingFees;
    }

    public BigDecimal getFbaFees() {
        return fbaFees;
    }

    public void setFbaFees(BigDecimal fbaFees) {
        this.fbaFees = fbaFees;
    }

    public BigDecimal getOtherTransactionFees() {
        return otherTransactionFees;
    }

    public void setOtherTransactionFees(BigDecimal otherTransactionFees) {
        this.otherTransactionFees = otherTransactionFees;
    }

    public BigDecimal getOther() {
        return other;
    }

    public void setOther(BigDecimal other) {
        this.other = other;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getRefundSaleQuantity() {
        return refundSaleQuantity;
    }

    public void setRefundSaleQuantity(Integer refundSaleQuantity) {
        this.refundSaleQuantity = refundSaleQuantity;
    }

    public BigDecimal getRefundProductSales() {
        return refundProductSales;
    }

    public void setRefundProductSales(BigDecimal refundProductSales) {
        this.refundProductSales = refundProductSales;
    }

    public BigDecimal getRefundProductSalesTax() {
        return refundProductSalesTax;
    }

    public void setRefundProductSalesTax(BigDecimal refundProductSalesTax) {
        this.refundProductSalesTax = refundProductSalesTax;
    }

    public BigDecimal getRefundShippingCredits() {
        return refundShippingCredits;
    }

    public void setRefundShippingCredits(BigDecimal refundShippingCredits) {
        this.refundShippingCredits = refundShippingCredits;
    }

    public BigDecimal getRefundShippingCreditsTax() {
        return refundShippingCreditsTax;
    }

    public void setRefundShippingCreditsTax(BigDecimal refundShippingCreditsTax) {
        this.refundShippingCreditsTax = refundShippingCreditsTax;
    }

    public BigDecimal getRefundGiftWrapCredits() {
        return refundGiftWrapCredits;
    }

    public void setRefundGiftWrapCredits(BigDecimal refundGiftWrapCredits) {
        this.refundGiftWrapCredits = refundGiftWrapCredits;
    }

    public BigDecimal getRefundGiftWrapCreditsTax() {
        return refundGiftWrapCreditsTax;
    }

    public void setRefundGiftWrapCreditsTax(BigDecimal refundGiftWrapCreditsTax) {
        this.refundGiftWrapCreditsTax = refundGiftWrapCreditsTax;
    }

    public BigDecimal getRefundPromotionalRebates() {
        return refundPromotionalRebates;
    }

    public void setRefundPromotionalRebates(BigDecimal refundPromotionalRebates) {
        this.refundPromotionalRebates = refundPromotionalRebates;
    }

    public BigDecimal getRefundPromotionalRebatesTax() {
        return refundPromotionalRebatesTax;
    }

    public void setRefundPromotionalRebatesTax(BigDecimal refundPromotionalRebatesTax) {
        this.refundPromotionalRebatesTax = refundPromotionalRebatesTax;
    }

    public BigDecimal getRefundMarketplaceWithheldTax() {
        return refundMarketplaceWithheldTax;
    }

    public void setRefundMarketplaceWithheldTax(BigDecimal refundMarketplaceWithheldTax) {
        this.refundMarketplaceWithheldTax = refundMarketplaceWithheldTax;
    }

    public BigDecimal getRefundSellingFees() {
        return refundSellingFees;
    }

    public void setRefundSellingFees(BigDecimal refundSellingFees) {
        this.refundSellingFees = refundSellingFees;
    }

    public BigDecimal getRefundFbaFees() {
        return refundFbaFees;
    }

    public void setRefundFbaFees(BigDecimal refundFbaFees) {
        this.refundFbaFees = refundFbaFees;
    }

    public BigDecimal getRefundOtherTransactionFees() {
        return refundOtherTransactionFees;
    }

    public void setRefundOtherTransactionFees(BigDecimal refundOtherTransactionFees) {
        this.refundOtherTransactionFees = refundOtherTransactionFees;
    }

    public BigDecimal getRefundOther() {
        return refundOther;
    }

    public void setRefundOther(BigDecimal refundOther) {
        this.refundOther = refundOther;
    }

    public BigDecimal getRefundTotal() {
        return refundTotal;
    }

    public void setRefundTotal(BigDecimal refundTotal) {
        this.refundTotal = refundTotal;
    }

    public BigDecimal getSellerpaymentsReportFeeSubscription() {
        return sellerpaymentsReportFeeSubscription;
    }

    public void setSellerpaymentsReportFeeSubscription(BigDecimal sellerpaymentsReportFeeSubscription) {
        this.sellerpaymentsReportFeeSubscription = sellerpaymentsReportFeeSubscription;
    }

    public BigDecimal getLightningDealFee() {
        return lightningDealFee;
    }

    public void setLightningDealFee(BigDecimal lightningDealFee) {
        this.lightningDealFee = lightningDealFee;
    }

    public BigDecimal getCostOfAdvertising() {
        return costOfAdvertising;
    }

    public void setCostOfAdvertising(BigDecimal costOfAdvertising) {
        this.costOfAdvertising = costOfAdvertising;
    }

    public BigDecimal getFbaInventoryReimbursementCustomerReturn() {
        return fbaInventoryReimbursementCustomerReturn;
    }

    public void setFbaInventoryReimbursementCustomerReturn(BigDecimal fbaInventoryReimbursementCustomerReturn) {
        this.fbaInventoryReimbursementCustomerReturn = fbaInventoryReimbursementCustomerReturn;
    }

    public BigDecimal getFbaInventoryReimbursementDamagedWarehouse() {
        return fbaInventoryReimbursementDamagedWarehouse;
    }

    public void setFbaInventoryReimbursementDamagedWarehouse(BigDecimal fbaInventoryReimbursementDamagedWarehouse) {
        this.fbaInventoryReimbursementDamagedWarehouse = fbaInventoryReimbursementDamagedWarehouse;
    }

    public BigDecimal getFbaInventoryReimbursementCustomerServiceIssue() {
        return fbaInventoryReimbursementCustomerServiceIssue;
    }

    public void setFbaInventoryReimbursementCustomerServiceIssue(BigDecimal fbaInventoryReimbursementCustomerServiceIssue) {
        this.fbaInventoryReimbursementCustomerServiceIssue = fbaInventoryReimbursementCustomerServiceIssue;
    }

    public BigDecimal getFbaInventoryReimbursementFeeCorrection() {
        return fbaInventoryReimbursementFeeCorrection;
    }

    public void setFbaInventoryReimbursementFeeCorrection(BigDecimal fbaInventoryReimbursementFeeCorrection) {
        this.fbaInventoryReimbursementFeeCorrection = fbaInventoryReimbursementFeeCorrection;
    }

    public BigDecimal getFbaInventoryReimbursementGeneralAdjustment() {
        return fbaInventoryReimbursementGeneralAdjustment;
    }

    public void setFbaInventoryReimbursementGeneralAdjustment(BigDecimal fbaInventoryReimbursementGeneralAdjustment) {
        this.fbaInventoryReimbursementGeneralAdjustment = fbaInventoryReimbursementGeneralAdjustment;
    }

    public BigDecimal getFbaInventoryReimbursementLostInbound() {
        return fbaInventoryReimbursementLostInbound;
    }

    public void setFbaInventoryReimbursementLostInbound(BigDecimal fbaInventoryReimbursementLostInbound) {
        this.fbaInventoryReimbursementLostInbound = fbaInventoryReimbursementLostInbound;
    }

    public BigDecimal getFbaInventoryReimbursementLostWarehouse() {
        return fbaInventoryReimbursementLostWarehouse;
    }

    public void setFbaInventoryReimbursementLostWarehouse(BigDecimal fbaInventoryReimbursementLostWarehouse) {
        this.fbaInventoryReimbursementLostWarehouse = fbaInventoryReimbursementLostWarehouse;
    }

    public BigDecimal getNonSubscriptionFeeAdjustment() {
        return nonSubscriptionFeeAdjustment;
    }

    public void setNonSubscriptionFeeAdjustment(BigDecimal nonSubscriptionFeeAdjustment) {
        this.nonSubscriptionFeeAdjustment = nonSubscriptionFeeAdjustment;
    }

    public BigDecimal getFbaInventoryPlacementServiceFee() {
        return fbaInventoryPlacementServiceFee;
    }

    public void setFbaInventoryPlacementServiceFee(BigDecimal fbaInventoryPlacementServiceFee) {
        this.fbaInventoryPlacementServiceFee = fbaInventoryPlacementServiceFee;
    }

    public BigDecimal getFbaCustomerReturnPerUnitFee() {
        return fbaCustomerReturnPerUnitFee;
    }

    public void setFbaCustomerReturnPerUnitFee(BigDecimal fbaCustomerReturnPerUnitFee) {
        this.fbaCustomerReturnPerUnitFee = fbaCustomerReturnPerUnitFee;
    }

    public BigDecimal getFbaInventoryStorageFee() {
        return fbaInventoryStorageFee;
    }

    public void setFbaInventoryStorageFee(BigDecimal fbaInventoryStorageFee) {
        this.fbaInventoryStorageFee = fbaInventoryStorageFee;
    }

    public BigDecimal getFbaLongTermStorageFee() {
        return fbaLongTermStorageFee;
    }

    public void setFbaLongTermStorageFee(BigDecimal fbaLongTermStorageFee) {
        this.fbaLongTermStorageFee = fbaLongTermStorageFee;
    }

    public BigDecimal getFbaRemovalOrderDisposalFee() {
        return fbaRemovalOrderDisposalFee;
    }

    public void setFbaRemovalOrderDisposalFee(BigDecimal fbaRemovalOrderDisposalFee) {
        this.fbaRemovalOrderDisposalFee = fbaRemovalOrderDisposalFee;
    }

    public BigDecimal getCouponRedemptionFee() {
        return couponRedemptionFee;
    }

    public void setCouponRedemptionFee(BigDecimal couponRedemptionFee) {
        this.couponRedemptionFee = couponRedemptionFee;
    }

    public BigDecimal getEarlyReviewerProgramFee() {
        return earlyReviewerProgramFee;
    }

    public void setEarlyReviewerProgramFee(BigDecimal earlyReviewerProgramFee) {
        this.earlyReviewerProgramFee = earlyReviewerProgramFee;
    }

    public BigDecimal getMoneyBack() {
        return moneyBack;
    }

    public void setMoneyBack(BigDecimal moneyBack) {
        this.moneyBack = moneyBack;
    }

    public BigDecimal getMoneyBackRate() {
        return moneyBackRate;
    }

    public void setMoneyBackRate(BigDecimal moneyBackRate) {
        this.moneyBackRate = moneyBackRate;
    }

    public BigDecimal getMainBusinessIncome() {
        return mainBusinessIncome;
    }

    public void setMainBusinessIncome(BigDecimal mainBusinessIncome) {
        this.mainBusinessIncome = mainBusinessIncome;
    }

    public BigDecimal getTotalEffectiveReceipts() {
        return totalEffectiveReceipts;
    }

    public void setTotalEffectiveReceipts(BigDecimal totalEffectiveReceipts) {
        this.totalEffectiveReceipts = totalEffectiveReceipts;
    }

    public Integer getSellableRequestedQuantity() {
        return sellableRequestedQuantity;
    }

    public void setSellableRequestedQuantity(Integer sellableRequestedQuantity) {
        this.sellableRequestedQuantity = sellableRequestedQuantity;
    }

    public BigDecimal getSellableCost() {
        return sellableCost;
    }

    public void setSellableCost(BigDecimal sellableCost) {
        this.sellableCost = sellableCost;
    }

    public Integer getUnsellableRequestedQuantity() {
        return unsellableRequestedQuantity;
    }

    public void setUnsellableRequestedQuantity(Integer unsellableRequestedQuantity) {
        this.unsellableRequestedQuantity = unsellableRequestedQuantity;
    }

    public BigDecimal getUnsellableCost() {
        return unsellableCost;
    }

    public void setUnsellableCost(BigDecimal unsellableCost) {
        this.unsellableCost = unsellableCost;
    }

    public BigDecimal getProcurementCost() {
        return procurementCost;
    }

    public void setProcurementCost(BigDecimal procurementCost) {
        this.procurementCost = procurementCost;
    }

    public BigDecimal getFbaHeadTripCost() {
        return fbaHeadTripCost;
    }

    public void setFbaHeadTripCost(BigDecimal fbaHeadTripCost) {
        this.fbaHeadTripCost = fbaHeadTripCost;
    }

    public BigDecimal getHeadDeductionFee() {
        return headDeductionFee;
    }

    public void setHeadDeductionFee(BigDecimal headDeductionFee) {
        this.headDeductionFee = headDeductionFee;
    }

    public BigDecimal getMainBusinessProfit() {
        return mainBusinessProfit;
    }

    public void setMainBusinessProfit(BigDecimal mainBusinessProfit) {
        this.mainBusinessProfit = mainBusinessProfit;
    }

    public BigDecimal getGrossMarginOnSales() {
        return grossMarginOnSales;
    }

    public void setGrossMarginOnSales(BigDecimal grossMarginOnSales) {
        this.grossMarginOnSales = grossMarginOnSales;
    }

    public BigDecimal getRoi() {
        return roi;
    }

    public void setRoi(BigDecimal roi) {
        this.roi = roi;
    }

    public Integer getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(Integer initialQuantity) {
        this.initialQuantity = initialQuantity;
    }

    public BigDecimal getInitialInventoryCost() {
        return initialInventoryCost;
    }

    public void setInitialInventoryCost(BigDecimal initialInventoryCost) {
        this.initialInventoryCost = initialInventoryCost;
    }

    public Integer getFinalQuantity() {
        return finalQuantity;
    }

    public void setFinalQuantity(Integer finalQuantity) {
        this.finalQuantity = finalQuantity;
    }

    public BigDecimal getFinalInventoryCost() {
        return finalInventoryCost;
    }

    public void setFinalInventoryCost(BigDecimal finalInventoryCost) {
        this.finalInventoryCost = finalInventoryCost;
    }

    public BigDecimal getInventoryTurnover() {
        return inventoryTurnover;
    }

    public void setInventoryTurnover(BigDecimal inventoryTurnover) {
        this.inventoryTurnover = inventoryTurnover;
    }

    public BigDecimal getManualAdjustment() {
        return manualAdjustment;
    }

    public void setManualAdjustment(BigDecimal manualAdjustment) {
        this.manualAdjustment = manualAdjustment;
    }

    public Integer getNewProduct() {
        return newProduct;
    }

    public void setNewProduct(Integer newProduct) {
        this.newProduct = newProduct;
    }

    public BigDecimal getRefundRate() {
        return refundRate;
    }

    public void setRefundRate(BigDecimal refundRate) {
        this.refundRate = refundRate;
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

    public BigDecimal getAdvertisingSalesPercentage() {
        return advertisingSalesPercentage;
    }

    public void setAdvertisingSalesPercentage(BigDecimal advertisingSalesPercentage) {
        this.advertisingSalesPercentage = advertisingSalesPercentage;
    }

    public Integer getProductMonth() {
        return productMonth;
    }

    public void setProductMonth(Integer productMonth) {
        this.productMonth = productMonth;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName == null ? null : currencyName.trim();
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode == null ? null : currencyCode.trim();
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getHeadTripCost() {
        return headTripCost;
    }

    public void setHeadTripCost(BigDecimal headTripCost) {
        this.headTripCost = headTripCost;
    }

    public Integer getDevelopmentLevel() {
        return developmentLevel;
    }

    public void setDevelopmentLevel(Integer developmentLevel) {
        this.developmentLevel = developmentLevel;
    }

    public BigDecimal getDisplayAdvertising() {
        return displayAdvertising;
    }

    public void setDisplayAdvertising(BigDecimal displayAdvertising) {
        this.displayAdvertising = displayAdvertising;
    }

    public BigDecimal getBrandAdvertising() {
        return brandAdvertising;
    }

    public void setBrandAdvertising(BigDecimal brandAdvertising) {
        this.brandAdvertising = brandAdvertising;
    }

    public BigDecimal getLiquidations() {
        return liquidations;
    }

    public void setLiquidations(BigDecimal liquidations) {
        this.liquidations = liquidations;
    }

    public BigDecimal getLiquidationsAdjustments() {
        return liquidationsAdjustments;
    }

    public void setLiquidationsAdjustments(BigDecimal liquidationsAdjustments) {
        this.liquidationsAdjustments = liquidationsAdjustments;
    }

    public BigDecimal getTbybOrderPayment() {
        return tbybOrderPayment;
    }

    public void setTbybOrderPayment(BigDecimal tbybOrderPayment) {
        this.tbybOrderPayment = tbybOrderPayment;
    }

    public BigDecimal getTbybTrialShipment() {
        return tbybTrialShipment;
    }

    public void setTbybTrialShipment(BigDecimal tbybTrialShipment) {
        this.tbybTrialShipment = tbybTrialShipment;
    }
}