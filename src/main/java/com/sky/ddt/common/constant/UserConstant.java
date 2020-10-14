package com.sky.ddt.common.constant;

import java.util.ArrayList;
import java.util.List;

public class UserConstant {

    public static final List<Integer> GENDER_LIST = new ArrayList<Integer>();
    public static final String GENDER_ERRO = "性别错误";
    public static final String USERNAME_EMPTY = "用户名不能为空";
    public static final String MOBILE_EMPTY = "手机号不能为空";
    public static final String REALNAME_EMPTY = "真实姓名不能为空";
    public static final String GENDER_EMPTY = "性别不能为空";
    public static final String USERNAME_EXIST = "用户名已存在";
    public static final String USERID_NOT_EXIST = "用户id不存在";
    public static final Integer STATUS_ENABLE = 1;
    public static final String USERNAME_NOT_EXIST = "用户名不存在";

    static {
        GENDER_LIST.add(1);//男
        GENDER_LIST.add(2);//女
        GENDER_LIST.add(3);//保密
    }
}
