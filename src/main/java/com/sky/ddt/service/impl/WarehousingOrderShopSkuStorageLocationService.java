package com.sky.ddt.service.impl;

import com.sky.ddt.dao.custom.CustomWarehousingOrderShopSkuStorageLocationMapper;
import com.sky.ddt.service.IWarehousingOrderShopSkuStorageLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sky
 * @Description 入库仓库sku库存
 * @date 2022/1/8 0:22
 */
@Service
public class WarehousingOrderShopSkuStorageLocationService implements IWarehousingOrderShopSkuStorageLocationService {
    @Autowired
    CustomWarehousingOrderShopSkuStorageLocationMapper customWarehousingOrderShopSkuStorageLocationMapper;
}
