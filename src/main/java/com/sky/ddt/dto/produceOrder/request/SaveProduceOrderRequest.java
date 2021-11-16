package com.sky.ddt.dto.produceOrder.request;

import com.sky.ddt.common.constant.ProduceOrderConstant;
import com.sky.ddt.common.constant.SkuConstant;
import com.sky.ddt.entity.ProduceOrder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
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
    @Length(max = 500, message = ProduceOrderConstant.COST_REMARK_TOO_LONG)
    String costRemark;
    @DecimalMin(value = "0.01", message = "布料成本必须为大于0的两位小数数字")
    @Digits(integer = 10,fraction = 2,message = "布料成本必须为大于0的两位小数数字")
    @DecimalMax(value = "1000000",message = "布料成本不能大于100万")
    private BigDecimal fabricCost;
    @DecimalMin(value = "0", message = "辅料成本必须为大于0的两位小数数字")
    @Digits(integer = 10,fraction = 2,message = "辅料成本必须为大于0的两位小数数字")
    @DecimalMax(value = "1000000",message = "辅料成本不能大于100万")
    private BigDecimal auxiliaryMaterialCost;
}
