package com.sky.ddt.dto.outboundOrder.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author baixueping
 * @description 列表查询出库单入参
 * @date 2020/5/12 10:04
 */
@Data
public class ListOutboundOrderRequest extends DataGridRequest {
    Integer shopId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date outboundTimeStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date outboundTimeEnd;
    String batchNumber;
    String fbaNo;
    String shopSku;
    String sku;
    Integer status;
    Integer type;
}
