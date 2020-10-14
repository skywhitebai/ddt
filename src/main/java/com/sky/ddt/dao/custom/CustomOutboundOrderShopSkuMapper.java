package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.OutboundOrderShopSkuMapper;
import com.sky.ddt.dto.outboundOrderShopSku.request.ListOutboundOrderShopSkuRequest;
import com.sky.ddt.dto.outboundOrderShopSku.response.ListOutboundOrderShopSkuResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author baixueping
 * @description 出库单店铺sku服务类
 * @date 2020/5/12 9:55
 */
public interface CustomOutboundOrderShopSkuMapper extends OutboundOrderShopSkuMapper {
    /**
     * @param
     * @return
     * @description 查询出库单店铺sku
     * @author baixueping
     * @date 2020/5/12 12:54
     */
    List<ListOutboundOrderShopSkuResponse> listOutboundOrderShopSku(ListOutboundOrderShopSkuRequest params);
    /**
     * @param
     * @return
     * @description 生成出库单店铺sku
     * @author baixueping
     * @date 2020/8/4 9:48
     */
    void generateOutboundOrderShopSku(@Param("fbaPackingListId")Integer fbaPackingListId, @Param("outboundOrderId")Integer outboundOrderId, @Param("dealUserId") Integer dealUserId);

}
