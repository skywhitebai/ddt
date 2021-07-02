package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.AmazonOrderMapper;
import com.sky.ddt.dto.amazon.amazonOrder.request.ListAmazonOrderRequest;
import com.sky.ddt.entity.AmazonOrder;

import java.util.List;

/**
 * @author baixueping
 * @description 亚马逊订单
 * @date 2021/6/25 10:31
 */
public interface CustomAmazonOrderMapper extends AmazonOrderMapper{
    List<AmazonOrder> listAmazonOrder(ListAmazonOrderRequest params);
}
