package com.sky.ddt.dto.checkOrder.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author baixueping
 * @description 列表查询盘点单入参
 * @date 2020/5/9 17:33
 */
@Data
public class ListCheckOrderRequest extends DataGridRequest{
    Integer shopId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date checkTimeStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date checkTimeEnd;
    String batchNumber;
    String shopSku;
    String sku;
    Integer status;
}
