package com.sky.ddt.common.constant;

import com.sky.ddt.common.excel.ExcelField;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baixueping
 * @description 入库单店铺sku静态类
 * @date 2020/4/24 9:36
 */
public class WarehousingOrderShopSkuConstant {
    public static final String WAREHOUSING_ORDER_ID_EMPTY = "入库单id不能为空";
    public static final String SHOP_SKU_EMPTY = "店铺sku不能为空";
    public static final String WAREHOUSING_QUANTITY_EMPTY = "入库数量不能为空";
    public static final String WAREHOUSING_QUANTITY_ERRO = "入库数量必须为大于0的整数";
    public static final String REMARK_TOO_LONG = "备注长度不能超过200";
    public static final String ID_NOT_EXIST = "入库单店铺skuid不存在";
    public static final String WAREHOUSING_ORDER_ID_NOT_EXIST = "入库单id不存在";
    public static final String WAREHOUSING_ORDER_ID_NOT_ALLOW_CHANGE = "入库单id不允许修改";
    public static final String SHOP_SKU_NOT_EXIST = "店铺sku不存在";
    public static final String SHOP_SKU_SHOP_ERRO = "店铺sku必须是入库单店铺的";
    public static final String WAREHOUSING_ORDER_SHOP_SKU_EXIST = "入库单已经存在此店铺sku";
    public static final String WAREHOUSING_ORDER_NOT_ALLOW_WAREHOUSING = "只有待入库的入库单允许添加店铺sku";
    public static final String ONLY_PENDING_STORAGE_ALLOW_IMPORT_SHOP_SKU = "只有待入库的入库单允许导入店铺sku";
    public static final String ID_EMPTY ="入库单店铺skuid不存在";
    public static final String ONLY_PENDING_STORAGE_ALLOW_DELETE_SHOP_SKU ="只有待入库的入库单允许删除店铺sku";
    public static List<ExcelField> exportWarehousingOrderShopSkuFieldList=new ArrayList<>();
    static{
        exportWarehousingOrderShopSkuFieldList.add(new ExcelField("shopName", "店铺名", ExcelField.FieldTypeEnum.STRING));
        exportWarehousingOrderShopSkuFieldList.add(new ExcelField("sku", "产品sku", ExcelField.FieldTypeEnum.STRING));
        exportWarehousingOrderShopSkuFieldList.add(new ExcelField("shopSku", "店铺sku", ExcelField.FieldTypeEnum.STRING));
        exportWarehousingOrderShopSkuFieldList.add(new ExcelField("warehousingQuantity", "入库数量", ExcelField.FieldTypeEnum.NUMBER));
    }
}
