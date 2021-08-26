package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.inventoryQuantityHis.request.ListInventoryQuantityHisRequest;
import com.sky.ddt.dto.inventoryQuantityHis.response.ListInventoryQuantityHisResponse;

/**
 * @author sky
 * @Description sku库存
 * @date 2021/8/20 23:30
 */
public interface ISkuInventoryQuantityHisService {
     /**
      * @param null
      * @return
      * @author sky
      * @Description: 保存sku库存记录
      * @date
      */
    void saveSkuInventoryQuantityHis();

    PageInfo<ListInventoryQuantityHisResponse> listSkuInventoryQuantityHis(ListInventoryQuantityHisRequest params);
}
