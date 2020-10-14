package com.sky.ddt.dto.skuWeightHis.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description 查询历史重量入参
 * @date 2019/12/31 9:24
 */
@Data
public class ListSkuWeightHisRequest extends DataGridRequest {
    Integer skuId;
}