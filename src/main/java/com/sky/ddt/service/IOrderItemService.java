package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.orderitem.request.OrderItemListByAmazonOrderIdRequest;
import com.sky.ddt.entity.OrderItem;

public interface IOrderItemService {
    PageInfo<OrderItem> listByAmazonOrderId(OrderItemListByAmazonOrderIdRequest orderItemListByAmazonOrderIdRequest);
}
