package com.sky.ddt.dto.stock.request;

import com.sky.ddt.common.constant.StockConsatnt;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 保存数量
 * @date 2019/8/22 14:50
 */
@Data
public class SaveStockQuantityDto {
    Integer shopSkuId;

    private Integer stockQuantityKy;

    private Integer stockQuantityKp;

    private Integer stockQuantityHy;
}
