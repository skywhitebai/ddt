package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.factoryProductionOrder.request.*;
import com.sky.ddt.dto.factoryProductionOrder.response.ListFactoryProductionOrderInfoResponse;
import com.sky.ddt.dto.factoryProductionOrder.response.ListFactoryProductionOrderShopParentSkuResponse;
import com.sky.ddt.dto.factoryProductionOrder.response.ListFactoryProductionOrderResponse;
import com.sky.ddt.dto.response.BaseResponse;

import javax.servlet.http.HttpServletResponse;

/**
 * @author baixueping
 * @description 工厂生产单
 * @date 2020/10/10 10:12
 */
public interface IFactoryProductionOrderService {
    /**
     * @param
     * @return
     * @description 分页查询工厂生产单数据
     * @author baixueping
     * @date 2020/10/12 15:07
     */
    PageInfo<ListFactoryProductionOrderResponse> listFactoryProductionOrder(ListFactoryProductionOrderRequest params);

    /**
     * @param
     * @return
     * @description 保存备注
     * @author baixueping
     * @date 2020/10/12 16:34
     */
    BaseResponse saveFactoryProductionOrderRemark(SaveFactoryProductionOrderRemark params, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 获取工厂生产单产品信息
     * @author baixueping
     * @date 2020/10/15 16:46
     */
    PageInfo<ListFactoryProductionOrderShopParentSkuResponse> listFactoryProductionOrderShopParentSku(ListFactoryProductionOrderShopParentSkuRequest params);

    /**
     * @param
     * @return
     * @description 获取父sku生产数量
     * @author baixueping
     * @date 2020/10/15 19:04
     */
    PageInfo<ListFactoryProductionOrderInfoResponse> listFactoryProductionOrderInfo(ListFactoryProductionOrderInfoRequest params);

    /**
     * @param
     * @return
     * @description 保存生产数量
     * @author baixueping
     * @date 2020/10/15 20:04
     */
    BaseResponse saveProductionQuantity(SaveProductionQuantityRequest params, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 创建工厂生产单
     * @author baixueping
     * @date 2020/10/28 17:02
     */
    BaseResponse createFactoryProductionOrder(Integer shopId, Integer dealUserId);

    /**
     * @param
     * @param factoryProductionOrderId
     * @return
     * @description 下载工厂生产单
     * @author baixueping
     * @date 2020/10/28 19:23
     */
    BaseResponse downFactoryProductionOrderByShopParentSku(String shopParentSku, Integer factoryProductionOrderId, HttpServletResponse response);
}
