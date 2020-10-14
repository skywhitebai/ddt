package com.sky.ddt.service.impl.finance;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.FinanceConstant;
import com.sky.ddt.common.constant.SkuConstant;
import com.sky.ddt.dao.custom.CustomFinanceMapper;
import com.sky.ddt.dto.finance.request.FinanceListRequest;
import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.finance.request.SaveFinanceRemarkRequest;
import com.sky.ddt.dto.finance.response.FbaCustomerReturnPerUnitFeeNotExistSkuResponse;
import com.sky.ddt.dto.finance.response.FinanceListResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.sku.response.SkuExportInfoResponse;
import com.sky.ddt.entity.Finance;
import com.sky.ddt.entity.FinanceExample;
import com.sky.ddt.service.finance.*;
import com.sky.ddt.util.DateUtil;
import com.sky.ddt.util.ExcelExportUtil;
import com.sky.ddt.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description 财务服务类
 * @date 2019/11/20 16:06
 */
@Service
public class FinanceService implements IFinanceService {
    @Autowired
    CustomFinanceMapper customFinanceMapper;
    @Autowired
    IMonthlySalesService monthlySalesService;
    @Autowired
    ILightingDealService lightingDealService;
    @Autowired
    IMonthlyStorageFeeService monthlyStorageFeeService;
    @Autowired
    ILongStorageFeeService longStorageFeeService;
    @Autowired
    IRemoveOrdersService removeOrdersService;
    @Autowired
    IReturnOrderService returnOrderService;
    @Autowired
    IMonthlyAdvertisingFeeService monthlyAdvertisingFeeService;
    @Autowired
    IDestructionFeeService destructionFeeService;
    @Autowired
    IDestructionDetailsService destructionDetailsService;
    @Autowired
    ICouponService couponService;
    @Autowired
    IEarlyReviewerProgramFeeService earlyReviewerProgramFeeService;
    @Autowired
    IHeadDeductionService headDeductionService;
    @Autowired
    IInventoryDetailsService inventoryDetailsService;
    @Autowired
    IManualAdjustmentService manualAdjustmentService;

    /**
     * @param params@return
     * @description 分页查询财务信息
     * @author baixueping
     * @date 2019/11/20 16:14
     */
    @Override
    public PageInfo<FinanceListResponse> list(FinanceListRequest params) {
        if(!StringUtils.isEmpty(params.getMonth())){
            String monthStr = params.getMonth() + "-01";
            Date monthDate = DateUtil.strToDate(monthStr);
            if (monthDate!= null) {
                params.setMonthDate(monthDate);
            }
        }
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<FinanceListResponse> list = customFinanceMapper.financeList(params);
        PageInfo<FinanceListResponse> page = new PageInfo<FinanceListResponse>(list);
        return page;
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 导入财务信息
     * @author baixueping
     * @date 2019/11/22 10:22
     */
    @Override
    public BaseResponse importFinance(ImportFinanceRequest params, Integer dealUserId) {
        StringBuilder sbErro = new StringBuilder();
        if (params.getFile() == null) {
            sbErro.append(",请选择要上传的文件");
        }
        if (StringUtils.isEmpty(params.getType())) {
            sbErro.append(FinanceConstant.TYPE_EMPTY);
        } else if (!FinanceConstant.FinanceTypeEnum.contains(params.getType())) {
            sbErro.append(FinanceConstant.TYPE_NOT_EXIST);
        }
        if (StringUtils.isEmpty(params.getMonth())) {
            sbErro.append(FinanceConstant.MONTH_EMPTY);
        } else {
            String monthStr = params.getMonth() + "-01";
            Date monthDate = DateUtil.strToDate(monthStr);
            if (monthDate == null) {
                sbErro.append(FinanceConstant.MONTH_ERRO);
            } else {
                params.setMonthDate(monthDate);
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
        if (FinanceConstant.FinanceTypeEnum.MONTHLY_SALES.getType().equals(params.getType())) {
            return monthlySalesService.importMonthlySales(params, dealUserId);
        } else if (FinanceConstant.FinanceTypeEnum.LIGHTING_DEAL.getType().equals(params.getType())) {
            return lightingDealService.importLightingDeal(params, dealUserId);
        } else if (FinanceConstant.FinanceTypeEnum.MONTHLY_STORAGE_FEE.getType().equals(params.getType())) {
            return monthlyStorageFeeService.importMonthlyStorageFee(params, dealUserId);
        } else if (FinanceConstant.FinanceTypeEnum.LONG_STORAGE_FEE.getType().equals(params.getType())) {
            return longStorageFeeService.importLongStorageFee(params, dealUserId);
        } else if (FinanceConstant.FinanceTypeEnum.REMOVE_ORDERS.getType().equals(params.getType())) {
            return removeOrdersService.importRemoveOrders(params, dealUserId);
        } else if (FinanceConstant.FinanceTypeEnum.RETURN_ORDER.getType().equals(params.getType())) {
            return returnOrderService.importReturnOrder(params, dealUserId);
        } else if (FinanceConstant.FinanceTypeEnum.MONTHLY_ADVERTISING_FEE.getType().equals(params.getType())) {
            return monthlyAdvertisingFeeService.importMonthlyAdvertisingFee(params, dealUserId);
        } else if (FinanceConstant.FinanceTypeEnum.DESTRUCTION_FEE.getType().equals(params.getType())) {
            return destructionFeeService.importDestructionFee(params, dealUserId);
        } else if (FinanceConstant.FinanceTypeEnum.DESTRUCTION_DETAILS.getType().equals(params.getType())) {
            return destructionDetailsService.importDestructionDetails(params, dealUserId);
        } else if (FinanceConstant.FinanceTypeEnum.COUPON.getType().equals(params.getType())) {
            return couponService.importCoupon(params, dealUserId);
        } else if (FinanceConstant.FinanceTypeEnum.EARLY_REVIEWER_PROGRAM_FEE.getType().equals(params.getType())) {
            return earlyReviewerProgramFeeService.importEarlyReviewerProgramFee(params, dealUserId);
        } else if (FinanceConstant.FinanceTypeEnum.HEAD_DEDUCTION.getType().equals(params.getType())) {
            return headDeductionService.importHeadDeduction(params, dealUserId);
        } else if (FinanceConstant.FinanceTypeEnum.INVENTORY_DETAILS.getType().equals(params.getType())) {
            return inventoryDetailsService.importInventoryDetails(params, dealUserId);
        }else if (FinanceConstant.FinanceTypeEnum.MANUAL_ADJUSTMENT.getType().equals(params.getType())) {
            return manualAdjustmentService.importManualAdjustment(params, dealUserId);
        }


        return BaseResponse.fail();
    }

    /**
     * @param shopId
     * @param month
     * @return
     * @description 根据shopId和month获取财务信息
     * @author baixueping
     * @date 2019/11/28 11:33
     */
    @Override
    public Finance getFinance(Integer shopId, Date month) {
        if (shopId == null || StringUtils.isEmpty(month)) {
            return null;
        }
        FinanceExample financeExample = new FinanceExample();
        financeExample.createCriteria().andShopIdEqualTo(shopId).andMonthEqualTo(month);
        List<Finance> list = customFinanceMapper.selectByExample(financeExample);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    /**
     * @param shopId
     * @param month
     * @param dealUserId
     * @return
     * @description 获取财务信息
     * @author baixueping
     * @date 2019/12/2 10:35
     */
    @Override
    public BaseResponse<Finance> getOrCreateFinance(Integer shopId, Date month, Integer dealUserId) {
        Finance finance = getFinance(shopId, month);
        if (finance == null) {
            finance = new Finance();
            finance.setCreateBy(dealUserId);
            finance.setStatus(FinanceConstant.FinanceStatusEnum.NOT_GENERATED.getStatus());
            finance.setShopId(shopId);
            finance.setMonth(month);
            finance.setCreateTime(new Date());
            int res = customFinanceMapper.insertSelective(finance);
            if (res <= 0) {
                return BaseResponse.failMessage(FinanceConstant.CREATE_FINANCE_FAIL);
            }
            //创建一个
        }
        return BaseResponse.successData(finance);
    }

    /**
     * @param
     * @return
     * @description 通过id获取财务信息
     * @author baixueping
     * @date 2019/12/24 11:05
     */
    @Override
    public Finance getFinance(Integer id) {
        if (id == null) {
            return null;
        }
        return customFinanceMapper.selectByPrimaryKey(id);
    }

    /**
     * @param response
     * @param financeId
     * @return
     * @description 导出退款费没有sku的订单
     * @author baixueping
     * @date 2019/12/27 11:17
     */
    @Override
    public BaseResponse exportFbaCustomerReturnPerUnitFeeNotExistSku(HttpServletResponse response, Integer financeId) {
        if (financeId == null) {
            return BaseResponse.failMessage(FinanceConstant.ID_EMPTY);        }
        List<FbaCustomerReturnPerUnitFeeNotExistSkuResponse> fbaCustomerReturnPerUnitFeeNotExistSkuResponseList = customFinanceMapper.listFbaCustomerReturnPerUnitFeeNotExistSkuResponse(financeId);
        BaseResponse exportResponse= new ExcelExportUtil<FbaCustomerReturnPerUnitFeeNotExistSkuResponse>().export(response,fbaCustomerReturnPerUnitFeeNotExistSkuResponseList, FinanceConstant.EXPORT_FBA_CUSTOMER_RETURN_PER_UNIT_FEE_NOT_EXIST_SKU_HEAD,"退款操作费找不到sku的订单");
        return exportResponse;
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 保存备注
     * @author baixueping
     * @date 2020/1/3 11:15
     */
    @Override
    public BaseResponse saveFinanceRemark(SaveFinanceRemarkRequest params, Integer dealUserId) {
        Finance financeUpdate=new Finance();
        financeUpdate.setId(params.getFinanceId());
        financeUpdate.setRemark(params.getRemark());
        customFinanceMapper.updateByPrimaryKeySelective(financeUpdate);
        return BaseResponse.success();
    }

    /**
     * @param id
     * @param dealUserId
     * @return
     * @description 锁定财务报表
     * @author baixueping
     * @date 2019/12/24 11:03
     */
    @Override
    public BaseResponse lockFinance(Integer id, Integer dealUserId) {
        if (id == null) {
            return BaseResponse.failMessage(FinanceConstant.ID_EMPTY);
        }
        Finance finance = getFinance(id);
        if (finance == null) {
            return BaseResponse.failMessage(FinanceConstant.ID_NOT_EXIST);
        }
        if (!FinanceConstant.FinanceStatusEnum.GENERATED.getStatus().equals(finance.getStatus())) {
            return BaseResponse.failMessage(FinanceConstant.NOT_ALLOW_LOCK);
        }
        Finance financeUpdate = new Finance();
        financeUpdate.setId(finance.getId());
        financeUpdate.setStatus(FinanceConstant.FinanceStatusEnum.LOCKED.getStatus());
        customFinanceMapper.updateByPrimaryKeySelective(financeUpdate);
        return BaseResponse.success();
    }
}
