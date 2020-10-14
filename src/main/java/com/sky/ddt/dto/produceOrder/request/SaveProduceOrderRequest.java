package com.sky.ddt.dto.produceOrder.request;

import com.sky.ddt.common.constant.ProduceOrderConstant;
import com.sky.ddt.entity.ProduceOrder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author baixueping
 * @description 保存生产单
 * @date 2020/3/30 11:37
 */
@Data
public class SaveProduceOrderRequest{
    Integer id;
    @NotNull(message = ProduceOrderConstant.SHOP_ID_EMPTY)
    Integer shopId;
    @NotNull(message = ProduceOrderConstant.PRODUCTION_TIME_EMPTY)
    @Length(max = 200, message = ProduceOrderConstant.REMARK_TOO_LONG)
    String remark;
}
