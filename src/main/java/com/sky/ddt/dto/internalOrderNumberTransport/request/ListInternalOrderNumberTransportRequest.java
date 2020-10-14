package com.sky.ddt.dto.internalOrderNumberTransport.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author baixueping
 * @description 分页查询内部订单运输信息
 * @date 2020/7/3 11:29
 */
@Data
public class ListInternalOrderNumberTransportRequest extends DataGridRequest {
    String orderNumber;
    String subOrderNumber;
    String fbaShipmentId;
    String transferOrderNo;
    Integer transportTypeId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date createTimeStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date createTimeEnd;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Integer lockHeadTripCostRate;
    Integer existFbaShipmentIdShort;
}
