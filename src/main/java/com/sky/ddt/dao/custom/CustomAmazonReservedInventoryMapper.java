package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.AmazonReservedInventoryMapper;
import com.sky.ddt.dto.amazonReservedInventory.req.ListAmazonReservedInventoryReq;
import com.sky.ddt.dto.amazonReservedInventory.resp.ListAmazonReservedInventoryResp;

import java.util.List;

/**
 * @author sky
 * @Description
 * @date 2022/11/7 16:43
 */
public interface CustomAmazonReservedInventoryMapper extends AmazonReservedInventoryMapper {
    List<ListAmazonReservedInventoryResp> listAmazonReservedInventory(ListAmazonReservedInventoryReq params);
}
