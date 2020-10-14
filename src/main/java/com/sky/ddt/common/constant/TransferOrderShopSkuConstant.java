package com.sky.ddt.common.constant;

import com.sky.ddt.common.excel.ExcelField;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baixueping
 * @description 调拨单店铺sku
 * @date 2020/9/1 12:46
 */
public class TransferOrderShopSkuConstant {
    public static final String TRANSFER_ORDER_ID_EMPTY ="调拨单id不能为空" ;
    public static final String SHOP_SKU_FROM_EMPTY ="调出店铺sku不能为空" ;
    public static final String TRANSFER_QUANTITY_EMPTY ="调拨数量不能为空" ;
    public static final String TRANSFER_QUANTITY_ERRO ="调拨数量必须为大于0的整数" ;
    public static final String REMARK_TOO_LONG ="备注长度不能超过200" ;
    public static final String ID_NOT_EXIST ="调拨单店铺skuid不存在" ;
    public static final String TRANSFER_ORDER_ID_NOT_EXIST ="调拨单id不存在" ;
    public static final String ONLY_PENDING_TRANSFER_ALLOW_SAVE_SHOP_SKU ="只有待调拨的调拨单允许保存店铺sku" ;
    public static final String TRANSFER_ORDER_ID_NOT_ALLOW_CHANGE ="调拨单id不允许修改" ;
    public static final String SHOP_SKU_FROM_NOT_EXIST ="调出店铺sku不存在" ;
    public static final String SHOP_SKU_FROM_SHOP_ERRO ="调出店铺sku必须是调出店铺的";
    public static final String TRANSFER_ORDER_SHOP_SKU_FROM_EXIST ="调拨单已经存在此调出店铺sku";
    public static final String TRANSFER_ORDER_SHOP_SKU_TO_NOT_EXIST ="调入店铺不存在此店铺sku" ;
    public static final String ID_EMPTY ="调拨单店铺skuid不能为空" ;
    public static final String ONLY_PENDING_TRANSFER_ALLOW_DELETE_SHOP_SKU = "只有待调拨的调拨单允许删除店铺sku" ;
    public static final String ONLY_PENDING_TRANSFER_ALLOW_IMPORT_SHOP_SKU = "只有待调拨的调拨单允许导入店铺sku" ;
    public static final String SKU_EMPTY ="调出产品sku不能为空" ;
    public static final String SKU_NOT_EXIST ="调出产品sku不存在" ;
    public static final String SHOP_SKU_TO_EMPTY ="调入店铺sku不能为空" ;
    public static final String SHOP_SKU_TO_NOT_EXIST = "调入店铺sku不存在" ;
    public static final String SHOP_SKU_FROM_SHOP_SKU_TO_SKU_ID_NOT_SAME ="调入、调出店铺sku，对应的产品sku不一致" ;
    public static final String SHOP_SKU_TO_SHOP_ERRO ="调入店铺sku必须是调入店铺的";
    public static List<ExcelField> exportTransferOrderShopSkuFieldList=new ArrayList<>();
    static {
        exportTransferOrderShopSkuFieldList.add(new ExcelField("shopNameFrom", "调出店铺名", ExcelField.FieldTypeEnum.STRING));
        exportTransferOrderShopSkuFieldList.add(new ExcelField("shopNameTo", "调入店铺名", ExcelField.FieldTypeEnum.STRING));
        exportTransferOrderShopSkuFieldList.add(new ExcelField("sku", "产品sku", ExcelField.FieldTypeEnum.STRING));
        exportTransferOrderShopSkuFieldList.add(new ExcelField("shopSkuFrom", "调出店铺sku", ExcelField.FieldTypeEnum.STRING));
        exportTransferOrderShopSkuFieldList.add(new ExcelField("shopSkuTo", "调入店铺sku", ExcelField.FieldTypeEnum.STRING));
        exportTransferOrderShopSkuFieldList.add(new ExcelField("transferQuantity", "调拨数量", ExcelField.FieldTypeEnum.NUMBER));
    }
}
