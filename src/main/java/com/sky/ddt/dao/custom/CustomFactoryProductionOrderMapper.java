package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.FactoryProductionOrderMapper;
import com.sky.ddt.dto.factoryProductionOrder.request.ListFactoryProductionOrderInfoRequest;
import com.sky.ddt.dto.factoryProductionOrder.request.ListFactoryProductionOrderShopParentSkuRequest;
import com.sky.ddt.dto.factoryProductionOrder.request.ListFactoryProductionOrderRequest;
import com.sky.ddt.dto.factoryProductionOrder.response.ListFactoryProductionOrderInfoResponse;
import com.sky.ddt.dto.factoryProductionOrder.response.ListFactoryProductionOrderShopParentSkuResponse;
import com.sky.ddt.dto.factoryProductionOrder.response.ListFactoryProductionOrderResponse;
import com.sky.ddt.dto.factoryProductionOrder.response.ShopSkuProductionQuantityDto;

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

    /**
     * @param
     * @return
     * @description 分页查询工厂生产单产品信息
     * @author baixueping
     * @date 2020/10/15 16:54
     */
    List<ListFactoryProductionOrderShopParentSkuResponse> listFactoryProductionOrderShopParentSku(ListFactoryProductionOrderShopParentSkuRequest params);

    List<ListFactoryProductionOrderInfoResponse> listColourByShopParentSku(ListFactoryProductionOrderInfoRequest params);

    List<ShopSkuProductionQuantityDto> listShopSkuProductionQuantity(ListFactoryProductionOrderInfoRequest params);
}
