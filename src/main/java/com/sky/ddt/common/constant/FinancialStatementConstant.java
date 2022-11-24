package com.sky.ddt.common.constant;

import com.sky.ddt.dto.finance.response.FinancialStatementExport;
import com.sky.ddt.entity.FinancialStatement;
import com.sky.ddt.util.MathUtil;
import lombok.Getter;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author baixueping
 * @description 财务报表
 * @date 2019/12/25 9:17
 */
public class FinancialStatementConstant {
    public static final String FINANCIAL_STATEMENT_NOT_EXIST = "财务报表不存在";
    public static final BigDecimal bigDecimal360 = new BigDecimal(360);
    public static final BigDecimal platformRate = new BigDecimal(-0.17);
    public static final BigDecimal platformRateMinusByOne = new BigDecimal(0.83);
    public static final BigDecimal refundRate = new BigDecimal(0.8);
    public static Map<Integer, String> titleMap = new HashMap<>();

    static {
        titleMap.put(0, "shopName");
        titleMap.put(1, "developerUserName");
        titleMap.put(2, "salesmanUserName");
        titleMap.put(3, "shopParentSku");
        titleMap.put(4, "sku");
        titleMap.put(5, "shopSku");
        titleMap.put(6, "productCode");
        titleMap.put(9, "saleQuantity");
        titleMap.put(10, "productSales");
        titleMap.put(11, "productSalesTax");
        titleMap.put(12, "shippingCredits");
        titleMap.put(13, "shippingCreditsTax");
        titleMap.put(14, "giftWrapCredits");
        titleMap.put(15, "giftWrapCreditsTax");
        titleMap.put(16, "promotionalRebates");
        titleMap.put(17, "promotionalRebatesTax");
        titleMap.put(18, "marketplaceWithheldTax");
        titleMap.put(19, "sellingFees");
        titleMap.put(20, "fbaFees");
        titleMap.put(21, "otherTransactionFees");
        titleMap.put(22, "other");
        titleMap.put(23, "total");
        titleMap.put(24, "refundSaleQuantity");
        titleMap.put(25, "refundProductSales");
        titleMap.put(26, "refundProductSalesTax");
        titleMap.put(27, "refundShippingCredits");
        titleMap.put(28, "refundShippingCreditsTax");
        titleMap.put(29, "refundGiftWrapCredits");
        titleMap.put(30, "refundGiftWrapCreditsTax");
        titleMap.put(31, "refundPromotionalRebates");
        titleMap.put(32, "refundPromotionalRebatesTax");
        titleMap.put(33, "refundMarketplaceWithheldTax");
        titleMap.put(34, "refundSellingFees");
        titleMap.put(35, "refundFbaFees");
        titleMap.put(36, "refundOtherTransactionFees");
        titleMap.put(37, "refundOther");
        titleMap.put(38, "refundTotal");
        titleMap.put(41, "sellerpaymentsReportFeeSubscription");
        titleMap.put(43, "lightningDealFee");
        titleMap.put(44, "costOfAdvertising");
        titleMap.put(45, "fbaInventoryReimbursementCustomerReturn");
        titleMap.put(46, "fbaInventoryReimbursementDamagedWarehouse");
        titleMap.put(47, "fbaInventoryReimbursementCustomerServiceIssue");
        titleMap.put(48, "fbaInventoryReimbursementFeeCorrection");
        titleMap.put(49, "fbaInventoryReimbursementGeneralAdjustment");
        titleMap.put(50, "fbaInventoryReimbursementLostInbound");
        titleMap.put(51, "fbaInventoryReimbursementLostWarehouse");
        titleMap.put(52, "nonSubscriptionFeeAdjustment");
        titleMap.put(53, "fbaInventoryPlacementServiceFee");
        titleMap.put(55, "fbaCustomerReturnPerUnitFee");
        titleMap.put(57, "fbaInventoryStorageFee");
        titleMap.put(58, "fbaLongTermStorageFee");
        titleMap.put(59, "fbaRemovalOrderDisposalFee");
        titleMap.put(62, "couponRedemptionFee");
        titleMap.put(63, "earlyReviewerProgramFee");
        titleMap.put(65, "moneyBack");
        titleMap.put(66, "moneyBackRate");
        titleMap.put(67, "mainBusinessIncome");
        titleMap.put(76, "totalEffectiveReceipts");
        titleMap.put(77, "sellableRequestedQuantity");
        titleMap.put(78, "sellableCost");
        titleMap.put(79, "unsellableRequestedQuantity");
        titleMap.put(80, "unsellableCost");
        titleMap.put(82, "procurementCost");
        titleMap.put(83, "fbaHeadTripCost");
        titleMap.put(84, "headDeductionFee");
        titleMap.put(89, "mainBusinessProfit");
        titleMap.put(90, "grossMarginOnSales");
        titleMap.put(91, "roi");
        titleMap.put(99, "initialQuantity");
        titleMap.put(100, "initialInventoryCost");
        titleMap.put(101, "finalQuantity");
        titleMap.put(102, "finalInventoryCost");
        titleMap.put(103, "inventoryTurnover");
    }

    /**
     * 初始化count
     *
     * @param financialStatementCount
     * @param financialStatementExport
     */
    public static FinancialStatementExport initFinancialStatementCount(FinancialStatementExport financialStatementExport) {
        FinancialStatementExport financialStatementCount = new FinancialStatementExport();
        financialStatementCount.setExchangeRate(financialStatementExport.getExchangeRate());
        financialStatementCount.setShopName(financialStatementExport.getShopName());
        financialStatementCount.setMonth(financialStatementExport.getMonth());
        financialStatementCount.setDeveloperUserName(financialStatementExport.getDeveloperUserName());
        financialStatementCount.setSalesmanUserName(financialStatementExport.getSalesmanUserName());
        financialStatementCount.setSalesGroupName(financialStatementExport.getSalesGroupName());
        financialStatementCount.setShopParentSku(financialStatementExport.getShopParentSku());
        financialStatementCount.setSku(financialStatementExport.getSku());
        financialStatementCount.setShopSku(financialStatementExport.getShopSku());
        financialStatementCount.setProductCode(financialStatementExport.getProductCode());
        return financialStatementCount;
    }

    /**
     * 更新全部信息，用于下载
     *
     * @param financialStatementExport
     */
    public static void initFinancialStatementExport(FinancialStatementExport financialStatementExport) {
        initFinancialStatementLessInfo(financialStatementExport);
        financialStatementExport.setAroi(MathUtil.divide(financialStatementExport.getMainBusinessProfit(), financialStatementExport.getAverageInventoryCost(), 2));
        financialStatementExport.setInventoryTurnoverTimes(MathUtil.divide(bigDecimal360, financialStatementExport.getInventoryTurnover(), 2));
        financialStatementExport.setRoiAssessmentCoefficient(MathUtil.multiply(financialStatementExport.getAroi(), financialStatementExport.getInventoryTurnoverTimes(), 2));
        financialStatementExport.setNotInit(false);
    }

    /**
     * 更新少量信息，供计算汇总信息
     *
     * @param financialStatementExport
     */
    public static void initFinancialStatementLessInfo(FinancialStatementExport financialStatementExport) {
        if (financialStatementExport.getProductMonth() != null) {
            if (financialStatementExport.getNewProduct() == 1) {
                financialStatementExport.setNewProductSellingFees(getSellingFees(financialStatementExport));
                financialStatementExport.setOldProductSellingFees(BigDecimal.ZERO);
                financialStatementExport.setNewProductMainBusinessProfit(financialStatementExport.getMainBusinessProfit());
                financialStatementExport.setOldProductMainBusinessProfit(BigDecimal.ZERO);
            } else {
                financialStatementExport.setNewProductSellingFees(BigDecimal.ZERO);
                financialStatementExport.setOldProductSellingFees(getSellingFees(financialStatementExport));
                financialStatementExport.setNewProductMainBusinessProfit(BigDecimal.ZERO);
                financialStatementExport.setOldProductMainBusinessProfit(financialStatementExport.getMainBusinessProfit());
            }
        }
        financialStatementExport.setAverageInventoryCost(MathUtil.divide(MathUtil.addBigDecimal(financialStatementExport.getInitialInventoryCost(), financialStatementExport.getFinalInventoryCost()), 2, 2));
    }

    private static BigDecimal getSellingFees(FinancialStatementExport financialStatementExport) {
        return MathUtil.multiply(MathUtil.addBigDecimal(MathUtil.divide(MathUtil.subtractBigDecimal(financialStatementExport.getSellingFees(), MathUtil.divide(financialStatementExport.getRefundSellingFees(), refundRate, 4)), platformRate, 4), MathUtil.divide(financialStatementExport.getTbybOrderPayment(), platformRateMinusByOne, 4)), financialStatementExport.getExchangeRate(), 2);
    }

    public static void setFinancialStatementCount(FinancialStatementExport financialStatementExport) {
        setMoneyBackRate(financialStatementExport);
        setGrossMarginOnSales(financialStatementExport);
        setRoiAndInventoryTurnover(financialStatementExport);
        setRefundRate(financialStatementExport);
        setAdvertisingSalesPercentage(financialStatementExport);
        financialStatementExport.setAroi(MathUtil.divide(financialStatementExport.getMainBusinessProfit(), financialStatementExport.getAverageInventoryCost(), 2));
        financialStatementExport.setInventoryTurnoverTimes(MathUtil.divide(bigDecimal360, financialStatementExport.getInventoryTurnover(), 2));
        financialStatementExport.setRoiAssessmentCoefficient(MathUtil.multiply(financialStatementExport.getAroi(), financialStatementExport.getInventoryTurnoverTimes(), 2));
    }

    private static void setMoneyBackRate(FinancialStatementExport financialStatement) {
        if (financialStatement.getProductSales() != null
                && financialStatement.getProductSales().compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal moneyBackRate = financialStatement.getMoneyBack().divide(financialStatement.getProductSales(), 4, BigDecimal.ROUND_HALF_UP);
            financialStatement.setMoneyBackRate(moneyBackRate);
        } else {
            financialStatement.setMoneyBackRate(BigDecimal.ZERO);
        }
    }

    private static void setGrossMarginOnSales(FinancialStatementExport financialStatement) {
        if (financialStatement.getProductSales() != null
                && financialStatement.getProductSales().compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal grossMarginOnSales = financialStatement.getMainBusinessProfit().divide(financialStatement.getProductSales().multiply(financialStatement.getExchangeRate()), 4, BigDecimal.ROUND_HALF_UP);
            financialStatement.setGrossMarginOnSales(grossMarginOnSales);
        } else {
            financialStatement.setGrossMarginOnSales(BigDecimal.ZERO);
        }
    }

    private static void setRoiAndInventoryTurnover(FinancialStatementExport financialStatement) {
        BigDecimal cost = MathUtil.subtractBigDecimal(MathUtil.addBigDecimal(financialStatement.getProcurementCost(), financialStatement.getFbaHeadTripCost()), financialStatement.getHeadDeductionFee());
        if (cost.compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal roi = MathUtil.divide(financialStatement.getMainBusinessProfit(), cost, 2);
            financialStatement.setRoi(roi);
            BigDecimal inventoryCost = MathUtil.addBigDecimal(financialStatement.getInitialInventoryCost(), financialStatement.getFinalInventoryCost());
            inventoryCost = MathUtil.divide(inventoryCost, new BigDecimal(2), 2);
            BigDecimal inventoryTurnover = MathUtil.divide(inventoryCost.multiply(new BigDecimal(30)), cost, 2);
            financialStatement.setInventoryTurnover(inventoryTurnover);
        } else {
            financialStatement.setRoi(BigDecimal.ZERO);
            financialStatement.setInventoryTurnover(BigDecimal.ZERO);
        }
    }

    private static void setRefundRate(FinancialStatementExport financialStatement) {
        if (new Integer(0).equals(financialStatement.getSaleQuantity())) {
            if (new Integer(0).equals(financialStatement.getRefundSaleQuantity())) {
                financialStatement.setRefundRate(BigDecimal.ZERO);
            } else {
                financialStatement.setRefundRate(new BigDecimal(10000));
            }
        } else {
            Double refundRate = MathUtil.divide(financialStatement.getRefundSaleQuantity(), financialStatement.getSaleQuantity().doubleValue(), 4);
            if (refundRate != null) {
                financialStatement.setRefundRate(new BigDecimal(refundRate));
            } else {
                financialStatement.setRefundRate(BigDecimal.ZERO);
            }
        }
    }

    private static void setAdvertisingSalesPercentage(FinancialStatementExport financialStatementResponse) {
        if (financialStatementResponse.getCostOfAdvertising().compareTo(BigDecimal.ZERO) == 0
                && financialStatementResponse.getDisplayAdvertising().compareTo(BigDecimal.ZERO) == 0
                && financialStatementResponse.getBrandAdvertising().compareTo(BigDecimal.ZERO) == 0) {
            financialStatementResponse.setAdvertisingSalesPercentage(BigDecimal.ZERO);
        } else {
            if (BigDecimal.ZERO.compareTo(financialStatementResponse.getProductSales()) == 0) {
                financialStatementResponse.setAdvertisingSalesPercentage(new BigDecimal(10000));
            } else {
                BigDecimal adCount = financialStatementResponse.getCostOfAdvertising().add(financialStatementResponse.getBrandAdvertising()).add(financialStatementResponse.getDisplayAdvertising());
                BigDecimal advertisingSalesPercentage = MathUtil.divide(adCount.multiply(new BigDecimal(-1)), financialStatementResponse.getProductSales(), 4);
                if (advertisingSalesPercentage != null) {
                    financialStatementResponse.setAdvertisingSalesPercentage(advertisingSalesPercentage);
                } else {
                    financialStatementResponse.setAdvertisingSalesPercentage(BigDecimal.ZERO);
                }
            }
        }
    }
}
