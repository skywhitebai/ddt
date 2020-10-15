package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.FactoryProductionOrderShopSkuMapper;
import com.sky.ddt.dto.factoryProductionOrder.request.ListFactoryProductionOrderInfoRequest;
import com.sky.ddt.entity.FactoryProductionOrderShopSku;

import java.util.List;

/**
 * @author baixueping
 * @description 工厂生产单店铺sku操作类
 * @date 2020/10/10 11:14
 */
public interface CustomFactoryProductionOrderShopSkuMapper extends FactoryProductionOrderShopSkuMapper {
    /**
     * @param
     * @return
     * @description 查询生产单店铺sku信息
     * @author baixueping
     * @date 2020/10/15 19:31
     */
    List<FactoryProductionOrderShopSku> listByShopParentSku(ListFactoryProductionOrderInfoRequest params);
}
