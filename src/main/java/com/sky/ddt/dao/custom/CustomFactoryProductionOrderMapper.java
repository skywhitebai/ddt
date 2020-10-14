package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.FactoryProductionOrderMapper;
import com.sky.ddt.dto.factoryProductionOrder.request.ListFactoryProductionOrderRequest;
import com.sky.ddt.dto.factoryProductionOrder.response.ListFactoryProductionOrderResponse;

import java.util.List;

/**
 * @author baixueping
 * @description 工厂生产单操作类
 * @date 2020/10/10 10:46
 */
public interface CustomFactoryProductionOrderMapper extends FactoryProductionOrderMapper {
    /**
     * @param
     * @return
     * @description 列表查询工厂生产单
     * @author baixueping
     * @date 2020/10/12 15:37
    */
    List<ListFactoryProductionOrderResponse> listFactoryProductionOrder(ListFactoryProductionOrderRequest params);
}
