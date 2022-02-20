package com.sky.ddt.dto.country.req;

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
 * @description 保存国家
 * @date 2020/7/2 14:41
 */
@Data
public class SaveCountryReq {
    Integer id;
    @NotBlank(message = "国家名称不能为空")
    @Length(max = 25, message = "国家名称长度不超过50")
    String countryName;
    @NotNull(message = "货币类型不能为空")
    Integer currencyId;
    @NotNull(message = "状态不能为空")
    Integer status;
    @Length(max = 100, message = "备注长度不能超过100")
    String remark;
}
