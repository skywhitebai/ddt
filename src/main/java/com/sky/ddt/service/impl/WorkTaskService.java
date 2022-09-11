package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.WorkOrderConstant;
import com.sky.ddt.common.constant.WorkTaskConstant;
import com.sky.ddt.dao.custom.CustomUserMapper;
import com.sky.ddt.dao.custom.CustomWorkTaskMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.workTask.req.ListWorkTaskReq;
import com.sky.ddt.dto.workTask.req.SaveWorkTaskReq;
import com.sky.ddt.dto.workTask.resp.ListWorkTaskResp;
import com.sky.ddt.entity.WorkOrder;
import com.sky.ddt.entity.WorkTask;
import com.sky.ddt.entity.WorkTaskExample;
import com.sky.ddt.entity.WorkTaskWithBLOBs;
import com.sky.ddt.service.IWorkTaskService;
import com.sky.ddt.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @Description
 * @date 2022/4/29 23:03
 */
@Service
public class WorkTaskService implements IWorkTaskService {
    @Autowired
    CustomWorkTaskMapper customWorkTaskMapper;
    @Autowired
    CustomUserMapper customUserMapper;

    @Override
    public PageInfo<ListWorkTaskResp> listWorkTask(ListWorkTaskReq params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListWorkTaskResp> list = customWorkTaskMapper.listWorkTask(params);
        PageInfo<ListWorkTaskResp> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public BaseResponse saveWorkTask(SaveWorkTaskReq params, Integer dealUserId) {
        WorkTask workTaskExist = null;
        if (params.getId() != null) {
            workTaskExist = customWorkTaskMapper.selectByPrimaryKey(params.getId());
            if (workTaskExist == null) {
                return BaseResponse.failMessage("任务id不存在");
            }
        }
        if (customUserMapper.selectByPrimaryKey(params.getChargeUserId()) == null) {
            return BaseResponse.failMessage("负责人id不存在");
        }
        WorkTaskWithBLOBs workTask = new WorkTaskWithBLOBs();
        if (!WorkTaskConstant.LevelEnum.contains(params.getLevel())) {
            return BaseResponse.failMessage("处理级别不存在");
        }
        BeanUtils.copyProperties(params, workTask);
        if (params.getId() == null) {
            workTask.setWorkTaskNo(getWorderTaskNo());
            workTask.setCreateBy(dealUserId);
            workTask.setCreateTime(new Date());
            workTask.setStatus(WorkTaskConstant.StatusEnum.HAVE_IN_HAND.getStatus());
            workTask.setDealStatus(WorkTaskConstant.DealStatusEnum.UN_DEAL.getDealStatus());
            customWorkTaskMapper.insertSelective(workTask);
        } else {
            if (!WorkTaskConstant.StatusEnum.contains(params.getStatus())) {
                return BaseResponse.failMessage("状态不存在");
            }
            if (WorkOrderConstant.StatusEnum.COMPLETED.getStatus().equals(params.getStatus())) {
                Date now = new Date();
                if (workTaskExist.getEndTime() == null || now.before(workTaskExist.getEndTime())) {
                    workTask.setDealStatus(WorkOrderConstant.DealStatusEnum.HANDLER.getDealStatus());
                } else {
                    workTask.setDealStatus(WorkOrderConstant.DealStatusEnum.TIMEOUT_HANDLER.getDealStatus());
                }
                workTask.setActualEndTime(now);
                workTask.setDealUserId(dealUserId);
            }
            workTask.setUpdateBy(dealUserId);
            workTask.setUpdateTime(new Date());
            customWorkTaskMapper.updateByPrimaryKeySelective(workTask);
        }
        return BaseResponse.success();
    }

    @Override
    public BaseResponse cancelWorkTask(Integer id, Integer dealUserId) {
        if (id == null) {
            return BaseResponse.failMessage("id不能为空");
        }
        WorkTask workTask = customWorkTaskMapper.selectByPrimaryKey(id);
        if (workTask == null) {
            return BaseResponse.failMessage("id不存在");
        }
        WorkTaskWithBLOBs workTaskUpdate = new WorkTaskWithBLOBs();
        workTaskUpdate.setId(id);
        workTaskUpdate.setUpdateBy(dealUserId);
        workTaskUpdate.setUpdateTime(new Date());
        workTaskUpdate.setStatus(WorkOrderConstant.StatusEnum.CANCEL.getStatus());
        customWorkTaskMapper.updateByPrimaryKeySelective(workTaskUpdate);
        return BaseResponse.success();
    }
    @Override
    public String getWorderTaskNo() {
        String worderTaskNoFirst = "WO" + DateUtil.getFormatStryyyyMMdd(new Date());
        WorkTaskExample example = new WorkTaskExample();
        example.createCriteria().andCreateTimeGreaterThanOrEqualTo(DateUtil.getToday());
        Long count = customWorkTaskMapper.countByExample(example);
        String worderTaskNo = "";
        do {
            count++;
            if (count >= 10) {
                worderTaskNo = worderTaskNoFirst + count.toString();
            } else {
                worderTaskNo = worderTaskNoFirst + "0" + count.toString();
            }
        }
        while (existWorkTaskNo(worderTaskNo));
        return worderTaskNo;
    }

    private boolean existWorkTaskNo(String worderTaskNo) {
        WorkTaskExample example = new WorkTaskExample();
        example.createCriteria().andWorkTaskNoEqualTo(worderTaskNo);
        Long count = customWorkTaskMapper.countByExample(example);
        return count > 0;
    }

}
