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
        WorkOrderExample workOrderExample = new WorkOrderExample();
        WorkOrderExample.Criteria criteria = workOrderExample.createCriteria();
        if (!StringUtils.isEmpty(params.getTitle())) {
            criteria.andTitleLike(params.getTitle());
        }
        if (params.getStatus() != null) {
            criteria.andStatusEqualTo(params.getStatus());
        }
        workOrderExample.setOrderByClause("create_time desc");
        List<WorkOrder> list = customWorkOrderMapper.selectByExampleWithBLOBs(workOrderExample);
        PageInfo<WorkOrder> page = new PageInfo<WorkOrder>(list);
        return page;
    }

    @Override
    public BaseResponse saveWorkOrder(SaveWorkOrderRequest params, Integer dealUserId) {
        WorkOrder workOrderExist = null;
        if (params.getId() != null) {
            workOrderExist = customWorkOrderMapper.selectByPrimaryKey(params.getId());
            if (workOrderExist == null) {
                return BaseResponse.failMessage("工单id不存在");
            }
        }
        WorkOrder workOrder = new WorkOrder();
        if (!WorkOrderConstant.LevelEnum.contains(params.getLevel())) {
            return BaseResponse.failMessage("处理级别不存在");
        }
        BeanUtils.copyProperties(params, workOrder);
        if (params.getId() == null) {
            workOrder.setCreateBy(dealUserId);
            workOrder.setCreateTime(new Date());
            workOrder.setStatus(WorkOrderConstant.StatusEnum.HAVE_IN_HAND.getStatus());
            workOrder.setDealStatus(WorkOrderConstant.DealStatusEnum.UN_DEAL.getDealStatus());
            customWorkOrderMapper.insertSelective(workOrder);
        } else {
            if (!WorkOrderConstant.StatusEnum.contains(params.getStatus())) {
                return BaseResponse.failMessage("状态不存在");
            }
            if (WorkOrderConstant.StatusEnum.COMPLETED.getStatus().equals(params.getStatus())) {
                Date now = new Date();
                if (workOrderExist.getPlanEndTime()==null||now.before(workOrderExist.getPlanEndTime())) {
                    workOrder.setDealStatus(WorkOrderConstant.DealStatusEnum.HANDLER.getDealStatus());
                } else {
                    workOrder.setDealStatus(WorkOrderConstant.DealStatusEnum.TIMEOUT_HANDLER.getDealStatus());
                }
                workOrder.setActualEndTime(now);
                workOrder.setDealUserId(dealUserId);
            }
            workOrder.setUpdateBy(dealUserId);
            workOrder.setUpdateTime(new Date());
            customWorkOrderMapper.updateByPrimaryKeySelective(workOrder);
        }
        return BaseResponse.success();
    }

    @Override
    public BaseResponse cancelWorkOrder(Integer id, Integer dealUserId) {
        if(id==null){
            return BaseResponse.failMessage("id不能为空");
        }
        WorkOrder workOrder=customWorkOrderMapper.selectByPrimaryKey(id);
        if(workOrder==null){
            return BaseResponse.failMessage("id不存在");
        }
        WorkOrder workOrderUpdate=new WorkOrder();
        workOrderUpdate.setId(id);
        workOrderUpdate.setUpdateBy(dealUserId);
        workOrderUpdate.setUpdateTime(new Date());
        workOrderUpdate.setStatus(WorkOrderConstant.StatusEnum.CANCEL.getStatus());
        customWorkOrderMapper.updateByPrimaryKeySelective(workOrderUpdate);
        return BaseResponse.success();
    }
}
