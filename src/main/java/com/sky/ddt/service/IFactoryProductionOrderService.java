package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.factoryProductionOrder.request.ListFactoryProductionOrderRequest;
import com.sky.ddt.dto.factoryProductionOrder.request.SaveFactoryProductionOrderRemark;
import com.sky.ddt.dto.factoryProductionOrder.response.ListFactoryProductionOrderResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.StockCart;

import java.util.List;

/**
 * @author baixueping
 * @description 工厂生产单
 * @date 2020/10/10 10:12
 */
public interface IFactoryProductionOrderService {
    /**
     * @param
     * @param shopId
     * @param title  @return
     * @description 生成工厂生产单
     * @author baixueping
     * @date 2020/10/10 14:32
     */
    void createFactoryProductionOrder(List<StockCart> stockCartList, Integer id, Integer shopId, String title, Integer currentUserId);

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
}
