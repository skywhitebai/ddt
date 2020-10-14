package com.sky.ddt.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author baixueping
 * @description 正则匹配
 * @date 2019/9/18 16:14
 */
public class RegexUtil {
    public static String getFirstStr(String content, String pattern) {
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 现在创建 matcher 对象
        Matcher m = r.matcher(content);
        if (m.find()) {
            return m.group(0);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(getFirstStr("abcdU001","U[0-9]{3}$"));
    }
}
