package com.sky.ddt.dto.internalOrderNumberTransport.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author baixueping
 * @description 保存重量入参
 * @date 2021/6/25 15:09
 */
@Data
public class SaveInternalOrderNumberTransportWightRequest {
    @NotNull(message = "id不能为空")
    Integer id;
    @Min(value = 0,message = "重量必须大于等于0的数字")
    BigDecimal weight;
}
