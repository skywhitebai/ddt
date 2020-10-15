package com.sky.ddt.dto.factoryProductionOrder.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 查詢店鋪sku生產數量
 * @date 2020/10/15 18:50
 */
@Data
public class ListFactoryProductionOrderInfoRequest  extends DataGridRequest {
    @NotNull(message = "工厂生产单id不能为空")
    Integer factoryProductionOrderId;
    @NotBlank(message = "店铺父sku不能为空")
    String shopParentSku;
}
