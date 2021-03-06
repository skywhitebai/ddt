package com.sky.ddt.common.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author baixueping
 * @description 财务报表
 * @date 2019/12/25 9:17
 */
public class FinancialStatementConstant {
    public static final String FINANCIAL_STATEMENT_NOT_EXIST ="财务报表不存在" ;
    public static Map<Integer,String> titleMap=new HashMap<>();

    static {
        titleMap.put(0,"shopName");
        titleMap.put(1,"developerUserName");
        titleMap.put(2,"salesmanUserName");
        titleMap.put(3,"shopParentSku");
        titleMap.put(4,"sku");
        titleMap.put(5,"shopSku");
        titleMap.put(6,"productCode");
        titleMap.put(9,"saleQuantity");
        titleMap.put(10,"productSales");
        titleMap.put(11,"productSalesTax");
        titleMap.put(12,"shippingCredits");
        titleMap.put(13,"shippingCreditsTax");
        titleMap.put(14,"giftWrapCredits");
        titleMap.put(15,"giftWrapCreditsTax");
        titleMap.put(16,"promotionalRebates");
        titleMap.put(17,"promotionalRebatesTax");
        titleMap.put(18,"marketplaceWithheldTax");
        titleMap.put(19,"sellingFees");
        titleMap.put(20,"fbaFees");
        titleMap.put(21,"otherTransactionFees");
        titleMap.put(22,"other");
        titleMap.put(23,"total");
        titleMap.put(24,"refundSaleQuantity");
        titleMap.put(25,"refundProductSales");
        titleMap.put(26,"refundProductSalesTax");
        titleMap.put(27,"refundShippingCredits");
        titleMap.put(28,"refundShippingCreditsTax");
        titleMap.put(29,"refundGiftWrapCredits");
        titleMap.put(30,"refundGiftWrapCreditsTax");
        titleMap.put(31,"refundPromotionalRebates");
        titleMap.put(32,"refundPromotionalRebatesTax");
        titleMap.put(33,"refundMarketplaceWithheldTax");
        titleMap.put(34,"refundSellingFees");
        titleMap.put(35,"refundFbaFees");
        titleMap.put(36,"refundOtherTransactionFees");
        titleMap.put(37,"refundOther");
        titleMap.put(38,"refundTotal");
        titleMap.put(41,"sellerpaymentsReportFeeSubscription");
        titleMap.put(43,"lightningDealFee");
        titleMap.put(44,"costOfAdvertising");
        titleMap.put(45,"fbaInventoryReimbursementCustomerReturn");
        titleMap.put(46,"fbaInventoryReimbursementDamagedWarehouse");
        titleMap.put(47,"fbaInventoryReimbursementCustomerServiceIssue");
        titleMap.put(48,"fbaInventoryReimbursementFeeCorrection");
        titleMap.put(49,"fbaInventoryReimbursementGeneralAdjustment");
        titleMap.put(50,"fbaInventoryReimbursementLostInbound");
        titleMap.put(51,"fbaInventoryReimbursementLostWarehouse");
        titleMap.put(52,"nonSubscriptionFeeAdjustment");
        titleMap.put(53,"fbaInventoryPlacementServiceFee");
        titleMap.put(55,"fbaCustomerReturnPerUnitFee");
        titleMap.put(57,"fbaInventoryStorageFee");
        titleMap.put(58,"fbaLongTermStorageFee");
        titleMap.put(59,"fbaRemovalOrderDisposalFee");
        titleMap.put(62,"couponRedemptionFee");
        titleMap.put(63,"earlyReviewerProgramFee");
        titleMap.put(65,"moneyBack");
        titleMap.put(66,"moneyBackRate");
        titleMap.put(67,"mainBusinessIncome");
        titleMap.put(76,"totalEffectiveReceipts");
        titleMap.put(77,"sellableRequestedQuantity");
        titleMap.put(78,"sellableCost");
        titleMap.put(79,"unsellableRequestedQuantity");
        titleMap.put(80,"unsellableCost");
        titleMap.put(82,"procurementCost");
        titleMap.put(83,"fbaHeadTripCost");
        titleMap.put(84,"headDeductionFee");
        titleMap.put(89,"mainBusinessProfit");
        titleMap.put(90,"grossMarginOnSales");
        titleMap.put(91,"roi");
        titleMap.put(99,"initialQuantity");
        titleMap.put(100,"initialInventoryCost");
        titleMap.put(101,"finalQuantity");
        titleMap.put(102,"finalInventoryCost");
        titleMap.put(103,"inventoryTurnover");
    }
}
