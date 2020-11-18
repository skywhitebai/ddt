package com.sky.ddt.dto.factoryProductionOrder.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 保存数量
 * @date 2020/10/15 20:02
 */
@Data
public class SaveProductionQuantityRequest {
    @NotBlank(message = "店铺父sku不能为空")
    String shopParentSku;
    @NotNull(message = "生产数量不能为空")
    @Min(value = 0, message = "生产数量必须大于等于0")
    Integer productionQuantity;
    @NotNull(message = "工厂生产单id不能为空")
    Integer factoryProductionOrderId;
    @NotBlank(message = "尺码不能为空")
    String size;
    @NotBlank(message = "颜色不能为空")
    String colour;
    String colourNumber;
}
