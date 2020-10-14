package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.OrderItemMapper;
import com.sky.ddt.dto.orderitem.request.OrderItemListByAmazonOrderIdRequest;
import com.sky.ddt.entity.OrderItem;

import java.util.List;

public interface CustomOrderItemMapper extends OrderItemMapper {
    List<OrderItem> listByAmazonOrderId(OrderItemListByAmazonOrderIdRequest params);
}
