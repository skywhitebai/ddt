package com.sky.ddt.dto.transferOrder.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author baixueping
 * @description 列表查询调拨单入参
 * @date 2020/8/31 16:35
 */
@Data
public class ListTransferOrderRequest extends DataGridRequest{
    Integer shopIdFrom;
    Integer shopIdTo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date createTimeStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date createTimeEnd;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date transferTimeStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date transferTimeEnd;
    String batchNumber;
    String sku;
    String shopSkuFrom;
    String shopSkuTo;
    Integer status;
}
