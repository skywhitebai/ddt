package com.sky.ddt.service.impl;

import com.sky.ddt.common.constant.AccountConstant;
import com.sky.ddt.common.constant.UserConstant;
import com.sky.ddt.common.enums.response.AccountEnum;
import com.sky.ddt.common.login.CurrentUserInfo;
import com.sky.ddt.dao.custom.CustomUserMapper;
import com.sky.ddt.dto.account.request.ChangePasswordRequest;
import com.sky.ddt.dto.account.request.LoginRequest;
import com.sky.ddt.dto.account.request.ResetPasswordRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.response.ErroResponse;
import com.sky.ddt.dto.sys.right.request.UserRightListRequest;
import com.sky.ddt.entity.User;
import com.sky.ddt.entity.UserExample;
import com.sky.ddt.service.IAccountService;
import com.sky.ddt.service.sys.IMenuService;
import com.sky.ddt.service.sys.IRightService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AccountService implements IAccountService {
    @Autowired
    CustomUserMapper customUserMapper;
    @Autowired
    IMenuService menuService;
    @Autowired
    IRightService rightService;
    @Override
    public BaseResponse login(LoginRequest params) {
        return getLoginResponse(params,"login");
    }

    private BaseResponse getLoginResponse(LoginRequest params, String type) {
        List<ErroResponse> errolist=new ArrayList<ErroResponse>();
        if(StringUtils.isEmpty(params.getUserName())){
            errolist.add(ErroResponse.erroEnum(AccountEnum.LOGIN_USER_NAME_EMPTY));
        }
        if(StringUtils.isEmpty(params.getPassword())){
            errolist.add(ErroResponse.erroEnum(AccountEnum.LOGIN_PASSWORD_EMPTY));
        }
        if(errolist.size()>0){
            return BaseResponse.fail(errolist);
        }
        UserExample userExample=new UserExample();
        userExample.createCriteria().andUserNameEqualTo(params.getUserName());
        List<User> userList= customUserMapper.selectByExample(userExample);
        if(userList.size()==0){
            errolist.add(ErroResponse.erroEnum(AccountEnum.LOGIN_USER_NAME_NOT_EXIST));
            return BaseResponse.fail(errolist);
        }
        User user=userList.get(0);
        if(!DigestUtils.md5DigestAsHex(params.getPassword().getBytes()).equals(user.getPassword())){
            errolist.add(ErroResponse.erroEnum(AccountEnum.LOGIN_PASSWORD_ERRO));
            return BaseResponse.fail(errolist);
        }
        if(!UserConstant.STATUS_ENABLE.equals(user.getStatus())){
            errolist.add(ErroResponse.erroEnum(AccountEnum.USER_DISABLE));
            return BaseResponse.fail(errolist);
        }
        User userUpdate=new User();
        userUpdate.setLastLoginTime(new Date());
        if(user.getLoginTimes()==null||user.getLoginTimes()<=0){
            userUpdate.setLoginTimes(1);
        }else{
            userUpdate.setLoginTimes(user.getLoginTimes()+1);
        }
        if("clientLogin".equals(type)){
            String loginToken=user.getUserId()+"---"+ UUID.randomUUID();
            userUpdate.setLoginToken(loginToken);
            user.setLoginToken(loginToken);
        }
        userUpdate.setUserId(user.getUserId());
        customUserMapper.updateByPrimaryKeySelective(userUpdate);
        CurrentUserInfo currentUserInfo=new CurrentUserInfo();
        BeanUtils.copyProperties(user,currentUserInfo);
        currentUserInfo.setMenuUrlList(getMenuUrlList(currentUserInfo.getUserId()));
        currentUserInfo.setRightStrList(getRightStrList(currentUserInfo.getUserId()));
        return BaseResponse.successData(currentUserInfo);
    }

    private List<String> getMenuUrlList(Integer userId) {
        return  menuService.userMenuUrlList(userId);
    }
    private List<String> getRightStrList(Integer userId) {
        UserRightListRequest userRightListRequest=new UserRightListRequest();
        userRightListRequest.setUserId(userId);
        BaseResponse baseResponse=rightService.userRightList(userRightListRequest);
        if(baseResponse.isSuccess()){
            return (List<String>) baseResponse.getData();
        }
        return new ArrayList<>();
    }

    @Override
    public BaseResponse changePassword(ChangePasswordRequest params, Integer currentUserId) {
        StringBuilder sbErro=new StringBuilder();
        if(StringUtils.isEmpty(params.getOldPassword())){
            sbErro.append(",").append(AccountConstant.OLD_PASSWORD_EMPTY);
        }
        if(StringUtils.isEmpty(params.getPassword())){
            sbErro.append(",").append(AccountConstant.PASSWORD_EMPTY);
        }
        if(StringUtils.isEmpty(params.getConfirmPassword())){
            sbErro.append(",").append(AccountConstant.CONFIRM_PASSWORD_EMPTY);
        }
        if(!params.getPassword().equals(params.getConfirmPassword())){
            sbErro.append(",").append(AccountConstant.CONFIRM_PASSWORD_ERRO);
        }
        if(sbErro.length()>0){
            return BaseResponse.failMessage(sbErro.substring(1));
        }
        User user= customUserMapper.selectByPrimaryKey(currentUserId);
        if(user==null){
            return BaseResponse.failMessage(AccountConstant.USERID_NOT_EXIST);
        }
        if(!DigestUtils.md5DigestAsHex(params.getOldPassword().getBytes()).equals(user.getPassword())){
            return BaseResponse.failMessage(AccountConstant.OLD_PASSWORD_ERRO);
        }
        User userUpdate=new User();
        userUpdate.setUserId(currentUserId);
        userUpdate.setPassword(DigestUtils.md5DigestAsHex(params.getPassword().getBytes()));
        int res= customUserMapper.updateByPrimaryKeySelective(userUpdate);
        if(res>0){
            return  BaseResponse.success();
        }else{
            return BaseResponse.fail();
        }
    }

    /**
     * 客户端登录
     *
     * @param params
     * @return
     */
    @Override
    public BaseResponse clientLogin(LoginRequest params) {
        return getLoginResponse(params,"clientLogin");
    }

    /**
     * @param params
     * @param currentUserId
     * @return
     * @description 重置密码
     * @author baixueping
     * @date 2019/7/12 16:15
     */
    @Override
    public BaseResponse resetPassword(ResetPasswordRequest params, Integer currentUserId) {
        User user=new User();
        user.setPassword(DigestUtils.md5DigestAsHex(params.getNewPassword().getBytes()));
        user.setUserId(params.getUserId());
        user.setUpdateTime(new Date());
        user.setUpdateBy(currentUserId);
        customUserMapper.updateByPrimaryKeySelective(user);
        return BaseResponse.success();
    }
}
