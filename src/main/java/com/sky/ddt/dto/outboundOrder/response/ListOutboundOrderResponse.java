package com.sky.ddt.dto.outboundOrder.response;

import com.sky.ddt.entity.CheckOrder;
import com.sky.ddt.entity.OutboundOrder;
import lombok.Data;

/**
 * @author baixueping
 * @description 列表查询出库单返回值
 * @date 2020/5/12 10:06
 */
@Data
public class ListOutboundOrderResponse extends OutboundOrder {
    String shopName;
    String outboundShopName;
    String statusName;
    Integer outboundQuantityTotal;
}
