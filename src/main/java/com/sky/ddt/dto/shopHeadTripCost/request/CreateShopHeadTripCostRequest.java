package com.sky.ddt.dto.shopHeadTripCost.request;

import lombok.Data;

import java.util.Date;

/**
 * @author baixueping
 * @description 创建店铺头程费入参
 * @date 2020/8/14 12:52
 */
@Data
public class CreateShopHeadTripCostRequest {
    Integer shopId;
    String month;
    Date monthDate;
    Integer type;
    String createRemark;
}
