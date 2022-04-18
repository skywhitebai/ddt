package com.sky.ddt.dto.amazonWarehouse.req;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author sky
 * @Description
 * @date 2022/4/18 22:41
 */
@Data
public class ListAmazonWarehouseReq extends DataGridRequest {
    private String fulfillmentCenterId;
    private String state;
}
