package com.sky.ddt.dto.transferOrder.response;

import com.sky.ddt.entity.TransferOrder;
import lombok.Data;

/**
 * @author baixueping
 * @description 列表查询调拨单返回值
 * @date 2020/8/31 17:24
 */
@Data
public class ListTransferOrderResponse extends TransferOrder {
    String shopNameFrom;
    String shopNameTo;
    String statusName;
    Integer transferQuantityTotal;
}
