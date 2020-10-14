package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.dao.custom.CustomOrderItemMapper;
import com.sky.ddt.dto.orderitem.request.OrderItemListByAmazonOrderIdRequest;
import com.sky.ddt.entity.OrderItem;
import com.sky.ddt.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class OrderItemService implements IOrderItemService {
    @Autowired
    CustomOrderItemMapper customOrderItemMapper;
    @Override
    public PageInfo<OrderItem> listByAmazonOrderId(OrderItemListByAmazonOrderIdRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<OrderItem> list = customOrderItemMapper.listByAmazonOrderId(params);
        PageInfo<OrderItem> page = new PageInfo<OrderItem>(list);
        return page;
    }
}
