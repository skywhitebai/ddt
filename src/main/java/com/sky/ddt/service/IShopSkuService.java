package com.sky.ddt.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopHeadTripCost.response.ShopSkuHeadTripCostInfo;
import com.sky.ddt.dto.shopSku.request.*;
import com.sky.ddt.dto.shopSku.response.ExportShopSkuResponse;
import com.sky.ddt.dto.shopSku.response.ListInventoryQuantityResponse;
import com.sky.ddt.dto.shopSku.response.ListShopSkuResponse;
import com.sky.ddt.dto.shopSku.response.ShopSkuFullProductName;
import com.sky.ddt.entity.ShopSku;
import com.sky.ddt.entity.Sku;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description 店铺sku
 * @date 2019/7/26 17:55
 */
public interface IShopSkuService {
    /**
     * @param
     * @return
     * @description 导入店铺sku
     * @author baixueping
     * @date 2019/7/29 9:57
     */
    BaseResponse importShopSku(MultipartFile file, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 获取店铺sku
     * @author baixueping
     * @date 2019/7/29 15:37
     */
    PageInfo<ListShopSkuResponse> listShopSku(ListShopSkuRequest params);

    /**
     * @param
     * @return
     * @description 修改店铺sku
     * @author baixueping
     * @date 2019/7/30 10:58
     */
    BaseResponse saveShopSku(SaveShopSkuRequest params);

    /**
     * @param
     * @return
     * @description 删除店铺sku
     * @author baixueping
     * @date 2019/7/30 11:24
     */
    BaseResponse deleteShopSku(List<Integer> shopSkuIds);

    /**
     * @param
     * @return
     * @description 查询导出的店铺sku数据
     * @author baixueping
     * @date 2019/7/30 14:10
     */
    List<ExportShopSkuResponse> listExportShopSku(ListShopSkuRequest params);

    /**
     * @param
     * @return
     * @description 店铺sku转换
     * @author baixueping
     * @date 2019/8/5 9:11
     */
    BaseResponse transformShopSkuInfo(MultipartFile file, HttpServletRequest request, HttpServletResponse response);

    /**
     * @param
     * @return
     * @description 获取店铺sku信息
     * @author baixueping
     * @date 2019/8/12 15:33
     */
    BaseResponse getPrintShopSku(GetPrintShopSkuRequest params);

    /**
     * @param
     * @return
     * @description 获取店铺sku信息
     * @author baixueping
     * @date 2019/8/14 11:14
     */
    ShopSku getShopSkuByShopSku(String shopSku);

    /**
     * @param
     * @return
     * @description 导入店铺父sku
     * @author baixueping
     * @date 2019/8/19 9:44
     */
    BaseResponse importShopParentSku(MultipartFile file, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 查询销售数据
     * @author baixueping
     * @date 2019/8/30 14:27
     */
    JSONObject salesCount(SalesCountRequest params);

    /**
     * @param
     * @return
     * @description 根据shopSku获取sku信息
     * @author baixueping
     * @date 2019/9/11 10:00
     */
    Sku getSkuByShopSku(String shopSku);

    /**
     * @param
     * @return
     * @description 根据shopSku查询报关信息
     * @author baixueping
     * @date 2019/9/17 17:49
     */
    List<ShopSkuFullProductName> listShopSkuFullProductName(List<String> shopSkuList);

    /**
     * @param
     * @return
     * @description 通过shopSku获取shopName
     * @author baixueping
     * @date 2019/9/18 16:56
     */
    String getShopNameByShopSku(String shopSku);

    /**
     * @param
     * @return
     * @description 导入店铺sku状态
     * @author baixueping
     * @date 2019/10/23 15:07
     */
    BaseResponse importShopSkuStatus(MultipartFile file, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 折线图显示某父sku子sku销售数量
     * @author baixueping
     * @date 2019/11/4 11:41
     */
    BaseResponse salesCountChart(SalesCountRequest params);

    /**
     * @param
     * @return
     * @description 通过asin获取shopSku
     * @author baixueping
     * @date 2019/12/2 9:51
     */
    ShopSku getShopSkuByAsin(String asin);

    /**
     * @param
     * @return
     * @description 导入sku销售人员
     * @author baixueping
     * @date 2020/1/3 16:02
     */
    BaseResponse importSalesmanUser(MultipartFile file, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 根据shopSkuId获取shopsku
     * @author baixueping
     * @date 2020/5/7 16:17
     */
    ShopSku getShopSku(Integer shopSkuId);

    /**
     * @param
     * @return
     * @description 修改库存
     * @author baixueping
     * @date 2020/5/7 16:56
     */
    void updateInventoryQuantity(UpdateShopSkuInventoryQuantityRequest updateShopSkuInventoryQuantityRequest);

    /**
     * @param
     * @return
     * @description 获取库存
     * @author baixueping
     * @date 2020/5/9 10:11
     */
    Integer getSkuInventoryQuantity(Integer skuId);

    List<ShopSkuFullProductName> listShopSkuFullProductNameByShopSkuId(List<Integer> shopSkuIdList);

    /**
     * @param
     * @param shopId
     * @return
     * @description 判断是否存在没有头程费的店铺sku
     * @author baixueping
     * @date 2020/8/14 15:34
     */
    boolean existWithoutHeadTripCostShopSku(Integer shopId);

    /**
     * @param
     * @param month
     * @return
     * @description
     * @author baixueping
     * @date 2020/8/17 17:06
     */
    List<ShopSkuHeadTripCostInfo> listNotExistShopSkuHeadTripCost(Integer shopId, Date month);

    boolean existWithoutWeightShopSku(Integer shopId);

    List<ShopSku> listShopSku(List<Integer> shopSkuIdList);

    ShopSku getShopSkuBySkuIdShopId(Integer shopId, Integer skuId);

    ShopSku getShopSkuBySkuShopId(Integer shopId, String sku);

    boolean existShopSku(List<Integer> skuIds);


    List<ShopSku> getShopSkuByShopParentSkuAndSize(GetShopSkuByShopParentSkuAndSizeRequest getShopSkuByShopParentSkuAndSizeRequest);

    /**
     * @param
     * @return
     * @description 查询其他店铺库存信息
     * @author baixueping
     * @date 2021/3/30 14:43
     */
    PageInfo<ListInventoryQuantityResponse> listInventoryQuantity(ListInventoryQuantityRequest params);

    BaseResponse stopShopSku(Integer shopSkuId, Integer currentUserId);
}
