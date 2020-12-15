package com.sky.ddt.service.impl.finance;

import com.sky.ddt.common.constant.FinanceConstant;
import com.sky.ddt.common.constant.FinancialStatementConstant;
import com.sky.ddt.dao.custom.CustomFinanceMapper;
import com.sky.ddt.dao.custom.CustomFinancialStatementMapper;
import com.sky.ddt.dao.custom.CustomMonthlySalesMapper;
import com.sky.ddt.dto.finance.response.FbaCustomerReturnFeeResponse;
import com.sky.ddt.dto.finance.response.FbaCustomerReturnSkuResponse;
import com.sky.ddt.dto.finance.response.FinancialStatementResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.Finance;
import com.sky.ddt.entity.FinanceExample;
import com.sky.ddt.entity.FinancialStatement;
import com.sky.ddt.entity.FinancialStatementExample;
import com.sky.ddt.service.finance.IFinanceService;
import com.sky.ddt.service.finance.IFinancialStatementService;
import com.sky.ddt.util.DateUtil;
import com.sky.ddt.util.ExcelUtil;
import com.sky.ddt.util.MathUtil;
import com.sky.ddt.util.ZipUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author baixueping
 * @description 财务报表服务
 * @date 2019/12/24 11:29
 */
@Service
public class FinancialStatementService implements IFinancialStatementService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    CustomFinancialStatementMapper customFinancialStatementMapper;
    @Autowired
    IFinanceService financeService;
    @Autowired
    CustomFinanceMapper customFinanceMapper;
    @Autowired
    CustomMonthlySalesMapper customMonthlySalesMapper;

    /**
     * @param financeId
     * @param dealUserId
     * @return
     * @description
     * @author baixueping
     * @date 2019/12/24 11:39
     */
    @Override
    public BaseResponse createFinancialStatement(Integer financeId, Integer dealUserId) {
        if (financeId == null) {
            return BaseResponse.failMessage(FinanceConstant.ID_EMPTY);
        }
        //获取
        List<FinancialStatementResponse> financialStatementResponseList = customFinancialStatementMapper.getFinancialStatementResponse(financeId);
        if (CollectionUtils.isEmpty(financialStatementResponseList)) {
            return BaseResponse.failMessage(FinanceConstant.GET_FINANCIAL_STATEMENT_RESPONSE_FAIL);
        }
        //设置fba服务费返还
        setfbaCustomerReturnPerUnitFee(financialStatementResponseList);
        //找出销售金额最大的 设置店铺费
        setSellerpaymentsReportFeeSubscription(financialStatementResponseList);

        //计算
        for (FinancialStatementResponse financialStatementResponse :
                financialStatementResponseList) {
            BigDecimal moneyBack = BigDecimal.ZERO;
            moneyBack = moneyBack.add(financialStatementResponse.getTotal());
            moneyBack = moneyBack.add(financialStatementResponse.getRefundTotal());
            moneyBack = moneyBack.add(financialStatementResponse.getSellerpaymentsReportFeeSubscription());
            moneyBack = moneyBack.add(financialStatementResponse.getFbaInventoryPlacementServiceFee());
            moneyBack = moneyBack.add(financialStatementResponse.getLightningDealFee());
            moneyBack = moneyBack.add(financialStatementResponse.getCostOfAdvertising());
            moneyBack = moneyBack.add(financialStatementResponse.getFbaInventoryReimbursementCustomerReturn());
            moneyBack = moneyBack.add(financialStatementResponse.getFbaInventoryReimbursementDamagedWarehouse());
            moneyBack = moneyBack.add(financialStatementResponse.getFbaInventoryReimbursementCustomerServiceIssue());
            moneyBack = moneyBack.add(financialStatementResponse.getFbaInventoryReimbursementFeeCorrection());
            moneyBack = moneyBack.add(financialStatementResponse.getFbaInventoryReimbursementGeneralAdjustment());
            moneyBack = moneyBack.add(financialStatementResponse.getFbaInventoryReimbursementLostInbound());
            moneyBack = moneyBack.add(financialStatementResponse.getFbaInventoryReimbursementLostWarehouse());
            moneyBack = moneyBack.add(financialStatementResponse.getNonSubscriptionFeeAdjustment());
            moneyBack = moneyBack.add(financialStatementResponse.getFbaInventoryPlacementServiceFee());
            moneyBack = moneyBack.add(financialStatementResponse.getFbaCustomerReturnPerUnitFee());
            moneyBack = moneyBack.add(financialStatementResponse.getFbaInventoryStorageFee());
            moneyBack = moneyBack.add(financialStatementResponse.getFbaLongTermStorageFee());
            moneyBack = moneyBack.add(financialStatementResponse.getFbaRemovalOrderDisposalFee());
            moneyBack = moneyBack.add(financialStatementResponse.getCouponRedemptionFee());
            moneyBack = moneyBack.add(financialStatementResponse.getEarlyReviewerProgramFee());
            moneyBack = moneyBack.add(financialStatementResponse.getManualAdjustment());
            financialStatementResponse.setMoneyBack(moneyBack);
            if (financialStatementResponse.getProductSales().compareTo(BigDecimal.ZERO) != 0) {
                BigDecimal moneyBackRate = financialStatementResponse.getMoneyBack().divide(financialStatementResponse.getProductSales(), 4, BigDecimal.ROUND_HALF_UP);
                financialStatementResponse.setMoneyBackRate(moneyBackRate);
            } else {
                financialStatementResponse.setMoneyBackRate(BigDecimal.ZERO);
            }
            financialStatementResponse.setMainBusinessIncome(financialStatementResponse.getMoneyBack().multiply(FinanceConstant.RATE_OF_DOLLAR_EXCHANGE_RMB));
            financialStatementResponse.setTotalEffectiveReceipts(financialStatementResponse.getMainBusinessIncome());
            BigDecimal mainBusinessProfit = BigDecimal.ZERO.add(financialStatementResponse.getTotalEffectiveReceipts())
                    .subtract(financialStatementResponse.getSellableCost())
                    .subtract(financialStatementResponse.getUnsellableCost())
                    .subtract(financialStatementResponse.getProcurementCost())
                    .subtract(financialStatementResponse.getFbaHeadTripCost())
                    .add(financialStatementResponse.getHeadDeductionFee());
            financialStatementResponse.setMainBusinessProfit(mainBusinessProfit);
            if (financialStatementResponse.getProductSales().compareTo(BigDecimal.ZERO) != 0) {
                BigDecimal grossMarginOnSales = financialStatementResponse.getMainBusinessProfit().divide(financialStatementResponse.getProductSales().multiply(FinanceConstant.RATE_OF_DOLLAR_EXCHANGE_RMB), 4, BigDecimal.ROUND_HALF_UP);
                financialStatementResponse.setGrossMarginOnSales(grossMarginOnSales);
            } else {
                financialStatementResponse.setGrossMarginOnSales(BigDecimal.ZERO);
            }
            BigDecimal cost = BigDecimal.ZERO.add(financialStatementResponse.getProcurementCost()).add(financialStatementResponse.getFbaHeadTripCost());
            if (cost.compareTo(BigDecimal.ZERO) != 0) {
                BigDecimal roi = financialStatementResponse.getMainBusinessProfit().divide(cost, 2, BigDecimal.ROUND_HALF_UP);
                financialStatementResponse.setRoi(roi);
                BigDecimal inventoryTurnover = financialStatementResponse.getInitialInventoryCost()
                        .add(financialStatementResponse.getFinalInventoryCost())
                        .divide(new BigDecimal(2))
                        .multiply(new BigDecimal(31))
                        .divide(cost, 2, BigDecimal.ROUND_HALF_UP);
                financialStatementResponse.setInventoryTurnover(inventoryTurnover);
            } else {
                financialStatementResponse.setRoi(BigDecimal.ZERO);
                financialStatementResponse.setInventoryTurnover(BigDecimal.ZERO);
            }
            if (new Integer(0).equals(financialStatementResponse.getSaleQuantity())) {
                if (new Integer(0).equals(financialStatementResponse.getRefundSaleQuantity())) {
                    financialStatementResponse.setRefundRate(BigDecimal.ZERO);
                } else {
                    financialStatementResponse.setRefundRate(new BigDecimal(10000));
                }
            } else {
                Double refundRate = MathUtil.divide(financialStatementResponse.getRefundSaleQuantity(), financialStatementResponse.getSaleQuantity().doubleValue(), 4);
                if (refundRate != null) {
                    financialStatementResponse.setRefundRate(new BigDecimal(refundRate));
                } else {
                    financialStatementResponse.setRefundRate(BigDecimal.ZERO);
                }
            }
            if (financialStatementResponse.getCostOfAdvertising().compareTo(BigDecimal.ZERO) == 0) {
                financialStatementResponse.setAdvertisingSalesPercentage(BigDecimal.ZERO);
            } else {
                if (BigDecimal.ZERO.compareTo(financialStatementResponse.getProductSales()) == 0) {
                    financialStatementResponse.setAdvertisingSalesPercentage(new BigDecimal(10000));
                } else {
                    BigDecimal advertisingSalesPercentage = MathUtil.divide(financialStatementResponse.getCostOfAdvertising().multiply(new BigDecimal(-1)), financialStatementResponse.getProductSales(), 4);
                    if (advertisingSalesPercentage != null) {
                        financialStatementResponse.setAdvertisingSalesPercentage(advertisingSalesPercentage);
                    } else {
                        financialStatementResponse.setAdvertisingSalesPercentage(BigDecimal.ZERO);
                    }
                }
            }
        }
        Finance finance = financeService.getFinance(financeId);
        if (finance == null) {
            return BaseResponse.failMessage(FinanceConstant.ID_NOT_EXIST);
        }
        if (FinanceConstant.FinanceStatusEnum.LOCKED.getStatus().equals(finance.getStatus())) {
            return BaseResponse.failMessage(FinanceConstant.NOT_ALLOW_CREATE_FINANCIAL_STATEMENT);
        }

        if (FinanceConstant.FinanceStatusEnum.GENERATED.getStatus().equals(finance.getStatus())) {
            FinancialStatementExample financialStatementExample = new FinancialStatementExample();
            financialStatementExample.createCriteria().andFinanceIdEqualTo(financeId);
            customFinancialStatementMapper.deleteByExample(financialStatementExample);
        }
        //存储
        for (FinancialStatementResponse financialStatementResponse :
                financialStatementResponseList) {
            FinancialStatement financialStatement = new FinancialStatement();
            BeanUtils.copyProperties(financialStatementResponse, financialStatement);
            financialStatement.setCreateBy(dealUserId);
            financialStatement.setCreateTime(new Date());
            customFinancialStatementMapper.insertSelective(financialStatement);
        }
        if (FinanceConstant.FinanceStatusEnum.NOT_GENERATED.getStatus().equals(finance.getStatus())) {
            Finance financeUpdate = new Finance();
            financeUpdate.setStatus(FinanceConstant.FinanceStatusEnum.GENERATED.getStatus());
            financeUpdate.setId(financeId);
            customFinanceMapper.updateByPrimaryKeySelective(financeUpdate);
        }
        return BaseResponse.success();
    }

    private void setfbaCustomerReturnPerUnitFee(List<FinancialStatementResponse> financialStatementResponseList) {
        if (CollectionUtils.isEmpty(financialStatementResponseList)) {
            return;
        }
        Integer shopId = financialStatementResponseList.get(0).getShopId();
        Integer financeId = financialStatementResponseList.get(0).getFinanceId();
        if (shopId == null || financeId == null) {
            return;
        }
        //获取退款服务费列表
        List<FbaCustomerReturnFeeResponse> fbaCustomerReturnFeeResponseList = customMonthlySalesMapper.listFbaCustomerReturnFee(financeId);
        if (CollectionUtils.isEmpty(fbaCustomerReturnFeeResponseList)) {
            return;
        }
        //获取退款服务费对应的sku
        List<FbaCustomerReturnSkuResponse> fbaCustomerReturnSkuResponseList = customMonthlySalesMapper.listFbaCustomerReturnFeeSku(financeId, shopId);
        if (CollectionUtils.isEmpty(fbaCustomerReturnSkuResponseList)) {
            return;
        }
        for (FbaCustomerReturnFeeResponse fbaCustomerReturnFeeResponse : fbaCustomerReturnFeeResponseList) {
            fbaCustomerReturnFeeResponse.setShopSkuId(getShopSkuId(fbaCustomerReturnFeeResponse.getOrderId(), fbaCustomerReturnSkuResponseList));
        }
        for (FinancialStatementResponse financialStatementResponse :
                financialStatementResponseList) {
            financialStatementResponse.setFbaCustomerReturnPerUnitFee(getFbaCustomerReturnPerUnitFee(financialStatementResponse.getShopSkuId(), fbaCustomerReturnFeeResponseList));
        }
    }

    private BigDecimal getFbaCustomerReturnPerUnitFee(Integer shopSkuId, List<FbaCustomerReturnFeeResponse> fbaCustomerReturnFeeResponseList) {
        BigDecimal fbaCustomerReturnPerUnitFee = BigDecimal.ZERO;
        Iterator<FbaCustomerReturnFeeResponse> it = fbaCustomerReturnFeeResponseList.iterator();
        while (it.hasNext()) {
            FbaCustomerReturnFeeResponse fbaCustomerReturnFeeResponse = it.next();
            if (shopSkuId.equals(fbaCustomerReturnFeeResponse.getShopSkuId())) {
                fbaCustomerReturnPerUnitFee = fbaCustomerReturnPerUnitFee.add(fbaCustomerReturnFeeResponse.getTotal());
                it.remove();
            }
        }
        return fbaCustomerReturnPerUnitFee;
    }

    private Integer getShopSkuId(String orderId, List<FbaCustomerReturnSkuResponse> fbaCustomerReturnSkuResponseList) {
        FbaCustomerReturnSkuResponse fbaCustomerReturnSkuResponseFirst = null;
        for (FbaCustomerReturnSkuResponse fbaCustomerReturnSkuResponse : fbaCustomerReturnSkuResponseList) {
            if (fbaCustomerReturnSkuResponse.getOrderId().equals(orderId)) {
                if (!Boolean.TRUE.equals(fbaCustomerReturnSkuResponse.getUsed())) {
                    fbaCustomerReturnSkuResponse.setUsed(Boolean.TRUE);
                    return fbaCustomerReturnSkuResponse.getShopSkuId();
                }
                if (fbaCustomerReturnSkuResponseFirst == null) {
                    fbaCustomerReturnSkuResponseFirst = fbaCustomerReturnSkuResponse;
                }

            }
        }
        if (fbaCustomerReturnSkuResponseFirst != null) {
            return fbaCustomerReturnSkuResponseFirst.getShopSkuId();
        } else {
            logger.info("fbaCustomerReturnFee orderId:" + orderId + ",找不到sku");
        }
        return null;
    }

    /**
     * @param response
     * @param financeId @return
     * @description 导出财务报表
     * @author baixueping
     * @date 2019/12/25 9:48
     */
    @Override
    public BaseResponse exportFinancialStatement(HttpServletResponse response, Integer financeId) {
        if (financeId == null) {
            return BaseResponse.failMessage(FinanceConstant.ID_EMPTY);
        }
        FinancialStatementExample example = new FinancialStatementExample();
        example.createCriteria().andFinanceIdEqualTo(financeId);
        example.setOrderByClause("shop_parent_sku,sku");
        List<FinancialStatement> financialStatementList = customFinancialStatementMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(financialStatementList)) {
            return BaseResponse.failMessage(FinancialStatementConstant.FINANCIAL_STATEMENT_NOT_EXIST);
        }
        FinancialStatement financialStatement = financialStatementList.get(0);
        String month = DateUtil.getMonthChinese(financialStatement.getMonth());
        if (month == null) {
            month = "";
        }
        String shopName = financialStatement.getShopName();
        if (shopName == null) {
            shopName = "";
        }
        //读取模板
        String excelTitle = month + "-" + shopName + "各SKU利润表";
        Workbook workbook =getWorkbook(financialStatementList, excelTitle);
        String fileName = financialStatement.getShopName() + "-" + month + "财务报表";
        return ExcelUtil.exportExcel(response, workbook, fileName);
    }

    /**
     * @param response
     * @param month
     * @param type     @return
     * @description 导出制定月份财务数据
     * @author baixueping
     * @date 2020/12/15 14:42
     */
    @Override
    public BaseResponse exportFinancialStatement(HttpServletResponse response, String month, String type) {
        //查询当月所有数据 判断是否全部已生成，如果有未生成的则报错
        if (StringUtils.isEmpty(month)) {
            return BaseResponse.failMessage("请选择月份");
        }
        Date monthDate = DateUtil.strMonthToDate(month);
        if (monthDate == null) {
            return BaseResponse.failMessage("月份格式错误");
        }
        BaseResponse<List<Integer>> checkFinancialStatusResponse = checkFinancialStatus(monthDate);
        if (checkFinancialStatusResponse.isFail()) {
            return checkFinancialStatusResponse;
        }
        //获取所有店铺sku销售数据
        FinancialStatementExample example = new FinancialStatementExample();
        example.createCriteria().andFinanceIdIn(checkFinancialStatusResponse.getData());
        example.setOrderByClause("shop_parent_sku,sku");
        List<FinancialStatement> financialStatementList = customFinancialStatementMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(financialStatementList)) {
            return BaseResponse.failMessage(FinancialStatementConstant.FINANCIAL_STATEMENT_NOT_EXIST);
        }
        String monthChinese = DateUtil.getMonthChinese(financialStatementList.get(0).getMonth());
        if (month == null) {
            month = "";
        }
        //根据用户信息，生成多个excel
        Map<String, Workbook> workbookMap = getWorkbookMap(financialStatementList, type, monthChinese);
        //Map<String, ByteArrayOutputStream> byteArrayOutputStreamMap = workBook2Stream(workbookMap);
        String fileName = getZipName(monthChinese, type);
        Map<String, byte[]> byteMap = workBook2Byte(workbookMap,fileName);
        ZipUtil.downloadBatchByFile(response, byteMap,fileName);
        return BaseResponse.success();
    }

    private Map<String,byte[]> workBook2Byte(Map<String, Workbook> workbookMap,String fileName) {
        Map<String, byte[]> map = new HashMap<>();
        String excelNameLast="-"+DateUtil.getFormatStryyyyMMddHHmmss(new Date())+".xlsx";
        for (String key : workbookMap.keySet()) {
            Workbook workbook = workbookMap.get(key);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try {
                workbook.write(outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] bytes = outputStream.toByteArray();
            String excelName=fileName+"-"+(StringUtils.isEmpty(key)?"null":key)+excelNameLast;
            map.put(excelName, bytes);
        }
        return map;
    }

    private String getZipName(String monthChinese, String type) {
        if ("developer".equals(type)) {
            return "开发人员" + monthChinese + "财务报表";
        } else if ("salesman".equals(type)) {
            return "销售人员" + monthChinese + "财务报表";
        } else {
            return "类型错误";
        }
    }

    public static Map<String, ByteArrayOutputStream> workBook2Stream(Map<String, Workbook> workbookMap) {
        Map<String, ByteArrayOutputStream> map = new HashMap<>();
        for (String key : workbookMap.keySet()) {
            Workbook workbook = workbookMap.get(key);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try {
                workbook.write(outputStream);
                map.put(key, outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    private Map<String, Workbook> getWorkbookMap(List<FinancialStatement> financialStatementList, String type, String monthChinese) {
        List<String> userNameList = getUserNameList(financialStatementList, type);
        Map<String, Workbook> workbookMap = new HashMap<>();
        userNameList.stream().forEach(userName -> {
            Workbook workbook = getWorkbook(userName, financialStatementList, type, monthChinese);
            workbookMap.put(userName, workbook);
        });
        return workbookMap;
    }

    private Workbook getWorkbook(String userName, List<FinancialStatement> financialStatementList, String type, String monthChinese) {
        //获取财务信息
        List<FinancialStatement> financialStatementListUserName = getFinancialStatementListUserName(userName, financialStatementList, type);
        //获取workbook
        String excelTitle = userName + "-" + monthChinese + "-各SKU利润表";
        Workbook workbook = getWorkbook(financialStatementListUserName, excelTitle);
        return workbook;
    }

    private Workbook getWorkbook(List<FinancialStatement> financialStatementList, String excelTitle) {
        //读取模板
        String path = FinancialStatementService.class.getClassLoader().getResource("template/finance/financialStatementTemplate.xlsx").getPath();
        Workbook wb = ExcelUtil.readExcel(path);
        Sheet sheet = wb.getSheetAt(0);
        setExcelTitle(sheet, excelTitle);
        setFinancialStatement(sheet, financialStatementList);
        Sheet sheetShopParentSku = wb.getSheetAt(1);
        setExcelTitle(sheetShopParentSku, excelTitle);
        setFinancialStatementShopParentSku(sheetShopParentSku, financialStatementList);
        return wb;
    }

    private void setExcelTitle(Sheet sheet, String excelTitle) {
        Row row = sheet.getRow(0);
        row.getCell(0).setCellValue(excelTitle);
    }

    private List<FinancialStatement> getFinancialStatementListUserName(String userName, List<FinancialStatement> financialStatementList, String type) {
        List<FinancialStatement> financialStatements = new ArrayList<>();
        if (FinanceConstant.FinanceUserType.DEVELOPER.getType().equals(type)) {
            financialStatements = financialStatementList.stream().filter(item -> {
                if (StringUtils.isEmpty(item.getDeveloperUserName())) {
                    if (StringUtils.isEmpty(userName)) {
                        return true;
                    } else {
                        return false;
                    }
                }
                if (item.getDeveloperUserName().equals(userName)) {
                    return true;
                }
                return false;
            }).collect(Collectors.toList());
        } else if (FinanceConstant.FinanceUserType.SALESMAN.getType().equals(type)) {
            financialStatements = financialStatementList.stream().filter(item -> {
                if (StringUtils.isEmpty(item.getSalesmanUserName())) {
                    if (StringUtils.isEmpty(userName)) {
                        return true;
                    } else {
                        return false;
                    }
                }
                if (item.getSalesmanUserName().equals(userName)) {
                    return true;
                }
                return false;
            }).collect(Collectors.toList());
        }

        return financialStatements;
    }


    private List<String> getUserNameList(List<FinancialStatement> financialStatementList, String type) {
        List<String> userNameList = new ArrayList<>();
        if ("developer".equals(type)) {
            userNameList = financialStatementList.stream().map(FinancialStatement::getDeveloperUserName).distinct().collect(Collectors.toList());
        } else if ("salesman".equals(type)) {
            userNameList = financialStatementList.stream().map(FinancialStatement::getDeveloperUserName).distinct().collect(Collectors.toList());
        }
        return userNameList;
    }

    private BaseResponse<List<Integer>> checkFinancialStatus(Date month) {
        FinanceExample financeExample = new FinanceExample();
        financeExample.createCriteria().andMonthEqualTo(month);
        List<Finance> financeList = customFinanceMapper.selectByExample(financeExample);
        if (CollectionUtils.isEmpty(financeList)) {
            return BaseResponse.failMessage("没有财务信息");
        }
        List<Integer> financeIdList = financeList.stream().filter(item -> {
            return FinanceConstant.FinanceStatusEnum.GENERATED.getStatus().equals(item.getStatus()) ||
                    FinanceConstant.FinanceStatusEnum.LOCKED.getStatus().equals(item.getStatus());
        }).map(Finance::getId).distinct().collect(Collectors.toList());
        if (CollectionUtils.isEmpty(financeIdList)) {
            return BaseResponse.failMessage("没有已生成或已锁定的财务信息");
        }
        return BaseResponse.successData(financeIdList);
    }

    private void setFinancialStatementShopParentSku(Sheet sheet, List<FinancialStatement> financialStatementList) {
        if (CollectionUtils.isEmpty(financialStatementList)) {
            return;
        }
        List<FinancialStatement> financialStatementShopParentSkuList = getFinancialStatementShopParentSkuList(financialStatementList);
        int rowIndex = 6;
        for (int i = 0; i < financialStatementShopParentSkuList.size(); i++) {
            FinancialStatement financialStatement = financialStatementShopParentSkuList.get(i);
            Row row = sheet.createRow(rowIndex);
            row.createCell(7).setCellValue(i + 1);
            row.createCell(0).setCellValue(financialStatement.getShopName());
            row.createCell(1).setCellValue(financialStatement.getDeveloperUserName());
            row.createCell(2).setCellValue(financialStatement.getSalesmanUserName());
            row.createCell(3).setCellValue(financialStatement.getShopParentSku());
            row.createCell(4).setCellValue(financialStatement.getSku());
            row.createCell(5).setCellValue(financialStatement.getProductCode());
            row.createCell(8).setCellValue(financialStatement.getSaleQuantity().doubleValue());
            row.createCell(9).setCellValue(financialStatement.getProductSales().doubleValue());
            row.createCell(10).setCellValue(financialStatement.getProductSalesTax().doubleValue());
            row.createCell(11).setCellValue(financialStatement.getShippingCredits().doubleValue());
            row.createCell(12).setCellValue(financialStatement.getShippingCreditsTax().doubleValue());
            row.createCell(13).setCellValue(financialStatement.getGiftWrapCredits().doubleValue());
            row.createCell(14).setCellValue(financialStatement.getGiftWrapCreditsTax().doubleValue());
            row.createCell(15).setCellValue(financialStatement.getPromotionalRebates().doubleValue());
            row.createCell(16).setCellValue(financialStatement.getPromotionalRebatesTax().doubleValue());
            row.createCell(17).setCellValue(financialStatement.getMarketplaceWithheldTax().doubleValue());
            row.createCell(18).setCellValue(financialStatement.getSellingFees().doubleValue());
            row.createCell(19).setCellValue(financialStatement.getFbaFees().doubleValue());
            row.createCell(20).setCellValue(financialStatement.getOtherTransactionFees().doubleValue());
            row.createCell(21).setCellValue(financialStatement.getOther().doubleValue());
            row.createCell(22).setCellValue(financialStatement.getTotal().doubleValue());
            row.createCell(23).setCellValue(financialStatement.getRefundSaleQuantity().doubleValue());
            row.createCell(24).setCellValue(financialStatement.getRefundProductSales().doubleValue());
            row.createCell(25).setCellValue(financialStatement.getRefundProductSalesTax().doubleValue());
            row.createCell(26).setCellValue(financialStatement.getRefundShippingCredits().doubleValue());
            row.createCell(27).setCellValue(financialStatement.getRefundShippingCreditsTax().doubleValue());
            row.createCell(28).setCellValue(financialStatement.getRefundGiftWrapCredits().doubleValue());
            row.createCell(29).setCellValue(financialStatement.getRefundGiftWrapCreditsTax().doubleValue());
            row.createCell(30).setCellValue(financialStatement.getRefundPromotionalRebates().doubleValue());
            row.createCell(31).setCellValue(financialStatement.getRefundPromotionalRebatesTax().doubleValue());
            row.createCell(32).setCellValue(financialStatement.getRefundMarketplaceWithheldTax().doubleValue());
            row.createCell(33).setCellValue(financialStatement.getRefundSellingFees().doubleValue());
            row.createCell(34).setCellValue(financialStatement.getRefundFbaFees().doubleValue());
            row.createCell(35).setCellValue(financialStatement.getRefundOtherTransactionFees().doubleValue());
            row.createCell(36).setCellValue(financialStatement.getRefundOther().doubleValue());
            row.createCell(37).setCellValue(financialStatement.getRefundTotal().doubleValue());
            row.createCell(40).setCellValue(financialStatement.getSellerpaymentsReportFeeSubscription().doubleValue());
            row.createCell(42).setCellValue(financialStatement.getLightningDealFee().doubleValue());
            row.createCell(43).setCellValue(financialStatement.getCostOfAdvertising().doubleValue());
            row.createCell(44).setCellValue(financialStatement.getFbaInventoryReimbursementCustomerReturn().doubleValue());
            row.createCell(45).setCellValue(financialStatement.getFbaInventoryReimbursementDamagedWarehouse().doubleValue());
            row.createCell(46).setCellValue(financialStatement.getFbaInventoryReimbursementCustomerServiceIssue().doubleValue());
            row.createCell(47).setCellValue(financialStatement.getFbaInventoryReimbursementFeeCorrection().doubleValue());
            row.createCell(48).setCellValue(financialStatement.getFbaInventoryReimbursementGeneralAdjustment().doubleValue());
            row.createCell(49).setCellValue(financialStatement.getFbaInventoryReimbursementLostInbound().doubleValue());
            row.createCell(50).setCellValue(financialStatement.getFbaInventoryReimbursementLostWarehouse().doubleValue());
            row.createCell(51).setCellValue(financialStatement.getNonSubscriptionFeeAdjustment().doubleValue());
            row.createCell(52).setCellValue(financialStatement.getFbaInventoryPlacementServiceFee().doubleValue());
            row.createCell(54).setCellValue(financialStatement.getFbaCustomerReturnPerUnitFee().doubleValue());
            row.createCell(56).setCellValue(financialStatement.getFbaInventoryStorageFee().doubleValue());
            row.createCell(57).setCellValue(financialStatement.getFbaLongTermStorageFee().doubleValue());
            row.createCell(58).setCellValue(financialStatement.getFbaRemovalOrderDisposalFee().doubleValue());
            row.createCell(61).setCellValue(financialStatement.getCouponRedemptionFee().doubleValue());
            row.createCell(62).setCellValue(financialStatement.getEarlyReviewerProgramFee().doubleValue());
            row.createCell(64).setCellValue(financialStatement.getManualAdjustment().doubleValue());
            row.createCell(65).setCellValue(financialStatement.getMoneyBack().doubleValue());
            row.createCell(66).setCellValue(financialStatement.getMoneyBackRate().multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
            row.createCell(67).setCellValue(financialStatement.getMainBusinessIncome().doubleValue());
            row.createCell(76).setCellValue(financialStatement.getTotalEffectiveReceipts().doubleValue());
            row.createCell(77).setCellValue(financialStatement.getSellableRequestedQuantity().doubleValue());
            row.createCell(78).setCellValue(financialStatement.getSellableCost().doubleValue());
            row.createCell(79).setCellValue(financialStatement.getUnsellableRequestedQuantity().doubleValue());
            row.createCell(80).setCellValue(financialStatement.getUnsellableCost().doubleValue());
            row.createCell(82).setCellValue(financialStatement.getProcurementCost().doubleValue());
            row.createCell(83).setCellValue(financialStatement.getFbaHeadTripCost().doubleValue());
            row.createCell(84).setCellValue(financialStatement.getHeadDeductionFee().doubleValue());
            row.createCell(89).setCellValue(financialStatement.getMainBusinessProfit().doubleValue());
            row.createCell(90).setCellValue(financialStatement.getGrossMarginOnSales().multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
            row.createCell(91).setCellValue(financialStatement.getRoi().doubleValue());
            row.createCell(99).setCellValue(financialStatement.getInitialQuantity());
            row.createCell(100).setCellValue(financialStatement.getInitialInventoryCost().doubleValue());
            row.createCell(101).setCellValue(financialStatement.getFinalQuantity());
            row.createCell(102).setCellValue(financialStatement.getFinalInventoryCost().doubleValue());
            row.createCell(103).setCellValue(financialStatement.getInventoryTurnover().doubleValue());
            row.createCell(104).setCellValue(financialStatement.getRefundRate().multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
            row.createCell(105).setCellValue(financialStatement.getAdvertisingSalesPercentage().multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
            rowIndex++;
        }
    }

    private List<FinancialStatement> getFinancialStatementShopParentSkuList(List<FinancialStatement> financialStatementList) {
        Map<String, FinancialStatement> financialStatementMap = new HashMap<>();
        Iterator<FinancialStatement> iterator = financialStatementList.iterator();
        while (iterator.hasNext()) {
            FinancialStatement financialStatement = iterator.next();
            FinancialStatement financialStatementShopParentSku = financialStatementMap.get(financialStatement.getShopParentSku());
            if (financialStatementShopParentSku == null) {
                financialStatementMap.put(financialStatement.getShopParentSku(), financialStatement);
                iterator.remove();
                continue;
            }
            financialStatementShopParentSku.setSaleQuantity(MathUtil.addInteger(financialStatementShopParentSku.getSaleQuantity(), financialStatement.getSaleQuantity()));
            financialStatementShopParentSku.setProductSales(MathUtil.addBigDecimal(financialStatementShopParentSku.getProductSales(), financialStatement.getProductSales()));
            financialStatementShopParentSku.setProductSalesTax(MathUtil.addBigDecimal(financialStatementShopParentSku.getProductSalesTax(), financialStatement.getProductSalesTax()));
            financialStatementShopParentSku.setShippingCredits(MathUtil.addBigDecimal(financialStatementShopParentSku.getShippingCredits(), financialStatement.getShippingCredits()));
            financialStatementShopParentSku.setShippingCreditsTax(MathUtil.addBigDecimal(financialStatementShopParentSku.getShippingCreditsTax(), financialStatement.getShippingCreditsTax()));
            financialStatementShopParentSku.setGiftWrapCredits(MathUtil.addBigDecimal(financialStatementShopParentSku.getGiftWrapCredits(), financialStatement.getGiftWrapCredits()));
            financialStatementShopParentSku.setGiftWrapCreditsTax(MathUtil.addBigDecimal(financialStatementShopParentSku.getGiftWrapCreditsTax(), financialStatement.getGiftWrapCreditsTax()));
            financialStatementShopParentSku.setPromotionalRebates(MathUtil.addBigDecimal(financialStatementShopParentSku.getPromotionalRebates(), financialStatement.getPromotionalRebates()));
            financialStatementShopParentSku.setPromotionalRebatesTax(MathUtil.addBigDecimal(financialStatementShopParentSku.getPromotionalRebatesTax(), financialStatement.getPromotionalRebatesTax()));
            financialStatementShopParentSku.setMarketplaceWithheldTax(MathUtil.addBigDecimal(financialStatementShopParentSku.getMarketplaceWithheldTax(), financialStatement.getMarketplaceWithheldTax()));
            financialStatementShopParentSku.setSellingFees(MathUtil.addBigDecimal(financialStatementShopParentSku.getSellingFees(), financialStatement.getSellingFees()));
            financialStatementShopParentSku.setFbaFees(MathUtil.addBigDecimal(financialStatementShopParentSku.getFbaFees(), financialStatement.getFbaFees()));
            financialStatementShopParentSku.setOtherTransactionFees(MathUtil.addBigDecimal(financialStatementShopParentSku.getOtherTransactionFees(), financialStatement.getOtherTransactionFees()));
            financialStatementShopParentSku.setOther(MathUtil.addBigDecimal(financialStatementShopParentSku.getOther(), financialStatement.getOther()));
            financialStatementShopParentSku.setTotal(MathUtil.addBigDecimal(financialStatementShopParentSku.getTotal(), financialStatement.getTotal()));
            financialStatementShopParentSku.setRefundSaleQuantity(MathUtil.addInteger(financialStatementShopParentSku.getRefundSaleQuantity(), financialStatement.getRefundSaleQuantity()));
            financialStatementShopParentSku.setRefundProductSales(MathUtil.addBigDecimal(financialStatementShopParentSku.getRefundProductSales(), financialStatement.getRefundProductSales()));
            financialStatementShopParentSku.setRefundProductSalesTax(MathUtil.addBigDecimal(financialStatementShopParentSku.getRefundProductSalesTax(), financialStatement.getRefundProductSalesTax()));
            financialStatementShopParentSku.setRefundShippingCredits(MathUtil.addBigDecimal(financialStatementShopParentSku.getRefundShippingCredits(), financialStatement.getRefundShippingCredits()));
            financialStatementShopParentSku.setRefundShippingCreditsTax(MathUtil.addBigDecimal(financialStatementShopParentSku.getRefundShippingCreditsTax(), financialStatement.getRefundShippingCreditsTax()));
            financialStatementShopParentSku.setRefundGiftWrapCredits(MathUtil.addBigDecimal(financialStatementShopParentSku.getRefundGiftWrapCredits(), financialStatement.getRefundGiftWrapCredits()));
            financialStatementShopParentSku.setRefundGiftWrapCreditsTax(MathUtil.addBigDecimal(financialStatementShopParentSku.getRefundGiftWrapCreditsTax(), financialStatement.getRefundGiftWrapCreditsTax()));
            financialStatementShopParentSku.setRefundPromotionalRebates(MathUtil.addBigDecimal(financialStatementShopParentSku.getRefundPromotionalRebates(), financialStatement.getRefundPromotionalRebates()));
            financialStatementShopParentSku.setRefundPromotionalRebatesTax(MathUtil.addBigDecimal(financialStatementShopParentSku.getRefundPromotionalRebatesTax(), financialStatement.getRefundPromotionalRebatesTax()));
            financialStatementShopParentSku.setRefundMarketplaceWithheldTax(MathUtil.addBigDecimal(financialStatementShopParentSku.getRefundMarketplaceWithheldTax(), financialStatement.getRefundMarketplaceWithheldTax()));
            financialStatementShopParentSku.setRefundSellingFees(MathUtil.addBigDecimal(financialStatementShopParentSku.getRefundSellingFees(), financialStatement.getRefundSellingFees()));
            financialStatementShopParentSku.setRefundFbaFees(MathUtil.addBigDecimal(financialStatementShopParentSku.getRefundFbaFees(), financialStatement.getRefundFbaFees()));
            financialStatementShopParentSku.setRefundOtherTransactionFees(MathUtil.addBigDecimal(financialStatementShopParentSku.getRefundOtherTransactionFees(), financialStatement.getRefundOtherTransactionFees()));
            financialStatementShopParentSku.setRefundOther(MathUtil.addBigDecimal(financialStatementShopParentSku.getRefundOther(), financialStatement.getRefundOther()));
            financialStatementShopParentSku.setRefundTotal(MathUtil.addBigDecimal(financialStatementShopParentSku.getRefundTotal(), financialStatement.getRefundTotal()));
            financialStatementShopParentSku.setSellerpaymentsReportFeeSubscription(MathUtil.addBigDecimal(financialStatementShopParentSku.getSellerpaymentsReportFeeSubscription(), financialStatement.getSellerpaymentsReportFeeSubscription()));
            financialStatementShopParentSku.setLightningDealFee(MathUtil.addBigDecimal(financialStatementShopParentSku.getLightningDealFee(), financialStatement.getLightningDealFee()));
            financialStatementShopParentSku.setCostOfAdvertising(MathUtil.addBigDecimal(financialStatementShopParentSku.getCostOfAdvertising(), financialStatement.getCostOfAdvertising()));
            financialStatementShopParentSku.setFbaInventoryReimbursementCustomerReturn(MathUtil.addBigDecimal(financialStatementShopParentSku.getFbaInventoryReimbursementCustomerReturn(), financialStatement.getFbaInventoryReimbursementCustomerReturn()));
            financialStatementShopParentSku.setFbaInventoryReimbursementDamagedWarehouse(MathUtil.addBigDecimal(financialStatementShopParentSku.getFbaInventoryReimbursementDamagedWarehouse(), financialStatement.getFbaInventoryReimbursementDamagedWarehouse()));
            financialStatementShopParentSku.setFbaInventoryReimbursementCustomerServiceIssue(MathUtil.addBigDecimal(financialStatementShopParentSku.getFbaInventoryReimbursementCustomerServiceIssue(), financialStatement.getFbaInventoryReimbursementCustomerServiceIssue()));
            financialStatementShopParentSku.setFbaInventoryReimbursementFeeCorrection(MathUtil.addBigDecimal(financialStatementShopParentSku.getFbaInventoryReimbursementFeeCorrection(), financialStatement.getFbaInventoryReimbursementFeeCorrection()));
            financialStatementShopParentSku.setFbaInventoryReimbursementGeneralAdjustment(MathUtil.addBigDecimal(financialStatementShopParentSku.getFbaInventoryReimbursementGeneralAdjustment(), financialStatement.getFbaInventoryReimbursementGeneralAdjustment()));
            financialStatementShopParentSku.setFbaInventoryReimbursementLostInbound(MathUtil.addBigDecimal(financialStatementShopParentSku.getFbaInventoryReimbursementLostInbound(), financialStatement.getFbaInventoryReimbursementLostInbound()));
            financialStatementShopParentSku.setFbaInventoryReimbursementLostWarehouse(MathUtil.addBigDecimal(financialStatementShopParentSku.getFbaInventoryReimbursementLostWarehouse(), financialStatement.getFbaInventoryReimbursementLostWarehouse()));
            financialStatementShopParentSku.setNonSubscriptionFeeAdjustment(MathUtil.addBigDecimal(financialStatementShopParentSku.getNonSubscriptionFeeAdjustment(), financialStatement.getNonSubscriptionFeeAdjustment()));
            financialStatementShopParentSku.setFbaInventoryPlacementServiceFee(MathUtil.addBigDecimal(financialStatementShopParentSku.getFbaInventoryPlacementServiceFee(), financialStatement.getFbaInventoryPlacementServiceFee()));
            financialStatementShopParentSku.setFbaCustomerReturnPerUnitFee(MathUtil.addBigDecimal(financialStatementShopParentSku.getFbaCustomerReturnPerUnitFee(), financialStatement.getFbaCustomerReturnPerUnitFee()));
            financialStatementShopParentSku.setFbaInventoryStorageFee(MathUtil.addBigDecimal(financialStatementShopParentSku.getFbaInventoryStorageFee(), financialStatement.getFbaInventoryStorageFee()));
            financialStatementShopParentSku.setFbaLongTermStorageFee(MathUtil.addBigDecimal(financialStatementShopParentSku.getFbaLongTermStorageFee(), financialStatement.getFbaLongTermStorageFee()));
            financialStatementShopParentSku.setFbaRemovalOrderDisposalFee(MathUtil.addBigDecimal(financialStatementShopParentSku.getFbaRemovalOrderDisposalFee(), financialStatement.getFbaRemovalOrderDisposalFee()));
            financialStatementShopParentSku.setCouponRedemptionFee(MathUtil.addBigDecimal(financialStatementShopParentSku.getCouponRedemptionFee(), financialStatement.getCouponRedemptionFee()));
            financialStatementShopParentSku.setEarlyReviewerProgramFee(MathUtil.addBigDecimal(financialStatementShopParentSku.getEarlyReviewerProgramFee(), financialStatement.getEarlyReviewerProgramFee()));
            financialStatementShopParentSku.setMoneyBack(MathUtil.addBigDecimal(financialStatementShopParentSku.getMoneyBack(), financialStatement.getMoneyBack()));

            financialStatementShopParentSku.setMainBusinessIncome(MathUtil.addBigDecimal(financialStatementShopParentSku.getMainBusinessIncome(), financialStatement.getMainBusinessIncome()));
            financialStatementShopParentSku.setTotalEffectiveReceipts(MathUtil.addBigDecimal(financialStatementShopParentSku.getTotalEffectiveReceipts(), financialStatement.getTotalEffectiveReceipts()));
            financialStatementShopParentSku.setSellableRequestedQuantity(MathUtil.addInteger(financialStatementShopParentSku.getSellableRequestedQuantity(), financialStatement.getSellableRequestedQuantity()));
            financialStatementShopParentSku.setSellableCost(MathUtil.addBigDecimal(financialStatementShopParentSku.getSellableCost(), financialStatement.getSellableCost()));
            financialStatementShopParentSku.setUnsellableRequestedQuantity(MathUtil.addInteger(financialStatementShopParentSku.getUnsellableRequestedQuantity(), financialStatement.getUnsellableRequestedQuantity()));
            financialStatementShopParentSku.setUnsellableCost(MathUtil.addBigDecimal(financialStatementShopParentSku.getUnsellableCost(), financialStatement.getUnsellableCost()));
            financialStatementShopParentSku.setProcurementCost(MathUtil.addBigDecimal(financialStatementShopParentSku.getProcurementCost(), financialStatement.getProcurementCost()));
            financialStatementShopParentSku.setFbaHeadTripCost(MathUtil.addBigDecimal(financialStatementShopParentSku.getFbaHeadTripCost(), financialStatement.getFbaHeadTripCost()));
            financialStatementShopParentSku.setHeadDeductionFee(MathUtil.addBigDecimal(financialStatementShopParentSku.getHeadDeductionFee(), financialStatement.getHeadDeductionFee()));
            financialStatementShopParentSku.setMainBusinessProfit(MathUtil.addBigDecimal(financialStatementShopParentSku.getMainBusinessProfit(), financialStatement.getMainBusinessProfit()));

            financialStatementShopParentSku.setInitialQuantity(MathUtil.addInteger(financialStatementShopParentSku.getInitialQuantity(), financialStatement.getInitialQuantity()));
            financialStatementShopParentSku.setInitialInventoryCost(MathUtil.addBigDecimal(financialStatementShopParentSku.getInitialInventoryCost(), financialStatement.getInitialInventoryCost()));
            financialStatementShopParentSku.setFinalQuantity(MathUtil.addInteger(financialStatementShopParentSku.getFinalQuantity(), financialStatement.getFinalQuantity()));
            financialStatementShopParentSku.setFinalInventoryCost(MathUtil.addBigDecimal(financialStatementShopParentSku.getFinalInventoryCost(), financialStatement.getFinalInventoryCost()));
            financialStatementShopParentSku.setManualAdjustment(MathUtil.addBigDecimal(financialStatementShopParentSku.getManualAdjustment(), financialStatement.getManualAdjustment()));
        }
        List<FinancialStatement> financialStatementShopParentSkuList = new ArrayList<>();
        for (Map.Entry<String, FinancialStatement> map : financialStatementMap.entrySet()) {
            FinancialStatement financialStatement = map.getValue();
            if (financialStatement.getProductSales().compareTo(BigDecimal.ZERO) != 0) {
                BigDecimal moneyBackRate = financialStatement.getMoneyBack().divide(financialStatement.getProductSales(), 4, BigDecimal.ROUND_HALF_UP);
                financialStatement.setMoneyBackRate(moneyBackRate);
            } else {
                financialStatement.setMoneyBackRate(BigDecimal.ZERO);
            }
            if (financialStatement.getProductSales().compareTo(BigDecimal.ZERO) != 0) {
                BigDecimal grossMarginOnSales = financialStatement.getMainBusinessProfit().divide(financialStatement.getProductSales().multiply(FinanceConstant.RATE_OF_DOLLAR_EXCHANGE_RMB), 4, BigDecimal.ROUND_HALF_UP);
                financialStatement.setGrossMarginOnSales(grossMarginOnSales);
            } else {
                financialStatement.setGrossMarginOnSales(BigDecimal.ZERO);
            }
            BigDecimal cost = BigDecimal.ZERO.add(financialStatement.getProcurementCost()).add(financialStatement.getFbaHeadTripCost());
            if (cost.compareTo(BigDecimal.ZERO) != 0) {
                BigDecimal roi = financialStatement.getMainBusinessProfit().divide(cost, 2, BigDecimal.ROUND_HALF_UP);
                financialStatement.setRoi(roi);
                BigDecimal inventoryTurnover = financialStatement.getInitialInventoryCost()
                        .add(financialStatement.getFinalInventoryCost())
                        .divide(new BigDecimal(2))
                        .multiply(new BigDecimal(31))
                        .divide(cost, 2, BigDecimal.ROUND_HALF_UP);
                financialStatement.setInventoryTurnover(inventoryTurnover);
            } else {
                financialStatement.setRoi(BigDecimal.ZERO);
                financialStatement.setInventoryTurnover(BigDecimal.ZERO);
            }
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
            if (financialStatement.getCostOfAdvertising().compareTo(BigDecimal.ZERO) == 0) {
                financialStatement.setAdvertisingSalesPercentage(BigDecimal.ZERO);
            } else {
                if (BigDecimal.ZERO.compareTo(financialStatement.getProductSales()) == 0) {
                    financialStatement.setAdvertisingSalesPercentage(new BigDecimal(10000));
                } else {
                    BigDecimal advertisingSalesPercentage = MathUtil.divide(financialStatement.getCostOfAdvertising().multiply(new BigDecimal(-1)), financialStatement.getProductSales(), 4);
                    if (advertisingSalesPercentage != null) {
                        financialStatement.setAdvertisingSalesPercentage(advertisingSalesPercentage);
                    } else {
                        financialStatement.setAdvertisingSalesPercentage(BigDecimal.ZERO);
                    }
                }
            }
            financialStatementShopParentSkuList.add(financialStatement);
        }
        Collections.sort(financialStatementShopParentSkuList, new Comparator<FinancialStatement>() {
            @Override
            public int compare(FinancialStatement o1, FinancialStatement o2) {
                if (o1.getShopParentSku() == null) {
                    return 1;
                }
                if (o2.getShopParentSku() == null) {
                    return -1;
                }
                return o1.getShopParentSku().compareTo(o2.getShopParentSku());
            }
        });
        return financialStatementShopParentSkuList;
    }

    private void setFinancialStatement(Sheet sheet, List<FinancialStatement> financialStatementList) {
        int rowIndex = 6;
        for (int i = 0; i < financialStatementList.size(); i++) {
            FinancialStatement financialStatement = financialStatementList.get(i);
            Row row = sheet.createRow(rowIndex);
            row.createCell(7).setCellValue(i + 1);
            row.createCell(0).setCellValue(financialStatement.getShopName());
            row.createCell(1).setCellValue(financialStatement.getDeveloperUserName());
            row.createCell(2).setCellValue(financialStatement.getSalesmanUserName());
            row.createCell(3).setCellValue(financialStatement.getShopParentSku());
            row.createCell(4).setCellValue(financialStatement.getSku());
            row.createCell(5).setCellValue(financialStatement.getShopSku());
            row.createCell(6).setCellValue(financialStatement.getProductCode());
            row.createCell(9).setCellValue(financialStatement.getSaleQuantity().doubleValue());
            row.createCell(10).setCellValue(financialStatement.getProductSales().doubleValue());
            row.createCell(11).setCellValue(financialStatement.getProductSalesTax().doubleValue());
            row.createCell(12).setCellValue(financialStatement.getShippingCredits().doubleValue());
            row.createCell(13).setCellValue(financialStatement.getShippingCreditsTax().doubleValue());
            row.createCell(14).setCellValue(financialStatement.getGiftWrapCredits().doubleValue());
            row.createCell(15).setCellValue(financialStatement.getGiftWrapCreditsTax().doubleValue());
            row.createCell(16).setCellValue(financialStatement.getPromotionalRebates().doubleValue());
            row.createCell(17).setCellValue(financialStatement.getPromotionalRebatesTax().doubleValue());
            row.createCell(18).setCellValue(financialStatement.getMarketplaceWithheldTax().doubleValue());
            row.createCell(19).setCellValue(financialStatement.getSellingFees().doubleValue());
            row.createCell(20).setCellValue(financialStatement.getFbaFees().doubleValue());
            row.createCell(21).setCellValue(financialStatement.getOtherTransactionFees().doubleValue());
            row.createCell(22).setCellValue(financialStatement.getOther().doubleValue());
            row.createCell(23).setCellValue(financialStatement.getTotal().doubleValue());
            row.createCell(24).setCellValue(financialStatement.getRefundSaleQuantity().doubleValue());
            row.createCell(25).setCellValue(financialStatement.getRefundProductSales().doubleValue());
            row.createCell(26).setCellValue(financialStatement.getRefundProductSalesTax().doubleValue());
            row.createCell(27).setCellValue(financialStatement.getRefundShippingCredits().doubleValue());
            row.createCell(28).setCellValue(financialStatement.getRefundShippingCreditsTax().doubleValue());
            row.createCell(29).setCellValue(financialStatement.getRefundGiftWrapCredits().doubleValue());
            row.createCell(30).setCellValue(financialStatement.getRefundGiftWrapCreditsTax().doubleValue());
            row.createCell(31).setCellValue(financialStatement.getRefundPromotionalRebates().doubleValue());
            row.createCell(32).setCellValue(financialStatement.getRefundPromotionalRebatesTax().doubleValue());
            row.createCell(33).setCellValue(financialStatement.getRefundMarketplaceWithheldTax().doubleValue());
            row.createCell(34).setCellValue(financialStatement.getRefundSellingFees().doubleValue());
            row.createCell(35).setCellValue(financialStatement.getRefundFbaFees().doubleValue());
            row.createCell(36).setCellValue(financialStatement.getRefundOtherTransactionFees().doubleValue());
            row.createCell(37).setCellValue(financialStatement.getRefundOther().doubleValue());
            row.createCell(38).setCellValue(financialStatement.getRefundTotal().doubleValue());
            row.createCell(41).setCellValue(financialStatement.getSellerpaymentsReportFeeSubscription().doubleValue());
            row.createCell(43).setCellValue(financialStatement.getLightningDealFee().doubleValue());
            row.createCell(44).setCellValue(financialStatement.getCostOfAdvertising().doubleValue());
            row.createCell(45).setCellValue(financialStatement.getFbaInventoryReimbursementCustomerReturn().doubleValue());
            row.createCell(46).setCellValue(financialStatement.getFbaInventoryReimbursementDamagedWarehouse().doubleValue());
            row.createCell(47).setCellValue(financialStatement.getFbaInventoryReimbursementCustomerServiceIssue().doubleValue());
            row.createCell(48).setCellValue(financialStatement.getFbaInventoryReimbursementFeeCorrection().doubleValue());
            row.createCell(49).setCellValue(financialStatement.getFbaInventoryReimbursementGeneralAdjustment().doubleValue());
            row.createCell(50).setCellValue(financialStatement.getFbaInventoryReimbursementLostInbound().doubleValue());
            row.createCell(51).setCellValue(financialStatement.getFbaInventoryReimbursementLostWarehouse().doubleValue());
            row.createCell(52).setCellValue(financialStatement.getNonSubscriptionFeeAdjustment().doubleValue());
            row.createCell(53).setCellValue(financialStatement.getFbaInventoryPlacementServiceFee().doubleValue());
            row.createCell(55).setCellValue(financialStatement.getFbaCustomerReturnPerUnitFee().doubleValue());
            row.createCell(57).setCellValue(financialStatement.getFbaInventoryStorageFee().doubleValue());
            row.createCell(58).setCellValue(financialStatement.getFbaLongTermStorageFee().doubleValue());
            row.createCell(59).setCellValue(financialStatement.getFbaRemovalOrderDisposalFee().doubleValue());
            row.createCell(62).setCellValue(financialStatement.getCouponRedemptionFee().doubleValue());
            row.createCell(63).setCellValue(financialStatement.getEarlyReviewerProgramFee().doubleValue());
            row.createCell(65).setCellValue(financialStatement.getManualAdjustment().doubleValue());
            row.createCell(66).setCellValue(financialStatement.getMoneyBack().doubleValue());
            row.createCell(67).setCellValue(financialStatement.getMoneyBackRate().multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
            row.createCell(68).setCellValue(financialStatement.getMainBusinessIncome().doubleValue());
            row.createCell(77).setCellValue(financialStatement.getTotalEffectiveReceipts().doubleValue());
            row.createCell(78).setCellValue(financialStatement.getSellableRequestedQuantity().doubleValue());
            row.createCell(79).setCellValue(financialStatement.getSellableCost().doubleValue());
            row.createCell(80).setCellValue(financialStatement.getUnsellableRequestedQuantity().doubleValue());
            row.createCell(81).setCellValue(financialStatement.getUnsellableCost().doubleValue());
            row.createCell(83).setCellValue(financialStatement.getProcurementCost().doubleValue());
            row.createCell(84).setCellValue(financialStatement.getFbaHeadTripCost().doubleValue());
            row.createCell(85).setCellValue(financialStatement.getHeadDeductionFee().doubleValue());
            row.createCell(90).setCellValue(financialStatement.getMainBusinessProfit().doubleValue());
            row.createCell(91).setCellValue(financialStatement.getGrossMarginOnSales().multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
            row.createCell(92).setCellValue(financialStatement.getRoi().doubleValue());
            row.createCell(100).setCellValue(financialStatement.getInitialQuantity());
            row.createCell(101).setCellValue(financialStatement.getInitialInventoryCost().doubleValue());
            row.createCell(102).setCellValue(financialStatement.getFinalQuantity());
            row.createCell(103).setCellValue(financialStatement.getFinalInventoryCost().doubleValue());
            row.createCell(104).setCellValue(financialStatement.getInventoryTurnover().doubleValue());
            row.createCell(105).setCellValue(financialStatement.getRefundRate().multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
            row.createCell(106).setCellValue(financialStatement.getNewProduct() == 1 ? "是" : "否");
            row.createCell(107).setCellValue(financialStatement.getAdvertisingSalesPercentage().multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
            row.createCell(108).setCellValue(financialStatement.getProductMonth());
            rowIndex++;
        }
    }

    private void setExcelTitle(Sheet sheet, String month, String shopName) {
        Row row = sheet.getRow(0);
        row.getCell(0).setCellValue(month + "-" + shopName + "各SKU利润表");
    }

    private void setSellerpaymentsReportFeeSubscription(List<FinancialStatementResponse> financialStatementResponseList) {
        if (CollectionUtils.isEmpty(financialStatementResponseList)) {
            return;
        }
        FinancialStatementResponse financialStatementResponseMax = financialStatementResponseList.get(0);
        for (FinancialStatementResponse financialStatementResponse :
                financialStatementResponseList) {
            financialStatementResponse.setSellerpaymentsReportFeeSubscription(BigDecimal.ZERO);
            if (financialStatementResponse.getProductSales().compareTo(financialStatementResponseMax.getProductSales()) > 0) {
                financialStatementResponseMax = financialStatementResponse;
            }
        }
        financialStatementResponseMax.setSellerpaymentsReportFeeSubscription(FinanceConstant.SELLERPAYMENTS_REPORT_FEE_SUBSCRIPTION);
    }
}
