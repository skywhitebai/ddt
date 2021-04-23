package com.sky.ddt.dto.fbaPackingListShopSku.response;

import com.sky.ddt.entity.FbaPackingListShopSku;
import lombok.Data;

/**
 * @author baixueping
 * @description 分页查询装箱单店铺sku信息
 * @date 2020/7/23 10:47
 */
@Data
public class ListFbaPackingListShopSkuResponse extends FbaPackingListShopSku {
    String shopSku;
    String sku;
}
