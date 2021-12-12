package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.inventoryQuantityHis.request.ListInventoryQuantityHisRequest;
import com.sky.ddt.dto.inventoryQuantityHis.response.ListInventoryQuantityHisResponse;

import java.util.List;

/**
 * @author sky
 * @Description 产品库存
 * @date 2021/8/20 23:30
 */
public interface IProductInventoryQuantityHisService {
     /**
      * @param null
      * @return
      * @author sky
      * @Description: 保存产品库存
      * @date
      */
    void saveProductInventoryQuantityHis();

    PageInfo<ListInventoryQuantityHisResponse> listProductInventoryQuantityHis(ListInventoryQuantityHisRequest params);

    List<ListInventoryQuantityHisResponse> listExportProductInventoryQuantityHis(ListInventoryQuantityHisRequest params);
}
