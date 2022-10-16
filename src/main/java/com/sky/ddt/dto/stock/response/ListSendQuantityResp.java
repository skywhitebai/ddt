package com.sky.ddt.dto.stock.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author baixueping
 * @description 备货信息查询结果
 * @date 2019/8/21 11:21
 */
@Data
public class ListSendQuantityResp {
    Integer shopId;
    Integer shopSkuId;
    String shopSku;
    String shipmentId;
    Integer quantity;
    String transportTypeName;
    Date createTime;
    Date estimatedArrivalTime;
}
