package com.sky.ddt.dto.internalOrderNumberTransport.request;

import lombok.Data;

/**
 * @author baixueping
 * @description 添加内部单号发货信息
 * @date 2020/7/7 15:09
 */
@Data
public class AddInternalOrderNumberTransportRequest {
    String subOrderNumber;
    String fbaShipmentId;
    String transferOrderNo;
}
