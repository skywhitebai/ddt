package com.sky.ddt.dto.internalOrderNumber.response;

import com.sky.ddt.entity.InternalOrderNumber;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author baixueping
 * @description 列表查询内部单号出参
 * @date 2020/6/30 14:40
 */
@Data
public class ListInternalOrderNumberResponse extends InternalOrderNumber{
    String transportTypeName;
    BigDecimal totalWeight;
    BigDecimal differenceAmount;
}
