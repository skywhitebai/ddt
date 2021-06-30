package com.sky.ddt.service.impl.amazon;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.sky.ddt.dao.custom.CustomAmazonFbaInventoryMapper;
import com.sky.ddt.dto.amazon.amazonFbaInventory.request.ListAmazonFbaInventoryRequest;
import com.sky.ddt.entity.AmazonFbaInventory;
import com.sky.ddt.entity.AmazonFbaInventoryExample;
import com.sky.ddt.service.amazon.IAmazonFbaInventoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author baixueping
 * @description 亚马逊库存
 * @date 2021/6/29 15:54
 */
@Service
public class AmazonFbaInventoryService implements IAmazonFbaInventoryService {
    @Autowired
    CustomAmazonFbaInventoryMapper customAmazonFbaInventoryMapper;

    @Override
    public PageInfo<AmazonFbaInventory> listAmazonFbaInventory(ListAmazonFbaInventoryRequest params) {
        AmazonFbaInventoryExample example = new AmazonFbaInventoryExample();
        AmazonFbaInventoryExample.Criteria criteria = example.createCriteria();
        if (!StringUtil.isEmpty(params.getMerchantId())) {
            criteria.andMerchantIdLike(params.getMerchantId());
        }
        if (!StringUtil.isEmpty(params.getAsin())) {
            criteria.andAsinLike(params.getAsin());
        }
        if (!StringUtil.isEmpty(params.getFnSku())) {
            criteria.andFnSkuLike(params.getFnSku());
        }
        if (!StringUtil.isEmpty(params.getSellerSku())) {
            criteria.andSellerSkuLike(params.getAsin());
        }
        if (!StringUtil.isEmpty(params.getProductName())) {
            criteria.andProductNameLike(params.getProductName());
        }
        PageHelper.startPage(params.getPage(), params.getRows());
        List<AmazonFbaInventory> list = customAmazonFbaInventoryMapper.selectByExample(example);
        PageInfo<AmazonFbaInventory> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
