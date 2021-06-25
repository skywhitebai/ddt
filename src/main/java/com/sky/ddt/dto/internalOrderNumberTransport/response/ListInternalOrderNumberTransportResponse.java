package com.sky.ddt.dto.internalOrderNumberTransport.response;

import com.sky.ddt.entity.InternalOrderNumberTransport;
import lombok.Data;

/**
 * @author baixueping
 * @description 分页查询内部单号运输信息
 * @date 2020/7/3 11:35
 */
@Data
public class ListInternalOrderNumberTransportResponse extends InternalOrderNumberTransport {
    String transportTypeName;
    String orderNumber;
    String existFbaShipmentIdShort;
    String remark;
}
