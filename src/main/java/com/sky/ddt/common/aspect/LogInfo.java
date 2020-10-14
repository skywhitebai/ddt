package com.sky.ddt.common.aspect;
import com.sky.ddt.util.DateUtil;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @author baixueping
 * @description todo
 * @date 2019/4/16 18:38
 */
@Data
public class LogInfo {
    Date startTime;
    Date endTime;
    String operName;
    String userAgent;
    String controller;
    String loginToken;
    String method;
    String json;
    String params;
    String url;
    String ip;
    Long costTime;
    String erroMessage;
    String result;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("-----------------------")
                .append(DateUtil.getFormatSSS(startTime))
                .append("-------------------------------------\n");
        sb.append("Controller: ")
                .append(controller)
                .append("\n");
        if (!StringUtils.isEmpty(loginToken)) {
            sb.append("loginToken: ").append(loginToken).append("\n");
        }
        sb.append("user_agent: ").append(userAgent).append("\n");
        sb.append("Method    : ").append(method).append("\n");
        if (!StringUtils.isEmpty(json)) {
            sb.append("Json      : ").append(json).append("\n");
        }
        if (!StringUtils.isEmpty(params)) {
            sb.append("Params    : ").append(params).append("\n");
        }
        sb.append("URI       : ").append(url).append("\n");
        sb.append("IP        : ").append(ip).append("\n");
        if (!StringUtils.isEmpty(operName)) {
            sb.append("operName  : ").append(operName).append("\n");
        }
        sb.append("CostTime  : ")
                .append(costTime).append("ms").append("\n");
        if (!StringUtils.isEmpty(erroMessage)) {
            sb.append("执行错误  : ")
                    .append(erroMessage).append("\n");
        }
        if (!StringUtils.isEmpty(result)) {
            sb.append("result  : ")
                    .append(result).append("\n");
        }
        sb.append("-----------------------")
                .append(DateUtil.getFormatSSS(endTime))
                .append("-------------------------------------\n");
        return sb.toString();
    }
}
