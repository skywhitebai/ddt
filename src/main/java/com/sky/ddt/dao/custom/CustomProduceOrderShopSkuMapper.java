package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.ProduceOrderShopSkuMapper;
import com.sky.ddt.dto.produceOrderShopSku.request.ListProduceOrderShopSkuProductionQuantityRequest;
import com.sky.ddt.dto.produceOrderShopSku.request.ListProduceOrderShopSkuRequest;
import com.sky.ddt.dto.produceOrderShopSku.response.ListProduceOrderShopSkuProductionQuantityResponse;
import com.sky.ddt.dto.produceOrderShopSku.response.ListProduceOrderShopSkuResponse;
import com.sky.ddt.entity.ProduceOrderShopSku;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author baixueping
 * @description 生产单店铺sku操作类
 * @date 2020/4/1 11:23
 */
public interface CustomProduceOrderShopSkuMapper extends ProduceOrderShopSkuMapper {
    /**
     * @param
     * @return
     * @description 查询生产单对应的店铺sku
     * @author baixueping
     * @date 2020/4/1 15:42
     */
    List<ListProduceOrderShopSkuResponse> listProduceOrderShopSku(ListProduceOrderShopSkuRequest listProduceOrderShopSkuRequest);

    List<ListProduceOrderShopSkuProductionQuantityResponse> listProduceOrderShopSkuProductionQuantity(ListProduceOrderShopSkuProductionQuantityRequest params);

    Boolean existProduceOrderShopSkuNotSameSku(ProduceOrderShopSku produceOrderShopSku);
}
