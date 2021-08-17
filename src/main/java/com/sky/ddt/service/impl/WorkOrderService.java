package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.WorkOrderConstant;
import com.sky.ddt.dao.custom.CustomWorkOrderMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.warehousingOrder.response.ListWarehousingOrderResponse;
import com.sky.ddt.dto.workOrder.request.ListWorkOrderRequest;
import com.sky.ddt.dto.workOrder.request.SaveWorkOrderRequest;
import com.sky.ddt.entity.WorkOrder;
import com.sky.ddt.entity.WorkOrderExample;
import com.sky.ddt.service.IWorkOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @Description 工单服务
 * @date 2021/8/9 21:46
 */
@Service
public class WorkOrderService implements IWorkOrderService {
    @Autowired
    CustomWorkOrderMapper customWorkOrderMapper;

    @Override
    public PageInfo<WorkOrder> listWorkOrder(ListWorkOrderRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        WorkOrderExample workOrderExample=new WorkOrderExample();
      WorkOrderExample.Criteria criteria=workOrderExample.createCriteria();
      if(!StringUtils.isEmpty(params.getTitle())){
          criteria.andTitleLike(params.getTitle());
      }
        if(params.getStatus()!=null){
            criteria.andStatusEqualTo(params.getStatus());
        }
        List<WorkOrder> list=customWorkOrderMapper.selectByExample(workOrderExample);
        PageInfo<WorkOrder> page = new PageInfo<WorkOrder>(list);
        return page;
    }

    @Override
    public BaseResponse saveWorkOrder(SaveWorkOrderRequest params, Integer dealUserId) {
        if(params.getId()!=null){
            WorkOrder workOrderExist=customWorkOrderMapper.selectByPrimaryKey(params.getId());
            if(workOrderExist==null){
                return BaseResponse.failMessage("工单id不存在");
            }
        }
        WorkOrder workOrder=new WorkOrder();
        if(!WorkOrderConstant.LevelEnum.contains(params.getLevel())){
            return BaseResponse.failMessage("处理级别不存在");
        }
        BeanUtils.copyProperties(params,workOrder);
        if(params.getId()==null){
            workOrder.setCreateBy(dealUserId);
            workOrder.setCreateTime(new Date());
            workOrder.setStatus(WorkOrderConstant.StatusEnum.HAVE_IN_HAND.getStatus());
            workOrder.setDealStatus(WorkOrderConstant.DealStatusEnum.UN_DEAL.getDealStatus());
            customWorkOrderMapper.insertSelective(workOrder);
        }else{
            if(!WorkOrderConstant.StatusEnum.contains(params.getStatus())){
                return BaseResponse.failMessage("状态不存在");
            }
            if(!WorkOrderConstant.DealStatusEnum.contains(params.getDealStatus())){
                return BaseResponse.failMessage("处理状态不存在");
            }

            workOrder.setUpdateBy(dealUserId);
            workOrder.setUpdateTime(new Date());
            customWorkOrderMapper.updateByPrimaryKeySelective(workOrder);
        }
        return BaseResponse.success();
    }
}
