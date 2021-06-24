package com.sky.ddt.dto.amazon;

import com.sky.ddt.dao.custom.CustomSysConfigMapper;
import com.sky.ddt.entity.SysConfig;
import com.sky.ddt.util.SpringUtil;
import lombok.Getter;

import java.util.List;
import java.util.Optional;

/**
 * @author baixueping
 * @description 亚马逊配置信息
 * @date 2021/6/24 11:18
 */
@Getter
public class AmazonConfig {
    public static AmazonConfig INSTANCE  = new AmazonConfig();
    String amazonIamUserAccessKeyId;
    String amazonIamUserSecretKey;
    String amazonIamRoleArn;
    String amazonIamRoleSessionName;
    String amazonAppClientId;
    String amazonAppClientSecret;
    Integer limitErroCode=429;
    private AmazonConfig() {


    }
    static {
        CustomSysConfigMapper customSysConfigMapper= SpringUtil.getBean(CustomSysConfigMapper.class);
        List<SysConfig> list=customSysConfigMapper.selectByExample(null);
        INSTANCE.amazonIamUserAccessKeyId=getConfig(list,"amazonIamUserAccessKeyId");
        INSTANCE.amazonIamUserSecretKey=getConfig(list,"amazonIamUserSecretKey");
        INSTANCE.amazonIamRoleArn=getConfig(list,"amazonIamRoleArn");
        INSTANCE.amazonIamRoleSessionName=getConfig(list,"amazonIamRoleSessionName");
        INSTANCE.amazonAppClientId=getConfig(list,"amazonAppClientId");
        INSTANCE.amazonAppClientSecret=getConfig(list,"amazonAppClientSecret");
    }

    private static String getConfig(List<SysConfig> list,String keyName) {
        Optional<SysConfig> firstFind=list.stream().filter(item->item.getKeyName().equals(keyName)).findFirst();
        if(!firstFind.isPresent()){
            return null;
        }
        return firstFind.get().getKeyValue();
    }

}