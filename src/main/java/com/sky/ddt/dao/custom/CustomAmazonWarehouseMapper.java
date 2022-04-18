package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.AmazonWarehouseMapper;
import com.sky.ddt.dto.amazonWarehouse.req.ListAmazonWarehouseReq;
import com.sky.ddt.dto.amazonWarehouse.resp.AmazonWarehouseComboxResp;
import com.sky.ddt.dto.amazonWarehouse.resp.ListAmazonWarehouseResp;

import java.util.List;

/**
 * @author sky
 * @Description
 * @date 2022/4/17 23:33
 */
public interface CustomAmazonWarehouseMapper extends AmazonWarehouseMapper {
    List<ListAmazonWarehouseResp> listAmazonWarehouse(ListAmazonWarehouseReq params);

    List<AmazonWarehouseComboxResp> amazonWarehouseComboboxlist();
}
