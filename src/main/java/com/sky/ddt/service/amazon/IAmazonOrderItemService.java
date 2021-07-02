package com.sky.ddt.service.amazon;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.amazon.amazonOrderItem.request.ListAmazonOrderItemRequest;
import com.sky.ddt.entity.AmazonOrderItem;

/**
 * @author baixueping
 * @description 亚马逊订单商品
 * @date 2021/7/2 12:37
 */
public interface IAmazonOrderItemService {
    PageInfo<AmazonOrderItem> listAmazonOrderItem(ListAmazonOrderItemRequest params);
}
