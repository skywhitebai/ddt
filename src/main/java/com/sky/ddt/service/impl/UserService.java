package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.UserConstant;
import com.sky.ddt.dao.custom.CustomUserMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.user.request.UserComboboxRequest;
import com.sky.ddt.dto.user.request.UserListRequest;
import com.sky.ddt.dto.user.request.UserSaveRequest;
import com.sky.ddt.dto.user.response.UserComboboxResponse;
import com.sky.ddt.dto.user.response.UserListResponse;
import com.sky.ddt.entity.User;
import com.sky.ddt.entity.UserExample;
import com.sky.ddt.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    CustomUserMapper customUserMapper;

    @Override
    public PageInfo<UserListResponse> list(UserListRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<UserListResponse> list = customUserMapper.listUser(params);
        PageInfo<UserListResponse> page = new PageInfo<UserListResponse>(list);
        return page;
    }

    @Override
    public BaseResponse save(UserSaveRequest params, Integer dealUserId) {
        //判断参数是否正确
        StringBuilder sbErro = new StringBuilder();
        if (StringUtils.isEmpty(params.getUserName())) {
            sbErro.append(",").append(UserConstant.USERNAME_EMPTY);
        }
        if (StringUtils.isEmpty(params.getMobile())) {
            sbErro.append(",").append(UserConstant.MOBILE_EMPTY);
        }
        if (StringUtils.isEmpty(params.getRealName())) {
            sbErro.append(",").append(UserConstant.REALNAME_EMPTY);
        }
        if (params.getGender() == null) {
            sbErro.append(",").append(UserConstant.GENDER_EMPTY);
        } else if (!UserConstant.GENDER_LIST.contains(params.getGender())) {
            sbErro.append(",").append(UserConstant.GENDER_ERRO);
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
        //判断用户名是否存在
        UserExample example = new UserExample();
        if (params.getUserId() == null) {
            example.createCriteria().andUserNameEqualTo(params.getUserName());
        } else {
            example.createCriteria().andUserNameEqualTo(params.getUserName()).andUserIdNotEqualTo(params.getUserId());
        }
        List<User> list = customUserMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            return BaseResponse.failMessage(UserConstant.USERNAME_EXIST);
        }
        User user = new User();
        BeanUtils.copyProperties(params, user);
        if (params.getUserId() == null) {
            user.setCreateBy(dealUserId);
            user.setCreateTime(new Date());
            user.setPassword(DigestUtils.md5DigestAsHex("123".getBytes()));
            int res = customUserMapper.insert(user);
            //添加成功
            if (res > 0) {
                return BaseResponse.success();
            } else {
                //添加失败
                return BaseResponse.fail();
            }
        } else {
            User userOld = customUserMapper.selectByPrimaryKey(params.getUserId());
            if (userOld == null) {
                return BaseResponse.failMessage(UserConstant.USERID_NOT_EXIST);
            }
            user.setUpdateBy(dealUserId);
            user.setUpdateTime(new Date());
            int res = customUserMapper.updateByPrimaryKeySelective(user);
            //修改成功
            if (res > 0) {
                return BaseResponse.success();
            } else {
                //修改失败
                return BaseResponse.fail();
            }
        }
    }

    @Override
    public BaseResponse delete(List<Integer> userIds, Integer dealUserId) {
        if (userIds == null || userIds.size() == 0) {
            return BaseResponse.success();
        }
        User user = new User();
        user.setStatus(0);
        user.setUpdateTime(new Date());
        user.setUpdateBy(dealUserId);
        UserExample example = new UserExample();
        example.createCriteria().andUserIdIn(userIds);
        int res = customUserMapper.updateByExampleSelective(user, example);
        return BaseResponse.success();
    }

    /**
     * 通过loginToken获取用户
     *
     * @param loginToken
     * @return
     */
    @Override
    public User getUserByLoginToken(String loginToken) {
        UserExample example = new UserExample();
        example.createCriteria().andLoginTokenEqualTo(loginToken);
        List<User> userList = customUserMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(userList)) {
            return null;
        }
        return userList.get(0);
    }

    /**
     * @return
     * @description 用户下拉
     * @author baixueping
     * @date 2019/7/19 15:04
     * @param params
     */
    @Override
    public List<UserComboboxResponse> comboboxlist(UserComboboxRequest params) {
        return customUserMapper.comboboxlist();
    }

    /**
     * @param userId@return
     * @description 判断用户id是否存在
     * @author baixueping
     * @date 2019/7/19 15:25
     */
    @Override
    public boolean exist(Integer userId) {
        if (userId == null) {
            return false;
        }
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdEqualTo(userId);
        return customUserMapper.countByExample(userExample) > 0;
    }

    /**
     * @param userName@return
     * @description 根据用户名获取用户信息
     * @author baixueping
     * @date 2020/1/3 10:21
     */
    @Override
    public User getUserByUserName(String userName) {
        if (StringUtils.isEmpty(userName)) {
            return null;
        }
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(userName);
        List<User> list = customUserMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }
}
