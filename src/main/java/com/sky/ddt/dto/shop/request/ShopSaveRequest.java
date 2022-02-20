package com.sky.ddt.dto.shop.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class ShopSaveRequest {
    private Integer shopId;
    @NotNull(message = "店铺名不能为空")
    @Length(max = 60, message = "店铺名长度不能超过60")
    private String shopName;
    @Length(max = 200, message = "店铺连接长度不能超过200")
    private String shopUrl;


    @Length(max = 30, message = "卖家id长度不能超过30")
    private String sellerId;

    @NotNull(message = "国家不能为空")
    private Integer countryId;

    @Length(max = 50, message = "商城编号长度不能超过50")
    private String shopMarketplaceId;

    @NotNull(message = "状态不能为空")
    private Boolean status;

    @Length(max = 200, message = "备注长度不能超过200")
    private String remark;
    @NotNull(message = "类型不能为空")
    private Integer type;
}
