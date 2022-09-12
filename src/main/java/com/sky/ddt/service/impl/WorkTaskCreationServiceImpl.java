package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.WorkTaskConstant;
import com.sky.ddt.common.constant.WorkTaskCreationConstant;
import com.sky.ddt.dao.custom.CustomWorkTaskCreationMapper;
import com.sky.ddt.dao.custom.CustomWorkTaskCreationUserMapper;
import com.sky.ddt.dao.custom.CustomWorkTaskMapper;
import com.sky.ddt.dao.custom.CustomWorkTaskUserMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.workTaskCreation.req.ListWorkTaskCreationReq;
import com.sky.ddt.dto.workTaskCreation.req.SaveWorkTaskCreationReq;
import com.sky.ddt.dto.workTaskCreation.resp.ListWorkTaskCreationResp;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.WorkTaskCreationService;
import com.sky.ddt.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @Description
 * @date 2022/9/10 16:13
 */
@Service
public class WorkTaskCreationServiceImpl implements WorkTaskCreationService {
    @Autowired
    CustomWorkTaskCreationMapper customWorkTaskCreationMapper;
    @Autowired
    CustomWorkTaskCreationUserMapper customWorkTaskCreationUserMapper;
    @Autowired
    WorkTaskService workTaskService;
    @Autowired
    CustomWorkTaskMapper customWorkTaskMapper;
    @Autowired
    CustomWorkTaskUserMapper customWorkTaskUserMapper;

    @Override
    public PageInfo<ListWorkTaskCreationResp> listWorkTaskCreation(ListWorkTaskCreationReq params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListWorkTaskCreationResp> list = customWorkTaskCreationMapper.listWorkTaskCreation(params);
        PageInfo<ListWorkTaskCreationResp> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public BaseResponse saveWorkTaskCreation(SaveWorkTaskCreationReq params, Integer dealUserId) {
        WorkTaskCreation workTaskCreationExist = null;
        if (params.getId() != null) {
            workTaskCreationExist = customWorkTaskCreationMapper.selectByPrimaryKey(params.getId());
            if (workTaskCreationExist == null) {
                return BaseResponse.failMessage("id不存在");
            }
        }
        if (!WorkTaskConstant.LevelEnum.contains(params.getLevel())) {
            return BaseResponse.failMessage("处理级别不存在");
        }
        WorkTaskCreation workTaskCreation = new WorkTaskCreation();
        BeanUtils.copyProperties(params, workTaskCreation);
        if (params.getId() == null) {
            workTaskCreation.setCreateBy(dealUserId);
            workTaskCreation.setCreateTime(new Date());
            workTaskCreation.setDealTime(DateUtil.baseDate);
            workTaskCreation.setStatus(WorkTaskCreationConstant.StatusEnum.ENABLE.getStatus());
            customWorkTaskCreationMapper.insertSelective(workTaskCreation);
        } else {
            if (!WorkTaskCreationConstant.StatusEnum.contains(params.getStatus())) {
                return BaseResponse.failMessage("状态不存在");
            }
            workTaskCreation.setUpdateBy(dealUserId);
            workTaskCreation.setUpdateTime(new Date());
            customWorkTaskCreationMapper.updateByPrimaryKeySelective(workTaskCreation);
        }
        return BaseResponse.success();
    }

    @Override
    public BaseResponse cancelWorkTaskCreation(Integer id, Integer dealUserId) {
        if (id == null) {
            return BaseResponse.failMessage("id不能为空");
        }
        WorkTaskCreation workTaskCreation = customWorkTaskCreationMapper.selectByPrimaryKey(id);
        if (workTaskCreation == null) {
            return BaseResponse.failMessage("id不存在");
        }
        WorkTaskCreation workTaskCreationUpdate = new WorkTaskCreation();
        workTaskCreationUpdate.setId(id);
        workTaskCreationUpdate.setUpdateBy(dealUserId);
        workTaskCreationUpdate.setUpdateTime(new Date());
        workTaskCreationUpdate.setStatus(WorkTaskCreationConstant.StatusEnum.CANCEL.getStatus());
        customWorkTaskCreationMapper.updateByPrimaryKeySelective(workTaskCreationUpdate);
        return BaseResponse.success();
    }

    @Override
    public void workTaskCreation() {
        //获取所有有效的任务信息
        List<WorkTaskCreation> workTaskCreationList = listEnableWorkTaskCreation();
        if (CollectionUtils.isEmpty(workTaskCreationList)) {
            return;
        }
        for (WorkTaskCreation workTaskCreation :
                workTaskCreationList) {
            workTaskCreation(workTaskCreation);
        }
    }

    private void workTaskCreation(WorkTaskCreation workTaskCreation) {
        Date dayNow = DateUtil.getToday();
        /*if (!HolidayUtil.isWorKDay(dayNow)) {
            //只有工作日执行
            return;
        }*/
        //判断是否已生成
        if (WorkTaskCreationConstant.TypeEnum.DAY.getType().equals(workTaskCreation.getType())) {
            if (workTaskCreation.getDealTime().after(dayNow)) {
                //已经执行了，则返回
                return;
            }
        } else if (WorkTaskCreationConstant.TypeEnum.WEEK.getType().equals(workTaskCreation.getType())) {
            //获取星期一的时间
            Date monday = DateUtil.getWeekMonday(dayNow);
            if (workTaskCreation.getDealTime().after(monday)) {
                //已经执行了，则返回
                return;
            }
        } else if (WorkTaskCreationConstant.TypeEnum.MONTH.getType().equals(workTaskCreation.getType())) {
            //获取本月一号的时间
            Date monthFirstDay = DateUtil.getMonthFirstDay(dayNow);
            if (workTaskCreation.getDealTime().after(monthFirstDay)) {
                //已经执行了，则返回
                return;
            }
        }else{
            //类型错误
            return;
        }
        //获取负责人信息

        List<WorkTaskCreationUser> workTaskCreationUserList = listWorkTaskCreationUser(workTaskCreation.getId());
        if (!CollectionUtils.isEmpty(workTaskCreationUserList)) {
            for (WorkTaskCreationUser workTaskCreationUser :
                    workTaskCreationUserList) {
                WorkTaskWithBLOBs workTask = new WorkTaskWithBLOBs();
                workTask.setTitle(workTaskCreation.getTitle());
                workTask.setWorkTaskNo(workTaskService.getWorderTaskNo());
                workTask.setContent(workTaskCreation.getContent());
                workTask.setLevel(workTaskCreation.getLevel());
                workTask.setStatus(WorkTaskConstant.StatusEnum.HAVE_IN_HAND.getStatus());
                workTask.setBeginTime(new Date());
                workTask.setEndTime(getEndTime(workTaskCreation.getType(), dayNow));
                workTask.setDealStatus(WorkTaskConstant.DealStatusEnum.UN_DEAL.getDealStatus());
                if(WorkTaskCreationConstant.NeedAuditEnum.NEED.getStatus().equals(workTaskCreation.getNeedAudit())){
                    workTask.setAuditStatus(WorkTaskConstant.AuditStatusEnum.WAIT_AUDIT.getAuditStatus());
                }else{
                    workTask.setAuditStatus(WorkTaskConstant.AuditStatusEnum.NO_NEED.getAuditStatus());
                }
                workTask.setCreateTime(new Date());
                workTask.setCreateBy(0);
                customWorkTaskMapper.insertSelective(workTask);
                WorkTaskUser workTaskUser=new WorkTaskUser();
                workTaskUser.setCreateTime(new Date());
                workTaskUser.setUserId(workTaskCreationUser.getUserId().intValue());
                workTaskUser.setWorkTaskId(workTask.getId());
                workTaskUser.setCreateBy(0);
                customWorkTaskUserMapper.insertSelective(workTaskUser);
            }
        }

        workTaskCreation.setDealTime(new Date());
        customWorkTaskCreationMapper.updateByPrimaryKey(workTaskCreation);
    }

    private Date getEndTime(Integer type, Date dayNow) {
        Date endTime = null;
        if (WorkTaskCreationConstant.TypeEnum.DAY.getType().equals(type)) {
            endTime = DateUtil.plusHour(19, dayNow);//晚上7点结束

        } else if (WorkTaskCreationConstant.TypeEnum.WEEK.getType().equals(type)) {
            Date monday = DateUtil.getWeekMonday(dayNow);
            endTime = DateUtil.plusHour(19, DateUtil.plusDay(6, monday));//周六晚上7点结束
        } else if (WorkTaskCreationConstant.TypeEnum.MONTH.getType().equals(type)) {
            //获取本月一号的时间
            Date monthFirstDay = DateUtil.getMonthFirstDay(dayNow);
            endTime = DateUtil.plusHour(19, DateUtil.plusDay(-1, DateUtil.plusMonth(1, monthFirstDay)));//周六晚上7点结束
        }
        return endTime;
    }

    private List<WorkTaskCreationUser> listWorkTaskCreationUser(Integer id) {
        WorkTaskCreationUserExample example = new WorkTaskCreationUserExample();
        example.createCriteria().andWorkTaskCreationIdEqualTo(id.longValue());
        return customWorkTaskCreationUserMapper.selectByExample(example);
    }

    private List<WorkTaskCreation> listEnableWorkTaskCreation() {
        Date dayNow = DateUtil.getToday();
        WorkTaskCreationExample example = new WorkTaskCreationExample();
        example.createCriteria().andStatusEqualTo(WorkTaskCreationConstant.StatusEnum.ENABLE.getStatus())
                .andBeginTimeLessThanOrEqualTo(dayNow).andEndTimeGreaterThanOrEqualTo(dayNow);
        return customWorkTaskCreationMapper.selectByExampleWithBLOBs(example);
    }
}
