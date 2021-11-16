package com.sky.ddt.dto.produceOrder.request;

import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author sky
 * @Description 保存成本备注
 * @date 2021/11/16 20:37
 */
@Data
public class SaveProduceOrderAuxiliaryMaterialCostRequest {
    @NotNull(message = "id不能为空")
    Integer id;
    @DecimalMin(value = "0", message = "辅料成本必须为0.01-1000000的两位小数")
    @DecimalMax(value = "1000000", message = "辅料成本必须为0.01-1000000的两位小数")
    @Digits(integer = 10, fraction = 2, message = "辅料成本必须为0.01-1000000的两位小数")
    BigDecimal auxiliaryMaterialCost;
}
