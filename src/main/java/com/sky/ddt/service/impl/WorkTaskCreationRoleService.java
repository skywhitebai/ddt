package com.sky.ddt.service.impl;

import com.sky.ddt.dao.custom.CustomWorkTaskCreationRoleMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.workTaskCreation.req.ListWorkTaskCreationRoleReq;
import com.sky.ddt.entity.WorkTaskCreationRole;
import com.sky.ddt.entity.WorkTaskCreationRoleExample;
import com.sky.ddt.entity.WorkTaskCreationUser;
import com.sky.ddt.entity.WorkTaskCreationUserExample;
import com.sky.ddt.service.IWorkTaskCreationRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author sky
 * @Description TODO
 * @date 2022/12/17 21:11
 */
@Service
public class WorkTaskCreationRoleService implements IWorkTaskCreationRoleService {
    @Autowired
    CustomWorkTaskCreationRoleMapper customWorkTaskCreationRoleMapper;
    @Override
    public BaseResponse listWorkTaskCreationRole(ListWorkTaskCreationRoleReq params) {
        if(params.getWorkTaskCreationId()==null){
            return BaseResponse.failMessage("WorkTaskCreationId不能为空");
        }
        WorkTaskCreationRoleExample example=new WorkTaskCreationRoleExample();
        example.createCriteria().andWorkTaskCreationIdEqualTo(params.getWorkTaskCreationId());
        List<WorkTaskCreationRole> list= customWorkTaskCreationRoleMapper.selectByExample(example);
        return BaseResponse.successData(list);
    }

    @Override
    public BaseResponse saveWorkTaskCreationRole(Long workTaskCreationId, List<Long> roleIds, Integer dealUserId) {
        if(workTaskCreationId ==null){
            return BaseResponse.failMessage("WorkTaskCreationId不能为空");
        }
        WorkTaskCreationRoleExample example = new WorkTaskCreationRoleExample();
        example.createCriteria().andWorkTaskCreationIdEqualTo(workTaskCreationId);
        //如果删除了所有菜单，直接删除就好了
        if(CollectionUtils.isEmpty(roleIds)){
            customWorkTaskCreationRoleMapper.deleteByExample(example);
            return BaseResponse.success();
        }
        //获取所有
        List<WorkTaskCreationRole> list=customWorkTaskCreationRoleMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(list)){
            List<Long> existRole=new ArrayList<>();
            Iterator<Long> iterator = roleIds.iterator();
            while(iterator.hasNext()){
                Long roleId=iterator.next();
                for(WorkTaskCreationRole workTaskCreationRole:list){
                    if(roleId.equals(workTaskCreationRole.getRoleId())){
                        existRole.add(roleId);
                        iterator.remove();
                        break;
                    }
                }
            }
            WorkTaskCreationRoleExample exampleDelete = new WorkTaskCreationRoleExample();
            if(!CollectionUtils.isEmpty(existRole)){
                exampleDelete.createCriteria().andWorkTaskCreationIdEqualTo(workTaskCreationId).andRoleIdNotIn(existRole);
            }else{
                exampleDelete.createCriteria().andWorkTaskCreationIdEqualTo(workTaskCreationId);
            }
            customWorkTaskCreationRoleMapper.deleteByExample(exampleDelete);
        }
        for(Long roleId:roleIds){
            WorkTaskCreationRole workTaskCreationRole=new WorkTaskCreationRole();
            workTaskCreationRole.setRoleId(roleId);
            workTaskCreationRole.setWorkTaskCreationId(workTaskCreationId);
            workTaskCreationRole.setCreateBy(dealUserId.longValue());
            workTaskCreationRole.setCreateTime(new Date());
            customWorkTaskCreationRoleMapper.insertSelective(workTaskCreationRole);
        }
        return BaseResponse.success();
    }
}
