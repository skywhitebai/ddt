package com.sky.ddt.controller;

import java.util.Date;

import com.sky.ddt.common.annotation.Action;
import com.sky.ddt.common.annotation.Log;
import com.sky.ddt.common.annotation.Login;
import com.sky.ddt.common.constant.BaseConstant;
import com.sky.ddt.common.login.CurrentUserInfo;
import com.sky.ddt.dto.account.request.ChangePasswordRequest;
import com.sky.ddt.dto.account.request.LoginRequest;
import com.sky.ddt.dto.account.request.ResetPasswordRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("account")
public class AccountController extends SuperController {

	@Autowired
	IAccountService accountService;
	@RequestMapping("test")
	@ResponseBody
	public String test() {
		return "test Date:"+new Date();
	}

	@RequestMapping("/noMenuRight")
	public String noMenuRight(){
		return "account/noMenuRight";
	}
	@RequestMapping("/noRight")
	public String noRight(){
		return "account/noRight";
	}

	@RequestMapping("dologin")
	@Login(action = Action.Skip )
	@ResponseBody
	public BaseResponse dologin(LoginRequest params) {
		BaseResponse baseResponse=accountService.login(params);
		if(!BaseResponse.SUCCESS_CODE.equals(baseResponse.getCode())){
			return baseResponse;
		}
		// 把用户数据保存在session域对象中
		session.setAttribute(BaseConstant.LOGIN_NAME, baseResponse.getData());
		return baseResponse;
	}
	@RequestMapping("clientLogin")
	@Login(action = Action.Skip )
	@ResponseBody
	public BaseResponse clientLogin(LoginRequest params) {
		return accountService.clientLogin(params);
	}
	@RequestMapping("login")
	@Login(action = Action.Skip )
	@Log("登录")
	public String login(){
		return "account/login";
	}

	@RequestMapping("test1")
	@ResponseBody
	public String test1(){
		response.setContentType("text/plain;charset=UTF-8");

		response.setCharacterEncoding("UTF-8");
		logger.info(new Date().toString());
		return "上九天揽月，下五洲捉鳖";
	}
	@RequestMapping("getCurrentUser")
	@ResponseBody
	public BaseResponse getCurrentUser(){
		CurrentUserInfo currentUserInfo=getCurrentUserInfo();
		return  BaseResponse.successData(currentUserInfo);
	}
	@RequestMapping("changePassword")
	@ResponseBody
	public BaseResponse changePassword(ChangePasswordRequest params){
		Integer currentUserId=getCurrentUserId();
		return  accountService.changePassword(params,currentUserId);
	}
	@RequestMapping("logOut")
	@ResponseBody
	public BaseResponse logOut(){
		session.removeAttribute(BaseConstant.LOGIN_NAME);
		return BaseResponse.success();
	}
	@RequestMapping("/resetPassword")
	@ResponseBody
	public BaseResponse resetPassword(@Validated ResetPasswordRequest params){
		Integer currentUserId=getCurrentUserId();
		return  accountService.resetPassword(params,currentUserId);
	}

}
