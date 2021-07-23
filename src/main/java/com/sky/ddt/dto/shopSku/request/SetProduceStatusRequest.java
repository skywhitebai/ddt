package com.sky.ddt.dto.shopSku.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 设置生产状态
 * @date 2021/7/23 15:46
 */
@Data
public class SetProduceStatusRequest {
    @NotNull(message = "shopSkuId不能为空")
    Integer shopSkuId;
    @NotNull(message = "生产状态不能为空")
    Integer produceStatus;
}
