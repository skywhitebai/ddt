package com.sky.ddt.service.impl;

import com.sky.ddt.dao.custom.CustomFactoryProductionOrderShopSkuMapper;
import com.sky.ddt.service.IFactoryProductionOrderShopSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author baixueping
 * @description 生产单店铺sku服务
 * @date 2020/10/10 11:22
 */
@Service
public class FactoryProductionOrderShopSkuService implements IFactoryProductionOrderShopSkuService {
    @Autowired
    CustomFactoryProductionOrderShopSkuMapper customFactoryProductionOrderShopSkuMapper;
}
