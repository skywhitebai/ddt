package com.sky.ddt.common.aspect;

import com.alibaba.fastjson.JSON;
import com.sky.ddt.common.annotation.Action;
import com.sky.ddt.common.annotation.Log;
import com.sky.ddt.common.annotation.LogRequest;
import com.sky.ddt.common.constant.BaseConstant;
import com.sky.ddt.common.login.LoginHelper;
import com.sky.ddt.util.HttpUtil;
import net.sf.json.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

public class LogAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 
	 * @Description: 方法调用前触发 记录开始时间
	 * @author fei.lei
	 * @date 2016年11月23日 下午5:10
	 * @param joinPoint
	 */
	public void before(JoinPoint joinPoint) {

	}

	/**
	 * 
	 * @Description: 方法调用后触发 记录结束时间
	 * @author fei.lei
	 * @date 2016年11月23日 下午5:10
	 * @param joinPoint
	 */
	public void after(JoinPoint joinPoint) {

	}

	/**
	 * @Description: 获取request
	 * @author fei.lei
	 * @date 2016年11月23日 下午5:10
	 * @param
	 * @return HttpServletRequest
	 */
	public HttpServletRequest getHttpServletRequest() {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();
		return request;
	}

	/**
	 * 
	 * @Title：around
	 * @Description: 环绕触发
	 * @author fei.lei
	 * @date 2016年11月23日 下午5:10
	 * @param joinPoint
	 * @return Object
	 * @throws Throwable
	 */
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

		HttpServletRequest request = getHttpServletRequest();
		LogInfo logInfo=new LogInfo();
		logInfo.setStartTime(new Date());
		logInfo.setUserAgent(request.getHeader("User-Agent"));
		// 获取class和method
		Signature signature = joinPoint.getSignature();
		Method method = ((MethodSignature) signature).getMethod();
		Log log = method.getAnnotation(Log.class);
		if (log != null) {
			logInfo.setOperName(log.value());
		}
		LogRequest logRequest = method.getAnnotation(LogRequest.class);
		logInfo.setController(joinPoint.getTarget().getClass().getName());
		String loginToken = request.getHeader(BaseConstant.LOGIN_NAME);
		logInfo.setLoginToken(loginToken);
		logInfo.setMethod(method.getName());
		//判断是否需要输出入参
		if (logRequest == null
				|| logRequest.action() == Action.Normal) {
			if (joinPoint.getArgs().length > 0) {
				StringBuilder sbJson=new StringBuilder();
				for (int i = 0; i < joinPoint.getArgs().length; i++) {
					sbJson.append(i == 0 ? "" : ", ");
					try {
						//如果输入条件是文件则不转换为json
						if(joinPoint.getArgs()[i]  instanceof MultipartFile){
							sbJson.append("入参是文件，不转换为json");
						}else{
							sbJson.append(JSON.toJSONString(joinPoint.getArgs()[i]));
						}
					} catch (Exception ex) {
						sbJson.append(joinPoint.getArgs()[i]);
					}
				}
				logInfo.setJson(sbJson.toString());
			}
			if (request.getParameterMap().size() > 0) {
				logInfo.setParams(JSONObject.fromObject(request.getParameterMap()).toString());
			}
		}
		logInfo.setUrl(request.getRequestURI());
		logInfo.setIp(HttpUtil.getIp(request));
		Object result = null;
		Exception e = null;
		try {
			result = joinPoint.proceed();
		} catch (Exception ex) {
			e = ex;
		}
		logInfo.setEndTime(new Date());
		logInfo.setCostTime(logInfo.getEndTime().getTime()-logInfo.getStartTime().getTime());
		if(e!=null){
			logInfo.setErroMessage(e.getMessage());
        }else if (result != null) {
        	try{
				logInfo.setResult(JSON.toJSONString(result));
        	}catch(Exception ex){
				ex.printStackTrace();
				logInfo.setResult(result.toString());
        	}
		}
		logger.info(logInfo.toString());
		if (e != null) {
			throw e;
		}
		return result;
	}
}
