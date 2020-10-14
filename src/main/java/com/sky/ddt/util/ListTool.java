package com.sky.ddt.util;

import org.springframework.util.CollectionUtils;

import java.util.List;

public class ListTool {
    /**
     * 列表转字符串
     * @param list
     * @param split
     * @return
     */
    public static String listToStr(List<String> list, String split) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        StringBuilder sb=new StringBuilder();
        for(String str:list){
            sb.append(split).append(str);
        }
        return sb.substring(1);
    }
    public static String listToStrByComma(List<String> list) {
        return listToStr(list,",");
    }
}
