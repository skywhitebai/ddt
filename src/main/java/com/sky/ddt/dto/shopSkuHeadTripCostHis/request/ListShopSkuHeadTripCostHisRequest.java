package com.sky.ddt.dto.shopSkuHeadTripCostHis.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

import java.util.Date;

/**
 * @author baixueping
 * @description 列表查询店铺头程费历史记录
 * @date 2020/8/18 18:07
 */
@Data
public class ListShopSkuHeadTripCostHisRequest extends DataGridRequest {
    Integer shopHeadTripCostId;
    String shopSku;
    Integer shopSkuId;


}
