package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.ShopSkuMapper;
import com.sky.ddt.dto.shopHeadTripCost.response.ShopSkuHeadTripCostInfo;
import com.sky.ddt.dto.shopSku.request.GetPrintShopSkuRequest;
import com.sky.ddt.dto.shopSku.request.GetShopSkuByShopParentSkuAndSizeRequest;
import com.sky.ddt.dto.shopSku.request.ListShopSkuRequest;
import com.sky.ddt.dto.shopSku.request.SalesCountRequest;
import com.sky.ddt.dto.shopSku.response.*;
import com.sky.ddt.entity.Shop;
import com.sky.ddt.entity.ShopSku;
import com.sky.ddt.entity.Sku;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description 店铺sku
 * @date 2019/7/26 18:01
 */
public interface CustomShopSkuMapper extends ShopSkuMapper {
    /**
     * @param
     * @return
     * @description 获取店铺sku列表
     * @author baixueping
     * @date 2019/7/29 15:38
     */
    List<ListShopSkuResponse> listShopSku(ListShopSkuRequest params);

    /**
     * @param
     * @return
     * @description 查询导出的店铺sku数据
     * @author baixueping
     * @date 2019/7/30 14:11
     */
    List<ExportShopSkuResponse> listExportShopSku(ListShopSkuRequest params);

    /**
     * @param
     * @return
     * @description 通过店铺sku获取仓库sku产品sku
     * @author baixueping
     * @date 2019/8/5 9:18
     */
    List<TranformShopSkuInfoResponse> selectByShopSku(List<String> shopSkuList);

    /**
     * @param
     * @return
     * @description 获取打印sku信息
     * @author baixueping
     * @date 2019/8/12 15:59
     */
    GetPrintShopSkuResponse getPrintShopSkuResponse(GetPrintShopSkuRequest params);

    /**
     * @param
     * @return
     * @description 获取销售统计sku
     * @author baixueping
     * @date 2019/8/30 15:01
     */
    List<SalesCountResponse> listSelectSalesCountShopSku(SalesCountRequest params);

    /**
     * @param
     * @return
     * @description 获取sku库存数量
     * @author baixueping
     * @date 2020/5/9 10:15
     */
    Integer getSkuInventoryQuantity(Integer skuId);

    /**
     * @param
     * @return
     * @description 初始化仓库sku
     * @author baixueping
     * @date 2020/8/3 9:15
     */
    void initWareHouseShopSku(Shop shop);

    /**
     * @param
     * @return
     * @description 插入仓库sku
     * @author baixueping
     * @date 2020/8/3 9:20
     */
    void insertWarehouseShopSku(Sku sku);

    List<ShopSkuFullProductName> listShopSkuFullProductName(@Param("shopSkuList") List<String> shopSkuList);

    List<ShopSkuFullProductName> listShopSkuFullProductNameByShopSkuId(@Param("shopSkuIdList") List<Integer> shopSkuIdList);

    List<ShopSkuHeadTripCostInfo> listNotExistShopSkuHeadTripCost(@Param("shopId")Integer shopId, @Param("month") Date month);

    Long existWithoutWeightShopSku(Integer shopId);

    ShopSku getShopSkuBySkuShopId(@Param("shopId")Integer shopId,@Param("sku") String sku);

    List<ShopSku> getShopSkuByShopParentSkuAndSize(GetShopSkuByShopParentSkuAndSizeRequest getShopSkuByShopParentSkuAndSizeRequest);
}
