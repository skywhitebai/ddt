package com.sky.ddt.service.impl;

import com.sky.ddt.dao.custom.CustomFactoryProductionOrderShopSkuMapper;
import com.sky.ddt.entity.FactoryProductionOrderShopSku;
import com.sky.ddt.entity.FactoryProductionOrderShopSkuExample;
import com.sky.ddt.service.IFactoryProductionOrderShopSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author baixueping
 * @description 生产单店铺sku服务
 * @date 2020/10/10 11:22
 */
@Service
public class FactoryProductionOrderShopSkuService implements IFactoryProductionOrderShopSkuService {
    @Autowired
    CustomFactoryProductionOrderShopSkuMapper customFactoryProductionOrderShopSkuMapper;

    /**
     * @param factoryProductionOrderId@return
     * @description 查询工厂生产单生产数量
     * @author baixueping
     * @date 2020/11/2 9:49
     */
    @Override
    public List<FactoryProductionOrderShopSku> listFactoryProductionOrderShopSku(Integer factoryProductionOrderId) {
        FactoryProductionOrderShopSkuExample example=new FactoryProductionOrderShopSkuExample();
        example.createCriteria().andFactoryProductionOrderIdEqualTo(factoryProductionOrderId);
        return customFactoryProductionOrderShopSkuMapper.selectByExample(example);
    }
}
