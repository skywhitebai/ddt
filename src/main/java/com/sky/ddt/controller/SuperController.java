package com.sky.ddt.controller;

import com.sky.ddt.common.login.CurrentUserInfo;
import com.sky.ddt.common.login.LoginHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SuperController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    @Autowired
    protected HttpSession session;
    @Autowired
    LoginHelper loginHelper;

   public CurrentUserInfo getCurrentUserInfo(){
       CurrentUserInfo currentUserInfo= loginHelper.getCurrentUserInfo(request);
       return currentUserInfo;
    }
    public Integer  getCurrentUserId(){
       return loginHelper.getCurrentUserId(request);
    }
}
