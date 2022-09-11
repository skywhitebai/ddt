package com.sky.ddt.service.impl;

import com.sky.ddt.dao.custom.CustomWorkTaskCreationUserMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.workTaskCreation.req.ListWorkTaskCreationUserReq;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.WorkTaskCreationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author sky
 * @Description
 * @date 2022/9/11 11:37
 */
@Service
public class WorkTaskCreationUserServiceImpl implements WorkTaskCreationUserService {
    @Autowired
    CustomWorkTaskCreationUserMapper customWorkTaskCreationUserMapper;

    @Override
    public BaseResponse listWorkTaskCreationUser(ListWorkTaskCreationUserReq params) {
        if(params.getWorkTaskCreationId()==null){
            return BaseResponse.failMessage("WorkTaskCreationId不能为空");
        }
        WorkTaskCreationUserExample example=new WorkTaskCreationUserExample();
        example.createCriteria().andWorkTaskCreationIdEqualTo(params.getWorkTaskCreationId());
        List<WorkTaskCreationUser> list= customWorkTaskCreationUserMapper.selectByExample(example);
        return BaseResponse.successData(list);
    }

    @Override
    public BaseResponse saveWorkTaskCreationUser(Long workTaskCreationId, List<Long> userIds, Integer dealUserId) {
        if(workTaskCreationId ==null){
            return BaseResponse.failMessage("WorkTaskCreationId不能为空");
        }
        WorkTaskCreationUserExample example = new WorkTaskCreationUserExample();
        example.createCriteria().andWorkTaskCreationIdEqualTo(workTaskCreationId);
        //如果删除了所有菜单，直接删除就好了
        if(CollectionUtils.isEmpty(userIds)){
            customWorkTaskCreationUserMapper.deleteByExample(example);
            return BaseResponse.success();
        }
        //获取所有菜单
        List<WorkTaskCreationUser> list=customWorkTaskCreationUserMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(list)){
            List<Long> existUser=new ArrayList<>();
            Iterator<Long> iterator = userIds.iterator();
            while(iterator.hasNext()){
                Long userId=iterator.next();
                for(WorkTaskCreationUser workTaskCreationUser:list){
                    if(userId.equals(workTaskCreationUser.getUserId())){
                        existUser.add(userId);
                        iterator.remove();
                        break;
                    }
                }
            }
            WorkTaskCreationUserExample exampleDelete = new WorkTaskCreationUserExample();
            if(!CollectionUtils.isEmpty(existUser)){
                exampleDelete.createCriteria().andWorkTaskCreationIdEqualTo(workTaskCreationId).andUserIdNotIn(existUser);
            }else{
                exampleDelete.createCriteria().andWorkTaskCreationIdEqualTo(workTaskCreationId);
            }
            customWorkTaskCreationUserMapper.deleteByExample(exampleDelete);
        }
        for(Long userId:userIds){
            WorkTaskCreationUser workTaskCreationUser=new WorkTaskCreationUser();
            workTaskCreationUser.setUserId(userId);
            workTaskCreationUser.setWorkTaskCreationId(workTaskCreationId);
            workTaskCreationUser.setCreateBy(dealUserId.longValue());
            workTaskCreationUser.setCreateTime(new Date());
            customWorkTaskCreationUserMapper.insertSelective(workTaskCreationUser);
        }
        return BaseResponse.success();
    }
}
