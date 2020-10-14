package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.inventory.request.InventoryListRequest;
import com.sky.ddt.dto.inventory.response.InventoryListResponse;
import com.sky.ddt.dto.inventory.response.ShopInventoryInfoResponse;
import com.sky.ddt.dto.response.BaseResponse;

import java.util.List;

/**
 * @author baixueping
 * @description 库存服务类
 * @date 2019/4/22 18:14
 */
public interface IInventoryService {
    /**
     * @param
     * @param dealUserId
     * @return
     * @description 保存库存信息
     * @author baixueping
     * @date 2019/4/22 18:17
     */
    BaseResponse saveInventory(Integer dealUserId, Integer shopId, String inventoryJson);

    /**
     * @param
     * @return
     * @description 库存列表查询
     * @author baixueping
     * @date 2019/4/23 9:13
     */
    PageInfo<InventoryListResponse> list(InventoryListRequest params);

    /**
     * @param
     * @return
     * @description 获取店铺库存详情
     * @author baixueping
     * @date 2019/4/24 9:37
     */
    List<ShopInventoryInfoResponse> listShopInventoryInfo(InventoryListRequest params);
}
