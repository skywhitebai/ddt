package com.sky.ddt.service.impl;

import com.sky.ddt.dao.custom.CustomDisplayAdvertisingMapper;
import com.sky.ddt.service.IDisplayAdvertisingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sky
 * @Description 展示广告
 * @date 2022/1/13 23:27
 */
@Service
public class DisplayAdvertisingService implements IDisplayAdvertisingService {
    @Autowired
    CustomDisplayAdvertisingMapper customDisplayAdvertisingMapper;
}
