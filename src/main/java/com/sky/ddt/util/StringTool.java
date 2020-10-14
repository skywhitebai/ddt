package com.sky.ddt.util;

public class StringTool {
    public static boolean equal(String str1, String str2) {
        if(str1==null){
            if(str2==null){
                return true;
            }
            return false;
        }
        return str1.equals(str2);
    }
}
