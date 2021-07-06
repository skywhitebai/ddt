package com.sky.ddt.service.impl.finance;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.FinanceConstant;
import com.sky.ddt.common.constant.ShopSkuConstant;
import com.sky.ddt.common.constant.finance.FinanceStatisticConstant;
import com.sky.ddt.dao.custom.CustomFinanceMapper;
import com.sky.ddt.dao.custom.CustomFinanceStatisticMapper;
import com.sky.ddt.dto.finance.financeStatistic.request.ListFinanceStatisticRequest;
import com.sky.ddt.dto.finance.financeStatistic.response.ListFinanceStatisticResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.Finance;
import com.sky.ddt.entity.FinanceStatistic;
import com.sky.ddt.entity.FinanceStatisticExample;
import com.sky.ddt.service.finance.IFinanceService;
import com.sky.ddt.service.finance.IFinanceStatisticService;
import com.sky.ddt.util.DateUtil;
import com.sky.ddt.util.ExcelExportByExcelFieldUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description 财务回款统计信息
 * @date 2021/7/5 11:39
 */
@Service
public class FinanceStatisticService implements IFinanceStatisticService {
    @Autowired
    CustomFinanceStatisticMapper customFinanceStatisticMapper;
    @Autowired
    CustomFinanceMapper customFinanceMapper;
    @Autowired
    IFinanceService financeService;
    /**
     * @param financeId
     * @param dealUserId
     * @return
     * @description 生成财务回款信息
     * @author baixueping
     * @date 2021/7/5 15:12
     */
    @Override
    public BaseResponse createFinanceStatistic(Integer financeId, Integer dealUserId) {
        if (financeId == null) {
            return BaseResponse.failMessage(FinanceConstant.ID_EMPTY);
        }
        Finance finance = financeService.getFinance(financeId);
        if (finance == null) {
            return BaseResponse.failMessage(FinanceConstant.ID_NOT_EXIST);
        }
        //查询财务汇款信息
        FinanceStatistic financeStatisticInfo=customFinanceStatisticMapper.getFinanceStatisticInfo(financeId);
        financeStatisticInfo.setNetIncome(getNetIncome(financeStatisticInfo));
        FinanceStatistic financeStatisticOld=getFinanceStatisticByFinanceId(financeId);
        if(financeStatisticOld==null){
            financeStatisticInfo.setCreateBy(dealUserId);
            financeStatisticInfo.setCreateTime(new Date());
            customFinanceStatisticMapper.insertSelective(financeStatisticInfo);
        }else{
            financeStatisticInfo.setId(financeStatisticOld.getId());
            financeStatisticInfo.setUpdateBy(financeId);
            financeStatisticInfo.setUpdateTime(new Date());
            customFinanceStatisticMapper.updateByPrimaryKeySelective(financeStatisticInfo);
        }
        Finance financeUpdate = new Finance();
        financeUpdate.setStatisticStatus(FinanceConstant.FinanceStatusEnum.GENERATED.getStatus());
        financeUpdate.setId(financeId);
        customFinanceMapper.updateByPrimaryKeySelective(financeUpdate);
        return BaseResponse.success();
    }

    @Override
    public PageInfo<ListFinanceStatisticResponse> listFinanceStatistic(ListFinanceStatisticRequest params) {
        if(!StringUtils.isEmpty(params.getMonth())){
            String monthStr = params.getMonth() + "-01";
            Date monthDate = DateUtil.strToDate(monthStr);
            if (monthDate!= null) {
                params.setMonthDate(monthDate);
            }
        }
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListFinanceStatisticResponse> list = customFinanceStatisticMapper.listFinanceStatistic(params);
        PageInfo<ListFinanceStatisticResponse> page = new PageInfo<ListFinanceStatisticResponse>(list);
        return page;
    }

    @Override
    public BaseResponse exportFinanceStatistic(HttpServletResponse response, ListFinanceStatisticRequest params) {
        List<ListFinanceStatisticResponse> list = customFinanceStatisticMapper.listFinanceStatistic(params);
        BaseResponse exportResponse=  new ExcelExportByExcelFieldUtil().export(response, list, FinanceStatisticConstant.exportFinanceStatisticFieldList, "回款信息");;
        return exportResponse;
    }

    private BigDecimal getNetIncome(FinanceStatistic financeStatisticInfo) {
        BigDecimal res=BigDecimal.ZERO;
        if(financeStatisticInfo.getMainBusinessIncome()!=null){
            res=res.add(financeStatisticInfo.getMainBusinessIncome());
        }
        if(financeStatisticInfo.getSendCost()!=null){
            res=res.subtract(financeStatisticInfo.getSendCost());
        }
        if(financeStatisticInfo.getManualAdjustment()!=null){
            res=res.add(financeStatisticInfo.getManualAdjustment());
        }
        return res;
    }

    private FinanceStatistic getFinanceStatisticByFinanceId(Integer financeId) {
        FinanceStatisticExample example=new FinanceStatisticExample();
        example.createCriteria().andFinanceIdEqualTo(financeId);
        List<FinanceStatistic> list= customFinanceStatisticMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }
}
