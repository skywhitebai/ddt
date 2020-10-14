package com.sky.ddt.dto.checkOrder.request;

import com.sky.ddt.common.constant.CheckOrderConstant;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 保存盘点单入参
 * @date 2020/5/11 10:16
 */
@Data
public class SaveCheckOrderRequest {
    Integer id;
    @NotNull(message = CheckOrderConstant.SHOP_ID_EMPTY)
    Integer shopId;
    @Length(max = 200, message = CheckOrderConstant.REMARK_TOO_LONG)
    String remark;
}
