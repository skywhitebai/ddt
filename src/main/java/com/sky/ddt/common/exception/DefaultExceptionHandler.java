package com.sky.ddt.common.exception;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.sky.ddt.common.constant.ResponseConstant;
import com.sky.ddt.dto.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class DefaultExceptionHandler extends DefaultHandlerExceptionResolver {

    private Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public ModelAndView doResolveException(HttpServletRequest request,
                                           HttpServletResponse response, Object handler, Exception ex) {
        StringBuffer sbErro = new StringBuffer();
        if(ex instanceof BindException){
            BindingResult bindingResult = ((BindException)ex).getBindingResult();            
            for(FieldError fieldError :bindingResult.getFieldErrors()){
                sbErro.append(",").append(fieldError.getDefaultMessage());
            }
        }else if(ex instanceof MethodArgumentNotValidException){
            BindingResult bindingResult = ((MethodArgumentNotValidException)ex).getBindingResult();
            for(FieldError fieldError :bindingResult.getFieldErrors()){
                sbErro.append(",").append(fieldError.getDefaultMessage());
            }
        }else if(ex instanceof NoticeException){
            sbErro.append(",").append(ex.getMessage());
        }
        ModelAndView mv = new ModelAndView();
        /* 使用FastJson提供的FastJsonJsonView视图返回，不需要捕获异常 */
        FastJsonJsonView view = new FastJsonJsonView();
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("code", ResponseConstant.FAIL_CODE);
        if(sbErro.length()>0){
            attributes.put("message", sbErro.substring(1));
        }else{
            attributes.put("message", "系统异常，请稍后重试或联系客服");
        }
        attributes.put("detailMessage", null);
        attributes.put("data", null);
        view.setAttributesMap(attributes);
        mv.setView(view);
        ex.printStackTrace();
        logger.error("异常:{},{}", ex.getMessage(), ex);
        return mv;
    }
}
