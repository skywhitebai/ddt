package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.InventoryMapper;
import com.sky.ddt.dto.inventory.request.InventoryListRequest;
import com.sky.ddt.dto.inventory.response.InventoryListResponse;
import com.sky.ddt.dto.inventory.response.ShopInventoryInfoResponse;

import java.util.List;

/**
 * @author baixueping
 * @description 库存dao
 * @date 2019/4/23 9:15
 */
public interface CustomInventoryMapper extends InventoryMapper {
    /**
     * @description 库存列表查询
     * @author baixueping
     * @date 2019/4/23 9:32
     * @param
     * @return
    */
    List<InventoryListResponse> inventoryList(InventoryListRequest params);
/**
 * @description 店铺库存信息
 * @author baixueping
 * @date 2019/4/24 9:38
 * @param
 * @return
*/
    List<ShopInventoryInfoResponse> listShopInventoryInfo(InventoryListRequest params);
}
