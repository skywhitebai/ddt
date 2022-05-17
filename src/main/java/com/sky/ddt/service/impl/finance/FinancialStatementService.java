package com.sky.ddt.service.impl.finance;

import com.sky.ddt.common.constant.FinanceConstant;
import com.sky.ddt.common.constant.FinancialStatementConstant;
import com.sky.ddt.common.login.CurrentUserInfo;
import com.sky.ddt.dao.custom.*;
import com.sky.ddt.dto.finance.response.FbaCustomerReturnFeeResponse;
import com.sky.ddt.dto.finance.response.FbaCustomerReturnSkuResponse;
import com.sky.ddt.dto.finance.response.FinancialStatementExport;
import com.sky.ddt.dto.finance.response.FinancialStatementResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.*;
import com.sky.ddt.entity.Currency;
import com.sky.ddt.service.IShopService;
import com.sky.ddt.service.finance.IFinanceService;
import com.sky.ddt.service.finance.IFinanceStatisticService;
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
import java.net.URLEncoder;
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
    @Autowired
    CustomSkuMapper customSkuMapper;
    @Autowired
    IFinanceStatisticService financeStatisticService;
    @Autowired
    IShopService shopService;
    @Autowired
    CustomSalesGroupUserMapper customSalesGroupUserMapper;

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
        Finance finance = financeService.getFinance(financeId);
        if (finance == null) {
            return BaseResponse.failMessage(FinanceConstant.ID_NOT_EXIST);
        }
        if (FinanceConstant.FinanceStatusEnum.LOCKED.getStatus().equals(finance.getStatus())) {
            return BaseResponse.failMessage(FinanceConstant.NOT_ALLOW_CREATE_FINANCIAL_STATEMENT);
        }
        //获取汇率
        Currency currency = getCurrency(finance.getShopId());
        if (currency == null) {
            return BaseResponse.failMessage("店铺汇率不能为空");
        }
        //获取
        List<FinancialStatementResponse> financialStatementResponseList = customFinancialStatementMapper.getFinancialStatementResponse(financeId);
        if (CollectionUtils.isEmpty(financialStatementResponseList)) {
            return BaseResponse.failMessage(FinanceConstant.GET_FINANCIAL_STATEMENT_RESPONSE_FAIL);
        }
        //设置fba服务费返还 直接从数据库读取
        //setfbaCustomerReturnPerUnitFee(financialStatementResponseList);
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
            moneyBack = moneyBack.add(financialStatementResponse.getDisplayAdvertising());
            moneyBack = moneyBack.add(financialStatementResponse.getBrandAdvertising());
            moneyBack = moneyBack.add(financialStatementResponse.getLiquidations());
            moneyBack = moneyBack.add(financialStatementResponse.getLiquidationsAdjustments());
            moneyBack = moneyBack.add(financialStatementResponse.getTbybOrderPayment());
            moneyBack = moneyBack.add(financialStatementResponse.getTbybTrialShipment());
            financialStatementResponse.setMoneyBack(moneyBack);
            if (financialStatementResponse.getProductSales().compareTo(BigDecimal.ZERO) != 0) {
                BigDecimal moneyBackRate = financialStatementResponse.getMoneyBack().divide(financialStatementResponse.getProductSales(), 4, BigDecimal.ROUND_HALF_UP);
                financialStatementResponse.setMoneyBackRate(moneyBackRate);
            } else {
                financialStatementResponse.setMoneyBackRate(BigDecimal.ZERO);
            }
            financialStatementResponse.setExchangeRate(currency.getExchangeRate());
            financialStatementResponse.setCurrencyCode(currency.getCurrencyCode());
            financialStatementResponse.setCurrencyName(currency.getCurrencyName());
            financialStatementResponse.setMainBusinessIncome(financialStatementResponse.getMoneyBack().multiply(financialStatementResponse.getExchangeRate()));
            financialStatementResponse.setTotalEffectiveReceipts(financialStatementResponse.getMainBusinessIncome());
            BigDecimal mainBusinessProfit = BigDecimal.ZERO.add(financialStatementResponse.getTotalEffectiveReceipts())
                    .subtract(financialStatementResponse.getSellableCost())
                    .subtract(financialStatementResponse.getUnsellableCost())
                    .subtract(financialStatementResponse.getProcurementCost())
                    .subtract(financialStatementResponse.getFbaHeadTripCost())
                    .add(financialStatementResponse.getHeadDeductionFee());
            financialStatementResponse.setMainBusinessProfit(mainBusinessProfit);
            if (financialStatementResponse.getProductSales().compareTo(BigDecimal.ZERO) != 0) {
                BigDecimal grossMarginOnSales = financialStatementResponse.getMainBusinessProfit().divide(financialStatementResponse.getProductSales().multiply(financialStatementResponse.getExchangeRate()), 4, BigDecimal.ROUND_HALF_UP);
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
                        .multiply(new BigDecimal(30))
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
            financialStatementResponse.setSaleCost(MathUtil.addBigDecimal(financialStatementResponse.getProcurementCost(), financialStatementResponse.getFbaHeadTripCost()));
            setAdvertisingSalesPercentage(financialStatementResponse);
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
        //生成回款信息
        BaseResponse createFinanceStatisticResponse = financeStatisticService.createFinanceStatistic(financeId, dealUserId);
        if (createFinanceStatisticResponse.isFail()) {
            return createFinanceStatisticResponse;
        }
        Finance financeUpdate = new Finance();
        financeUpdate.setStatus(FinanceConstant.FinanceStatusEnum.GENERATED.getStatus());
        financeUpdate.setExchangeRate(currency.getExchangeRate());
        financeUpdate.setCurrencyCode(currency.getCurrencyCode());
        financeUpdate.setCurrencyName(currency.getCurrencyName());
        financeUpdate.setId(financeId);
        customFinanceMapper.updateByPrimaryKeySelective(financeUpdate);
        return BaseResponse.success();
    }

    private Currency getCurrency(Integer shopId) {
        return shopService.getCurrency(shopId);
    }

    private void setAdvertisingSalesPercentage(FinancialStatement financialStatementResponse) {
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


    @Override
    public BaseResponse exportFinancialStatementAll(HttpServletResponse response, String month) {
        if (StringUtils.isEmpty(month)) {
            return BaseResponse.failMessage(FinanceConstant.MONTH_EMPTY);
        }
        Date monthDate = DateUtil.strMonthToDate(month);
        if (monthDate == null) {
            return BaseResponse.failMessage("月份格式错误");
        }
        FinancialStatementExample example = new FinancialStatementExample();
        example.createCriteria().andMonthEqualTo(monthDate);
        example.setOrderByClause("shop_name,shop_parent_sku,sku");
        List<FinancialStatement> financialStatementList = customFinancialStatementMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(financialStatementList)) {
            return BaseResponse.failMessage(FinancialStatementConstant.FINANCIAL_STATEMENT_NOT_EXIST);
        }
        FinancialStatement financialStatement = financialStatementList.get(0);
        //读取模板
        String excelTitle = month + "-各SKU利润表";
        Workbook workbook = getWorkbook(financialStatementList, excelTitle);
        String fileName = month + "财务报表";
        return ExcelUtil.exportExcel(response, workbook, fileName);
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
        Workbook workbook = getWorkbook(financialStatementList, excelTitle);
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
        String fileName = getZipName(monthChinese, type, "");
        Map<String, byte[]> byteMap = workBook2Byte(workbookMap, fileName);
        ZipUtil.downloadBatchByFile(response, byteMap, fileName);
        return BaseResponse.success();
    }

    /**
     * @param response
     * @param month
     * @param type            @return
     * @param currentUserInfo
     * @description 导出制定月份财务数据
     * @author baixueping
     * @date 2020/12/15 14:42
     */
    @Override
    public BaseResponse exportCurrentUserFinancialStatement(HttpServletResponse response, String month, String type, CurrentUserInfo currentUserInfo) {
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
        FinancialStatementExample.Criteria criteria = example.createCriteria().andFinanceIdIn(checkFinancialStatusResponse.getData());
        example.setOrderByClause("shop_parent_sku,sku");
        if (type.equals("developer")) {
            criteria.andDeveloperUserIdEqualTo(currentUserInfo.getUserId());
        } else if (type.equals("salesman")) {
            criteria.andSalesmanUserIdEqualTo(currentUserInfo.getUserId());
        } else if (type.equals(FinanceConstant.FinanceExprotType.SALESGROUP.getType())) {
            List<Integer> userIdList = customSalesGroupUserMapper.selectSelesGroupUserIdbyUserId(currentUserInfo.getUserId());
            if (CollectionUtils.isEmpty(userIdList)) {
                return BaseResponse.failMessage("用户没有分组");
            }
            criteria.andSalesmanUserIdIn(userIdList);
        }
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
        Workbook workbook = null;
        for (String key : workbookMap.keySet()) {
            workbook = workbookMap.get(key);

        }
        String fileName = getZipName(monthChinese, type, currentUserInfo.getRealName());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            workbook.write(outputStream);
            ByteArrayInputStream tempIn = new ByteArrayInputStream(outputStream.toByteArray());
            response.setHeader("Content-Length", String.valueOf(tempIn.available()));
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + DateUtil.getFormatStryyyyMMddHHmmss(new Date()) + ".xlsx");//默认Excel名称
            OutputStream out = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int a;
            while ((a = tempIn.read(buffer)) != -1) {
                out.write(buffer, 0, a);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return BaseResponse.success();
    }

    private Map<String, byte[]> workBook2Byte(Map<String, Workbook> workbookMap, String fileName) {
        Map<String, byte[]> map = new HashMap<>();
        String excelNameLast = "-" + DateUtil.getFormatStryyyyMMddHHmmss(new Date()) + ".xlsx";
        for (String key : workbookMap.keySet()) {
            Workbook workbook = workbookMap.get(key);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try {
                workbook.write(outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] bytes = outputStream.toByteArray();
            String excelName = fileName + "-" + (StringUtils.isEmpty(key) ? "null" : key) + excelNameLast;
            map.put(excelName, bytes);
        }
        return map;
    }

    private String getZipName(String monthChinese, String type, String realName) {
        String name = "";
        if ("developer".equals(type)) {
            name = "开发人员";
        } else if ("salesman".equals(type)) {
            name = "销售人员";
        } else if (FinanceConstant.FinanceExprotType.SALESGROUP.getType().equals(type)) {
            name = "销售分组";
        } else {
            return "类型错误";
        }
        if (!StringUtils.isEmpty(realName)) {
            name = name + "-" + realName;
        }
        name = name + "-" + monthChinese + "财务报表";
        return name;
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
        List<FinancialStatementExport> financialStatementExportList = FinancialStatementConstant.convertToFinancialStatementExportList(financialStatementList);
        //回收掉，避免浪费内存
        financialStatementList = null;
        setExcelTitle(sheet, excelTitle);
        setCurrency(sheet, financialStatementExportList);
        setFinancialStatement(sheet, financialStatementExportList);
        setFinancialCountInfo(sheet, financialStatementExportList, excelTitle);
        Sheet sheetShopParentSku = wb.getSheetAt(1);
        setExcelTitle(sheetShopParentSku, excelTitle);
        setFinancialStatementShopParentSku(sheetShopParentSku, financialStatementExportList);
        return wb;
    }

    private void setCurrency(Sheet sheet, List<FinancialStatementExport> financialStatementList) {
        if (CollectionUtils.isEmpty(financialStatementList)) {
            return;
        }
        Row row2 = sheet.getRow(2);
        String currencyName = financialStatementList.get(0).getCurrencyName();
        if (!StringUtils.isEmpty(currencyName)) {
            String cellValue = ExcelUtil.getCellFormatValueString(row2.getCell(0));
            row2.getCell(0).setCellValue(cellValue.replace("美元", currencyName));
        }
        Row row = sheet.getRow(3);
        String currencyCode = financialStatementList.get(0).getCurrencyCode();
        if (!StringUtils.isEmpty(currencyCode)) {
            for (int i = 0; i < row.getLastCellNum(); i++) {
                String cellValue = ExcelUtil.getCellFormatValueString(row.getCell(i));
                if (cellValue.contains("单位:USD")) {
                    row.getCell(i).setCellValue(cellValue.replace("USD", currencyCode));
                }
            }
        }

    }

    private void setFinancialCountInfo(Sheet sheet, List<FinancialStatementExport> financialStatementList, String excelTitle) {
        FinancialStatementExport financialStatementCount = new FinancialStatementExport();
        BigDecimal rateOfDollarExchangeRmb = BigDecimal.ZERO;
        if (!CollectionUtils.isEmpty(financialStatementList)) {
            if (financialStatementList.get(0).getExchangeRate() != null) {
                rateOfDollarExchangeRmb = financialStatementList.get(0).getExchangeRate();
            }
        }
        financialStatementCount.setExchangeRate(rateOfDollarExchangeRmb);
        for (FinancialStatementExport financialStatement :
                financialStatementList) {
            financialStatementCount.setSaleQuantity(MathUtil.add(financialStatementCount.getSaleQuantity(), financialStatement.getSaleQuantity()));
            financialStatementCount.setProductSales(MathUtil.addBigDecimal(financialStatementCount.getProductSales(), financialStatement.getProductSales()));
            financialStatementCount.setProductSalesTax(MathUtil.addBigDecimal(financialStatementCount.getProductSalesTax(), financialStatement.getProductSalesTax()));
            financialStatementCount.setShippingCredits(MathUtil.addBigDecimal(financialStatementCount.getShippingCredits(), financialStatement.getShippingCredits()));
            financialStatementCount.setShippingCreditsTax(MathUtil.addBigDecimal(financialStatementCount.getShippingCreditsTax(), financialStatement.getShippingCreditsTax()));
            financialStatementCount.setGiftWrapCredits(MathUtil.addBigDecimal(financialStatementCount.getGiftWrapCredits(), financialStatement.getGiftWrapCredits()));
            financialStatementCount.setGiftWrapCreditsTax(MathUtil.addBigDecimal(financialStatementCount.getGiftWrapCreditsTax(), financialStatement.getGiftWrapCreditsTax()));
            financialStatementCount.setPromotionalRebates(MathUtil.addBigDecimal(financialStatementCount.getPromotionalRebates(), financialStatement.getPromotionalRebates()));
            financialStatementCount.setPromotionalRebatesTax(MathUtil.addBigDecimal(financialStatementCount.getPromotionalRebatesTax(), financialStatement.getPromotionalRebatesTax()));
            financialStatementCount.setMarketplaceWithheldTax(MathUtil.addBigDecimal(financialStatementCount.getMarketplaceWithheldTax(), financialStatement.getMarketplaceWithheldTax()));
            financialStatementCount.setSellingFees(MathUtil.addBigDecimal(financialStatementCount.getSellingFees(), financialStatement.getSellingFees()));
            financialStatementCount.setFbaFees(MathUtil.addBigDecimal(financialStatementCount.getFbaFees(), financialStatement.getFbaFees()));
            financialStatementCount.setOtherTransactionFees(MathUtil.addBigDecimal(financialStatementCount.getOtherTransactionFees(), financialStatement.getOtherTransactionFees()));
            financialStatementCount.setOther(MathUtil.addBigDecimal(financialStatementCount.getOther(), financialStatement.getOther()));
            financialStatementCount.setTotal(MathUtil.addBigDecimal(financialStatementCount.getTotal(), financialStatement.getTotal()));
            financialStatementCount.setRefundSaleQuantity(MathUtil.add(financialStatementCount.getRefundSaleQuantity(), financialStatement.getRefundSaleQuantity()));
            financialStatementCount.setRefundProductSales(MathUtil.addBigDecimal(financialStatementCount.getRefundProductSales(), financialStatement.getRefundProductSales()));
            financialStatementCount.setRefundProductSalesTax(MathUtil.addBigDecimal(financialStatementCount.getRefundProductSalesTax(), financialStatement.getRefundProductSalesTax()));
            financialStatementCount.setRefundShippingCredits(MathUtil.addBigDecimal(financialStatementCount.getRefundShippingCredits(), financialStatement.getRefundShippingCredits()));
            financialStatementCount.setRefundShippingCreditsTax(MathUtil.addBigDecimal(financialStatementCount.getRefundShippingCreditsTax(), financialStatement.getRefundShippingCreditsTax()));
            financialStatementCount.setRefundGiftWrapCredits(MathUtil.addBigDecimal(financialStatementCount.getRefundGiftWrapCredits(), financialStatement.getRefundGiftWrapCredits()));
            financialStatementCount.setRefundGiftWrapCreditsTax(MathUtil.addBigDecimal(financialStatementCount.getRefundGiftWrapCreditsTax(), financialStatement.getRefundGiftWrapCreditsTax()));
            financialStatementCount.setRefundPromotionalRebates(MathUtil.addBigDecimal(financialStatementCount.getRefundPromotionalRebates(), financialStatement.getRefundPromotionalRebates()));
            financialStatementCount.setRefundPromotionalRebatesTax(MathUtil.addBigDecimal(financialStatementCount.getRefundPromotionalRebatesTax(), financialStatement.getRefundPromotionalRebatesTax()));
            financialStatementCount.setRefundMarketplaceWithheldTax(MathUtil.addBigDecimal(financialStatementCount.getRefundMarketplaceWithheldTax(), financialStatement.getRefundMarketplaceWithheldTax()));
            financialStatementCount.setRefundSellingFees(MathUtil.addBigDecimal(financialStatementCount.getRefundSellingFees(), financialStatement.getRefundSellingFees()));
            financialStatementCount.setRefundFbaFees(MathUtil.addBigDecimal(financialStatementCount.getRefundFbaFees(), financialStatement.getRefundFbaFees()));
            financialStatementCount.setRefundOtherTransactionFees(MathUtil.addBigDecimal(financialStatementCount.getRefundOtherTransactionFees(), financialStatement.getRefundOtherTransactionFees()));
            financialStatementCount.setRefundOther(MathUtil.addBigDecimal(financialStatementCount.getRefundOther(), financialStatement.getRefundOther()));
            financialStatementCount.setRefundTotal(MathUtil.addBigDecimal(financialStatementCount.getRefundTotal(), financialStatement.getRefundTotal()));
            financialStatementCount.setSellerpaymentsReportFeeSubscription(MathUtil.addBigDecimal(financialStatementCount.getSellerpaymentsReportFeeSubscription(), financialStatement.getSellerpaymentsReportFeeSubscription()));
            financialStatementCount.setLightningDealFee(MathUtil.addBigDecimal(financialStatementCount.getLightningDealFee(), financialStatement.getLightningDealFee()));
            financialStatementCount.setCostOfAdvertising(MathUtil.addBigDecimal(financialStatementCount.getCostOfAdvertising(), financialStatement.getCostOfAdvertising()));
            financialStatementCount.setFbaInventoryReimbursementCustomerReturn(MathUtil.addBigDecimal(financialStatementCount.getFbaInventoryReimbursementCustomerReturn(), financialStatement.getFbaInventoryReimbursementCustomerReturn()));
            financialStatementCount.setFbaInventoryReimbursementDamagedWarehouse(MathUtil.addBigDecimal(financialStatementCount.getFbaInventoryReimbursementDamagedWarehouse(), financialStatement.getFbaInventoryReimbursementDamagedWarehouse()));
            financialStatementCount.setFbaInventoryReimbursementCustomerServiceIssue(MathUtil.addBigDecimal(financialStatementCount.getFbaInventoryReimbursementCustomerServiceIssue(), financialStatement.getFbaInventoryReimbursementCustomerServiceIssue()));
            financialStatementCount.setFbaInventoryReimbursementFeeCorrection(MathUtil.addBigDecimal(financialStatementCount.getFbaInventoryReimbursementFeeCorrection(), financialStatement.getFbaInventoryReimbursementFeeCorrection()));
            financialStatementCount.setFbaInventoryReimbursementGeneralAdjustment(MathUtil.addBigDecimal(financialStatementCount.getFbaInventoryReimbursementGeneralAdjustment(), financialStatement.getFbaInventoryReimbursementGeneralAdjustment()));
            financialStatementCount.setFbaInventoryReimbursementLostInbound(MathUtil.addBigDecimal(financialStatementCount.getFbaInventoryReimbursementLostInbound(), financialStatement.getFbaInventoryReimbursementLostInbound()));
            financialStatementCount.setFbaInventoryReimbursementLostWarehouse(MathUtil.addBigDecimal(financialStatementCount.getFbaInventoryReimbursementLostWarehouse(), financialStatement.getFbaInventoryReimbursementLostWarehouse()));
            financialStatementCount.setNonSubscriptionFeeAdjustment(MathUtil.addBigDecimal(financialStatementCount.getNonSubscriptionFeeAdjustment(), financialStatement.getNonSubscriptionFeeAdjustment()));
            financialStatementCount.setFbaInventoryPlacementServiceFee(MathUtil.addBigDecimal(financialStatementCount.getFbaInventoryPlacementServiceFee(), financialStatement.getFbaInventoryPlacementServiceFee()));
            financialStatementCount.setFbaCustomerReturnPerUnitFee(MathUtil.addBigDecimal(financialStatementCount.getFbaCustomerReturnPerUnitFee(), financialStatement.getFbaCustomerReturnPerUnitFee()));
            financialStatementCount.setFbaInventoryStorageFee(MathUtil.addBigDecimal(financialStatementCount.getFbaInventoryStorageFee(), financialStatement.getFbaInventoryStorageFee()));
            financialStatementCount.setFbaLongTermStorageFee(MathUtil.addBigDecimal(financialStatementCount.getFbaLongTermStorageFee(), financialStatement.getFbaLongTermStorageFee()));
            financialStatementCount.setFbaRemovalOrderDisposalFee(MathUtil.addBigDecimal(financialStatementCount.getFbaRemovalOrderDisposalFee(), financialStatement.getFbaRemovalOrderDisposalFee()));
            financialStatementCount.setCouponRedemptionFee(MathUtil.addBigDecimal(financialStatementCount.getCouponRedemptionFee(), financialStatement.getCouponRedemptionFee()));
            financialStatementCount.setEarlyReviewerProgramFee(MathUtil.addBigDecimal(financialStatementCount.getEarlyReviewerProgramFee(), financialStatement.getEarlyReviewerProgramFee()));
            financialStatementCount.setMoneyBack(MathUtil.addBigDecimal(financialStatementCount.getMoneyBack(), financialStatement.getMoneyBack()));
            financialStatementCount.setMainBusinessIncome(MathUtil.addBigDecimal(financialStatementCount.getMainBusinessIncome(), financialStatement.getMainBusinessIncome()));
            financialStatementCount.setTotalEffectiveReceipts(MathUtil.addBigDecimal(financialStatementCount.getTotalEffectiveReceipts(), financialStatement.getTotalEffectiveReceipts()));
            financialStatementCount.setSellableRequestedQuantity(MathUtil.add(financialStatementCount.getSellableRequestedQuantity(), financialStatement.getSellableRequestedQuantity()));
            financialStatementCount.setSellableCost(MathUtil.addBigDecimal(financialStatementCount.getSellableCost(), financialStatement.getSellableCost()));
            financialStatementCount.setUnsellableRequestedQuantity(MathUtil.add(financialStatementCount.getUnsellableRequestedQuantity(), financialStatement.getUnsellableRequestedQuantity()));
            financialStatementCount.setUnsellableCost(MathUtil.addBigDecimal(financialStatementCount.getUnsellableCost(), financialStatement.getUnsellableCost()));
            financialStatementCount.setProcurementCost(MathUtil.addBigDecimal(financialStatementCount.getProcurementCost(), financialStatement.getProcurementCost()));
            financialStatementCount.setFbaHeadTripCost(MathUtil.addBigDecimal(financialStatementCount.getFbaHeadTripCost(), financialStatement.getFbaHeadTripCost()));
            financialStatementCount.setHeadDeductionFee(MathUtil.addBigDecimal(financialStatementCount.getHeadDeductionFee(), financialStatement.getHeadDeductionFee()));
            financialStatementCount.setMainBusinessProfit(MathUtil.addBigDecimal(financialStatementCount.getMainBusinessProfit(), financialStatement.getMainBusinessProfit()));
            financialStatementCount.setInitialQuantity(MathUtil.add(financialStatementCount.getInitialQuantity(), financialStatement.getInitialQuantity()));
            financialStatementCount.setInitialInventoryCost(MathUtil.addBigDecimal(financialStatementCount.getInitialInventoryCost(), financialStatement.getInitialInventoryCost()));
            financialStatementCount.setFinalQuantity(MathUtil.add(financialStatementCount.getFinalQuantity(), financialStatement.getFinalQuantity()));
            financialStatementCount.setFinalInventoryCost(MathUtil.addBigDecimal(financialStatementCount.getFinalInventoryCost(), financialStatement.getFinalInventoryCost()));
            financialStatementCount.setManualAdjustment(MathUtil.addBigDecimal(financialStatementCount.getManualAdjustment(), financialStatement.getManualAdjustment()));
            financialStatementCount.setDisplayAdvertising(MathUtil.addBigDecimal(financialStatementCount.getDisplayAdvertising(), financialStatement.getDisplayAdvertising()));
            financialStatementCount.setBrandAdvertising(MathUtil.addBigDecimal(financialStatementCount.getBrandAdvertising(), financialStatement.getBrandAdvertising()));
            financialStatementCount.setLiquidations(MathUtil.addBigDecimal(financialStatementCount.getLiquidations(), financialStatement.getLiquidations()));
            financialStatementCount.setLiquidationsAdjustments(MathUtil.addBigDecimal(financialStatementCount.getLiquidationsAdjustments(), financialStatement.getLiquidationsAdjustments()));
            financialStatementCount.setTbybOrderPayment(MathUtil.addBigDecimal(financialStatementCount.getTbybOrderPayment(), financialStatement.getTbybOrderPayment()));
            financialStatementCount.setTbybTrialShipment(MathUtil.addBigDecimal(financialStatementCount.getTbybTrialShipment(), financialStatement.getTbybTrialShipment()));
            financialStatementCount.setAdvertisingIncome(MathUtil.addBigDecimal(financialStatementCount.getAdvertisingIncome(), financialStatement.getAdvertisingIncome()));
            financialStatementCount.setDisplayAdvertisingIncome(MathUtil.addBigDecimal(financialStatementCount.getDisplayAdvertisingIncome(), financialStatement.getDisplayAdvertisingIncome()));
            financialStatementCount.setBrandAdvertisingIncome(MathUtil.addBigDecimal(financialStatementCount.getBrandAdvertisingIncome(), financialStatement.getBrandAdvertisingIncome()));
            financialStatementCount.setNewProductSellingFees(MathUtil.addBigDecimal(financialStatementCount.getNewProductSellingFees(), financialStatement.getNewProductSellingFees()));
            financialStatementCount.setOldProductSellingFees(MathUtil.addBigDecimal(financialStatementCount.getOldProductSellingFees(), financialStatement.getOldProductSellingFees()));
            financialStatementCount.setNewProductMainBusinessProfit(MathUtil.addBigDecimal(financialStatementCount.getNewProductMainBusinessProfit(), financialStatement.getNewProductMainBusinessProfit()));
            financialStatementCount.setOldProductMainBusinessProfit(MathUtil.addBigDecimal(financialStatementCount.getOldProductMainBusinessProfit(), financialStatement.getOldProductMainBusinessProfit()));
            financialStatementCount.setAverageInventoryCost(MathUtil.addBigDecimal(financialStatementCount.getAverageInventoryCost(), financialStatement.getAverageInventoryCost()));
            financialStatementCount.setSaleCost(MathUtil.addBigDecimal(financialStatementCount.getSaleCost(), financialStatement.getSaleCost()));
            financialStatementCount.setSendCost(MathUtil.addBigDecimal(financialStatementCount.getSendCost(), financialStatement.getSendCost()));
            financialStatementCount.setSendCostPrice(MathUtil.addBigDecimal(financialStatementCount.getSendCostPrice(), financialStatement.getSendCostPrice()));
            financialStatementCount.setSendHeadTripCost(MathUtil.addBigDecimal(financialStatementCount.getSendHeadTripCost(), financialStatement.getSendHeadTripCost()));
        }
        setMoneyBackRate(financialStatementCount);
        setGrossMarginOnSales(financialStatementCount);
        setRoiAndInventoryTurnover(financialStatementCount);
        setRefundRate(financialStatementCount);
        setAdvertisingSalesPercentage(financialStatementCount);
        FinancialStatementConstant.setFinancialStatementCount(financialStatementCount);
        int rowIndex = sheet.getLastRowNum() + 2;
        Row row = sheet.createRow(rowIndex);
        row.createCell(6).setCellValue(excelTitle);
        row.createCell(7).setCellValue("汇总");
        row.createCell(9).setCellValue(financialStatementCount.getSaleQuantity().doubleValue());
        row.createCell(10).setCellValue(financialStatementCount.getProductSales().doubleValue());
        row.createCell(11).setCellValue(financialStatementCount.getProductSalesTax().doubleValue());
        row.createCell(12).setCellValue(financialStatementCount.getShippingCredits().doubleValue());
        row.createCell(13).setCellValue(financialStatementCount.getShippingCreditsTax().doubleValue());
        row.createCell(14).setCellValue(financialStatementCount.getGiftWrapCredits().doubleValue());
        row.createCell(15).setCellValue(financialStatementCount.getGiftWrapCreditsTax().doubleValue());
        row.createCell(16).setCellValue(financialStatementCount.getPromotionalRebates().doubleValue());
        row.createCell(17).setCellValue(financialStatementCount.getPromotionalRebatesTax().doubleValue());
        row.createCell(18).setCellValue(financialStatementCount.getMarketplaceWithheldTax().doubleValue());
        row.createCell(19).setCellValue(financialStatementCount.getSellingFees().doubleValue());
        row.createCell(20).setCellValue(financialStatementCount.getFbaFees().doubleValue());
        row.createCell(21).setCellValue(financialStatementCount.getOtherTransactionFees().doubleValue());
        row.createCell(22).setCellValue(financialStatementCount.getOther().doubleValue());
        row.createCell(23).setCellValue(financialStatementCount.getTotal().doubleValue());
        row.createCell(24).setCellValue(financialStatementCount.getRefundSaleQuantity().doubleValue());
        row.createCell(25).setCellValue(financialStatementCount.getRefundProductSales().doubleValue());
        row.createCell(26).setCellValue(financialStatementCount.getRefundProductSalesTax().doubleValue());
        row.createCell(27).setCellValue(financialStatementCount.getRefundShippingCredits().doubleValue());
        row.createCell(28).setCellValue(financialStatementCount.getRefundShippingCreditsTax().doubleValue());
        row.createCell(29).setCellValue(financialStatementCount.getRefundGiftWrapCredits().doubleValue());
        row.createCell(30).setCellValue(financialStatementCount.getRefundGiftWrapCreditsTax().doubleValue());
        row.createCell(31).setCellValue(financialStatementCount.getRefundPromotionalRebates().doubleValue());
        row.createCell(32).setCellValue(financialStatementCount.getRefundPromotionalRebatesTax().doubleValue());
        row.createCell(33).setCellValue(financialStatementCount.getRefundMarketplaceWithheldTax().doubleValue());
        row.createCell(34).setCellValue(financialStatementCount.getRefundSellingFees().doubleValue());
        row.createCell(35).setCellValue(financialStatementCount.getRefundFbaFees().doubleValue());
        row.createCell(36).setCellValue(financialStatementCount.getRefundOtherTransactionFees().doubleValue());
        row.createCell(37).setCellValue(financialStatementCount.getRefundOther().doubleValue());
        row.createCell(38).setCellValue(financialStatementCount.getRefundTotal().doubleValue());
        row.createCell(41).setCellValue(financialStatementCount.getSellerpaymentsReportFeeSubscription().doubleValue());
        row.createCell(43).setCellValue(financialStatementCount.getLightningDealFee().doubleValue());
        row.createCell(44).setCellValue(financialStatementCount.getCostOfAdvertising().doubleValue());
        row.createCell(45).setCellValue(financialStatementCount.getFbaInventoryReimbursementCustomerReturn().doubleValue());
        row.createCell(46).setCellValue(financialStatementCount.getFbaInventoryReimbursementDamagedWarehouse().doubleValue());
        row.createCell(47).setCellValue(financialStatementCount.getFbaInventoryReimbursementCustomerServiceIssue().doubleValue());
        row.createCell(48).setCellValue(financialStatementCount.getFbaInventoryReimbursementFeeCorrection().doubleValue());
        row.createCell(49).setCellValue(financialStatementCount.getFbaInventoryReimbursementGeneralAdjustment().doubleValue());
        row.createCell(50).setCellValue(financialStatementCount.getFbaInventoryReimbursementLostInbound().doubleValue());
        row.createCell(51).setCellValue(financialStatementCount.getFbaInventoryReimbursementLostWarehouse().doubleValue());
        row.createCell(52).setCellValue(financialStatementCount.getNonSubscriptionFeeAdjustment().doubleValue());
        row.createCell(53).setCellValue(financialStatementCount.getFbaInventoryPlacementServiceFee().doubleValue());
        row.createCell(55).setCellValue(financialStatementCount.getFbaCustomerReturnPerUnitFee().doubleValue());
        row.createCell(57).setCellValue(financialStatementCount.getFbaInventoryStorageFee().doubleValue());
        row.createCell(58).setCellValue(financialStatementCount.getFbaLongTermStorageFee().doubleValue());
        row.createCell(59).setCellValue(financialStatementCount.getFbaRemovalOrderDisposalFee().doubleValue());
        row.createCell(62).setCellValue(financialStatementCount.getCouponRedemptionFee().doubleValue());
        row.createCell(63).setCellValue(financialStatementCount.getEarlyReviewerProgramFee().doubleValue());
        row.createCell(65).setCellValue(financialStatementCount.getManualAdjustment().doubleValue());
        row.createCell(66).setCellValue(financialStatementCount.getMoneyBack().doubleValue());
        row.createCell(67).setCellValue(financialStatementCount.getMoneyBackRate().multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
        row.createCell(68).setCellValue(financialStatementCount.getMainBusinessIncome().doubleValue());
        row.createCell(77).setCellValue(financialStatementCount.getTotalEffectiveReceipts().doubleValue());
        row.createCell(78).setCellValue(financialStatementCount.getSellableRequestedQuantity().doubleValue());
        row.createCell(79).setCellValue(financialStatementCount.getSellableCost().doubleValue());
        row.createCell(80).setCellValue(financialStatementCount.getUnsellableRequestedQuantity().doubleValue());
        row.createCell(81).setCellValue(financialStatementCount.getUnsellableCost().doubleValue());
        row.createCell(83).setCellValue(financialStatementCount.getProcurementCost().doubleValue());
        row.createCell(84).setCellValue(financialStatementCount.getFbaHeadTripCost().doubleValue());
        row.createCell(85).setCellValue(financialStatementCount.getHeadDeductionFee().doubleValue());
        row.createCell(90).setCellValue(financialStatementCount.getMainBusinessProfit().doubleValue());
        row.createCell(91).setCellValue(financialStatementCount.getGrossMarginOnSales().multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
        row.createCell(92).setCellValue(financialStatementCount.getRoi().doubleValue());
        row.createCell(100).setCellValue(financialStatementCount.getInitialQuantity());
        row.createCell(101).setCellValue(financialStatementCount.getInitialInventoryCost().doubleValue());
        row.createCell(102).setCellValue(financialStatementCount.getFinalQuantity());
        row.createCell(103).setCellValue(financialStatementCount.getFinalInventoryCost().doubleValue());
        row.createCell(104).setCellValue(financialStatementCount.getInventoryTurnover().doubleValue());
        row.createCell(105).setCellValue(financialStatementCount.getRefundRate().multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
        row.createCell(107).setCellValue(financialStatementCount.getAdvertisingSalesPercentage().multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");

        row.createCell(112).setCellValue(financialStatementCount.getDisplayAdvertising().doubleValue());
        row.createCell(113).setCellValue(financialStatementCount.getBrandAdvertising().doubleValue());
        row.createCell(114).setCellValue(financialStatementCount.getLiquidations().doubleValue());
        row.createCell(115).setCellValue(financialStatementCount.getLiquidationsAdjustments().doubleValue());
        row.createCell(116).setCellValue(financialStatementCount.getTbybOrderPayment().doubleValue());
        row.createCell(117).setCellValue(financialStatementCount.getTbybTrialShipment().doubleValue());
        //118 groupName
        row.createCell(119).setCellValue(financialStatementCount.getAdvertisingIncome().doubleValue());
        row.createCell(120).setCellValue(financialStatementCount.getDisplayAdvertisingIncome().doubleValue());
        row.createCell(121).setCellValue(financialStatementCount.getBrandAdvertisingIncome().doubleValue());

        row.createCell(122).setCellValue(financialStatementCount.getNewProductSellingFees().doubleValue());
        row.createCell(123).setCellValue(financialStatementCount.getOldProductSellingFees().doubleValue());
        row.createCell(124).setCellValue(financialStatementCount.getNewProductMainBusinessProfit().doubleValue());
        row.createCell(125).setCellValue(financialStatementCount.getOldProductMainBusinessProfit().doubleValue());
        row.createCell(126).setCellValue(financialStatementCount.getAverageInventoryCost().doubleValue());
        row.createCell(127).setCellValue(financialStatementCount.getSaleCost().doubleValue());
        if (financialStatementCount.getAroi() != null) {
            row.createCell(128).setCellValue(financialStatementCount.getAroi().doubleValue());
        }
        if (financialStatementCount.getInventoryTurnoverTimes() != null) {
            row.createCell(129).setCellValue(financialStatementCount.getInventoryTurnoverTimes().doubleValue());
        }
        if (financialStatementCount.getRoiAssessmentCoefficient() != null) {
            row.createCell(130).setCellValue(financialStatementCount.getRoiAssessmentCoefficient().doubleValue());
        }
        if (financialStatementCount.getRoiAssessmentCoefficient() != null) {
            row.createCell(130).setCellValue(financialStatementCount.getRoiAssessmentCoefficient().doubleValue());
        }

        if (financialStatementCount.getSendCost() != null) {
            row.createCell(131).setCellValue(financialStatementCount.getSendCost().doubleValue());
        }
        if (financialStatementCount.getSendCostPrice() != null) {
            row.createCell(132).setCellValue(financialStatementCount.getSendCostPrice().doubleValue());
        }

        if (financialStatementCount.getSendHeadTripCost() != null) {
            row.createCell(133).setCellValue(financialStatementCount.getSendHeadTripCost().doubleValue());
        }
        /*Row row2 = sheet.createRow(rowIndex + 1);
        Row row3 = sheet.createRow(rowIndex + 2);
        row2.createCell(7).setCellValue("负责人");
        row3.createCell(7).setCellValue(excelTitle);
        row2.createCell(8).setCellValue("业绩额");
        row3.createCell(8).setCellValue(financialStatementCount.getMainBusinessProfit().doubleValue());
        row2.createCell(9).setCellValue("ROI");
        row3.createCell(9).setCellValue(financialStatementCount.getRoi().doubleValue());
        row2.createCell(10).setCellValue("库存周转天数");
        row3.createCell(10).setCellValue(financialStatementCount.getInventoryTurnover().doubleValue());
        row2.createCell(11).setCellValue("0-14");
        row3.createCell(11).setCellValue(newMainBusinessProfit.doubleValue());
        row2.createCell(12).setCellValue("14+");
        row3.createCell(12).setCellValue(oldMainBusinessProfit.doubleValue());
        row2.createCell(13).setCellValue("销售量");
        row3.createCell(13).setCellValue(financialStatementCount.getSaleQuantity());
        row2.createCell(14).setCellValue("销售额");
        row3.createCell(14).setCellValue(financialStatementCount.getProductSales().doubleValue());
        row2.createCell(15).setCellValue("期末价值");
        row3.createCell(15).setCellValue(financialStatementCount.getFinalInventoryCost().doubleValue());
        row2.createCell(16).setCellValue("回款率");
        row3.createCell(16).setCellValue(financialStatementCount.getMoneyBackRate().multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
        row2.createCell(17).setCellValue("退款率");
        row3.createCell(17).setCellValue(financialStatementCount.getRefundRate().multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
        row2.createCell(18).setCellValue("广告占比");
        row3.createCell(18).setCellValue(financialStatementCount.getAdvertisingSalesPercentage().multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
        row2.createCell(19).setCellValue("销售业绩");
        row3.createCell(19).setCellValue(financialStatementCount.getMainBusinessProfit().multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%");
        row2.createCell(20).setCellValue("品牌广告支出");
        //row3.createCell(20).setCellValue("");
        row2.createCell(21).setCellValue("其他补贴");
        //row3.createCell(21).setCellValue("");
        row2.createCell(22).setCellValue("提成计算总额");
        row3.createCell(22).setCellValue(financialStatementCount.getMainBusinessProfit().doubleValue());
        row2.createCell(23).setCellValue("年度业绩计入");
        row3.createCell(23).setCellValue(financialStatementCount.getMainBusinessProfit().doubleValue());
        row2.createCell(24).setCellValue("月度业绩计入");
        row3.createCell(24).setCellValue(financialStatementCount.getMainBusinessProfit().doubleValue());
        row2.createCell(25).setCellValue("毛利率");
        row3.createCell(25).setCellValue(financialStatementCount.getGrossMarginOnSales().doubleValue());*/
    }

    private void setRefundRate(FinancialStatement financialStatement) {
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

    private void setRoiAndInventoryTurnover(FinancialStatement financialStatement) {
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

    private void setGrossMarginOnSales(FinancialStatement financialStatement) {
        if (financialStatement.getProductSales() != null
                && financialStatement.getProductSales().compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal grossMarginOnSales = financialStatement.getMainBusinessProfit().divide(financialStatement.getProductSales().multiply(financialStatement.getExchangeRate()), 4, BigDecimal.ROUND_HALF_UP);
            financialStatement.setGrossMarginOnSales(grossMarginOnSales);
        } else {
            financialStatement.setGrossMarginOnSales(BigDecimal.ZERO);
        }
    }

    private void setMoneyBackRate(FinancialStatement financialStatement) {
        if (financialStatement.getProductSales() != null
                && financialStatement.getProductSales().compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal moneyBackRate = financialStatement.getMoneyBack().divide(financialStatement.getProductSales(), 4, BigDecimal.ROUND_HALF_UP);
            financialStatement.setMoneyBackRate(moneyBackRate);
        } else {
            financialStatement.setMoneyBackRate(BigDecimal.ZERO);
        }
    }

    private void setExcelTitle(Sheet sheet, String excelTitle) {
        Row row = sheet.getRow(0);
        row.getCell(0).setCellValue(excelTitle);
    }

    private List<FinancialStatement> getFinancialStatementListUserName(String userName, List<FinancialStatement> financialStatementList, String type) {
        List<FinancialStatement> financialStatements = new ArrayList<>();
        if (FinanceConstant.FinanceExprotType.DEVELOPER.getType().equals(type)) {
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
        } else if (FinanceConstant.FinanceExprotType.SALESMAN.getType().equals(type)) {
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
        } else if (FinanceConstant.FinanceExprotType.SALESGROUP.getType().equals(type)) {
            financialStatements = financialStatementList.stream().filter(item -> {
                if (StringUtils.isEmpty(item.getSalesGroupName())) {
                    if (StringUtils.isEmpty(userName)) {
                        return true;
                    } else {
                        return false;
                    }
                }
                if (item.getSalesGroupName().equals(userName)) {
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
            userNameList = financialStatementList.stream().map(FinancialStatement::getSalesmanUserName).distinct().collect(Collectors.toList());
        } else if ("salesGroup".equals(type)) {
            userNameList = financialStatementList.stream().map(FinancialStatement::getSalesGroupName).distinct().collect(Collectors.toList());
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

    private void setFinancialStatementShopParentSku(Sheet sheet, List<FinancialStatementExport> financialStatementList) {
        if (CollectionUtils.isEmpty(financialStatementList)) {
            return;
        }
        List<FinancialStatementExport> financialStatementShopParentSkuList = getFinancialStatementShopParentSkuList(financialStatementList);
        int rowIndex = 6;
        for (int i = 0; i < financialStatementShopParentSkuList.size(); i++) {
            FinancialStatementExport financialStatement = financialStatementShopParentSkuList.get(i);
            Row row = sheet.createRow(rowIndex);
            row.createCell(6).setCellValue(i + 1);
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
            row.createCell(106).setCellValue("");
            row.createCell(107).setCellValue("");
            if (financialStatement.getDisplayAdvertising() != null) {
                row.createCell(108).setCellValue(financialStatement.getDisplayAdvertising().doubleValue());
            }
            if (financialStatement.getBrandAdvertising() != null) {
                row.createCell(109).setCellValue(financialStatement.getBrandAdvertising().doubleValue());
            }
            row.createCell(110).setCellValue(financialStatement.getLiquidations().doubleValue());
            row.createCell(111).setCellValue(financialStatement.getLiquidationsAdjustments().doubleValue());
            row.createCell(112).setCellValue(financialStatement.getTbybOrderPayment().doubleValue());
            row.createCell(113).setCellValue(financialStatement.getTbybTrialShipment().doubleValue());
            row.createCell(114).setCellValue(financialStatement.getAverageInventoryCost().doubleValue());
            row.createCell(115).setCellValue(financialStatement.getSaleCost().doubleValue());
            if (financialStatement.getAroi() != null) {
                row.createCell(116).setCellValue(financialStatement.getAroi().doubleValue());
            }
            if (financialStatement.getInventoryTurnoverTimes() != null) {
                row.createCell(117).setCellValue(financialStatement.getInventoryTurnoverTimes().doubleValue());
            }
            if (financialStatement.getRoiAssessmentCoefficient() != null) {
                row.createCell(118).setCellValue(financialStatement.getRoiAssessmentCoefficient().doubleValue());
            }
            if (financialStatement.getSendCost() != null) {
                row.createCell(119).setCellValue(financialStatement.getSendCost().doubleValue());
            }
            if (financialStatement.getSendCostPrice() != null) {
                row.createCell(120).setCellValue(financialStatement.getSendCostPrice().doubleValue());
            }

            if (financialStatement.getSendHeadTripCost() != null) {
                row.createCell(121).setCellValue(financialStatement.getSendHeadTripCost().doubleValue());
            }
            rowIndex++;
        }
    }

    private List<FinancialStatementExport> getFinancialStatementShopParentSkuList(List<FinancialStatementExport> financialStatementList) {
        Map<String, FinancialStatementExport> financialStatementMap = new HashMap<>();
        Iterator<FinancialStatementExport> iterator = financialStatementList.iterator();
        while (iterator.hasNext()) {
            FinancialStatementExport financialStatement = iterator.next();
            FinancialStatementExport financialStatementShopParentSku = financialStatementMap.get(financialStatement.getShopParentSku());
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
            financialStatementShopParentSku.setDisplayAdvertising(MathUtil.addBigDecimal(financialStatementShopParentSku.getDisplayAdvertising(), financialStatement.getDisplayAdvertising()));
            financialStatementShopParentSku.setBrandAdvertising(MathUtil.addBigDecimal(financialStatementShopParentSku.getBrandAdvertising(), financialStatement.getBrandAdvertising()));
            financialStatementShopParentSku.setLiquidations(MathUtil.addBigDecimal(financialStatementShopParentSku.getLiquidations(), financialStatement.getLiquidations()));
            financialStatementShopParentSku.setLiquidationsAdjustments(MathUtil.addBigDecimal(financialStatementShopParentSku.getLiquidationsAdjustments(), financialStatement.getLiquidationsAdjustments()));
            financialStatementShopParentSku.setTbybOrderPayment(MathUtil.addBigDecimal(financialStatementShopParentSku.getTbybOrderPayment(), financialStatement.getTbybOrderPayment()));
            financialStatementShopParentSku.setTbybTrialShipment(MathUtil.addBigDecimal(financialStatementShopParentSku.getTbybTrialShipment(), financialStatement.getTbybTrialShipment()));
        }
        List<FinancialStatementExport> financialStatementShopParentSkuList = new ArrayList<>();
        for (Map.Entry<String, FinancialStatementExport> map : financialStatementMap.entrySet()) {
            FinancialStatementExport financialStatement = map.getValue();
            setMoneyBackRate(financialStatement);
            setGrossMarginOnSales(financialStatement);
            setRoiAndInventoryTurnover(financialStatement);
            setRefundRate(financialStatement);
            setAdvertisingSalesPercentage(financialStatement);
            FinancialStatementConstant.initFinancialStatementExport(financialStatement);
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

    private void setFinancialStatement(Sheet sheet, List<FinancialStatementExport> financialStatementList) {
        setExchangeRate(sheet, financialStatementList);
        //设置开发等级
        int rowIndex = 6;
        for (int i = 0; i < financialStatementList.size(); i++) {
            FinancialStatementExport financialStatement = financialStatementList.get(i);
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
            if (!StringUtils.isEmpty(financialStatement.getProductMonth())) {
                row.createCell(108).setCellValue(financialStatement.getProductMonth());
            }
            if (financialStatement.getDevelopmentLevel() != null) {
                row.createCell(109).setCellValue(financialStatement.getDevelopmentLevel());
            }
            row.createCell(110).setCellValue(financialStatement.getCostPrice().doubleValue());
            row.createCell(111).setCellValue(financialStatement.getHeadTripCost().doubleValue());
            row.createCell(112).setCellValue(financialStatement.getDisplayAdvertising().doubleValue());
            row.createCell(113).setCellValue(financialStatement.getBrandAdvertising().doubleValue());
            row.createCell(114).setCellValue(financialStatement.getLiquidations().doubleValue());
            row.createCell(115).setCellValue(financialStatement.getLiquidationsAdjustments().doubleValue());
            row.createCell(116).setCellValue(financialStatement.getTbybOrderPayment().doubleValue());
            row.createCell(117).setCellValue(financialStatement.getTbybTrialShipment().doubleValue());
            row.createCell(118).setCellValue(financialStatement.getSalesGroupName());
            row.createCell(119).setCellValue(financialStatement.getAdvertisingIncome().doubleValue());
            row.createCell(120).setCellValue(financialStatement.getDisplayAdvertisingIncome().doubleValue());
            row.createCell(121).setCellValue(financialStatement.getBrandAdvertisingIncome().doubleValue());
            FinancialStatementConstant.initFinancialStatementExport(financialStatement);
            row.createCell(122).setCellValue(financialStatement.getNewProductSellingFees().doubleValue());
            row.createCell(123).setCellValue(financialStatement.getOldProductSellingFees().doubleValue());
            row.createCell(124).setCellValue(financialStatement.getNewProductMainBusinessProfit().doubleValue());
            row.createCell(125).setCellValue(financialStatement.getOldProductMainBusinessProfit().doubleValue());
            row.createCell(126).setCellValue(financialStatement.getAverageInventoryCost().doubleValue());
            row.createCell(127).setCellValue(financialStatement.getSaleCost().doubleValue());
            if (financialStatement.getAroi() != null) {
                row.createCell(128).setCellValue(financialStatement.getAroi().doubleValue());
            }
            if (financialStatement.getInventoryTurnoverTimes() != null) {
                row.createCell(129).setCellValue(financialStatement.getInventoryTurnoverTimes().doubleValue());
            }
            if (financialStatement.getRoiAssessmentCoefficient() != null) {
                row.createCell(130).setCellValue(financialStatement.getRoiAssessmentCoefficient().doubleValue());
            }
            if (financialStatement.getSendCost() != null) {
                row.createCell(131).setCellValue(financialStatement.getSendCost().doubleValue());
            }
            if (financialStatement.getSendCostPrice() != null) {
                row.createCell(132).setCellValue(financialStatement.getSendCostPrice().doubleValue());
            }

            if (financialStatement.getSendHeadTripCost() != null) {
                row.createCell(133).setCellValue(financialStatement.getSendHeadTripCost().doubleValue());
            }
            rowIndex++;
        }
    }

    private void setExchangeRate(Sheet sheet, List<FinancialStatementExport> financialStatementList) {
        if (CollectionUtils.isEmpty(financialStatementList)) {
            return;
        }
        if (financialStatementList.get(0).getExchangeRate() == null) {
            return;
        }
        sheet.getRow(2).getCell(5).setCellValue(financialStatementList.get(0).getExchangeRate().toString());

    }

    private List<Sku> getSkuList(List<FinancialStatement> financialStatementList) {
        List<String> skuStrList = financialStatementList.stream().map(FinancialStatement::getSku).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());
        SkuExample skuExample = new SkuExample();
        skuExample.createCriteria().andSkuIn(skuStrList);
        return customSkuMapper.selectByExample(skuExample);
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
