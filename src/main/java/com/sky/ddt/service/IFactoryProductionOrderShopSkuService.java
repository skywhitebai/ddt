package com.sky.ddt.service;

import com.sky.ddt.entity.FactoryProductionOrderShopSku;

import java.util.List;

/**
 * @author baixueping
 * @description 生产单店铺sku服务
 * @date 2020/10/10 11:21
 */
public interface IFactoryProductionOrderShopSkuService {
    /**
     * @param
     * @return
     * @description 查询工厂生产单生产数量
     * @author baixueping
     * @date 2020/11/2 9:49
    */
    List<FactoryProductionOrderShopSku> listFactoryProductionOrderShopSku(Integer factoryProductionOrderId);
}
