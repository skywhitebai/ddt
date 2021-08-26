package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.ProductInventoryQuantityHisMapper;
import com.sky.ddt.dto.inventoryQuantityHis.request.ListInventoryQuantityHisRequest;
import com.sky.ddt.dto.inventoryQuantityHis.response.ListInventoryQuantityHisResponse;

import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @Description 产品库存历史记录
 * @date 2021/8/20 23:20
 */
public interface CustomProductInventoryQuantityHisMapper extends ProductInventoryQuantityHisMapper {
    void saveProductInventoryQuantityHis(Date month);

    List<ListInventoryQuantityHisResponse> listProductInventoryQuantityHis(ListInventoryQuantityHisRequest params);
}
