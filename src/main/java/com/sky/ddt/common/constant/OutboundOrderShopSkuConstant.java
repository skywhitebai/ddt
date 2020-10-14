package com.sky.ddt.common.constant;

import com.sky.ddt.common.excel.ExcelField;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baixueping
 * @description 出库单店铺sku
 * @date 2020/5/12 13:02
 */
public class OutboundOrderShopSkuConstant {
    public static final String OUTBOUND_ORDER_ID_EMPTY ="出库单id不能为空";
    public static final String SHOP_SKU_EMPTY =  "店铺sku不能为空";
    public static final String OUTBOUND_QUANTITY_EMPTY ="出库数量不能为空";
    public static final String OUTBOUND_QUANTITY_ERRO ="出库数量必须为大于0的整数";
    public static final String REMARK_TOO_LONG ="备注长度不能超过200";
    public static final String ID_NOT_EXIST ="出库单店铺skuid不存在";
    public static final String OUTBOUND_ORDER_ID_NOT_EXIST ="出库单单id不存在";
    public static final String ONLY_PENDING_OUTBOUND_ALLOW_SAVE_SHOP_SKU ="只有待出库的出库单允许保存店铺sku信息" ;
    public static final String OUTBOUND_ORDER_ID_NOT_ALLOW_CHANGE = "出库单id不允许修改" ;
    public static final String SHOP_SKU_NOT_EXIST ="店铺sku不存在";
    public static final String SHOP_SKU_SHOP_ERRO ="店铺sku必须是出库单店铺的";
    public static final String OUTBOUND_ORDER_SHOP_SKU_EXIST = "出库单已经存在此店铺sku";
    public static final String ID_EMPTY = "出库单店铺skuid不能为空";
    public static final String ONLY_PENDING_OUTBOUND_ALLOW_DELETE_SHOP_SKU = "只有待出库的出库单允许删除店铺sku信息" ;
    public static final String ONLY_PENDING_OUTBOUND_ALLOW_IMPORT_SHOP_SKU ="只有待出库的出库单允许导入店铺sku信息" ;
    public static List<ExcelField> exportOutboundOrderShopSkuFieldList=new ArrayList<>();
    static {
        exportOutboundOrderShopSkuFieldList.add(new ExcelField("shopName", "店铺名", ExcelField.FieldTypeEnum.STRING));
        exportOutboundOrderShopSkuFieldList.add(new ExcelField("sku", "产品sku", ExcelField.FieldTypeEnum.STRING));
        exportOutboundOrderShopSkuFieldList.add(new ExcelField("shopSku", "店铺sku", ExcelField.FieldTypeEnum.STRING));
        exportOutboundOrderShopSkuFieldList.add(new ExcelField("outboundQuantity", "出库数量", ExcelField.FieldTypeEnum.NUMBER));
    }
}
