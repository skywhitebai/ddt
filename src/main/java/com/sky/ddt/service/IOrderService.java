package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.order.request.OrderListRequest;
import com.sky.ddt.dto.order.response.OrderListResponse;
import com.sky.ddt.dto.response.BaseResponse;

public interface IOrderService {
    /**
     * 保存订单信息
     *
     * @param shopId
     * @param orderJson
     * @param orderItemsJson
     * @return
     */
    BaseResponse saveOrder(Integer shopId, String orderJson, String orderItemsJson);

    /**
     * 订单列表
     * @param params
     * @return
     */
    PageInfo<OrderListResponse> list(OrderListRequest params);
}
