package com.sky.ddt.dto.shopSku.request;

import com.sky.ddt.common.constant.ShopSkuConstant;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 保存店铺sku数据
 * @date 2019/7/30 10:43
 */
@Data
public class SaveShopSkuRequest {
    @NotNull(message = ShopSkuConstant.SHOP_SKU_ID_EMPTY)
    Integer shopSkuId;
    @NotBlank(message = ShopSkuConstant.SHOP_SKU_EMPTY)
    String shopSku;
    @NotBlank(message = ShopSkuConstant.FNSKU_EMPTY)
    String fnsku;
    Integer salesmanUserId;
    String remark;
    @NotBlank(message = ShopSkuConstant.TITLE_EMPTY)
    String title;
    @NotBlank(message = ShopSkuConstant.SHOP_PARENT_SKU_EMPTY)
    String shopParentSku;
    //@NotBlank(message = ShopSkuConstant.ASIN_EMPTY)
    String asin;
    @NotNull(message = ShopSkuConstant.STATUS_EMPTY)
    Integer status;
    String parentAsin;
    Integer userId;
    String storageLocation;
}
