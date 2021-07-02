package com.sky.ddt.service.impl.amazon;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.dao.custom.CustomAmazonOrderItemMapper;
import com.sky.ddt.dto.amazon.amazonOrderItem.request.ListAmazonOrderItemRequest;
import com.sky.ddt.entity.AmazonFbaInventory;
import com.sky.ddt.entity.AmazonOrderItem;
import com.sky.ddt.entity.AmazonOrderItemExample;
import com.sky.ddt.service.amazon.IAmazonOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author baixueping
 * @description 亚马逊订单商品
 * @date 2021/7/2 12:37
 */
@Service
public class AmazonOrderItemService implements IAmazonOrderItemService {
    @Autowired
    CustomAmazonOrderItemMapper customAmazonOrderItemMapper;

    @Override
    public PageInfo<AmazonOrderItem> listAmazonOrderItem(ListAmazonOrderItemRequest params) {
        AmazonOrderItemExample example = new AmazonOrderItemExample();
        AmazonOrderItemExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(params.getAmazonOrderId())) {
            criteria.andAmazonOrderIdEqualTo(params.getAmazonOrderId());
        }
        if (!StringUtils.isEmpty(params.getAsin())) {
            criteria.andAsinEqualTo(params.getAsin());
        }
        if (!StringUtils.isEmpty(params.getSellerSku())) {
            criteria.andSellerSkuLike(params.getSellerSku());
        }
        if (!StringUtils.isEmpty(params.getTitle())) {
            criteria.andTitleLike(params.getTitle());
        }
        PageHelper.startPage(params.getPage(), params.getRows());
        List<AmazonOrderItem> list = customAmazonOrderItemMapper.selectByExample(example);
        PageInfo<AmazonOrderItem> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
