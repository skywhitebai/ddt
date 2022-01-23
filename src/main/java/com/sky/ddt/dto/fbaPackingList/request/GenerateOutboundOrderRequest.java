package com.sky.ddt.dto.fbaPackingList.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author sky
 * @Description 生成出库单入参
 * @date 2022/1/23 12:53
 */
@Data
public class GenerateOutboundOrderRequest {
    @NotNull(message = "fba装箱单id不能为空")
    Integer id;
    @NotNull(message = "出库仓库id不能为空")
    Integer outboundShopId;
}
