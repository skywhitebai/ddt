package com.sky.ddt.service.finance;

import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopHeadTripCost.response.ShopSkuInventoryDetails;

import java.util.List;

/**
 * @author baixueping
 * @description 库存明细
 * @date 2019/12/12 15:18
 */
public interface IInventoryDetailsService {
    /**
     * @param
     * @return
     * @description 导入库存明细
     * @author baixueping
     * @date 2019/12/12 15:23
     */
    BaseResponse importInventoryDetails(ImportFinanceRequest params, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 查询店铺sku存库
     * @author baixueping
     * @date 2020/8/17 19:10
     */
    List<ShopSkuInventoryDetails> listShopSkuInventoryDetails(Integer id);
}
