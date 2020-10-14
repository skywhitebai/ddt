package com.sky.ddt.util;

import com.sky.ddt.dto.response.BaseResponse;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * @author baixueping
 * @description 校验数据
 * @date 2019/8/15 10:51
 */
public class CheckUtil {
    public static boolean checkInt(String str, Integer min, Integer max) {
        return false;
    }

    public static BaseResponse<BigDecimal> checkBigDecimal(Map<String, String> map, String key, boolean need) {
        String str = map.get(key);
        if (StringUtils.isEmpty(str)) {
            if (need) {
                return BaseResponse.failMessage(key + "不能为空");
            } else {
                return BaseResponse.success();
            }
        } else {
            BigDecimal bigDecimal = MathUtil.strToBigDecimal(str);
            if (bigDecimal == null) {
                return BaseResponse.failMessage(key + "必须为数字");
            } else {
                return BaseResponse.successData(bigDecimal);
            }
        }
    }

    public static void checkAndSetBigDecimal(Object object, StringBuilder sbErroItem, Map<String, String> map, String key, String propertyName, boolean need) {
        BaseResponse<BigDecimal> checkBigDecimalResponse = checkBigDecimal(map, key, need);
        if (!checkBigDecimalResponse.isSuccess()) {
            sbErroItem.append(",").append(checkBigDecimalResponse.getMessage());
            return;
        }
        setValue(object, sbErroItem, key,propertyName,checkBigDecimalResponse.getData());

    }

    private static void setValue(Object object, StringBuilder sbErroItem, String key,String propertyName, Object value) {
        if (value == null) {
            return;
        }
        //key值设置为驼峰命名
        if(StringUtils.isEmpty(propertyName)){
            propertyName=strToCamel(key);
        }
        Field field = getField(object.getClass(),propertyName);
        if(field==null){
            sbErroItem.append(",").append(key+"字段不存在");
            return;
        }
        try {
            //去除权限
            field.setAccessible(true);
            field.set(object, value);
        } catch (Exception e) {
            e.printStackTrace();
            sbErroItem.append(",").append(e.getMessage());
        }
    }
    private static Field getField(Class _class,String fieldName){
        Field[] fields = _class.getDeclaredFields();
        Field.setAccessible(fields, true);
        for (int i = 0; i < fields.length; i++) {
            if (fieldName.equals(fields[i].getName())) {
               return fields[i];
            }
        }
        if(_class.getGenericSuperclass()!=null){
            return getField(_class.getSuperclass(), fieldName);
        }
        return null;
    }

    /**
     * 下划线格式字符串转换为驼峰格式字符串
     *
     * @param param
     * @return
     */
    public static String strToCamel(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (c == '_' || c == '-' || c == ' ') {
                if (++i < len) {
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void checkAndSetStr(Object object, StringBuilder sbErroItem, Map<String, String> map, String key, String propertyName, boolean need) {
        String str = map.get(key);
        if (StringUtils.isEmpty(str)) {
            if (need) {
                sbErroItem.append(",").append(key + "不能为空");
            }
        } else {
            setValue(object, sbErroItem, key,propertyName, str);
        }
    }

    public static void checkAndSetBoolen(Object object, StringBuilder sbErroItem, Map<String, String> map, String key, boolean need) {
        String str = map.get(key);
        if (StringUtils.isEmpty(str)) {
            if (need) {
                sbErroItem.append(",").append(key + "不能为空");
            }
        } else {
            Boolean b = null;
            str=str.toLowerCase();
            if ("true".equals(str)) {
                b = true;
            } else if ("false".equals(str)) {
                b = false;
            } else {
                sbErroItem.append(",").append(key + "必须为TRUE或者FALSE");
                return;
            }
            setValue(object, sbErroItem, key,null, b);
        }
    }
    public static void checkAndSetBoolenOrYN(Object object, StringBuilder sbErroItem, Map<String, String> map, String key, boolean need) {
        String str = map.get(key);
        if (StringUtils.isEmpty(str)) {
            if (need) {
                sbErroItem.append(",").append(key + "不能为空");
            }
        } else {
            Boolean b = null;
            str=str.toLowerCase();
            if ("true".equals(str) || "y".equals(str)) {
                b = true;
            } else if ("false".equals(str)|| "n".equals(str)) {
                b = false;
            } else {
                sbErroItem.append(",").append(key + "必须为TRUE或者FALSE或者Y或者N");
                return;
            }
            setValue(object, sbErroItem, key,null, b);
        }
    }
    public static void checkAndSetUtcDateTime(Object object, StringBuilder sbErroItem, Map<String, String> map, String key, String propertyName, boolean need) {
        String str = map.get(key);
        if (StringUtils.isEmpty(str)) {
            if (need) {
                sbErroItem.append(",").append(key + "不能为空");
            }
        } else {
            Date date= DateUtil.UtcStrToDateTime(str);
            if(date==null){
                sbErroItem.append(",").append(key + "必须为时间");
            }else{
                setValue(object, sbErroItem, key,propertyName, date);
            }
        }
    }

    public static void checkAndSetInteger(Object object, StringBuilder sbErroItem, Map<String, String> map, String key, String propertyName, boolean need) {
        String str = map.get(key);
        if (StringUtils.isEmpty(str)) {
            if (need) {
                sbErroItem.append(",").append(key + "不能为空");
            }
        } else {
            Integer integer= MathUtil.strToInteger(str);
            if(integer==null){
                sbErroItem.append(",").append(key + "必须为数字");
            }else{
                setValue(object, sbErroItem, key,propertyName, integer);
            }
        }
    }

    public static void checkAndSetDate(Object object, StringBuilder sbErroItem, Map<String, String> map, String key, String propertyName, boolean need) {
        String str = map.get(key);
        if (StringUtils.isEmpty(str)) {
            if (need) {
                sbErroItem.append(",").append(key + "不能为空");
            }
        } else {
            Date date= DateUtil.strToDate(str);
            if(date==null){
                sbErroItem.append(",").append(key + "必须为时间");
            }else{
                setValue(object, sbErroItem, key,propertyName, date);
            }
        }
    }
}
