package com.sky.ddt.dto.currency.req;

import com.sky.ddt.common.constant.TransportTypeConstant;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author baixueping
 * @description 保存运输方式入参
 * @date 2020/7/2 14:41
 */
@Data
public class SaveCurrencyReq {
    Integer id;
    @NotBlank(message = "货币名称不能为空")
    @Length(max = 25, message = "货币名称长度不超过25")
    String currencyName;
    @NotBlank(message = "货币编码不能为空")
    @Length(max = 25, message = "货币编码长度不超过25")
    String currencyCode;
    @NotNull(message = "汇率不能为空")
    @DecimalMin(value = "0.01", message = "汇率必须大于等于0.01")
    @DecimalMax(value = "10000.00", message = "汇率必须小于10000")
    BigDecimal exchangeRate;
    @Length(max = 100, message = "备注长度不能超过100")
    String remark;
}
