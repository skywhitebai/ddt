package com.sky.ddt.service.impl.finance;

import com.sky.ddt.common.constant.FinanceConstant;
import com.sky.ddt.dao.custom.CustomFinanceMapper;
import com.sky.ddt.dao.custom.CustomFinanceStatisticMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.Finance;
import com.sky.ddt.entity.FinanceStatistic;
import com.sky.ddt.entity.FinanceStatisticExample;
import com.sky.ddt.service.finance.IFinanceService;
import com.sky.ddt.service.finance.IFinanceStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
