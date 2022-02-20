package com.sky.ddt.dto.shop.response;

import com.sky.ddt.entity.Shop;
import com.sky.ddt.entity.ShopSenderAddress;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ShopListResponse {
    private Integer shopId;

    private String shopName;

    private Integer type;

    private String shopUrl;

    private String sellerId;

    private String shopMarketplaceId;
    private Boolean status;

    private Date createTime;

    private Date updateTime;

    private String remark;
    private ShopSenderAddress shopSenderAddress;
    private String shopUserRealNames;
    private BigDecimal exchangeRate;
    private String currencyCode;
    private String currencyName;
    private Integer countryId;
    private String countryName;

}
