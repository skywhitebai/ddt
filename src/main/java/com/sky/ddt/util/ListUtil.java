package com.sky.ddt.util;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
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

    public static  List<List<Object>> splitList(List<Object> messagesList, int groupSize) {
        int length = messagesList.size();
        // 计算可以分成多少组
        int num = (length + groupSize - 1) / groupSize; // TODO
        List<List<Object>> newList = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            // 开始位置
            int fromIndex = i * groupSize;
            // 结束位置
            int toIndex = (i + 1) * groupSize < length ? (i + 1) * groupSize : length;
            newList.add(messagesList.subList(fromIndex, toIndex));
        }
        return newList;
    }
}
