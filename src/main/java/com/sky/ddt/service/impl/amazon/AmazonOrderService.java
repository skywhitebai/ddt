package com.sky.ddt.service.impl.amazon;

import com.sky.ddt.dao.custom.CustomAmazonOrderMapper;
import com.sky.ddt.service.amazon.IAmazonOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author baixueping
 * @description 亚马逊订单服务
 * @date 2021/6/30 16:13
 */
@Service
public class AmazonOrderService implements IAmazonOrderService {
    @Autowired
    CustomAmazonOrderMapper customAmazonOrderMapper;
}
