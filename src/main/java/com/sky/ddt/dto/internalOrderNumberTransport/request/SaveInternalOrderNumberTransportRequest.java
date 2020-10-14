package com.sky.ddt.dto.internalOrderNumberTransport.request;

import com.sky.ddt.common.constant.InternalOrderNumberTransportConstant;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * @author baixueping
 * @description 修改内部单号运输信息入参
 * @date 2020/7/3 15:02
 */
@Data
public class SaveInternalOrderNumberTransportRequest {
    @NotNull(message = InternalOrderNumberTransportConstant.ID_EMPTY)
    Integer id;
    @NotBlank(message = InternalOrderNumberTransportConstant.SUB_ORDER_NUMBER_EMPTY)
    @Length(max = 50,message =InternalOrderNumberTransportConstant.SUB_ORDER_NUMBER_TOO_LONG )
    String subOrderNumber;
    @NotBlank(message = InternalOrderNumberTransportConstant.FBA_SHIPMENT_ID_EMPTY)
    @Length(max = 50,message =InternalOrderNumberTransportConstant.FBA_SHIPMENT_ID_TOO_LONG )
    String fbaShipmentId;
    @NotBlank(message = InternalOrderNumberTransportConstant.TRANSFER_ORDER_NO_EMPTY)
    @Length(max = 50,message =InternalOrderNumberTransportConstant.TRANSFER_ORDER_NO_TOO_LONG)
    String transferOrderNo;
    @NotNull(message = InternalOrderNumberTransportConstant.TRANSPORT_TYPE_ID_EMPTY)
    Integer transportTypeId;
    @DecimalMin(value = "0.001",message =InternalOrderNumberTransportConstant.HEAD_TRIP_COST_RATE_ERRO )
    @DecimalMax(value = "0.200",message =InternalOrderNumberTransportConstant.HEAD_TRIP_COST_RATE_ERRO )
    @Digits(integer = 1/* 小数点前最多1位*/,fraction=3 /* 小数点后最多2位*/,message =InternalOrderNumberTransportConstant.HEAD_TRIP_COST_RATE_ERRO )
    BigDecimal headTripCostRate;
}
