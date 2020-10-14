package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.WarehousingOrderShopSkuMapper;
import com.sky.ddt.dto.warehousingOrderShopSku.request.ListWarehousingOrderShopSkuRequest;
import com.sky.ddt.dto.warehousingOrderShopSku.response.ListWarehousingOrderShopSkuResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author baixueping
 * @description 入库单店铺sku管理
 * @date 2020/4/23 17:20
 */
public interface CustomWarehousingOrderShopSkuMapper extends WarehousingOrderShopSkuMapper {
    /**
     * @param
     * @return
     * @description 列表查询入库单店铺sku
     * @author baixueping
     * @date 2020/4/23 17:43
     */
    List<ListWarehousingOrderShopSkuResponse> listWarehousingOrderShopSku(ListWarehousingOrderShopSkuRequest listWarehousingOrderShopSkuRequest);

    /**
     * @param
     * @return
     * @description 判断是否存在生产单店铺sku
     * @author baixueping
     * @date 2020/4/28 10:46
     */
    boolean existProduceOrderShopSku(@Param("produceOrderId")Integer produceOrderId, @Param("shopSku") String shopSku);
}
