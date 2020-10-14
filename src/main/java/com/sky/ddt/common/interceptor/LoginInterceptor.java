package com.sky.ddt.common.interceptor;
import com.sky.ddt.common.annotation.Action;
import com.sky.ddt.common.annotation.Login;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.common.annotation.RightAnnotation;
import com.sky.ddt.common.enums.response.AccountEnum;
import com.sky.ddt.common.login.CurrentUserInfo;
import com.sky.ddt.common.login.LoginHelper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.sys.IMenuService;
import com.sky.ddt.service.sys.IRightService;
import com.sky.ddt.util.HttpUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * 登录拦截器，做登录校验
 * @author Administrator
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	LoginHelper loginHelper;
	@Autowired
	IMenuService menuService;
	@Autowired
	IRightService rightService;
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	/**
	 * 登录权限验证
	 * <p>
	 * 方法拦截 Controller 处理之前进行调用。
	 * </p>
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/**
		 * 处理 Controller 方法
		 * <p>
		 * 判断 handler 是否为 HandlerMethod 实例
		 * </p>
		 */
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			Boolean needLogin = false;
			Boolean needMenu = false;
			Boolean needRight = false;
			Login login = method.getAnnotation(Login.class);
			if (login == null||login.action() != Action.Skip) {
				needLogin=true;
			}
			MenuAnnotation menuAnnotation=method.getAnnotation(MenuAnnotation.class);
			if (menuAnnotation != null&&!StringUtils.isEmpty(menuAnnotation.value())) {
				needMenu=true;
			}
			RightAnnotation rightAnnotation=method.getAnnotation(RightAnnotation.class);
			if (rightAnnotation != null&&!StringUtils.isEmpty(rightAnnotation.value())) {
				needRight=true;
			}
			if (needLogin == false && needMenu == false && needRight == false) {
				return true;
			}
			/**
			 * 正常执行 判断是否登录
			 */
			CurrentUserInfo currentUserInfo= loginHelper.getCurrentUserInfo(request);
			if(currentUserInfo==null){
				if ( HttpUtil.isAjax(request) ) {
					getUnLoginReponse(response);
				}
				else{
					//String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
					String contextPath= request.getContextPath();
					if(StringUtils.isEmpty(contextPath)){
						String loginUrl="/account/login";
						if(!request.getRequestURI().equals("")&&!request.getRequestURI().equals("index")&&!request.getRequestURI().equals("/")){
							loginUrl+="?backUrl="+request.getRequestURI();
						}
						response.sendRedirect(loginUrl);
					}
					else{
						response.sendRedirect(contextPath+"/account/login");
					}
				}
				return false;
			}
			if(needMenu){
				String menu=menuAnnotation.value();
				if(!currentUserInfo.hasMenuUrl(menu)){
					if ( HttpUtil.isAjax(request) ) {
						getUnMenuRightReponse(response);
					}
					else{
						String contextPath= request.getContextPath();
						if(StringUtils.isEmpty(contextPath)){
							String loginUrl="/account/noMenuRight";
							response.sendRedirect(loginUrl);
						}
						else{
							response.sendRedirect(contextPath+"/account/noMenuRight");
						}
					}
					return false;
				}
			}
			if(needRight){
				String right=rightAnnotation.value();
				if(!currentUserInfo.hasRightStr(right)){
					if ( HttpUtil.isAjax(request) ) {
						getUnRightReponse(response);
					}
					else{
						String contextPath= request.getContextPath();
						if(StringUtils.isEmpty(contextPath)){
							String loginUrl="/account/noRight";
							response.sendRedirect(loginUrl);
						}
						else{
							response.sendRedirect(contextPath+"/account/noRight");
						}
					}
					return false;
				}
			}
			return true;
		}

		/**
		 * 通过拦截
		 */
		return true;
	}

	private void getUnMenuRightReponse(HttpServletResponse response)throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setStatus(402);
		PrintWriter out = response.getWriter();
		BaseResponse baseResponse=BaseResponse.baseEnum(AccountEnum.NO_MENU);
		out.print(JSONObject.fromObject(baseResponse));
		out.flush();
	}
	private void getUnRightReponse(HttpServletResponse response)throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setStatus(402);
		PrintWriter out = response.getWriter();
		BaseResponse baseResponse=BaseResponse.baseEnum(AccountEnum.NO_RIGHT);
		out.print(JSONObject.fromObject(baseResponse));
		out.flush();
	}
	private void getUnLoginReponse(HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		response.setStatus(401);
		PrintWriter out = response.getWriter();
		BaseResponse baseResponse=BaseResponse.baseEnum(AccountEnum.LOGIN_DISABLE);
		out.print(JSONObject.fromObject(baseResponse));
		out.flush();
	}

}
