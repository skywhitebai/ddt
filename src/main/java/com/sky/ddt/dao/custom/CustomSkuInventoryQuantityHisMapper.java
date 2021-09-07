package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.SkuInventoryQuantityHisMapper;
import com.sky.ddt.dto.inventoryQuantityHis.request.ListInventoryQuantityHisRequest;
import com.sky.ddt.dto.inventoryQuantityHis.response.ListInventoryQuantityHisResponse;

import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @Description sku历史库存
 * @date 2021/8/20 23:19
 */
public interface CustomSkuInventoryQuantityHisMapper extends SkuInventoryQuantityHisMapper {
    void saveSkuInventoryQuantityHis(Date month);

    List<ListInventoryQuantityHisResponse> listSkuInventoryQuantityHis(ListInventoryQuantityHisRequest params);
}
