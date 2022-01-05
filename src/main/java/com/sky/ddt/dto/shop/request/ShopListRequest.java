package com.sky.ddt.dto.shop.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

import java.util.Date;

@Data
public class ShopListRequest extends DataGridRequest {
    private String shopName;


    private String sellerId;

    private String shopMarketplaceId;

    private Boolean status;
    private Integer type;

}
