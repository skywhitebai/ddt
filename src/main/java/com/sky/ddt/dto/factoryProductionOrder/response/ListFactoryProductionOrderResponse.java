package com.sky.ddt.dto.factoryProductionOrder.response;

import com.sky.ddt.entity.FactoryProductionOrder;
import lombok.Data;

/**
 * @author baixueping
 * @description 分页查询工厂生产单信息
 * @date 2020/10/12 14:59
 */
@Data
public class ListFactoryProductionOrderResponse extends FactoryProductionOrder {
    String shopName;
}
