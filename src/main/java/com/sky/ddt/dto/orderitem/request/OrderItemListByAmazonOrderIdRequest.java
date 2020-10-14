package com.sky.ddt.dto.orderitem.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class OrderItemListByAmazonOrderIdRequest extends DataGridRequest {
    @NotEmpty(message = "亚马逊订单id不能为空")
    String amazonOrderId;
}
