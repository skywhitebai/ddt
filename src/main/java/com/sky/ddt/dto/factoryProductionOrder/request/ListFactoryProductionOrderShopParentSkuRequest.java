package com.sky.ddt.dto.factoryProductionOrder.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 列表查询工厂生产单产品信息
 * @date 2020/10/15 16:41
 */
@Data
public class ListFactoryProductionOrderShopParentSkuRequest extends DataGridRequest {
    @NotNull(message = "工厂生产单id不能为空")
    Integer factoryProductionOrderId;
    String shopParentSku;
}
