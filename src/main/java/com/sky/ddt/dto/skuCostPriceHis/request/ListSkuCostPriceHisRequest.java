package com.sky.ddt.dto.skuCostPriceHis.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description 查询历史成本价入参
 * @date 2019/12/31 9:24
 */
@Data
public class ListSkuCostPriceHisRequest extends DataGridRequest {
    Integer skuId;
}