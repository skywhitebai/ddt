package com.sky.ddt.dto.warehousingOrder.request;

import com.sky.ddt.common.constant.WarehousingOrderConstant;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author baixueping
 * @description 保存入库单信息
 * @date 2020/4/17 16:27
 */
@Data
public class SaveWarehousingOrderRequest {
    Integer id;
    @NotNull(message = WarehousingOrderConstant.SHOP_ID_EMPTY)
    Integer shopId;
    @NotNull(message = WarehousingOrderConstant.TYPE_EMPTY)
    Integer type;
    //修改时需要判断是否已经添加了入库产品，已添加入库产品不能修改
    String produceOrderBatchNumber;
    @Length(max = 200, message = WarehousingOrderConstant.REMARK_TOO_LONG)
    String remark;
}
