package com.sky.ddt.service.impl;

import com.sky.ddt.dao.custom.CsutomBrandAdvertisingMapper;
import com.sky.ddt.service.IBrandAdvertisingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sky
 * @Description 品牌广告
 * @date 2022/1/13 23:28
 */
@Service
public class BrandAdvertisingService implements IBrandAdvertisingService {
    @Autowired
    CsutomBrandAdvertisingMapper csutomBrandAdvertisingMapper;
}
