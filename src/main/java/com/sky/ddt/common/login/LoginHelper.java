package com.sky.ddt.common.login;

import com.sky.ddt.common.constant.BaseConstant;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.User;
import com.sky.ddt.service.IAccountService;
import com.sky.ddt.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class LoginHelper {
    @Autowired
    IAccountService accountService;
    @Autowired
    IUserService userService;
    private static final Logger logger = LoggerFactory.getLogger(LoginHelper.class);

    /**
     * 获取登录用户信息
     * @param request
     * @return
     */
    public CurrentUserInfo getCurrentUserInfo(HttpServletRequest request) {
        CurrentUserInfo currentUserInfo=getCurrentUserInfoBySession(request);
        if (currentUserInfo!=null){
            return currentUserInfo;
        }
        currentUserInfo=getCurrentUserInfoByLoginToken(request);
        return currentUserInfo;
    }

    /**
     * 通过loginToken获取登录用户信息
     * @param request
     * @return
     */
    private CurrentUserInfo getCurrentUserInfoByLoginToken(HttpServletRequest request) {
        String loginToken=getToken(request);
        if(StringUtils.isEmpty(loginToken)){
            return null;
        }
        User user=userService.getUserByLoginToken(loginToken);
        if(user==null){
            return null;
        }
        CurrentUserInfo currentUserInfo=new CurrentUserInfo();
        BeanUtils.copyProperties(user,currentUserInfo);
        //session里面添加currentUserInfo信息防止需要重复获取用户信息
        request.getSession().setAttribute(BaseConstant.LOGIN_NAME, currentUserInfo);
        return currentUserInfo;
    }

    /**
     * 通过session获取当前用户信息
     * @param request
     * @return
     */
    private CurrentUserInfo getCurrentUserInfoBySession(HttpServletRequest request){
        //通过网页登录的话从session里面拿loginToken
        HttpSession httpSession = request.getSession();
        Object object = httpSession.getAttribute(BaseConstant.LOGIN_NAME);
        if (object == null) {
            return null;
        }
        try {
            return (CurrentUserInfo) object;
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("获取session错误,{}", ex);
            return null;
        }
    }

    /**
     * 获取用户ID
     */
    public Integer getCurrentUserId(HttpServletRequest request) {
        Integer currentUserId=getCurrentUserIdBySession(request);
        if(currentUserId!=null){
            return currentUserId;
        }
        currentUserId=getCurrentUserIdByLoginToken(request);
        return currentUserId;
    }

    /**
     * 通过session获取当前用户id
     * @param request
     * @return
     */
    private Integer getCurrentUserIdBySession(HttpServletRequest request) {
        CurrentUserInfo currentUserInfo=getCurrentUserInfoBySession(request);
        if(currentUserInfo==null){
            return null;
        }else {
            return  currentUserInfo.getUserId();
        }
    }
    /**
     * 通过LoginToken获取当前用户id
     * @param request
     * @return
     */
    private Integer getCurrentUserIdByLoginToken(HttpServletRequest request) {
        String loginToken = getToken(request);
        if (StringUtils.isEmpty(loginToken)) {
            return null;
        }
        return getCurrentUserId(loginToken);
    }
    /**
     * 通过LoginToken获取当前用户id
     * @param loginToken
     * @return
     */
    private Integer getCurrentUserId(String loginToken) {
        User user=userService.getUserByLoginToken(loginToken);
        if(user==null){
            return null;
        }
        return user.getUserId();
    }
    /**
     * 获取LoginToken
     * @param request
     * @return
     */
    private String getToken(HttpServletRequest request) {
        String loginToken = request.getHeader(BaseConstant.LOGIN_NAME);
        if (StringUtils.isEmpty(loginToken)) {
            loginToken = request.getParameter(BaseConstant.LOGIN_NAME);
            if (!StringUtils.isEmpty(loginToken)) {
                request.setAttribute(BaseConstant.LOGIN_NAME, loginToken);
            }
        }
        if (StringUtils.isEmpty(loginToken)) {
            Object token = request.getAttribute(BaseConstant.LOGIN_NAME);
            if (token != null) {
                loginToken = token.toString();
            }
        }
        if (!StringUtils.isEmpty(loginToken)) {
            logger.info("loginToken：{}", loginToken.toString());
            return loginToken.toString();
        } else {
            logger.info("loginToken：null");
            return loginToken;
        }
    }

}
