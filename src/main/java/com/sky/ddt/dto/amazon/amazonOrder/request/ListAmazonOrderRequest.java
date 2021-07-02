package com.sky.ddt.dto.amazon.amazonOrder.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author baixueping
 * @description 列表查询亚马逊订单信息
 * @date 2021/7/2 11:26
 */
@Data
public class ListAmazonOrderRequest extends DataGridRequest {
    private String merchantId;

    private String marketplaceId;

    private String amazonOrderId;

    private String sellerOrderId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date purchaseDateStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date purchaseDateEnd;
    private String orderStatus;
    private String buyerEmail;
    private String sellerSku;
}
