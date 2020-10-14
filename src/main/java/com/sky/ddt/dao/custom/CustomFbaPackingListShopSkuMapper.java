package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.FbaPackingListShopSkuMapper;
import com.sky.ddt.dto.fbaPackingListShopSku.request.ListFbaPackingListShopSkuRequest;
import com.sky.ddt.dto.fbaPackingListShopSku.response.ListFbaPackingListShopSkuResponse;
import com.sky.ddt.dto.shopHeadTripCost.response.FbaShopSkuHeadTripCostInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description fba装箱单店铺sku
 * @date 2020/7/22 15:42
 */
public interface CustomFbaPackingListShopSkuMapper extends FbaPackingListShopSkuMapper{
    List<ListFbaPackingListShopSkuResponse> listFbaPackingListShopSku(ListFbaPackingListShopSkuRequest params);

    List<FbaShopSkuHeadTripCostInfo> listFbaShopSkuHeadTripCostInfo(@Param("shopId") Integer shopId,@Param("month") Date month);
}
