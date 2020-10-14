package com.sky.ddt.common.constant;

import com.sky.ddt.common.excel.ExcelField;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baixueping
 * @description 盘点单店铺sku静态类
 * @date 2020/5/11 15:21
 */
public class CheckOrderShopSkuConstant {
    public static final String CHECK_ORDER_ID_EMPTY ="盘点单id不能为空";
    public static final String SHOP_SKU_EMPTY =  "店铺sku不能为空";
    public static final String INVENTORY_QUANTITY_NEW_EMPTY ="最新库存数量不能为空";
    public static final String INVENTORY_QUANTITY_NEW_ERRO ="最新库存数量必须为大于等于0的整数";
    public static final String REMARK_TOO_LONG ="备注长度不能超过200";
    public static final String ID_NOT_EXIST ="盘点单店铺skuid不存在";
    public static final String CHECK_ORDER_ID_NOT_EXIST ="盘点单id不存在";
    public static final String ONLY_PENDING_CONFIRM_ALLOW_SAVE_SHOP_SKU ="只有待确认的盘点单允许保存店铺sku信息" ;
    public static final String CHECK_ORDER_ID_NOT_ALLOW_CHANGE ="盘点单id不允许修改" ;
    public static final String SHOP_SKU_NOT_EXIST ="店铺sku不存在";
    public static final String SHOP_SKU_SHOP_ERRO ="店铺sku必须是盘点单店铺的";
    public static final String CHECK_ORDER_SHOP_SKU_EXIST = "盘点单已经存在此店铺sku";
    public static final String ID_EMPTY ="盘点单店铺skuid不能为空";
    public static final String ONLY_PENDING_CONFIRM_ALLOW_DELETE_SHOP_SKU ="只有待确认的盘点单允许删除店铺sku信息" ;
    public static final String ONLY_PENDING_CONFIRM_ALLOW_IMPORT_SHOP_SKU ="只有待确认的盘点单允许导入店铺sku信息" ;
    public static List<ExcelField> exportCheckOrderShopSkuFieldList=new ArrayList<>();
    static {
        exportCheckOrderShopSkuFieldList.add(new ExcelField("shopName", "店铺名", ExcelField.FieldTypeEnum.STRING));
        exportCheckOrderShopSkuFieldList.add(new ExcelField("sku", "产品sku", ExcelField.FieldTypeEnum.STRING));
        exportCheckOrderShopSkuFieldList.add(new ExcelField("shopSku", "店铺sku", ExcelField.FieldTypeEnum.STRING));
        exportCheckOrderShopSkuFieldList.add(new ExcelField("inventoryQuantityNew", "最新库存数量", ExcelField.FieldTypeEnum.NUMBER));
    }
}
