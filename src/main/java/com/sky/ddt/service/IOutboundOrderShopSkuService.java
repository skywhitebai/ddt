package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.outboundOrderShopSku.request.ListOutboundOrderShopSkuRequest;
import com.sky.ddt.dto.outboundOrderShopSku.request.SaveOutboundOrderShopSkuRequest;
import com.sky.ddt.dto.outboundOrderShopSku.request.SaveOutboundQuantityRequest;
import com.sky.ddt.dto.outboundOrderShopSku.response.ListOutboundOrderShopSkuResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.OutboundOrderShopSku;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author baixueping
 * @description 出库单店铺sku服务
 * @date 2020/5/12 9:52
 */
public interface IOutboundOrderShopSkuService {
    /**
     * @param
     * @return
     * @description 判断出库单是否存在店铺sku
     * @author baixueping
     * @date 2020/5/12 11:09
     */
    boolean existOutboundOrderShopSku(Integer outboundOrderId);

    /**
     * @param
     * @return
     * @description 分页查询出库单店铺sku
     * @author baixueping
     * @date 2020/5/12 12:53
     */
    PageInfo<ListOutboundOrderShopSkuResponse> listOutboundOrderShopSku(ListOutboundOrderShopSkuRequest params);

    /**
     * @param
     * @return
     * @description 分页查询出库单店铺sku
     * @author baixueping
     * @date 2020/5/12 12:53
     */
    List<OutboundOrderShopSku> listOutboundOrderShopSku(Integer outboundOrderId);

    /**
     * @param
     * @return
     * @description 保存出库单店铺sku
     * @author baixueping
     * @date 2020/5/12 13:05
     */
    BaseResponse saveOutboundOrderShopSku(SaveOutboundOrderShopSkuRequest params, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 删除出库单店铺sku
     * @author baixueping
     * @date 2020/5/12 13:16
     */
    BaseResponse deleteOutboundOrderShopSku(Integer id);

    /**
     * @param
     * @return
     * @description 导入出库单店铺sku
     * @author baixueping
     * @date 2020/5/12 14:08
     */
    BaseResponse importOutboundOrderShopSku(MultipartFile file, Integer outboundOrderId, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 导出出库单店铺sku信息
     * @author baixueping
     * @date 2020/5/12 14:15
     */
    List<ListOutboundOrderShopSkuResponse> listOutboundOrderShopSkuByOutboundOrderId(Integer outboundOrderId);

    /**
     * @param
     * @return
     * @description 保存出库数量
     * @author baixueping
     * @date 2020/7/17 11:14
     */
    BaseResponse saveOutboundQuantity(SaveOutboundQuantityRequest params, Integer dealUserId);
}
