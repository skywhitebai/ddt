package com.sky.ddt.dto.order.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class OrderListRequest extends DataGridRequest {
    Integer shopId;
    String amazonOrderId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date purchaseDateStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date purchaseDateEnd;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date lastUpdateDateStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date lastUpdateDateEnd;
    String orderStatus;
    String marketplaceId;
    String buyerName;
}
