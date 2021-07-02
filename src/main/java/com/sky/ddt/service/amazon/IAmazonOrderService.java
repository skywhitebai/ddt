package com.sky.ddt.service.amazon;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.amazon.amazonOrder.request.ListAmazonOrderRequest;
import com.sky.ddt.entity.AmazonOrder;

/**
 * @author baixueping
 * @description 亚马逊订单
 * @date 2021/6/30 16:13
 */
public interface IAmazonOrderService {
    PageInfo<AmazonOrder> listAmazonOrder(ListAmazonOrderRequest params);
}
