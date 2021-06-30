package com.sky.ddt.service.amazon;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.amazon.amazonFbaInventory.request.ListAmazonFbaInventoryRequest;
import com.sky.ddt.entity.AmazonFbaInventory;

/**
 * @author baixueping
 * @description FBA库存服务
 * @date 2021/6/28 14:54
 */
public interface IAmazonFbaInventoryService {
    PageInfo<AmazonFbaInventory> listAmazonFbaInventory(ListAmazonFbaInventoryRequest params);
}
