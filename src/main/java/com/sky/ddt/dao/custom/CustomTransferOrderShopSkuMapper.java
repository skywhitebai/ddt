package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.TransferOrderShopSkuMapper;
import com.sky.ddt.dto.transferOrderShopSku.request.ListTransferOrderShopSkuRequest;
import com.sky.ddt.dto.transferOrderShopSku.response.ListTransferOrderShopSkuResponse;

import java.util.List;

/**
 * @author baixueping
 * @description 调拨单操作类
 * @date 2020/8/28 16:26
 */
public interface CustomTransferOrderShopSkuMapper extends TransferOrderShopSkuMapper {
    List<ListTransferOrderShopSkuResponse> listTransferOrderShopSku(ListTransferOrderShopSkuRequest params);
}
