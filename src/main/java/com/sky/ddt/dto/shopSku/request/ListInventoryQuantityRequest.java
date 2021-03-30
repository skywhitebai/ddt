package com.sky.ddt.dto.shopSku.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 其他店铺库存查询
 * @date 2021/3/30 14:26
 */
@Data
public class ListInventoryQuantityRequest extends DataGridRequest {
    @NotNull(message = "店铺id不能为空")
    Integer shopId;
    @NotNull(message = "产品skuId不能为空")
    Integer skuId;
    @NotNull(message = "店铺类型不能为空")
    Integer type;
}
