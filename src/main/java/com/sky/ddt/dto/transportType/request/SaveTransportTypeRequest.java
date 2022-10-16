package com.sky.ddt.dto.transportType.request;

import com.sky.ddt.common.constant.TransportTypeConstant;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 保存运输方式入参
 * @date 2020/7/2 14:41
 */
@Data
public class SaveTransportTypeRequest {
    Integer id;
    @NotBlank(message = TransportTypeConstant.TRANSPORT_TYPE_NAME_EMPTY)
    @Length(max = 50, message = TransportTypeConstant.TRANSPORT_TYPE_NAME_TOO_LONG)
    String transportTypeName;
    @NotNull(message = TransportTypeConstant.SORT_EMPTY)
    @Min(value = 1, message = TransportTypeConstant.SORT_ERRO)
    Integer sort;
    @NotNull(message = "时效不能为空")
    @Min(value = 1, message = "时效必须为数字")
    Integer timeliness;
    @Length(max = 200, message = TransportTypeConstant.REMARK_TOO_LONG)
    String remark;
}
