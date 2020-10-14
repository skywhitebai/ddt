package com.sky.ddt.service.impl.sys;

import com.sky.ddt.common.constant.RoleMenuConstant;
import com.sky.ddt.common.exception.NoticeException;
import com.sky.ddt.dao.custom.CustomRoleMenuMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.RoleMenu;
import com.sky.ddt.entity.RoleMenuExample;
import com.sky.ddt.service.sys.IRoleMenuService;
import com.sky.ddt.service.sys.IRoleRightService;
import com.sky.ddt.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author baixueping
 * @description 角色菜单
 * @date 2019/6/21 11:10
 */
@Service
public class RoleMenuService implements IRoleMenuService {
    @Autowired
    CustomRoleMenuMapper customRoleMenuMapper;
    @Autowired
    IRoleRightService roleRightService;
    /**
     * @param roleId
     * @return
     * @description 通过角色id删除角色菜单
     * @author baixueping
     * @date 2019/6/21 11:15
     */
    @Override
    public void deleteByRoleId(Integer roleId) {
        RoleMenuExample example = new RoleMenuExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        customRoleMenuMapper.deleteByExample(example);
    }

    /**
     * @return
     * @description 获取角色菜单
     * @author baixueping
     * @date 2019/6/24 14:09
     * @param roleId
     */
    @Override
    public BaseResponse<List<RoleMenu>> roleMenuList(Integer roleId) {
        if(roleId==null){
            return BaseResponse.success();
        }

        RoleMenuExample example = new RoleMenuExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        List<RoleMenu> list=customRoleMenuMapper.selectByExample(example);

        return BaseResponse.successData(list);
    }

    /**
     * @param roleId
     * @param menuIds
     * @param dealUserId
     * @return
     * @description 保存角色菜单
     * @author baixueping
     * @date 2019/6/24 14:53
     */
    @Override
    public BaseResponse save(Integer roleId, List<Integer> menuIds, Integer dealUserId) {
        if(roleId==null){
            return BaseResponse.failMessage(RoleMenuConstant.ROLE_ID_EMPTY);
        }
        RoleMenuExample example = new RoleMenuExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        //如果删除了所有菜单，直接删除就好了
        if(CollectionUtils.isEmpty(menuIds)){
            customRoleMenuMapper.deleteByExample(example);
            return BaseResponse.success();
        }
        //获取所有菜单
        List<RoleMenu> list=customRoleMenuMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(list)){
            List<Integer> existMenu=new ArrayList<>();
            Iterator<Integer> iterator = menuIds.iterator();
            while(iterator.hasNext()){
                Integer menuId=iterator.next();
                for(RoleMenu roleMenu:list){
                    if(menuId.equals(roleMenu.getMenuId())){
                        existMenu.add(menuId);
                        iterator.remove();
                        break;
                    }
                }
            }
            RoleMenuExample exampleDelete = new RoleMenuExample();
            if(!CollectionUtils.isEmpty(existMenu)){
                exampleDelete.createCriteria().andRoleIdEqualTo(roleId).andMenuIdNotIn(existMenu);
            }else{
                exampleDelete.createCriteria().andRoleIdEqualTo(roleId);
            }
            customRoleMenuMapper.deleteByExample(exampleDelete);
        }
        for(Integer menuId:menuIds){
            RoleMenu roleMenu=new RoleMenu();
            roleMenu.setMenuId(menuId);
            roleMenu.setRoleId(roleId);
            roleMenu.setCreateBy(dealUserId);
            roleMenu.setCreateTime(new Date());
            customRoleMenuMapper.insertSelective(roleMenu);
        }
        return BaseResponse.success();
    }

    /**
     * @param roleId
     * @param menuRightIds
     * @param currentUserId @return
     * @description 保存角色菜单和权限
     * @author baixueping
     * @date 2020/9/27 14:07
     */
    @Override
    public BaseResponse saveRoleMenuRight(Integer roleId, List<String> menuRightIds, Integer currentUserId) {
        if(roleId==null){
            return BaseResponse.failMessage(RoleMenuConstant.ROLE_ID_EMPTY);
        }
        List<Integer> menuIdList=new ArrayList<>();
        List<Integer> rightIdList=new ArrayList<>();
        setMenuRightList(menuIdList,rightIdList,menuRightIds);
        BaseResponse baseResponse=save(roleId,menuIdList,currentUserId);
        if(!baseResponse.isSuccess()){
            return baseResponse;
        }
        baseResponse=roleRightService.saveRoleRight(roleId,rightIdList,currentUserId);
        return baseResponse;
    }

    private void setMenuRightList(List<Integer> menuIdList, List<Integer> rightIdList, List<String> menuRightIds) {
        for (String menuRightId:
                menuRightIds) {
            String[]menuRightArray=menuRightId.split(",");
            if(menuRightArray.length!=2){
                throw new NoticeException("菜单权限id格式错误，必须为menu,id或right,id格式");
            }
            Integer entityId=MathUtil.strToInteger(menuRightArray[1]);
            if(entityId==null){
                throw new NoticeException("菜单权限id格式错误，必须为menu,id或right,id格式");
            }
            if(menuRightArray[0].equals("menu")){
                menuIdList.add(entityId);
            }else if(menuRightArray[0].equals("right")){
                rightIdList.add(entityId);
            }else{
                throw new NoticeException("菜单权限id格式错误，必须为menu,id或right,id格式");
            }
        }
    }
}
