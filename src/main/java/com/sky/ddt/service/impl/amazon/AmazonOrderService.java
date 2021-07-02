package com.sky.ddt.service.impl.amazon;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.dao.custom.CustomAmazonOrderMapper;
import com.sky.ddt.dto.amazon.amazonOrder.request.ListAmazonOrderRequest;
import com.sky.ddt.entity.AmazonOrder;
import com.sky.ddt.service.amazon.IAmazonOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * @author baixueping
 * @description 亚马逊订单服务
 * @date 2021/6/30 16:13
 */
@Service
public class AmazonOrderService implements IAmazonOrderService {
    @Autowired
    CustomAmazonOrderMapper customAmazonOrderMapper;

    @Override
    public PageInfo<AmazonOrder> listAmazonOrder(ListAmazonOrderRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows());
        List<AmazonOrder> list=customAmazonOrderMapper.listAmazonOrder(params);
        PageInfo<AmazonOrder> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
