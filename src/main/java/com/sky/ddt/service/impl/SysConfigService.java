package com.sky.ddt.service.impl;

import com.alibaba.fastjson.JSON;
import com.sky.ddt.common.constant.ConfigConstant;
import com.sky.ddt.dao.custom.CustomSysConfigMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.SysConfig;
import com.sky.ddt.entity.SysConfigExample;
import com.sky.ddt.service.ISysConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 系统配置
 *
 * @author sky
 * @date 2019/3/17
 */
@Service
public class SysConfigService implements ISysConfigService{
    Logger log= LoggerFactory.getLogger(this.getClass());

    @Autowired
    CustomSysConfigMapper customSysConfigMapper;
    /**
     * 获取配置信息
     *
     * @param keyName
     * @return
     */
    @Override
    public BaseResponse<SysConfig> getConfigByKey(String keyName) {
        if(StringUtils.isEmpty(keyName)){
            return BaseResponse.failMessage(ConfigConstant.KEY_EMPTY);
        }
        SysConfigExample example=new SysConfigExample();
        example.createCriteria().andKeyNameEqualTo(keyName);
        List<SysConfig> list=customSysConfigMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            return BaseResponse.failMessage(ConfigConstant.KEY_NOT_EXIST);
        }
        if(list.size()>1){
            log.info("getShopByLoginToken return more than one results,key:{},result list:",keyName, JSON.toJSON(list));
        }
        return BaseResponse.successData(list.get(0));
    }
}
