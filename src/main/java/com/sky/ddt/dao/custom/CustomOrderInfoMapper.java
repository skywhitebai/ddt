package com.sky.ddt.dao.custom;


import com.sky.ddt.dao.generate.OrderInfoMapper;
import com.sky.ddt.dto.order.request.OrderListRequest;
import com.sky.ddt.dto.order.response.OrderListResponse;

import java.util.List;

public interface CustomOrderInfoMapper extends OrderInfoMapper {
    List<OrderListResponse> orderList(OrderListRequest params);
}
