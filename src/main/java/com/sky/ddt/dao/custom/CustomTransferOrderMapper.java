package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.TransferOrderMapper;
import com.sky.ddt.dto.transferOrder.request.ListTransferOrderRequest;
import com.sky.ddt.dto.transferOrder.response.ListTransferOrderResponse;

import java.util.List;

/**
 * @author baixueping
 * @description 自定义调拨单操作类
 * @date 2020/8/28 16:22
 */
public interface CustomTransferOrderMapper extends TransferOrderMapper {
    List<ListTransferOrderResponse> listTransferOrder(ListTransferOrderRequest params);


}
