package com.sky.ddt.service;

import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.SysConfig;

/**
 * 系统配置
 *
 * @author sky
 * @date 2019/3/17
 */
public interface ISysConfigService {
    /**
     * 获取配置信息
     * @param key
     * @return
     */
    BaseResponse<SysConfig> getConfigByKey(String key);
}
