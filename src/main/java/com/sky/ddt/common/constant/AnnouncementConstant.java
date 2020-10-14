package com.sky.ddt.common.constant;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementConstant {
    public static final String TITLE_EMPTY ="标题不能为空" ;
    public static final String CONTENT_EMPTY ="内容不能为空" ;
    public static final String STATUS_EMPTY ="状态不能为空" ;
    public static final List<Integer> STATUS_LIST =new ArrayList<Integer>();
    public static final String STATUS_ERRO ="状态错误" ;
    public static final String ANNOUNCEMENTID_NOT_EXIST ="公告ID不存在" ;
    public static final Integer STATUS_ENABLE = 1;

    static {
        STATUS_LIST.add(1);//启用
        STATUS_LIST.add(0);//停用
    }
}
