package com.sky.ddt.dto.shopHeadTripCost.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

import java.util.Date;

/**
 * @author baixueping
 * @description 查询店铺头程费入参
 * @date 2020/8/13 19:01
 */
@Data
public class ListShopHeadTripCostRequest extends DataGridRequest {
    Integer shopId;
    String month;
    Date monthDate;
    Integer userId;
}
