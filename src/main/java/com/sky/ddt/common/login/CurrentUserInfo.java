package com.sky.ddt.common.login;

import lombok.Data;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Data
public class CurrentUserInfo {
    private Integer userId;

    private String userName;

    private String mobile;

    private String realName;

    private Integer gender;

    private String email;
    private String loginToken;
    private List<String> menuUrlList;
    private List<String> rightStrList;

    public boolean hasMenuUrl(String menuUrl){
        if(StringUtils.isEmpty(menuUrl)|| CollectionUtils.isEmpty(menuUrlList)){
            return false;
        }
        if(menuUrlList.contains("admin")){
            return true;
        }
        return menuUrlList.contains(menuUrl);
    }
    public boolean hasRightStr(String rightStr){
        if(StringUtils.isEmpty(rightStr)|| CollectionUtils.isEmpty(rightStrList)){
            return false;
        }

        if(!CollectionUtils.isEmpty(menuUrlList)&&menuUrlList.contains("admin")){
            return true;
        }
        return rightStrList.contains(rightStr);
    }

}
