package com.sky.ddt.dto.order.response;

import com.sky.ddt.entity.OrderInfo;
import lombok.Data;

@Data
public class OrderListResponse extends OrderInfo {
    String shopName;
    String sellerSku;
}
