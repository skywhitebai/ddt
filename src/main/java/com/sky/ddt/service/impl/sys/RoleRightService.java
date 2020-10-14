package com.sky.ddt.service.impl.sys;

import com.sky.ddt.common.constant.RoleMenuConstant;
import com.sky.ddt.dao.custom.CustomRoleRightMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.RoleRight;
import com.sky.ddt.entity.RoleRightExample;
import com.sky.ddt.service.sys.IRoleRightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author baixueping
 * @description 角色权限
 * @date 2020/9/22 18:52
 */
@Service
public class RoleRightService implements IRoleRightService {
    @Autowired
    CustomRoleRightMapper customRoleRightMapper;

    @Override
    public void deleteByRightId(Integer rightId) {
        if(rightId==null){
            return;
        }
        RoleRightExample example=new RoleRightExample();
        example.createCriteria().andRightIdEqualTo(rightId);
        customRoleRightMapper.deleteByExample(example);
    }

    @Override
    public BaseResponse<List<RoleRight>> roleRightList(Integer roleId) {
        if(roleId==null){
            return BaseResponse.success();
        }

        RoleRightExample example = new RoleRightExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        List<RoleRight> list=customRoleRightMapper.selectByExample(example);

        return BaseResponse.successData(list);
    }

    @Override
    public BaseResponse saveRoleRight(Integer roleId, List<Integer> rightIdList, Integer dealUserId) {
        if(roleId==null){
            return BaseResponse.failMessage(RoleMenuConstant.ROLE_ID_EMPTY);
        }
        RoleRightExample example = new RoleRightExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        //如果删除了所有菜单，直接删除就好了
        if(CollectionUtils.isEmpty(rightIdList)){
            customRoleRightMapper.deleteByExample(example);
            return BaseResponse.success();
        }
        //获取所有菜单
        List<RoleRight> list=customRoleRightMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(list)){
            List<Integer> existRight=new ArrayList<>();
            Iterator<Integer> iterator = rightIdList.iterator();
            while(iterator.hasNext()){
                Integer rightId=iterator.next();
                for(RoleRight roleRight:list){
                    if(rightId.equals(roleRight.getRightId())){
                        existRight.add(rightId);
                        iterator.remove();
                        break;
                    }
                }
            }
            RoleRightExample exampleDelete = new RoleRightExample();
            if(!CollectionUtils.isEmpty(existRight)){
                exampleDelete.createCriteria().andRoleIdEqualTo(roleId).andRightIdNotIn(existRight);
            }else{
                exampleDelete.createCriteria().andRoleIdEqualTo(roleId);
            }
            customRoleRightMapper.deleteByExample(exampleDelete);
        }
        for(Integer rightId:rightIdList){
            RoleRight roleRight=new RoleRight();
            roleRight.setRightId(rightId);
            roleRight.setRoleId(roleId);
            roleRight.setCreateBy(dealUserId);
            roleRight.setCreateTime(new Date());
            customRoleRightMapper.insertSelective(roleRight);
        }
        return BaseResponse.success();
    }
}
