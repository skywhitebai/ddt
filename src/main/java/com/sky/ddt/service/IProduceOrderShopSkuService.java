package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.produceOrderShopSku.request.ListProduceOrderShopSkuProductionQuantityRequest;
import com.sky.ddt.dto.produceOrderShopSku.request.ListProduceOrderShopSkuRequest;
import com.sky.ddt.dto.produceOrderShopSku.request.SaveProduceOrderShopSkuRequest;
import com.sky.ddt.dto.produceOrderShopSku.request.SaveProductionQuantityRequest;
import com.sky.ddt.dto.produceOrderShopSku.response.ListProduceOrderShopSkuProductionQuantityResponse;
import com.sky.ddt.dto.produceOrderShopSku.response.ListProduceOrderShopSkuResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.FbaPackingList;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author baixueping
 * @description 生产单店铺sku
 * @date 2020/4/1 11:22
 */
public interface IProduceOrderShopSkuService {
    /**
     * @param
     * @return
     * @description 判断生产单是否包含店铺sku
     * @author baixueping
     * @date 2020/4/1 11:29
     */
    boolean existProduceOrderShopSku(Integer produceOrderId);

    /**
     * @param
     * @return
     * @description 查询生产单店铺sku
     * @author baixueping
     * @date 2020/4/1 15:36
     */
    PageInfo<ListProduceOrderShopSkuResponse> listProduceOrderShopSku(ListProduceOrderShopSkuRequest listProduceOrderShopSkuRequest);

    /**
     * @param
     * @return
     * @description 保存生产单店铺sku
     * @author baixueping
     * @date 2020/4/2 11:40
     */
    BaseResponse saveProduceOrderShopSku(SaveProduceOrderShopSkuRequest params, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 删除生产单店铺sku
     * @author baixueping
     * @date 2020/4/7 10:26
     */
    BaseResponse deleteProduceOrderShopSku(Integer id);

    /**
     * @param
     * @return
     * @description 导入生产单店铺sku
     * @author baixueping
     * @date 2020/4/26 16:10
     */
    BaseResponse importProduceOrderShopSku(MultipartFile file, Integer produceOrderId, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 查询生产单所有店铺
     * @author baixueping
     * @date 2020/4/27 15:56
     */
    List<ListProduceOrderShopSkuResponse> listProduceOrderShopSkuByProduceOrderId(Integer produceOrderId);

    /**
     * @param
     * @return
     * @description 保存生产数量
     * @author baixueping
     * @date 2020/7/9 12:53
     */
    BaseResponse saveProductionQuantity(SaveProductionQuantityRequest params, Integer currentUserId);

    PageInfo<ListProduceOrderShopSkuProductionQuantityResponse> listProduceOrderShopSkuProductionQuantity(ListProduceOrderShopSkuProductionQuantityRequest params);
}
