package com.sky.ddt.dto.amazon.amazonOrderItem.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description 列表查询亚马逊订单商品信息入参
 * @date 2021/7/2 12:32
 */
@Data
public class ListAmazonOrderItemRequest extends DataGridRequest {
    private String amazonOrderId;

    private String asin;

    private String sellerSku;
    private String title;

}
