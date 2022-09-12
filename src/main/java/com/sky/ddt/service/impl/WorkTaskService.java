package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.WorkOrderConstant;
import com.sky.ddt.common.constant.WorkTaskConstant;
import com.sky.ddt.dao.custom.CustomUserMapper;
import com.sky.ddt.dao.custom.CustomWorkTaskLogMapper;
import com.sky.ddt.dao.custom.CustomWorkTaskMapper;
import com.sky.ddt.dao.custom.CustomWorkTaskUserMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.workTask.req.AuditWorkTaskReq;
import com.sky.ddt.dto.workTask.req.ListWorkTaskReq;
import com.sky.ddt.dto.workTask.req.SaveWorkTaskReq;
import com.sky.ddt.dto.workTask.resp.ListWorkTaskResp;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.IWorkTaskService;
import com.sky.ddt.service.WorkTaskLogService;
import com.sky.ddt.util.DateUtil;
import com.sky.ddt.util.MathUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

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
    @Autowired
    CustomWorkTaskUserMapper customWorkTaskUserMapper;
    @Autowired
    WorkTaskLogService workTaskLogService;

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
            addWorkTaskUser(params.getChargeUserIds(), workTask.getId(), dealUserId);
            workTaskLogService.addWorkTaskLog(workTask.getId(), "添加任务", dealUserId);
        } else {
            if (!WorkTaskConstant.StatusEnum.contains(params.getStatus())) {
                return BaseResponse.failMessage("状态不存在");
            }
            //还是改成待审核 未审核
            if (WorkOrderConstant.StatusEnum.COMPLETED.getStatus().equals(params.getStatus())) {
                if (StringUtils.isEmpty(params.getSolution())) {
                    return BaseResponse.failMessage("解决方案不能为空");
                }
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
            updateWorkTaskUser(params.getChargeUserIds(), workTask.getId(), dealUserId);
            workTaskLogService.addWorkTaskLog(workTask.getId(), "修改任务", dealUserId);
        }
        return BaseResponse.success();
    }

    private void addWorkTaskUser(String chargeUserIds, Integer workTaskId, Integer dealUserId) {
        String[] userIds = chargeUserIds.split(",");
        for (String userId : userIds) {
            WorkTaskUser workTaskUser = new WorkTaskUser();
            workTaskUser.setUserId(MathUtil.strToInteger(userId));
            workTaskUser.setWorkTaskId(workTaskId);
            workTaskUser.setCreateTime(new Date());
            workTaskUser.setCreateBy(dealUserId);
            customWorkTaskUserMapper.insertSelective(workTaskUser);
        }
    }

    private void updateWorkTaskUser(String chargeUserIds, Integer workTaskId, Integer dealUserId) {
        List<WorkTaskUser> workTaskUserList = listWorkTaskUser(workTaskId);
        String[] userIdStrs = chargeUserIds.split(",");
        List<String> userIds = new ArrayList<>();
        for (String userId:
                userIdStrs) {
            userIds.add(userId);
        }
        if (!CollectionUtils.isEmpty(workTaskUserList)) {
            List<Integer> existUser = new ArrayList<>();
            Iterator<String> iterator = userIds.iterator();
            while (iterator.hasNext()) {
                Integer userId = MathUtil.strToInteger(iterator.next());
                for (WorkTaskUser workTaskUser : workTaskUserList) {
                    if (userId.equals(workTaskUser.getUserId())) {
                        existUser.add(userId);
                        iterator.remove();
                        break;
                    }
                }
            }
            WorkTaskUserExample exampleDelete = new WorkTaskUserExample();
            if (!CollectionUtils.isEmpty(existUser)) {
                exampleDelete.createCriteria().andWorkTaskIdEqualTo(workTaskId).andUserIdNotIn(existUser);
            } else {
                exampleDelete.createCriteria().andWorkTaskIdEqualTo(workTaskId);
            }
            customWorkTaskUserMapper.deleteByExample(exampleDelete);
        }
        for (String userId : userIds) {
            WorkTaskUser workTaskUser = new WorkTaskUser();
            workTaskUser.setUserId(MathUtil.strToInteger(userId));
            workTaskUser.setWorkTaskId(workTaskId);
            workTaskUser.setCreateTime(new Date());
            workTaskUser.setCreateBy(dealUserId);
            customWorkTaskUserMapper.insertSelective(workTaskUser);
        }
    }

    private List<WorkTaskUser> listWorkTaskUser(Integer workTaskId) {
        WorkTaskUserExample example = new WorkTaskUserExample();
        example.createCriteria().andWorkTaskIdEqualTo(workTaskId);
        return customWorkTaskUserMapper.selectByExample(example);
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

    @Override
    public BaseResponse auditWorkTask(AuditWorkTaskReq params, Integer dealUserId) {
        WorkTaskWithBLOBs workTask = customWorkTaskMapper.selectByPrimaryKey(params.getWorkTaskId());
        if (workTask == null) {
            return BaseResponse.failMessage("任务不存在");
        }
        workTask.setAuditStatus(params.getAuditStatus());
        workTask.setAuditContent(params.getAuditContent());
        workTask.setUpdateBy(dealUserId);
        workTask.setUpdateTime(new Date());
        String content = "";
        if (WorkTaskConstant.AuditStatusEnum.AUDIT.getAuditStatus().equals(params.getAuditStatus())) {
            //审核通过
            workTask.setStatus(WorkTaskConstant.StatusEnum.COMPLETED.getStatus());
            if (workTask.getActualEndTime() == null) {
                workTask.setActualEndTime(new Date());
            }
            content = "审核通过";
        } else if (WorkTaskConstant.AuditStatusEnum.NOT_AUDIT.getAuditStatus().equals(params.getAuditStatus())) {
            //审核不通过
            workTask.setStatus(WorkTaskConstant.StatusEnum.WAIT_AUDIT.getStatus());
            content = "审核不通过";
        }
        customWorkTaskMapper.updateByPrimaryKeySelective(workTask);
        workTaskLogService.addWorkTaskLog(params.getWorkTaskId(), content, dealUserId);
        return BaseResponse.success();
    }

    private boolean existWorkTaskNo(String worderTaskNo) {
        WorkTaskExample example = new WorkTaskExample();
        example.createCriteria().andWorkTaskNoEqualTo(worderTaskNo);
        Long count = customWorkTaskMapper.countByExample(example);
        return count > 0;
    }

}
